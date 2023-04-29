package by.pvt.predkel.commands.factory;


import by.pvt.predkel.commands.Command;
import by.pvt.predkel.commands.functional.*;
import by.pvt.predkel.commands.navigate.*;

public enum CommandType {
    //functional commands
    LOGIN, LOGOUT, REGISTRATION, CALCULATE, SUBSTANCES, BUILDINGS, SAVEREPORT,
    //navigate commands
    TOCALCULATE, TORECALCULATE, TOBUILDINGS, TOSUBSTANCES, TOFUNCTIONS, TOREGISTER, TOHELP,
    //locale command
    SETLANGUAGE,
    //pagination
    SETSIZE;

    public Command getCurrentCommand() throws EnumConstantNotPresentException {
        switch (this) {
            case LOGIN:
                return new LoginUserCommand();

            case LOGOUT:
                return new LogoutUserCommand();

            case REGISTRATION:
                return new RegistrationUserCommand();

            case CALCULATE:
                return new CalculateCommand();

            case SUBSTANCES:
                return new SubstancesListCommand();

            case BUILDINGS:
                return new BuildingsListCommand();

            case SAVEREPORT:
                return new SaveReportCommand();

            case TOCALCULATE:
                return new GoToCalculate();

            case TORECALCULATE:
                return new GoToReCalculate();

            case TOBUILDINGS:
                return new GoToListOfBuildings();

            case TOSUBSTANCES:
                return new GoToListOfSubstances();

            case TOFUNCTIONS:
                return new GoToListOfFunctions();

            case TOREGISTER:
                return new GoToRegister();

            case TOHELP:
                return new GoToHelp();

            case SETLANGUAGE:
                return new ChangeLocale();

            case SETSIZE:
                return new SetPaginationSize();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
