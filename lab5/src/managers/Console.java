package managers;

import system.Color;
import system.XMLreader;

import java.io.InputStream;
import java.util.Scanner;

public class Console { //чтение командной строки

    public static String data_path;
    public void start(InputStream input, String[] args) {
        Scanner scanner = new Scanner(input);
        CommandManager commandManager = new CommandManager();
        new CollectionManager();
        try {
            System.out.println("Загрузка данных из файла...");
            XMLreader.read(args[0], false);
            data_path = args[0];
            System.out.println(Color.ANSI_CYAN + "Все в порядке" + Color.ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при чтении файла\n" + args[0]);
            System.exit(0);
        }

        System.out.println("Добро пожаловать в программу");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()){
                try {
                    commandManager.startExecuting(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
