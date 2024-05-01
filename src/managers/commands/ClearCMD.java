package managers.commands;

import managers.CollectionManager;

public class ClearCMD implements BasicCommand {
    @Override
    public void execute(String[] args) {
        CollectionManager.getTable().clear();
        System.out.println("Collection has been cleared");
    }

    @Override
    public String getDescription() {
        return "clear data from collection";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
