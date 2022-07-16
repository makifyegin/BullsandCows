package bullscows;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> secretCode = new ArrayList<>();
        secretCode.addAll(Arrays.asList(9, 3, 0, 5));
        ArrayList<Integer> guessDigitList = new ArrayList<>();
        int cows = 0;
        int bulls = 0;
        Integer digit = 0;
        Integer first = scanner.nextInt();
        ArrayList<Integer> arrs = convertFromStringToArrayList(first);
        for (int i = 0; i < 4; i++) {

            digit = arrs.get(i);
            guessDigitList.add(digit);
            if (secretCode.contains(digit)) {
                if (guessDigitList.indexOf(digit) == guessDigitList.lastIndexOf(digit)) {
                    if (guessDigitList.indexOf(digit) != secretCode.indexOf(digit)) {
                        cows++;
                    }
                } else {
                    if (i >= 1) {
                        if (guessDigitList.get(i - 1).equals(guessDigitList.get(i))) {
                            if (guessDigitList.lastIndexOf(digit) != secretCode.lastIndexOf(digit)) {
                                cows++;
                            }
                        }
                    }
                }

                if (guessDigitList.lastIndexOf(digit) == secretCode.indexOf(digit)) {
                    bulls++;
                }
            }
        }
        if (cows > 0 && bulls > 0) {

            System.out.print("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is ");
            arrayListPrint(secretCode);
            System.out.print(".");
            System.exit(0);

        }
        if (bulls > 0) {

            System.out.print("Grade: " + bulls + " bull(s). The secret code is ");
            arrayListPrint(secretCode);
            System.out.print(".");
            System.exit(0);
        }
        if (cows > 0) {

            System.out.print("Grade: " + cows + " cow(s). The secret code is ");
            arrayListPrint(secretCode);
            System.out.print(".");
            System.exit(0);
        }

        if (cows == 0 && bulls == 0) {

            System.out.print("Grade: None. The secret code is ");
            arrayListPrint(secretCode);
            System.out.print(".");
            System.exit(0);
        }

    }

    public static String a = "";

    public static void arrayListPrint(ArrayList<Integer> secretCode) {
        for (Integer integer : secretCode) {

            a += "" + integer;
        }
        System.out.print(a);
        a = "";

    }

    public static ArrayList<Integer> convertFromStringToArrayList(Integer first) {


        Integer firstDigit = first / 1000;
        Integer secondDigit = (first / 100) % 10;
        Integer thirdDigit = (first / 10) % 10;
        Integer fourthDigit = first % 10;

        ArrayList<Integer> arrs = new ArrayList<>();
        arrs.addAll(Arrays.asList(firstDigit, secondDigit, thirdDigit, fourthDigit));


        return arrs;
    }
}