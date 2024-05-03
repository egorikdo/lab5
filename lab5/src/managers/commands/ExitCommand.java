package managers.commands;

import managers.BaseCommandInterface;

//Команда завершает программу без сохранения

public class ExitCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        System.exit(1);
    }
    @Override
    public String getName() {
        return "exit";
    }
    @Override
    public String getDescription() {
        return "Команда завершает программу без сохранения";
    }
}
