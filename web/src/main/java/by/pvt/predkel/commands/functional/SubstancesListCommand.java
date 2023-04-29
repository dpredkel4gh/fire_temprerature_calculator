package by.pvt.predkel.commands.functional;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.ServiceException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.commands.navigate.GoToListOfSubstances;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;

import javax.servlet.http.HttpServletRequest;

public class SubstancesListCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IFlammableSubstanceService flammableSubstanceService) {

        GoToListOfSubstances go = new GoToListOfSubstances();

        Integer size = Integer.parseInt(request.getParameter(Parameters.AMOUNT_OF_SUBSTANCES));

        FlammableSubstance sub = new FlammableSubstance();
        try {
            for (int i = 0; i < size; i++)
                if (request.getParameterValues(Parameters.ID_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.COMBUSTION_HEAT)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i].isEmpty()) {

                    sub.setNameOfSubstance(request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i]);
                    sub.setAmountOfCombustionAir(Double.parseDouble(request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i]));
                    sub.setCombustionHeat(Double.parseDouble(request.getParameterValues(Parameters.COMBUSTION_HEAT)[i]));
                    sub.setAverageSpeedBurnout(Double.parseDouble(request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i]));
                    flammableSubstanceService.save(sub);

                } else if (!request.getParameterValues(Parameters.ID_SUBSTANCE)[i].isEmpty() && (
                        request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i].isEmpty() ||
                                request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i].isEmpty() ||
                                request.getParameterValues(Parameters.COMBUSTION_HEAT)[i].isEmpty() ||
                                request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i].isEmpty())) {

                    sub.setId(Long.parseLong(request.getParameterValues(Parameters.ID_SUBSTANCE)[i]));
                    flammableSubstanceService.delete(sub);

                } else if (!request.getParameterValues(Parameters.ID_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.COMBUSTION_HEAT)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i].isEmpty()) {

                    sub.setId(Long.parseLong(request.getParameterValues(Parameters.ID_SUBSTANCE)[i]));
                    sub.setNameOfSubstance(request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i]);
                    sub.setAmountOfCombustionAir(Double.parseDouble(request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i]));
                    sub.setCombustionHeat(Double.parseDouble(request.getParameterValues(Parameters.COMBUSTION_HEAT)[i]));
                    sub.setAverageSpeedBurnout(Double.parseDouble(request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i]));
                    flammableSubstanceService.update(sub);
                }
        } catch (ServiceException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return go.execute(request, flammableSubstanceService);
        } catch (IllegalArgumentException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.CALCULATE_INCORRECT_ERROR);
            return go.execute(request, flammableSubstanceService);
        }
        return go.execute(request, flammableSubstanceService);
    }
}
