package by.pvt.predkel.calculateParameters;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.Room;

/**
 * Класс, в котором реализован весь расчет по всему зданию
 */
public class AllDefinition {

    public void setALlParameters(Building build) {
        DefinitionOfParametersOfCalculatedFireLoad1 firstPart = new DefinitionOfParametersOfCalculatedFireLoad1();
        firstPart.setBuilding(build);

        DefinitionOfThermalParametersOfDevelopingFire2 secondPart = new DefinitionOfThermalParametersOfDevelopingFire2();
        secondPart.setBuilding(build);

        for (Room temp : build.getRoom()) {
            firstPart.findCalculatedParameters(temp);//вызывается функция, в которой реализована
            // полная функциональность первого класса
            secondPart.findThermalParameters(temp);//аналогично для второго класса
        }
    }
}
