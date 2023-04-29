package by.pvt.predkel.commands.navigate;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.parameters.Path;

public class GoToHelp extends AbstractCommand {

    public String execute() {
        return Path.HELP_PATH;
    }
}
