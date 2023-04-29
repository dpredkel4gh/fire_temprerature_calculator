package by.pvt.predkel.commands.functional;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.exceptions.ServiceException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IBuildingService;
import by.pvt.predkel.utils.report.CreateReport;
import by.pvt.predkel.utils.optional.Transliterator;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class BuildingsListCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IBuildingService buildingService, User user) {
        String action = request.getParameter(Parameters.BUILDING_ACTION);

        String idBuilding = request.getParameter(Parameters.ID_BUILDING);

        Building build;
        try {
            build = buildingService.getById(Long.parseLong(idBuilding));

            if (action.equals(Parameters.SAVE)) {//если пользователь выбрал скачивание отчета
                //здесь надо либо создавать новый отчет или достать старый
                CreateReport create = new CreateReport(build);

                String path = request.getServletContext().getRealPath("/") + "asserts/reports/" + user.getLogin() + "/";
                File myPath = new File(path);
                myPath.mkdirs();
                try {
                    create.create(path);
                } catch (Exception e) {
                    MyLogger.INSTANCE.logError(getClass(), e.getMessage());
                    request.setAttribute(Attributes.ERROR, Errors.REPORT_ERROR);
                    return Path.BUILDINGS_PATH;
                }

                request.getSession().setAttribute(Attributes.BUILDING, build);
                request.getSession().setAttribute(Attributes.USERNAME, user.getLogin());
                request.getSession().setAttribute(Attributes.NAME_OF_BUILDING, Transliterator.transliterate(build.getNameOfBuilding()));
                request.getSession().setAttribute(Attributes.NAME_OF_CHARTS, create.getChart().getImageNames());
                request.getSession().setAttribute(Attributes.REPORT_FILEPATH, path);
                request.getSession().setAttribute(Attributes.SAVE_BUILDING, true);

                return Path.CHART_PATH;
            } else if (action.equals(Parameters.DELETE)) {//если пользователь выбрал удаление отчета
                buildingService.delete(build);
                request.setAttribute(Attributes.ALL_USER_BUILDINGS, buildingService.getAllByFk(user.getId()));
                return Path.BUILDINGS_PATH;
            }
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return Path.BUILDINGS_PATH;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return Path.BUILDINGS_PATH;
    }
}
