package managers;

import data.Worker;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;

import static managers.ScannerPars.Scan;

public class WriterJSON {
    public static void write(String[] args) throws IOException {
        File file = new File(args[1] + ".json");
        if(!file.canRead()){
            throw new RuntimeException("You don't have enough permission to open this file");
        }
        StringBuilder json = new StringBuilder();
        TreeMap<String, Worker> table = CollectionManager.getTable();
        for (String key : table.keySet()) {
            json.append("\t\t<Worker ");
            json.append("key=\"").append(key).append("\" ");
            Worker worker = table.get(key);
            json.append(worker.toString()).append("/>\n");
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(args[1] + ".json"));
        bufferedOutputStream.write(json.toString().getBytes());
        bufferedOutputStream.close();
    }
}
