package managers.commands;

import data.Worker;

import java.util.TreeMap;

public class ExitCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.exit(1);
    }

    @Override
    public String getDescription() {
        return "This command complete exit from program";
    }

    @Override
    public String getName() {
        return "exit";
    }
}
