package managers.commands;
import exception.NoElementException;
import managers.BaseCommandInterface;
import managers.CollectionManager;
import system.Color;

//Команда удаляет элемент из коллекции по его ключу
public class RemoveKeyCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception{
        System.out.println(Color.ANSI_CYAN + "Начало выполнения команды" + Color.ANSI_RESET);
        try {
            CollectionManager.remove(args[1]);
            System.out.println(Color.ANSI_CYAN + "Элемент удален" + Color.ANSI_RESET);
        } catch (NoElementException e) {
            System.out.println(Color.ANSI_RED + e.getMessage() + Color.ANSI_RESET);
            System.out.println("Программа возвращена в безопасное состояние");
        }
    }
    @Override
    public String getName() {
        return "remove_key null";
    }
    @Override
    public String getDescription() {
        return "Команда удаляет элемент из коллекции по его ключу";
    }
}
