import java.util.Arrays;

public class StepTracker {

    int[][] MonthData = new int[12][30];

    public StepTracker() { // Заполнение массива
        for (int[] monthDatum : MonthData) Arrays.fill(monthDatum, 10000);
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

    public void stepStats(int neededMonth ) {
        int sum = 0;
        int maxValue = 0;
        int counter = 0;
        Converter converter = new Converter();

        for (int j = 0; j < MonthData[neededMonth].length; j++){

            System.out.println((j + 1)+" день: "+ MonthData[neededMonth-1][j]+ " шагов");
            sum += MonthData[neededMonth-1][j];
            if (MonthData[neededMonth-1][j] > maxValue){
                maxValue = MonthData[neededMonth-1][j];
            }
            if (MonthData[neededMonth-1][j] != 0){
                ++counter;
            }
        }
        System.out.println("\n Дополнительная статистика:");
        System.out.println("-Сумма за месяц: "+ sum +" шагов");
        System.out.println("-Максимальное количество за месяц: " + maxValue+ " шагов");
        System.out.println("-Среднее количество: " + (sum / counter)+ " шагов");
        converter.stepStatsTwo(sum);

    }
}