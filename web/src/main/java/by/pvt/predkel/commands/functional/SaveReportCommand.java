package by.pvt.predkel.commands.functional;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IBuildingService;

import javax.servlet.http.HttpServletRequest;

public class SaveReportCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IBuildingService buildingService) {
        Building build = (Building) request.getSession().getAttribute(Attributes.BUILDING);
        try {
            buildingService.addBuilding(build);
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }
        request.getSession().setAttribute(Attributes.SAVE_BUILDING, false);
        return Path.CHART_PATH;
    }
}
