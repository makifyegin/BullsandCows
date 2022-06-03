import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        int maxLength = 0;
        // write your code here
        for (String s : list) {
            if (s.length()>maxLength) {
                maxLength = s.length();
            }


        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}