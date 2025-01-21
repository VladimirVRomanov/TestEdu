package Lesson4Task1.src;
/*
    Напишите программу которая получает на вход некую строку, после она вызывает метод,
    заменяющий в строке все вхождения слова «бяка» на «вырезано цензурой» и выводит результат в консоль!
*/
import java.util.Scanner;

public class Lesson4Task1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Занятие 4, задание 1:");
        System.out.println("Напишите программу которая получает на вход некую строку, после она вызывает метод,\n" +
			               "заменяющий в строке все вхождения слова «бяка» на «вырезано цензурой» и выводит результат в консоль!");
        System.out.println();

        System.out.print("Введите строку: ");
        var inString = new Scanner(System.in);
        String s = inString.nextLine();
        String[] words = s.split("[^а-яА-Я]");
        for (String w : words) {
            if (w.regionMatches(true, 0, "бяка", 0, 3))
                s = s.replace(w, "вырезано цензурой");
        }
        System.out.println(s);
        inString.close();
    }
}