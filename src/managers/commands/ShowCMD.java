package managers.commands;

import data.Worker;
import managers.CollectionManager;

public class ShowCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        Worker worker;
        for(String key : CollectionManager.getTable().keySet()){
            worker = CollectionManager.getTable().get(key);
            System.out.println(worker.toString());
        }
    }

    @Override
    public String getDescription() {
        return "this command is showing your collection";
    }

    @Override
    public String getName() {
        return "show";
    }
}
