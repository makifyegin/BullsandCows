import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        int result = 0;
        int result1 = 0;

        String first = a.substring(0, 3);
        for (int i = 0; i < first.length(); i++) {
            result += first.charAt(i);
        }

        String second = a.substring(3);
        for (int i = 0; i < second.length(); i++) {
            result1 += second.charAt(i);
        }

        if (result == result1) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
