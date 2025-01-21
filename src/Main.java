import Lesson1Task1.src.*;
import Lesson1Task2.src.*;
import Lesson1Task3.src.*;
import Lesson1Task4.src.*;
import Lesson1TaskDop.src.*;
import Lesson2Task1.src.*;
import Lesson3Task1.src.*;
import Lesson3Task2.src.*;
import Lesson3Task3.src.*;
import Lesson4Task1.src.*;
import Lesson4Task2.src.*;
import Lesson4Task3.src.*;
import Lesson4Task4.src.*;
import Lesson5Task1.src.*;
import Lesson5Task2.src.*;
import Lesson5Task3.src.*;
import Lesson5Task4.src.*;
import Lesson6Task1.src.*;
import Lesson6Task2.src.*;
import Lesson6Task3.src.*;
import Lesson6Task4.src.*;

public class Main {
    public static void main(String[] args) {
        final int minLessonNum = 1;
        final int maxLessonNum = 6;
        final int minTaskNum = 1;

        int lessonNum, taskNum;
        System.out.printf("\nВведите номер занятия (от %d до %d).\n", minLessonNum, maxLessonNum);
        System.out.print("Занятие: ");
        var num = new InputIntNumber(minLessonNum, maxLessonNum);
        num.inputNumber();
        while (num.getValue() < minLessonNum || num.getValue() > maxLessonNum) {
            System.out.printf("\nВведен недопустимый номер занятия. Введите целое число от %d до %d.\n", minLessonNum, maxLessonNum);
            System.out.print("Занятие: ");
            num.inputNumber();
        }
        lessonNum = num.getValue();
        int maxTaskNum;
        switch (lessonNum) {
            case 1:
                maxTaskNum = 5;
                taskNum = getTaskNum(minTaskNum, maxTaskNum);
                switch (taskNum) {
                    case 1:
                        Lesson1Task1.main(args);
                        break;
                    case 2:
                        Lesson1Task2.main(args);
                        break;
                    case 3:
                        Lesson1Task3.main(args);
                        break;
                    case 4:
                        Lesson1Task4.main(args);
                        break;
                    case 5:
                        Lesson1TaskDop.main(args);
                        break;
                }
                return;
            case 2:
                Lesson2Task1.main(args);
                return;
            case 3:
                maxTaskNum = 3;
                taskNum = getTaskNum(minTaskNum, maxTaskNum);
                switch (taskNum) {
                    case 1:
                        Lesson3Task1.main(args);
                        break;
                    case 2:
                        Lesson3Task2.main(args);
                        break;
                    case 3:
                        Lesson3Task3.main(args);
                        break;
                }
                return;
            case 4:
                maxTaskNum = 4;
                taskNum = getTaskNum(minTaskNum, maxTaskNum);
                switch (taskNum) {
                    case 1:
                        Lesson4Task1.main(args);
                        break;
                    case 2:
                        Lesson4Task2.main(args);
                        break;
                    case 3:
                        Lesson4Task3.main(args);
                        break;
                    case 4:
                      Lesson4Task4.main(args);
                    break;
                }
                return;
            case 5:
                maxTaskNum = 4;
                taskNum = getTaskNum(minTaskNum, maxTaskNum);
                switch (taskNum) {
                    case 1:
                        Lesson5Task1.main(args);
                        break;
                    case 2:
                        Lesson5Task2.main(args);
                        break;
                    case 3:
                        Lesson5Task3.main(args);
                        break;
                    case 4:
                        Lesson5Task4.main(args);
                        break;
                }
                return;
            case 6:
                maxTaskNum = 4;
                taskNum = getTaskNum(minTaskNum, maxTaskNum);
                switch (taskNum) {
                    case 1:
                        Lesson6Task1.main(args);
                        break;
                    case 2:
                        Lesson6Task2.main(args);
                        break;
                    case 3:
                        Lesson6Task3.main(args);
                        break;
                    case 4:
                        Lesson6Task4.main(args);
                        break;
                }
        }
    }
    static int getTaskNum(int from, int to) {
        String msgNotAllowedTaskNum = "\nВведен недопустимый номер задания. Введите целое число от %d до %d.\n";
        var num = new InputIntNumber(from, to);
        System.out.printf("\nВведите номер задания (от %d до %d).\n", from, to);
        System.out.print("Задание: ");
        num.inputNumber();
        while (num.getValue() < from || num.getValue() > to) {
            System.out.printf(msgNotAllowedTaskNum, from, to);
            System.out.print("Задание: ");
            num.inputNumber();
        }
        return num.getValue();
    }
}