package src.Practice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CutLine {
    public static void main(String[] args) {
        CutLine main = new CutLine();
        main.newMain();
    }

    void newMain() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int num, pri, temp, min;

        num = scanner.nextInt();
        pri = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            temp = scanner.nextInt();
            arr.add(temp);
        }

        Collections.sort(arr);

        temp = num - 1;

        for (int i = 0; i < pri; i++) {
            res.add(arr.get(temp));

            temp -= 1;
        }

        min = res.get(pri-1);

        System.out.print(min);
    }
}
