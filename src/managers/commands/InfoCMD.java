package managers.commands;

import managers.CollectionManager;

public class InfoCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Data type - " + CollectionManager.getTable().getClass().getName());
        System.out.println("Count of workers - " + CollectionManager.getTable().keySet().size());
        System.out.println("Init date - " + CollectionManager.getDate());
    }

    @Override
    public String getDescription() {
        return "return information about program";
    }

    @Override
    public String getName() {
        return "info";
    }
}
