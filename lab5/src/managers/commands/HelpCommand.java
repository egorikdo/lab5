package managers.commands;

import managers.BaseCommandInterface;
import managers.CommandManager;
import system.Color;

import java.util.LinkedHashMap;

//Команда выводит описание всех команд

public class HelpCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception{
        CommandManager commandManager = new CommandManager();
        LinkedHashMap<String, BaseCommandInterface> commandList = commandManager.getCommandList();
        for (String name: commandList.keySet()){
            BaseCommandInterface command = commandList.get(name);
            System.out.println(Color.ANSI_CYAN + command.getName() + Color.ANSI_RESET + " - " + command.getDescription());
        }
    }
    @Override
    public String getName() {
        return "help";
    }
    @Override
    public String getDescription() {
        return "Получить информации о доступных командах";
    }
}
