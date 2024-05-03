package managers.commands;

import data.Route;
import data.generators.RouteGenerator;
import exception.ArgumentException;
import exception.BuildRouteObjException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import system.Color;

//Команда добавляет новый элемент по ключу

public class InsertNullCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws ArgumentException {
        System.out.println(Color.ANSI_CYAN + "Началось выполнение команды..." + Color.ANSI_RESET);
        if (args.length == 2 && !CollectionManager.getTable().containsKey(args[1])) {
            try {
                Object route = RouteGenerator.createRoute(0L);
                CollectionManager.add(args[1], (Route) route);
                System.out.println(Color.ANSI_CYAN + "Добавление элемента завершено" + Color.ANSI_RESET);
            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (BuildRouteObjException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Программа возвращена в безопасное состояние");
            }
        } else throw new ArgumentException("KEY");
    }

    @Override
    public String getName() {
        return "insert null {element}";
    }

    @Override
    public String getDescription() {
        return "Команда добавляет новый элемент по ключу";
    }
}
