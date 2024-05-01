package parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Worker;
import exceptions.BuildWorkerEX;
import exceptions.IdCopyEX;
import exceptions.WrongArgEX;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class JsonParser {


    public Object JsonParser(String[] args) throws WrongArgEX, IdCopyEX, BuildWorkerEX, IOException {

        Gson gson = new Gson();
        File filename = new File(args[1] + ".txt");
        return gson.fromJson(new FileReader(filename), new TypeToken<TreeMap<String, Worker>>() {}.getType());
    }
}
