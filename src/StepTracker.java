public class StepTracker {

    Integer[][] MonthData;

    {
        MonthData = new Integer[12][30];
    }

    public StepTracker() { // [12]


    }

    boolean addSteps(Integer[][] MonthData, int month, int day, int steps) {
        if (MonthData[month-1][day-1] != null){
            return false;
        }
        else {
            MonthData[month-1][day-1] = steps;
            return true;
        }

    }

}