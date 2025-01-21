package Lesson1Task4.src;

import java.util.Scanner;

public class InputLongNumber {
    private long number;

    public long getNumber() {
        return number;
    }
    public void inputNumber() {
        Scanner scanInpString;

        Scanner scanSystemIn = new Scanner(System.in);
        var inpString = scanSystemIn.next();
        scanInpString = new Scanner(inpString);
        while ( !scanInpString.hasNextLong() ) {
            System.out.print("Введенное значение не является целым числом или выходит за пределы допустимого диапазона.\nВведите корректное целое число: ");
            inpString = scanSystemIn.next();
            scanInpString = new Scanner(inpString);
        }
        number = scanInpString.nextLong();
        scanInpString.close();
    }
}
