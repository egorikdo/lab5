package managers.commands;


import managers.BaseCommandInterface;
import managers.Console;
import system.Color;
import system.XMLwriter;


//Команда сохраняет коллекцию в файл (XML)
public class SaveCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        XMLwriter.write(Console.data_path);
        System.out.println(Color.ANSI_CYAN + "Данные сохранены в:" + Color.ANSI_RESET + "\n" + Console.data_path);
    }
    @Override
    public String getName() {
        return "Save";
    }
    @Override
    public String getDescription() {
        return "Команда сохраняет коллекцию в файл";
    }
}
