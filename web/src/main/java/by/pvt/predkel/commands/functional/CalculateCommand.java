package by.pvt.predkel.commands.functional;


import by.pvt.predkel.calculateParameters.AllDefinition;
import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.*;
import by.pvt.predkel.exceptions.ServiceException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.commands.navigate.GoToCalculate;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;
import by.pvt.predkel.utils.optional.Transliterator;
import by.pvt.predkel.utils.report.CreateReport;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class CalculateCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IFlammableSubstanceService flammableSubstanceService, User user) {
        GoToCalculate go = new GoToCalculate();

        if ((request.getParameter(Parameters.AMOUNT_OF_ROOMS)).isEmpty()
                || (Integer.parseInt(request.getParameter(Parameters.AMOUNT_OF_ROOMS)) == 0)) {
            request.setAttribute(Attributes.ERROR, Errors.ROOM_AMOUNT_ERROR);
            return go.execute(request, flammableSubstanceService);
        }

        if (request.getParameter(Parameters.NAME_OF_BUILDING).isEmpty()) {
            request.setAttribute(Attributes.ERROR, Errors.CALCULATE_EMPTY_ERROR);
            return go.execute(request, flammableSubstanceService);
        }

        Integer amountOfRooms = Integer.parseInt(request.getParameter(Parameters.AMOUNT_OF_ROOMS));
        Integer amountOfApertures = 6;
        Integer amountOfSubstances = 6;

        Building build = new Building();
        Integer currentAmountOfApertures = 0;
        Integer currentAmountOfSubstances = 0;

        try {

            build.setNameOfBuilding(request.getParameter(Parameters.NAME_OF_BUILDING));
            build.setSelectedTemperatureOfRegion(Double.parseDouble(request.getParameter(Parameters.BUILDING_SELECTED_TEMPERATURE)));

            build.getCoefficientSForBuild().add(Double.parseDouble(request.getParameter(Parameters.BUILDING_C2)));
            build.getCoefficientSForBuild().add(Double.parseDouble(request.getParameter(Parameters.BUILDING_C3)));
            build.getCoefficientSForBuild().add(Double.parseDouble(request.getParameter(Parameters.BUILDING_C5)));
            build.getCoefficientSForBuild().add(Double.parseDouble(request.getParameter(Parameters.BUILDING_C6)));
            build.setSpecifyingCoefficientS5(Double.parseDouble(request.getParameter(Parameters.BUILDING_SPECIFYING_COEFFICIENT_C5)));

            for (int i = 0; i < amountOfRooms; i++) {
                Room room = new Room();
                if (request.getParameterValues(Parameters.POSITION_OF_ROOM)[i].isEmpty() ||
                        request.getParameterValues(Parameters.NAME_OF_ROOM)[i].isEmpty())
                    continue;
                room.getCommonParameters().setPositionOfRoom(request.getParameterValues(Parameters.POSITION_OF_ROOM)[i]);
                room.getCommonParameters().setNameOfRoom(request.getParameterValues(Parameters.NAME_OF_ROOM)[i]);
                room.getCommonParameters().setSquare(Double.parseDouble(request.getParameterValues(Parameters.SQUARE_OF_ROOM)[i]));
                room.getCommonParameters().setHeight(Double.parseDouble(request.getParameterValues(Parameters.HEIGHT_OF_ROOM)[i]));
                room.getCommonParameters().setPerimeter(Double.parseDouble(request.getParameterValues(Parameters.PERIMETER_OF_ROOM)[i]));

                if (request.getParameterValues(Parameters.VOLUME_OF_ROOM)[i].isEmpty()) {
                    room.getCommonParameters().getVolume();
                } else
                    room.getCommonParameters().setVolume(Double.parseDouble(request.getParameterValues(Parameters.VOLUME_OF_ROOM)[i]));

                if (request.getParameterValues(Parameters.SQUARE_OF_CONSTRUCTION_ROOM)[i].isEmpty()) {
                    room.getCommonParameters().getSquareOfConstruction();
                } else room.getCommonParameters().setSquareOfConstruction(Double.parseDouble(
                        request.getParameterValues(Parameters.SQUARE_OF_CONSTRUCTION_ROOM)[i]));


                for (int j = 0; j < amountOfApertures; j++) {
                    Aperture aperture = new Aperture();
                    if (request.getParameterValues(Parameters.TYPE_OF_APERTURE)[currentAmountOfApertures].isEmpty()) {
                        currentAmountOfApertures++;
                        continue;
                    }

                    aperture.setTypeOfAperture(request.getParameterValues(Parameters.TYPE_OF_APERTURE)[currentAmountOfApertures]);
                    aperture.setWidth(Double.parseDouble(request.getParameterValues(Parameters.WIDTH_OF_APERTURE)[currentAmountOfApertures]));
                    aperture.setHeight(Double.parseDouble(request.getParameterValues(Parameters.HEIGHT_OF_APERTURE)[currentAmountOfApertures]));
                    aperture.setCount(Short.parseShort(request.getParameterValues(Parameters.COUNT_OF_APERTURES)[currentAmountOfApertures]));
                    if (request.getParameterValues(Parameters.SQUARE_OF_APERTURE)[currentAmountOfApertures].isEmpty()) {
                        aperture.getSquareOfAperture();
                    } else
                        aperture.setSquareOfAperture(Double.parseDouble(request.getParameterValues(Parameters.SQUARE_OF_APERTURE)[currentAmountOfApertures]));
                    currentAmountOfApertures++;
                    room.getAperture().add(aperture);
                }
                room.getCoefficientSForRoom().add(Double.parseDouble(request.getParameterValues(Parameters.ROOM_C1)[i]));
                room.getCoefficientSForRoom().add(Double.parseDouble(request.getParameterValues(Parameters.ROOM_C4)[i]));
                room.getCoefficientSForRoom().add(Double.parseDouble(request.getParameterValues(Parameters.ROOM_C7)[i]));
                room.getCoefficientSForRoom().add(Double.parseDouble(request.getParameterValues(Parameters.ROOM_C8)[i]));
                room.getCoefficientSForRoom().add(Double.parseDouble(request.getParameterValues(Parameters.ROOM_C9)[i]));
                room.getCoefficientSForRoom().add(Double.parseDouble(request.getParameterValues(Parameters.ROOM_C10)[i]));


                for (int k = 0; k < amountOfSubstances; k++) {
                    if (request.getParameterValues(Parameters.WEIGHT_OF_SUBSTANCE)[currentAmountOfSubstances].isEmpty()) {
                        currentAmountOfSubstances++;
                        continue;
                    }

                    FlammableSubstance substance;
                    try {
                        substance = flammableSubstanceService.getById(
                                Long.parseLong(request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[currentAmountOfSubstances]));
                    } catch (ServiceException e) {
                        MyLogger.INSTANCE.logError(getClass(), e.getMessage());
                        request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
                        return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
                    }

                    SubstanceOfRoom subOfRoom = new SubstanceOfRoom();
                    subOfRoom.setFlammableSubstance(substance);
//                    subOfRoom.setSubstanceId(substance.getId());
                    subOfRoom.setWeight(Double.parseDouble(request.getParameterValues(Parameters.WEIGHT_OF_SUBSTANCE)[currentAmountOfSubstances]));
                    currentAmountOfSubstances++;
                    room.getSubstanceOfRoom().add(subOfRoom);
                }

                if (!request.getParameterValues(Parameters.ROOM_SPECIFIC_FIRE_LOAD_ZVEZDOCHKA)[i].isEmpty())
                    room.getParametersCalculatedFireLoad().setSpecificFireLoadZVEZDOCHKA(
                            Double.parseDouble(request.getParameterValues(Parameters.ROOM_SPECIFIC_FIRE_LOAD_ZVEZDOCHKA)[i]));
                build.getRoom().add(room);

                if (room.getSubstanceOfRoom().size() == 0
                        && request.getParameterValues(Parameters.ROOM_SPECIFIC_FIRE_LOAD_ZVEZDOCHKA)[i].isEmpty()) {
                    request.setAttribute(Attributes.ERROR, Errors.SUBSTANCES_ERROR);
                    return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
                }
            }

        } catch (NullPointerException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.CALCULATE_EMPTY_ERROR);
            return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
        } catch (IllegalArgumentException e2) {
            MyLogger.INSTANCE.logError(getClass(), e2.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.CALCULATE_INCORRECT_ERROR);
            return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
        }

        if (build.getRoom().size() == 0) {
            request.setAttribute(Attributes.ERROR, Errors.CALCULATE_NULL_ROOMS);
            return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
        }

        build.setUserId(user.getId());
        build.setUser(user);

        AllDefinition def = new AllDefinition();
        def.setALlParameters(build);
        //System.getProperty("user.dir") + "/tomcat/webapps/Engineering/other/" + us.getLogin() + "/"- было раньше
        ///путь для генерации отчета и графиков
        String path = request.getServletContext().getRealPath("/") + "asserts/reports/" + user.getLogin() + "/";
        File myPath = new File(path);
        myPath.mkdirs();

        CreateReport create = new CreateReport(build);

        try {
            create.create(path);
        }catch (NumberFormatException e1){
            MyLogger.INSTANCE.logError(getClass(), e1.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.NUMBER_FORMAT_ERROR);
            return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
        }catch (Exception e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.REPORT_ERROR);
            return go.execute(request, flammableSubstanceService);//Path.CALCULATE_PATH;
        }
        request.getSession().setAttribute(Attributes.BUILDING, build);
        request.getSession().setAttribute(Attributes.USERNAME, user.getLogin());
        request.getSession().setAttribute(Attributes.NAME_OF_BUILDING, Transliterator.transliterate(build.getNameOfBuilding()));
        request.getSession().setAttribute(Attributes.NAME_OF_CHARTS, create.getChart().getImageNames());
//        request.getSession().setAttribute(Attributes.REPORT_FILEPATH, path);
        request.getSession().setAttribute(Attributes.SAVE_BUILDING, true);

        return Path.CHART_PATH;
    }
}