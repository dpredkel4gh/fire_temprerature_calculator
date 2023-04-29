package by.pvt.predkel.commands.functional;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IUserService;

import javax.servlet.http.HttpServletRequest;

public class LoginUserCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IUserService userService) {

        if (request.getParameter(Parameters.LOGIN).isEmpty() || request.getParameter(Parameters.PASSWORD).isEmpty()) {
            request.setAttribute(Attributes.ERROR, Errors.USER_EMPTY_ERROR);
            return Path.INDEX_PATH;
        }
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        User user;

        try {
            user = userService.loginUser(login, password);

        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return Path.INDEX_PATH;
        }

        if (user != null) {
            request.getSession(true).setAttribute(Attributes.USER, user);
            return Path.FUNCTIONS_PATH;
        } else {
            request.setAttribute(Attributes.ERROR, Errors.USER_INCORRECT_ERROR);
            return Path.INDEX_PATH;
        }
    }
}
