package src.Practice;

import java.util.*;

public class SortNum {
    public static void main(String[] args) {
        SortNum main = new SortNum();
        main.newMain();
    }

    void newMain() {
        String input;
        Scanner scanner = new Scanner(System.in);

        input = scanner.nextLine();

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            arr.add(input.charAt(i) + ""); // Split input char by char
        }

        arr.sort(Collections.reverseOrder()); // Sort arr by descending

        for (var a : arr) {
            System.out.print(a);
        }
    }
}
