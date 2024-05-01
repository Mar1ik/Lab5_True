package managers.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import managers.CollectionManager;

import java.io.File;
import java.io.FileOutputStream;

public class SaveCMD implements BasicCommand {

    @Override
    public void execute(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(false));

        File filename = new File(args[1] + ".json");

        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(CollectionManager.getTable());

        fileOutputStream.write(json.getBytes());
        fileOutputStream.close();


        //objectMapper.writeValue(new File(filename + ".json"), CollectionManager.getTable());
        System.out.println("Your programm has been saved");
    }

    @Override
    public String getDescription() {
        return "this command is saving your worker";
    }

    @Override
    public String getName() {
        return "save";
    }
}
