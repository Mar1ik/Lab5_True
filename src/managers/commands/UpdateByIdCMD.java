package managers.commands;

import data.Worker;
import data.randomizer.WorkerGenerator;
import exceptions.NoElementException;
import managers.CollectionManager;

public class UpdateByIdCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Start executing command...");

        boolean elementInCollection = false;
        Long id = Long.parseLong(args[1]);

        for (String key : CollectionManager.getTable().keySet()) {
            if (CollectionManager.getTable().get(key).getId().equals(id)) {
                System.out.println("Updating element with id " + args[1]);
                elementInCollection = true;
                Long idTrue = CollectionManager.getTable().get(key).getId();
                Worker worker = WorkerGenerator.createWorker(id);
                CollectionManager.remove(key);
                CollectionManager.add(key, worker);
                worker.setId(idTrue);

                System.out.println("Element was updated");
            }
        }
        if (!elementInCollection) {
            try {
                throw new NoElementException(id);
            } catch (NoElementException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return "this command change you data by ID";
    }

    @Override
    public String getName() {
        return "update";
    }
}
