package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;

//Команда очищает коллекцию

public class ClearCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.getTable().clear();
        System.out.println("Коллекция очищена");
    }
    @Override
    public String getName() {
        return "clear";
    }
    @Override
    public String getDescription() {
        return "Команда очищает коллекцию";
    }
}
