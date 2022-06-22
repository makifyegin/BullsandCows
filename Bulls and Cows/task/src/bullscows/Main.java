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


        for (int i = 0; i < 4; i++) {
            digit = scanner.nextInt();
            guessDigitList.add(digit);
            if (secretCode.contains(digit)) {
                if (guessDigitList.indexOf(digit) == guessDigitList.lastIndexOf(digit)) {
                    if (guessDigitList.indexOf(digit) != secretCode.indexOf(digit)) {
                        cows++;
                    }
                }

                if (guessDigitList.indexOf(digit) == secretCode.indexOf(digit)) {
                    bulls++;
                }
            }
        }
        System.out.println(bulls);
        System.out.println(cows);


//        arrayListPrint(secretCode);
//        String none = " None.";
//        String bullsAndCows = "Grade:" + bulls + " bull(s) and" + cows + "cow(s).";
//
//
//        if (cows == 0 && bulls == 0) {
//            System.out.println("Grade: None. The secret code is " + ".");
//        }
//
//        System.out.println("> " + guessDigitList + "\n" +
//                "Grade: " + cows + " cow(s). The secret code is " + a + ".");
//
//        String Template = "Grade: 1 bull(s) and 1 cow(s). The secret code is 9305.";
//    }
//
//
//    public static String a = "";
//
//    public static String arrayListPrint(ArrayList<Integer> secretCode) {
//        for (Integer integer : secretCode) {
//
//            a += "" + integer;
//        }
//        return a;
//    }
    }
}
