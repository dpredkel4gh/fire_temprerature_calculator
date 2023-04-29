package by.pvt.predkel.calculateParameters;

import by.pvt.predkel.entities.Aperture;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.Room;
import by.pvt.predkel.entities.SubstanceOfRoom;

import static java.lang.Math.*;

/**
 * Класс вычисления параметров расчетной пожарной нагрузки
 */
public class DefinitionOfParametersOfCalculatedFireLoad1 {
    private Building myBuilding;

    public void setBuilding(Building myBuilding) {
        this.myBuilding = myBuilding;
    }

    /**
     * Функция для вычисления всех функций класса и запись их в объект
     * сделано для возможности реализации тестировки
     */
    void findCalculatedParameters(Room myRoom) {
        Double[] res = findReducedHeightOfApertures(myRoom);
        myRoom.getParametersCalculatedFireLoad().setReducedHeightOfApertures((res[0]));//приведенная высота проемов
        myRoom.getParametersCalculatedFireLoad().setGeneralSquareOfApertures((res[1]));//общая площадь проемов

        myRoom.getParametersCalculatedFireLoad().setVentilationParameter((findVentilationParameter(myRoom)));

        myRoom.getParametersCalculatedFireLoad().setCoefficientK((findCoefficientK(myRoom)));

        myRoom.getParametersCalculatedFireLoad().setCoefficientB((findCoefficientB(myRoom)));

        myRoom.getParametersCalculatedFireLoad().setCoefficientS((findCoefficientС(myRoom)));

        myRoom.getParametersCalculatedFireLoad().setSpecificFireLoad((findSpecificFireLoad(myRoom)));

        myRoom.getParametersCalculatedFireLoad().setEstimatedFireLoad((findEstimatedFireLoad(myRoom)));
    }

    /**
     * Функция нахождения приведенной высоты проемов в вертикальных ограждающих конструкциях помещения
     * и общей площади проемов в наружных стенах помещения
     */
    public Double[] findReducedHeightOfApertures(Room myRoom) {
        Double numerator = 0.0;//числитель
        Double denominator = 0.0;//знаменатель
        Double result = 0.0;//приведенная высота проемов
        if (myRoom.getAperture().size() == 0)
            throw new NullPointerException();
        for (Aperture temp : myRoom.getAperture()) {
            numerator += ((temp.getHeight() * temp.getSquareOfAperture()) * temp.getCount());//сумма: высота*площадь*количество
            denominator += (temp.getSquareOfAperture() * temp.getCount());//сумма площадь*количество
            result = numerator / denominator;
        }
        Double[] res = new Double[2];
        res[0] = result;//приведенная высота проемов
        res[1] = denominator;//общая площадь проемов
        return res;
    }

    /**
     * Функция нахождения параметра вентиляции
     */
    public Double findVentilationParameter(Room myRoom) {
        return ((myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures() *
                (sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures()))) /
                myRoom.getCommonParameters().getSquareOfConstruction());
    }

    /**
     * Функция нахождения коэффициента К
     */
    public Double findCoefficientK(Room myRoom) {//коэффициент необходим для конечного вычисления коэффициента В
        if (myRoom.getParametersCalculatedFireLoad().getVentilationParameter() <= 0.03) {
            return (2.31 *
                    pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(), 0.84));
        } else if (myRoom.getParametersCalculatedFireLoad().getVentilationParameter() > 0.03) {
            return (((0.3 *
                    (pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(), 0.8))) -
                    (0.002 * (pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(), -1))) +
                    (log10(myRoom.getParametersCalculatedFireLoad().getVentilationParameter())) + 2.25) * (1 / 5.5));
        }
        return null;
    }

    /**
     * Функция нахождения коэффициента B
     */
    public Double findCoefficientB(Room myRoom) {
        return ((myRoom.getCommonParameters().getSquare() *
                myRoom.getParametersCalculatedFireLoad().getCoefficientK()) /
                (myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures() *
                        (sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures()))));
    }

    /**
     * Функция нахождения коэффициента С
     */
    public Double findCoefficientС(Room myRoom) {
        Double coefficientС = 1.0;
        if (myBuilding.getSpecifyingCoefficientS5() > 0)
            myBuilding.getCoefficientSForBuild().set
                    (2, myBuilding.getCoefficientSForBuild().get(2) *
                            myBuilding.getSpecifyingCoefficientS5());//нужно умножить на уточняющий коэффициент для пятого пункта

        for (Double temp : myRoom.getCoefficientSForRoom())
            coefficientС *= temp;
        for (Double temp1 : myBuilding.getCoefficientSForBuild())
            coefficientС *= temp1;
        return (coefficientС);
    }

    /**
     * Функция нахождения удельной пожарной нагрузки
     */
    public Double findSpecificFireLoad(Room myRoom) {
        if (myRoom.getSubstanceOfRoom().size() > 0) {
            Double num = 0.0;
            for (SubstanceOfRoom temp : myRoom.getSubstanceOfRoom()) {
                num += temp.getWeight() * temp.getFlammableSubstance().getCombustionHeat();
            }
            return num / myRoom.getCommonParameters().getSquare();
        } else if (myRoom.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA() != 0) {
            return myRoom.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA();
        } else
            throw new NullPointerException();
    }

    /**
     * Функция нахождения расчетной пожарной нагрузки
     */
    public Double findEstimatedFireLoad(Room myRoom) {//перемножаем коэффициенты А В С и удельную пожарную нагрузку
        return (myRoom.getParametersCalculatedFireLoad().getSpecificFireLoad() *
                myRoom.getParametersCalculatedFireLoad().getCoefficientA() *
                myRoom.getParametersCalculatedFireLoad().getCoefficientB() *
                myRoom.getParametersCalculatedFireLoad().getCoefficientS());
    }
}
