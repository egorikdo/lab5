package managers.commands;

import data.Route;
import data.generators.IdGenerator;
import data.generators.RouteGenerator;
import managers.BaseCommandInterface;
import managers.CollectionManager;

import java.util.Hashtable;
import java.util.Scanner;

//Команда удаляет из коллекции все элементы, превышающие заданный

public class RemoveGreaterCommand implements BaseCommandInterface {

    @Override
    public void execute(String[] args) throws Exception {
        Hashtable<String, Route> table = CollectionManager.getTable();
        Route newroute = RouteGenerator.createRoute(IdGenerator.generateId());
        System.out.println("Введите ID:");
        Scanner scanner = new Scanner(System.in);
        String newId = scanner.nextLine();
        newroute.setId(Long.valueOf(newId));

        boolean removed = false;
        for (Route route: table.values()){
            if (route.compareTo(newroute)>0){
                removed = true;
                break;
            }
        }
        if (removed) {
            table.put(newId,newroute);
            System.out.println("Элементы удалены");

        } else {
            System.out.println("В коллекции нет элементов, превышающих заданный");
        }
    }


    @Override
    public String getName() { return "remove_greater"; }

    @Override
    public String getDescription() { return "Команда удаляет из коллекции все элементы, превышающие заданный"; }
}
