package managers.commands;

import data.Worker;
import data.randomizer.WorkerGenerator;
import exceptions.BuildWorkerEX;
import exceptions.WrongArgEX;
import managers.CollectionManager;

public class InsertCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Starting execute program");
        if (args.length == 2) {
            try {
                Worker worker = WorkerGenerator.createWorker(0L);
                CollectionManager.add(args[1], worker);
                System.out.println("Element was added");
            } catch (WrongArgEX e) {
                System.out.println(e.getMessage());
            } catch (BuildWorkerEX e) {
                System.out.println(e.getMessage());
                System.out.println("Program has returned for a safe state");
            }
        } else {
            throw new WrongArgEX("Error!!!\nPRINT KEY");
        }
    }

    @Override
    public String getDescription() {
        return "insert element into collection";
    }

    @Override
    public String getName() {
        return "insert";
    }
}
