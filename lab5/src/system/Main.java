package system;

import managers.Console;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println(Color.ANSI_RED + "Неверный путь" + Color.ANSI_RESET);
        }
        else {
            File file = new File(args[0]);
            if (file.canRead() && file.canWrite()){
                Console console = new Console();
                console.start(System.in, args);
            }
            else {
                System.out.println(Color.ANSI_RED + "Недостаточно прав" + Color.ANSI_RESET);
            }
        }
    }
}

