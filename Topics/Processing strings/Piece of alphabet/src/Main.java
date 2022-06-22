import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = "";
        String alphabet = "abcdefghijklmopqrstuvwxyz";


        if (alphabet.contains(first)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
