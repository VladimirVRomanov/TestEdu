package Lesson1Task3.src;
/*
    Написать программу для вывода на экран таблицы умножения.
*/
public class Lesson1Task3 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Занятие 1, задание 3:");
        System.out.println("Написать программу для вывода на экран таблицы умножения.");
        System.out.println();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++)
                System.out.printf("%4d", i * j);
            System.out.println();
        }
    }
}