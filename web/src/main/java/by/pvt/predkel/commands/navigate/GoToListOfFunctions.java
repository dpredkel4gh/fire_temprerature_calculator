package by.pvt.predkel.commands.navigate;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.parameters.Path;

public class GoToListOfFunctions extends AbstractCommand {

    public String execute() {
        return Path.FUNCTIONS_PATH;
    }
}
