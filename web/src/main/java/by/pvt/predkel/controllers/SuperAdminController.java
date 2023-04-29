package by.pvt.predkel.controllers;

import by.pvt.predkel.commands.functional.RegistrationUserCommand;
import by.pvt.predkel.commands.navigate.GoToRegister;
import by.pvt.predkel.serviceForDao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/moder")
public class SuperAdminController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/registration")
    public String goToRegister() throws ServletException, IOException {
        return new GoToRegister().execute();
    }

    @RequestMapping(value = "/registration/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) throws ServletException, IOException {
        return new RegistrationUserCommand().execute(request, userService);
    }

}

