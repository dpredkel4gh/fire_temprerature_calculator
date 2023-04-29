package by.pvt.predkel.commands.factory;

import by.pvt.predkel.commands.Command;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Parameters;

import javax.servlet.http.HttpServletRequest;

public enum CommandFactory {
    INSTANCE;

    public Command defineCommand(HttpServletRequest request) {
        Command current = null;
        String commandName = request.getParameter(Parameters.COMMAND);
        try {
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = type.getCurrentCommand();
        } catch (NullPointerException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return current;
    }
}
