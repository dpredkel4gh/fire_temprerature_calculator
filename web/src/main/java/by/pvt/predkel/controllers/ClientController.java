package by.pvt.predkel.controllers;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.commands.functional.BuildingsListCommand;
import by.pvt.predkel.commands.functional.CalculateCommand;
import by.pvt.predkel.commands.functional.SaveReportCommand;
import by.pvt.predkel.commands.navigate.*;
import by.pvt.predkel.security.PrincipalUtil;
import by.pvt.predkel.serviceForDao.IBuildingService;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private IFlammableSubstanceService flammableSubstanceService;
    @Autowired
    private IBuildingService buildingService;
    @Autowired
    private PrincipalUtil principalUtil;

    @RequestMapping(value = "/main")
    public String goToFunctions() throws ServletException, IOException {
        return new GoToListOfFunctions().execute();
    }

    @RequestMapping(value = "/help")
    public String goToHelp() throws ServletException, IOException {
        return new GoToHelp().execute();
    }

    @RequestMapping(value = "/recalculate")
    public String goToRecalculate(HttpServletRequest request) throws ServletException, IOException {
        return new GoToReCalculate().execute(request, flammableSubstanceService);
    }

    @RequestMapping(value = "/calculate")
    public String goToCalculate(HttpServletRequest request) throws ServletException, IOException {
        return new GoToCalculate().execute(request, flammableSubstanceService);
    }

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public String calculate(HttpServletRequest request) throws ServletException, IOException {
        User user = principalUtil.getPrincipal();
        return new CalculateCommand().execute(request, flammableSubstanceService, user);
    }

    @RequestMapping(value = "/history")
    public String goToBuildings(HttpServletRequest request) throws ServletException, IOException {
        User user = principalUtil.getPrincipal();
        return new GoToListOfBuildings().execute(request, buildingService, user);
    }

    @RequestMapping(value = "/history/edit", method = RequestMethod.POST)
    public String buildings(HttpServletRequest request) throws ServletException, IOException {
        User user = principalUtil.getPrincipal();
        return new BuildingsListCommand().execute(request, buildingService, user);
    }

    @RequestMapping(value = "/result/save")
    public String saveReport(HttpServletRequest request) throws ServletException, IOException {
        return new SaveReportCommand().execute(request, buildingService);
    }

}

