package managers.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.NoElementEx;
import managers.CollectionManager;

import java.io.File;

public class RemoveCMD implements BasicCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Removing element from collection");
        try {
            CollectionManager.remove(args[1]);
            System.out.println("it has removed");
        } catch (NoElementEx e) {
            System.out.println(e.getMessage());
            System.out.println("Program has returned to safe state");
        }
    }

    @Override
    public String getDescription() {
        return "remove element from collection";
    }

    @Override
    public String getName() {
        return "remove element";
    }
}
