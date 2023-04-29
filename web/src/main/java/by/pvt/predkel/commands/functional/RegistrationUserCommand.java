package by.pvt.predkel.commands.functional;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.entities.access.AccessLevelType;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.*;
import by.pvt.predkel.serviceForDao.IUserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationUserCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IUserService userService) {

        User user = new User();

        if (request.getParameter(Parameters.LOGIN).isEmpty() ||
                request.getParameter(Parameters.PASSWORD).isEmpty() ||
                request.getParameter(Parameters.PASSWORD2).isEmpty()) {
            request.setAttribute(Attributes.ERROR, Errors.USER_EMPTY_ERROR);
            return Path.REGISTRATION_PATH;
        } else if (!request.getParameter(Parameters.PASSWORD).equals(request.getParameter(Parameters.PASSWORD2))) {
            request.setAttribute(Attributes.ERROR, Errors.INCORRECT_PASSWORD);
        } else {
            user.setLogin(request.getParameter(Parameters.LOGIN));
            user.setPassword(request.getParameter(Parameters.PASSWORD));
            if (request.getParameter(Parameters.ROLE).equals(WebConstants.ROLE_ADMIN))
                user.setAccessLevelType(AccessLevelType.ADMIN);
            else user.setAccessLevelType(AccessLevelType.USER);
        }

        Boolean checker;
        try {
            checker = userService.registerUser(user);
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return Path.REGISTRATION_PATH;
        }
        if (!checker) {
            request.setAttribute(Attributes.ERROR, Errors.USER_NOT_EMPTY_LOGIN_ERROR);
            return Path.REGISTRATION_PATH;
        }

        return Path.FUNCTIONS_PATH;
    }
}
