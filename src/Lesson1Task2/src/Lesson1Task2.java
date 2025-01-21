package Lesson1Task2.src;
/*
    Написать программу, которая описывает введенное число.
    Отрицательное оно число или положительное (или нулевое), чётное или нечётное.
*/
import java.util.Scanner;

public class Lesson1Task2 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Занятие 1, задание 2:");
        System.out.println("Написать программу, которая описывает введенное число.\n" +
                           "Отрицательное оно число или положительное (или нулевое), чётное или нечётное.");
        System.out.println();

        InputNumber inpNum = new InputNumber();
        inpNum.inputNumber();
        inpNum.describe();
    }
}

class InputNumber {
    private String inpString;
    private double number;
    private DescriptionOfTheNumber descNumb;

    InputNumber() {
        inpString = "0";
    }

    public String getInpString() { return inpString; }
    public double getNumber() { return number; }

    public void inputNumber() {
        Scanner scanInpString;

        System.out.print("Введите число: ");
        Scanner scanSystemIn = new Scanner(System.in);
        inpString = scanSystemIn.next();
        scanInpString = new Scanner(inpString);
        while ( !(scanInpString.hasNextLong() || scanInpString.hasNextDouble()) ) {
            System.out.print("Введенное значение не является числом или выходит за пределы допустимого диапазона.\nВведите корректное число: ");
            inpString = scanSystemIn.next();
            scanInpString = new Scanner(inpString);
        }
        if ( scanInpString.hasNextInt() )
            descNumb = new DescriptionOfTheIntNumber(this);
        else
            descNumb = new DescriptionOfTheDoubleNumber(this);

        number = scanInpString.nextDouble();
        scanInpString.close();
    }
    public void describe() {
        if (descNumb != null)
            descNumb.describe();
        else
            inputNumber();
    }
}

abstract class DescriptionOfTheNumber {
    protected InputNumber inpNumber;

    DescriptionOfTheNumber(InputNumber num) {
        inpNumber = num;
    }
    public void describe() {
        System.out.println("Введено" + getSignText() + getEvenText() + " " + getTypeText() + ".");
    }
    private String getSignText() {
        return switch (getSign()) {
            case 1 -> " положительное";
            case -1 -> " отрицательное";
            default -> "";
        };
    }
    protected byte getSign() {
        if (inpNumber.getNumber() > 0)
            return 1;
        else if (inpNumber.getNumber() < 0)
            return -1;
        else
            return 0;
    }
    private String getTypeText() {
        return (inpNumber.getNumber() == 0 ? "число 0" : getType());
    }
    abstract String getType();
    abstract String getEvenText();
}

class DescriptionOfTheIntNumber extends DescriptionOfTheNumber {

    DescriptionOfTheIntNumber(InputNumber num) {
        super(num);
    }
    String getType() {
        return "целое число";
    }
    String getEvenText() {
        return getSign() == 0 ? "" : " " + (isEven() ? "чётное" : "нечётное");
    }
    private boolean isEven() {
        return ((int) inpNumber.getNumber() % 2) == 0;
    }
}

class DescriptionOfTheDoubleNumber extends DescriptionOfTheNumber {

    DescriptionOfTheDoubleNumber(InputNumber num) {
        super(num);
    }
    String getType() {
        return "вещественное число";
    }
    String getEvenText() {
        return "";
    }
}

