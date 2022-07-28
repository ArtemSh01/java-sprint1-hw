import java.util.Arrays;
import java.util.Collections;

public class StepTracker {

    int[][] MonthData = new int[12][30];

    public StepTracker() { // [12]

        for (int i = 0; i < MonthData.length; i++) {
            for (int j = 0; j < MonthData[i].length; j++){
                MonthData[i][j] = 0;
            }
        }
    }

    boolean addSteps(int[][] MonthData, int month, int day, int steps) {
        if (MonthData[month-1][day-1] != 0){
            return false;
        }
        else {
            MonthData[month-1][day-1] = steps;
            return true;
        }

    }

    public void stepStats(int neededMonth) {
        int sum = 0;
        int maxValue = 0;
        int counter = 0;
        for (int j = 0; j < MonthData[neededMonth].length; j++){
            System.out.println("День " + (j + 1) + ": Пройдено шагов: " + MonthData[neededMonth-1][j]);
            sum += MonthData[neededMonth-1][j];
            if (MonthData[neededMonth-1][j] > maxValue){
                maxValue = MonthData[neededMonth-1][j];
            }
            if (MonthData[neededMonth-1][j] != 0){
                ++counter;
            }
        }
        System.out.println("Сумма шагов за месяц: " + sum);
        System.out.println("Максимальное кол-во шагов за месяц: " + maxValue);
        System.out.println("Среднее кол-во шагов: " + (sum / counter));
    }


}