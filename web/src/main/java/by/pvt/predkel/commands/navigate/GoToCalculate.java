package by.pvt.predkel.commands.navigate;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.ServiceException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToCalculate extends AbstractCommand {

    public String execute(HttpServletRequest request, IFlammableSubstanceService flammableSubstanceService) {
        List<FlammableSubstance> substances = null;
        try {
            substances = flammableSubstanceService.getAll();
        } catch (ServiceException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }

        request.setAttribute(Attributes.ALL_SUBSTANCES, substances);
        return Path.CALCULATE_PATH;
    }
}
