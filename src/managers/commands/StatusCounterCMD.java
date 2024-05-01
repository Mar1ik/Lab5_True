package managers.commands;

import data.Status;
import data.Worker;
import managers.CollectionManager;

import java.util.TreeMap;

public class StatusCounterCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 2) {
            try {
                Worker worker = null;
                int count = 0;
                Status myNewEnum = Status.valueOf(args[1].toUpperCase());

                for (String key : CollectionManager.getTable().keySet()) {
                    if (CollectionManager.getTable().get(key).getStatus().equals(myNewEnum)) {
                        count += 1;
                    } else {
                        count += 0;
                    }

                }
                System.out.println(count);


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getDescription() {
        return "return count of your worker's status";
    }

    @Override
    public String getName() {
        return "count_by_status status";
    }
}
