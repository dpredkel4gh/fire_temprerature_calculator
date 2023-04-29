package by.pvt.predkel.listener;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.utils.optional.DeleteFiles;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;

/**
 * Листенер был создан для создания папки с именем пользователя, когда он заходит
 * там бы складывались его графики и отчеты
 * а после выхода удалялись
 */
public class DeleteGeneratedFiles implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        try {
            User user = (User) session.getAttribute(Attributes.USER);
            DeleteFiles.deleteDir(new File((session.getServletContext().getRealPath("/") + "jsp/reports/" + user.getLogin() + "/")));
        } catch (NullPointerException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage() + " Package did not created");
        }

    }
}
