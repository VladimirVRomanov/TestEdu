package Lesson2Task1.src;

import java.util.Scanner;

public class InputIntNumber {
    private int value;
    private final int lower;
    private final int upper;

    public InputIntNumber(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
    public int getValue() {
        return value;
    }

    public boolean inputNumber() {
        boolean result = true;
        Scanner scanInpString;

        Scanner scanSystemIn = new Scanner(System.in);
        var inpString = scanSystemIn.next();
        scanInpString = new Scanner(inpString);
        if ( !scanInpString.hasNextInt() )
            result = false;
        else {
            value = scanInpString.nextInt();
            if (value < lower || value > upper)
                result = false;
        }
        scanInpString.close();
        return result;
    }
}
