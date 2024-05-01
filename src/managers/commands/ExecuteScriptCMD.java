package managers.commands;

import data.Worker;
import exceptions.NoElementEx;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Stack;
import java.util.TreeMap;

public class ExecuteScriptCMD implements BasicCommand {
    private static Stack<File> st = new Stack<>();

    @Override
    public void execute(String[] args) throws Exception {
        File file = new File(args[1] );
        if (!file.canRead()) {
            throw new NoElementEx("You do not have enough rights to read the file");
        }

        if (st.isEmpty()) {
            st.add(file);
        } else if (st.contains(file)) {
            throw new NoElementEx("You're having a recursion in your script&, please, delete your execute to another script and try again");
        }
        st.add(file);
        String path = args[1];
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        String[] work = new String[10];
        while ((line = br.readLine()) != null) {
            if (line.split(" ")[0].equals("insert")) {
                String key = line.split(" ")[1];
                for (int n = 1; n < 10; n++) {
                    if ((line = br.readLine()) != null) {
                        work[n] = line;
                    }
                }
                CollectionManager.add(key, new Worker(work));
            } else {
                CommandManager.startExecuting(line);
            }
        }
        st.pop();
    }

    @Override
    public String getDescription() {
        return "execute your script file";
    }

    @Override
    public String getName() {
        return "execute";
    }
}

