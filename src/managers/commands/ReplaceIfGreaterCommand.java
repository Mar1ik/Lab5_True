package managers.commands;

import data.Worker;
import data.comparator.SalaryComp;
import data.randomizer.WorkerGenerator;
import managers.CollectionManager;

import java.util.TreeMap;

public class ReplaceIfGreaterCommand implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        String key = args[1];
        TreeMap<String, Worker> table = CollectionManager.getTable();
        SalaryComp c1 = new SalaryComp();
        if (table.containsKey(key)) {
            Worker worker = WorkerGenerator.createWorker(0L);
            if (c1.compare(worker, table.get(key)) > 0) {
                CollectionManager.remove(key);
                CollectionManager.add(key, worker);
                System.out.println("Complete");
            }else{
                System.out.println("Nothing change");
            }
        }
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "null {element} - update element by key if new bigger than element in collection with the same key";
    }
}
