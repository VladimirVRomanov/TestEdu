package Lesson4Task4.src;
/*
    Реализовать класс в конструкторе которого будет счетчик количества создаваемых объектов.
    Написать метод для получения информации о количестве.
*/
public class Lesson4Task4 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Занятие 4, задание 4:");
        System.out.println("Реализовать класс в конструкторе которого будет счетчик количества создаваемых объектов.\n" +
			               "Написать метод для получения информации о количестве.");
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nСоздаем объект " + i);
            new CounterOfObjects().showCountInfo();
        }
    }
}

class CounterOfObjects {
    private static int objectCounter;

    CounterOfObjects() {
        objectCounter++;
    }

    public int getObjectCount() { return objectCounter; }

    public void showCountInfo () {
        System.out.printf("Количество созданных объектов: %d\n", getObjectCount());
    }
}