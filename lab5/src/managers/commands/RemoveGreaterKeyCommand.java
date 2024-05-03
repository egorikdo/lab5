package managers.commands;

import data.Route;
import managers.BaseCommandInterface;
import managers.CollectionManager;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

//Команда удаляет из коллекции все элементы, ключ которых превышает заданный
public class RemoveGreaterKeyCommand implements BaseCommandInterface {

    @Override
    public void execute(String[] args) throws Exception {
        Hashtable<String, Route> table = CollectionManager.getTable();
        System.out.println("Введите ID:");
        Scanner scanner = new Scanner(System.in);
        String newId = scanner.nextLine();

        boolean removed = false;
        Iterator<Route> iterator = table.values().iterator();
        while (iterator.hasNext()) {
            Route route = iterator.next();
            if (Long.parseLong(newId) < route.getId()) {
                iterator.remove();
                removed = true;
            }
        }

        if (removed) {
            System.out.println("Элементы удалены");
        } else {
            System.out.println("В коллекции нет элементов, ключи которых больше заданного");
        }
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    @Override
    public String getDescription() { return "Команда удаляет из коллекции все элементы, ключ которых превышает заданный"; }
}
