package managers.commands;

import data.Route;
import managers.BaseCommandInterface;
import managers.CollectionManager;

import java.util.Hashtable;

//Команда выводит все элементы коллекции в строковом представлении
public class ShowCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        Hashtable<String, Route> table = CollectionManager.getTable();
        for (String x : table.keySet()) {
            System.out.println(table.get(x));
        }
        if (table.isEmpty()) {
            System.out.println(CollectionManager.getTable().getClass().getName() + " пусто");
        }
    }
    @Override
    public String getName() {
        return "show";
    }
    @Override
    public String getDescription() {
        return "Команда выводит все элементы коллекции в строковом представлении";
    }
}
