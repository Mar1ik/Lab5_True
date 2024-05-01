package managers.commands;

import data.Worker;
import managers.CollectionManager;

import java.util.TreeMap;

public class SumSalaryCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("A salary count of your worker's is " + CollectionManager.sumSalary());
    }

    @Override
    public String getDescription() {
        return "this program calculate all salary of your workers";
    }

    @Override
    public String getName() {
        return "sumsalary";
    }
}
