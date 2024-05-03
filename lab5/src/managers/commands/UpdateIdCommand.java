package managers.commands;

import data.Route;
import data.generators.RouteGenerator;
import exception.NoElementException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import system.Color;


//Команда обновляет элемент коллекции по ID
public class UpdateIdCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Начало выполнения команды...");

        boolean elementInCollection = false;
        Long id = Long.parseLong(args[1]);

        for (String key : CollectionManager.getTable().keySet()) {
            if (CollectionManager.getTable().get(key).getId().equals(id)) {
                System.out.println(Color.ANSI_CYAN + "Обновление элемента по ID " + args[1] + Color.ANSI_RESET);
                elementInCollection = true;

                Route organization = RouteGenerator.createRoute(id);
                CollectionManager.remove(key);
                CollectionManager.add(key, organization);

                System.out.println(Color.ANSI_CYAN + "Обновление завершено" + Color.ANSI_RESET);
            }
        }
        if (!elementInCollection) {
            throw new NoElementException(id);
        }
    }
    @Override
    public String getName() {
        return "update id {element}";
    }
    @Override
    public String getDescription() {
        return "Команда обновляет элемент коллекции по ID";
    }
}
