package managers.commands;

import data.Position;
import data.Worker;
import managers.CollectionManager;

import java.util.ArrayList;

public class filter_less_than_position implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        Worker worker;
        Position position = Position.valueOf(args[1].toUpperCase());
        ArrayList<String> keySet = new ArrayList<>();
        for (String key : CollectionManager.getTable().keySet()) {
            if (position.getValue() < CollectionManager.getTable().get(key).getPosition().getValue()) {
                keySet.add(key);
            }
        }
        int k = keySet.size();
        for (String key : keySet) {
           worker = CollectionManager.getTable().get(key);
            System.out.println(worker);
        }
        if (k == CollectionManager.getTable().size()) {
            System.out.println("Nothing was changed");
        }
    }

    @Override
    public String getDescription() {
        return "filter less than position your worker have";
    }

    @Override
    public String getName() {
        return "filter_less";
    }
}