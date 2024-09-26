package src.Lecture2;

import java.util.*;
import java.util.random.RandomGenerator;

public class OrganizeNums {
    public static void main(String[] args){
        OrganizeNums org = new OrganizeNums();
        org.newMain();
    }

    void newMain() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] input = new int[num];

        for (int i = 0; i < num; i++) {
            input[i] = scanner.nextInt();
        }

        Arrays.sort(input);

        System.out.println(Arrays.toString(input));

        for (var i : input) {
            System.out.printf("%d\n", i);
        }

        scanner.close();
    }
}