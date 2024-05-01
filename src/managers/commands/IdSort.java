package managers.commands;

import data.Worker;
import managers.CollectionManager;

import java.util.TreeMap;

public class IdSort implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        Worker worker = null;
        int count = 0;
        TreeMap<String, Worker> table = CollectionManager.getTable();
        for (String key : table.keySet()) {
            if (worker == null) {
                worker = table.get(key);
                count += 0;
            } else if (worker.compareTo(table.get(key)) < 0) {
                worker = table.get(key);

            }System.out.println(worker);

        }

    }

    @Override
    public String getDescription() {
        return "this command reduce your collection by id";
    }

    @Override
    public String getName() {
        return "minId";
    }
}
