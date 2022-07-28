
import java.util.Scanner;

    /*
    - Ввести количество шагов за определённый день;
    - Напечатать статистику за определённый месяц;
    - Изменить цель по количеству шагов в день;
    - Выйти из приложения.
    */


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();
        int month;
        int day;
        int steps;

        while (command != 0) {

            if (command == 1) {   // Ввести количество шагов за определённый день;

                System.out.println("--Ввести количество шагов за определённый день--");
                System.out.println("Введите месяц:");

                month = scanner.nextInt();
                if ((month >= 1) && (month <= 12)) {
                    System.out.println("Введите день:");
                    day = scanner.nextInt();

                    if ((day >= 1) && (day <= 30)) {
                        System.out.println("Введите количество шагов:");
                        steps = scanner.nextInt();
                        } else {
                        System.out.println("Неврное значение! (Введите число от 1 до 30)");
                        continue;
                    }
                } else {
                    System.out.println("Неверное значение! (Введите число от 1 до 12)");
                    continue;
                }


                boolean isSuccess = stepTracker.addSteps(stepTracker.MonthData, month, day, steps);
                if (isSuccess) {
                    System.out.println("Шаги записаны!");
                } else {
                    System.out.println("Шаги в этот день уже заполненны!");
                }

            } else if (command == 2) {
                // Напечатать статистику за определённый месяц;
                System.out.println("Выбранно - Напечатать статистику за определённый месяц. \n" +
                        "Введите номер месяца: ");
                int monthStat = scanner.nextInt();
                stepTracker.stepStats(monthStat);

            } else if (command == 3) {
                // Изменить цель по количеству шагов в день;
                System.out.println("Выбранно - Изменить цель по количеству шагов в день");
            } else {
                System.out.println("Такого действия нет!");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            command = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
        System.out.println("Введите номер действия: ");
    }
} 