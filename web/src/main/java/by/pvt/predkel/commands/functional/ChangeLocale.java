package by.pvt.predkel.commands.functional;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocale extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String language = request.getParameter(Parameters.LANGUAGE);
        request.getSession().setAttribute(Attributes.LOCALE, language);
        return Path.FUNCTIONS_PATH;
    }
}
