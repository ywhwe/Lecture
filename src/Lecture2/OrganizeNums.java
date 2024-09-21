package src.Lecture2;

import java.util.*;

public class OrganizeNums {
    public static void main(String[] args){
        OrganizeNums org = new OrganizeNums();
        org.newMain();
    }

    void newMain() {
        Scanner scanner = new Scanner(System.in);

        int temp, min = 1000, max = 0;

        int num = scanner.nextInt();

        int[] input = new int[num];

        for (int i = 0; i < num; i++) {
            input[i] = scanner.nextInt();
            if (min > input[i]) min = input[i];
            if (max < input[i]) max = input[i];
        }

        while (input[0] != min || input[num-1] != max) {
            for (int i = 1; i < input.length; i++) {
                if (input[i-1] > input[i]) {
                    temp = input[i];
                    input[i] = input[i-1];
                    input[i-1] = temp;
                }

                if (i > 1 && input[i-2] > input[i-1]) {
                    temp = input[i-1];
                    input[i-1] = input[i-2];
                    input[i-2] = temp;
                }
            }
        }

        for (var i : input) {
            System.out.printf("%d\n", i);
        }

        scanner.close();
    }
}