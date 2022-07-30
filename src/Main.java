    /*
       + 1. Консольный интерфейс для управления программой
            -Реализованно в виде меню в методе "printMenu()"

       ? 2. Хранение данных о количестве пройденных шагов за несколько месяцев;

       ? 3. Ввод вашей цели по количеству шагов в день;

       + 4. Ввод пройденного количества шагов за день;
            -При выборе команды 1, пользователь проваливается в меню с заполнением
            определенного месяца, дня количеством шагов "command == 1"

       + 5. Вывод статистики за определённый месяц.
            -Реализация при вводе команды 2 "command == 2"
            -Логика пункта выполняется в классе "StepTracker"

             +   -Количество пройденных шагов по дням в следующем формате:
                  1 день: 3000, 2 день: 2000, ..., 30 день: 10000
             +   -Общее количество шагов за месяц;
             +   -Максимальное пройденное количество шагов в месяце;
             +   -Среднее количество шагов;
             +   -Пройденная дистанция (в км);
             +   -Количество сожжённых килокалорий;
             ?   -Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
    */


    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();
        int month;
        int day;
        int steps;
        int monthStat;

        while (command != 0) {

            if (command == 1) {   // Ввести количество шагов за определённый день;

                System.out.println("--Ввести количество шагов за определённый день--");
                System.out.println("Ввдите месяц:");
                    month = scanner.nextInt();

                        if (month >= 1 && month <= 12) {
                            System.out.println("Введите день:");
                            day = scanner.nextInt();

                            if (day >= 1 && day <= 30) {
                                System.out.println("Введите количество шагов:");
                                steps = scanner.nextInt();
                            } else {
                                    System.out.println("Неврное значение! (Введите число от 1 до 30)");
                                    continue;
                                    }

                        } else {
                            System.out.println("Неврное значение! (Введите число от 1 до 12)");
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
                System.out.println("Выбранно - Напечатать статистику за определённый месяц");
                System.out.println("Введите номер месяца:");
                monthStat = scanner.nextInt();

                if (monthStat >= 1 && monthStat <= 12){
                     stepTracker.stepStats(monthStat);
                }else {
                    System.out.println("Некоректный ввод, введите от 1 до 12");
                    continue;
                }

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