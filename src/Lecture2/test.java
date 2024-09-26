package src.Lecture2;

import java.util.*;

public class test {
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int input1;
        int max = Integer.MIN_VALUE;
        List<Integer> list= new ArrayList<>();

        int[] arr = new int[10];

        input = input.replaceAll("\\[|]|\\s", "");

        String[] nums = input.split(",");

        for (String num : nums) {
            try {
                list.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                System.out.println("err");
            }
        }

        List<Integer> indices = new ArrayList<>();

        for (int value : list) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                indices.add(i);
            }
        }

        System.out.print(indices);*/
    }

    public int[] solution1(int[] arr) {
        int[] answer;
        int[] temp = new int[10];
        int count = 0;

        int max = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                temp[count] = i;
                count++;
            }
        }

        answer = new int[count];
        count = 0;

        for (int i : temp) {
            if (i != 0) {
                answer[count] = i;
                count++;
            }
        }

        return answer;
    }

    public boolean solution2(int[] arr) {
        boolean answer = true;

        int n = arr.length;

        if (n == 0) answer = false;

        for (int i = 0; i < n; i++) {
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    public int[] solution3(long n) {
        int[] answer;
        int temp;

        List<Integer> d = new ArrayList<>();

        while (n > 0) {
            d.add((int)(n%10));
            n /= 10;
        }

        answer = new int[d.size()];

        for (int i = 0; i < d.size(); i++) {
            answer[i] = d.get(i);
        }

        return answer;
    }
}