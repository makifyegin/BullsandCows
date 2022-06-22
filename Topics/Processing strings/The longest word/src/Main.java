import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String[] arr = first.split(" ");
        int max = 0;
        String maxString = "";
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
                maxString = s;
            }

        }
        System.out.println(maxString);


    }
}