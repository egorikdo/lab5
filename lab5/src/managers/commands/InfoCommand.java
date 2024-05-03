package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;

//Команда выводит информацию о программе
public class InfoCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Тип данных: " + CollectionManager.getTable().getClass().getName());
        System.out.println("Дата инициализации: " + CollectionManager.getInDate());
        System.out.println("Количество маршрутов: " + CollectionManager.getTable().size());
    }
    @Override
    public String getName() {
        return "info";
    }
    @Override
    public String getDescription() {
        return "Команда выводит информацию о программе";
    }
}
