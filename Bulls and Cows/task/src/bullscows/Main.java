package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    int count = 1;

    public static void main(String[] args) {
        int count = 1;
        Long first;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");


        int length = scanner.nextInt();

        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
            System.exit(0);
        }


        long pseudoRandomNumber = 0;
        Long pseudoRandomNumber1 = null;


        do {
            pseudoRandomNumber = System.nanoTime();
            pseudoRandomNumber1 = (Long) pseudoRandomNumber;
            a = pseudoRandomNumber1.toString();
            a = a.substring(1, length+1);


            pseudoRandomNumber1 = pseudoRandomNumber1.valueOf(a);

        } while (!(isUnique(pseudoRandomNumber1)));

        String pseudoRandomNumber1String = pseudoRandomNumber1.toString();

        ArrayList<Integer> guessDigitList = new ArrayList<>();
        int cows = 0;
        int bulls = 0;
        Long digit = pseudoRandomNumber1;
        System.out.println("Okay, let's start a game!");
        System.out.println("pseudoRandomNumber1 = " + pseudoRandomNumber1);
        do {





            System.out.println("Turn " + count + ":");

            first = scanner.nextLong();
            ArrayList<Long> secretCode = convertFromStringToArrayList(pseudoRandomNumber1);
            ArrayList<Long> arrs = convertFromStringToArrayList(first);
            ArrayList<Long> guessDigitList1 = new ArrayList<>();



            for (int i = 0; i < length; i++) {
                try {
                    digit = arrs.get(i);
                    guessDigitList1.add(digit);
                    if (secretCode.contains(digit)) {
                        if (guessDigitList1.indexOf(digit) == guessDigitList1.lastIndexOf(digit)) {
                            if (guessDigitList1.indexOf(digit) != secretCode.indexOf(digit)) {
                                cows++;
                            }
                        } else {
                            if (i >= 1) {
                                if (guessDigitList1.get(i - 1).equals(guessDigitList1.get(i))) {
                                    if (guessDigitList1.lastIndexOf(digit) != secretCode.lastIndexOf(digit)) {
                                        cows++;
                                    }
                                }
                            }
                        }

                        if (guessDigitList1.lastIndexOf(digit) == secretCode.indexOf(digit)) {
                            bulls++;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bulls > 0 && cows ==0) {
                System.out.println("Grade: " + bulls + " bull(s)..");
            }
            if (cows > 0 && bulls==0)  {
                System.out.println("Grade: " + cows + " cow(s)..");
            }

            if (cows > 0 && bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)..");
            }
            if (cows == 0 && bulls == 0) {
                System.out.println("Grade: None..");
            }
            count++;

            cows = 0;
            bulls = 0;
        } while (!(pseudoRandomNumber1.equals(first)));
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static String a = "";

    public static void arrayListPrint(ArrayList<Long> secretCode) {


        for (Long along : secretCode) {

            a += "" + along;
        }
        System.out.print(a);
        a = "";

    }

    public static ArrayList<Long> convertFromStringToArrayList(Long first) {

String stringFirst = first.toString();
        ArrayList<Long> arrs = new ArrayList<>();
        for (char c : stringFirst.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            Integer numericValue1 = (Integer) numericValue;
            long l = numericValue1.longValue();
            arrs.addAll(Arrays.asList(l));
        }



        return arrs;
    }

    public static boolean isUnique(Long pseudoRandomNumber) {

        boolean unique = false;
        String a = pseudoRandomNumber.toString();
        char[] a1 = a.toCharArray();


        for (int i = 0; i < a.length(); i++) {

            if (a.indexOf(a1[i]) == a.lastIndexOf(a1[i])) {
                unique = true;

            } else {

                unique = false;
                break;

            }
        }
        return unique;
    }
}