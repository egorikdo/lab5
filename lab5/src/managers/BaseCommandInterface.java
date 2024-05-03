package managers;

public interface BaseCommandInterface { // базовый интерфейс для реализации команд

    void execute(String[] args) throws Exception; // Метод для выводы исполнения команды
    String getName(); //метод для вывода названия команды
    String getDescription(); //метод для вывода описания команды

}
