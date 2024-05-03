package managers.commands;

import data.Route;
import exception.RecursionException;
import exception.RootException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class ExecuteScriptCommand implements BaseCommandInterface {
    private static Stack<File> st = new Stack<>();

    @Override
    public void execute(String[] args) throws Exception {
        File file = new File(args[1]);
        if (!file.canRead()){
            throw new RootException("Недостаточно прав для чтения файла");
        }

        if(st.isEmpty()){
            st.add(file);
        }
        else if(st.contains(file)){
            throw new RecursionException();
        }
        st.add(file);
        String path = args[1];
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        String[] route = new String[10];
        while ((line = br.readLine()) != null) {
            if (line.split(" ")[0].equals("insert")){
                String key = line.split(" ")[0];
                for (int n = 0; n < 10; n++){
                    if ((line = br.readLine()) != null){
                        route[n] = line;
                    }
                }
                CollectionManager.add(key, new Route(route));
            }
            else{
                CommandManager.startExecuting(line);
            }
        }
        st.pop();
    }


    @Override
    public String getName() { return "execute_script file_name"; }

    @Override
    public String getDescription() { return "Команда исполняет скрипт из указанного файла"; }
}
