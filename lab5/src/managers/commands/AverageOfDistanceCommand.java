package managers.commands;

import managers.BaseCommandInterface;
import managers.CollectionManager;

//Команда выводит среднее значение поля distance для всех элементов коллекции

public class AverageOfDistanceCommand implements BaseCommandInterface {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Среднее значение поля distance:" + CollectionManager.getAverageOfDistance());
    }
    @Override
    public String getName() {
        return "average_of_distance";
    }
    @Override
    public String getDescription() {
        return "Команда выводит среднее значение поля distance для всех элементов коллекции";
    }
}
