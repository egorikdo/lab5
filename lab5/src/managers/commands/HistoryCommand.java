package managers.commands;

import managers.BaseCommandInterface;
import managers.CommandManager;

//Команда выводит последние команды
public class HistoryCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        String[] sp = new String[6];
        int n = 0;
        for (BaseCommandInterface command : CommandManager.lastCommands) {
            sp[n] = command.getName();
            n += 1;
        }
        for (int i = 0; i < 6; i++) {
            if (!(sp[i] == null)) {
                System.out.println("-" + sp[i]);
            }
        }
    }

    @Override
    public String getName() { return "history"; }

    @Override
    public String getDescription() {return "Команда выводит последние команды"; }
}
