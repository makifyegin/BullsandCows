package bullscows;

import java.util.*;


public class Main {

    int count = 1;
    public static int length = 0;

    public static long codeGenerator(int length) {
        long pseudoRandomNumber = 0;
        Long pseudoRandomNumber1 = null;

        ArrayList<String> listNumber = new ArrayList<>();
        ArrayList<String> listNumberNewLength = new ArrayList<>();

        // should sure that this is bigger than length


        Random random = new Random();

        do {
            pseudoRandomNumber = Math.abs(random.nextLong());
            String a = String.valueOf(pseudoRandomNumber);
            String[] split = a.split("");
            listNumber.addAll(Arrays.asList(split));
        } while (listNumber.size() < length);

        listNumberNewLength.addAll(Arrays.asList(listNumber.get(0)));

        for (int i = 1; i < listNumber.size(); i++) {
            if (listNumberNewLength.size() == length) {
                break;
            }
            if (!(listNumberNewLength.contains(listNumber.get(i)))) {
                listNumberNewLength.addAll(Arrays.asList(listNumber.get(i)));
            } else {
                continue;

            }

        }

        pseudoRandomNumber1 = convertFromList_StringToLong(listNumberNewLength);
        return pseudoRandomNumber1;
    }

    public static void main(String[] args) {
        int count = 1;
        Long first;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");


        length = scanner.nextInt();
        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
            System.exit(0);
        }
        Long pseudoRandomNumber1 = null;
        pseudoRandomNumber1 = codeGenerator(length);

        List<Integer> guessDigitList;
        int cows = 0;
        int bulls = 0;
        Long digit = pseudoRandomNumber1;
        String guessNumber;
        System.out.println("Okay, let's start a game!");
        do {


            System.out.println("Turn " + count + ":");
            Scanner scanner1 = new Scanner(System.in);
            guessNumber = scanner1.nextLine();
            List<Long> secretCode = convertFromLongtoListLong(pseudoRandomNumber1);

            List<Long> arrs = new ArrayList<>();
            arrs = convertStringToListLong(guessNumber);
            List<Long> guessDigitList1 = new ArrayList<>();
            System.out.println(pseudoRandomNumber1);

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
            if (bulls > 0 && cows == 0) {
                System.out.println("Grade: " + bulls + " bull(s)..");
            }
            if (cows > 0 && bulls == 0) {
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
        } while (!(pseudoRandomNumber1.equals(Long.parseLong(guessNumber))));
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static String a = "";

    public static void ListPrint(List<Long> secretCode) {


        for (Long along : secretCode) {

            a += "" + along;
        }
        System.out.print(a);
        a = "";

    }

    public static List<Long> convertFromLongtoListLong(Long first) {

        String stringFirst = first.toString();
        List<Long> arrs = new ArrayList<>();
        for (char c : stringFirst.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            Integer numericValue1 = (Integer) numericValue;
            long l = numericValue1.longValue();
            arrs.addAll(Arrays.asList(l));
        }
        return arrs;
    }

    public static Long convertFromList_StringToLong(List<String> first) {
        Long pseudoRandomNumber1;
        String newS = "";
        for (String s : first) {
            newS += s;
        }

        pseudoRandomNumber1 = Long.parseLong(newS);
        return pseudoRandomNumber1;
    }

    public static List<Long> convertStringToListLong(String arg0) {
        String b = "";
        ArrayList<Long> a = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();


        for (int i = 0; i < arg0.length(); i++) {
            b = "" + arg0.charAt(i);
            a1.add(b);

        }

        for (int i = 0; i < a1.size(); i++) {
            a.add(Long.parseLong(a1.get(i)));
        }



        return a;
    }

    public static ArrayList<Long> stringToLongArray(String arg0) {
        return null;

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

