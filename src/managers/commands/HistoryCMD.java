package managers.commands;

import managers.CommandManager;

public class HistoryCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println(CommandManager.lastSixCommand);
    }

    @Override
    public String getDescription() {
        return "return last twelve commands";
    }

    @Override
    public String getName() {
        return "history";
    }
}
