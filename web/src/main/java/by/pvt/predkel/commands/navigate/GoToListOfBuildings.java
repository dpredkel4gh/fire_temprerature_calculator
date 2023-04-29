package by.pvt.predkel.commands.navigate;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IBuildingService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Здесь из БД достается список отчетов, сгенеренных данным юзером
 * и выкидываюся на jsp в виде таблицы
 */
public class GoToListOfBuildings extends AbstractCommand {

    public String execute(HttpServletRequest request, IBuildingService buildingService, User user) {

        List<Building> buildings = null;
        try {
            buildings = buildingService.getAllByFk(user.getId());
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }

        request.setAttribute(Attributes.ALL_USER_BUILDINGS, buildings);
        return Path.BUILDINGS_PATH;
    }

    private boolean checkLists(List<Building> list1, List<Building> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i)))
                return false;
        }
        return true;
    }
}
