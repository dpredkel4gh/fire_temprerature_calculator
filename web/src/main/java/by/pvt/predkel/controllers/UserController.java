package by.pvt.predkel.controllers;

import by.pvt.predkel.commands.functional.ChangeLocale;
import by.pvt.predkel.commands.navigate.SetPaginationSize;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.parameters.WebConstants;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private IFlammableSubstanceService flammableSubstanceService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(HttpServletRequest request,
                               HttpServletResponse response,
                               RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equalsIgnoreCase(WebConstants.ANONYMOUS_USER)) {
            redirectAttributes.addFlashAttribute(Attributes.ERROR, Errors.USER_INCORRECT_ERROR);
        }
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return Path.INDEX_PATH;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() throws ServletException, IOException {
        return Path.INDEX_PATH;
    }

//    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
//    public void logout(HttpServletRequest request,
//                       HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().invalidate();
//        request.getRequestDispatcher(Path.INDEX_PATH).forward(request, response);
//    }

    @RequestMapping(value = "/setlanguage")
    public String changeLocale(HttpServletRequest request) throws ServletException, IOException {
        return new ChangeLocale().execute(request);
    }

    @RequestMapping(value = "/setsize")
    public String serPaginationSize(HttpServletRequest request) throws ServletException, IOException {
        return new SetPaginationSize().execute(request, flammableSubstanceService);
    }
}

