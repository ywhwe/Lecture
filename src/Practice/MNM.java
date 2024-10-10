package src.Practice;

import java.util.*;

public class MNM {
    public static void main(String[] args) {
        MNM main = new MNM();
        main.newMain();
    }

    void newMain() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        int temp, sum = 0, mean, middle;

        for (int i = 0; i < 5; i++) {
            temp = scanner.nextInt();
            arr.add(temp);
            sum += temp;
        }

        Collections.sort(arr);

        mean = sum / 5;

        middle = arr.get(2);

        System.out.println(mean);
        System.out.println(middle);
    }
}
