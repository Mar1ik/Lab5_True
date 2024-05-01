package managers.commands;

import data.Worker;
import managers.CommandManager;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HelpCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CommandManager commandManager = new CommandManager();
        LinkedHashMap<String, BasicCommand> commandlist = commandManager.getCommandList();
        for (String name : commandlist.keySet()) {
            BasicCommand command = commandlist.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return "this command show you information about all commands";
    }

    @Override
    public String getName() {
        return "help";
    }
}
