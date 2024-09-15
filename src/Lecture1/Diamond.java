package src.Lecture1;

import java.util.*;

public class Diamond {
    public static void main(String[] args) {
        Diamond newMain = new Diamond();
        newMain.newMain();
    }

    public void newMain() {
        Scanner scanner = new Scanner(System.in);

        int input;

        input = scanner.nextInt();

        int counter1 = input;
        int counter2 = 0;

        for (int i = 1; i < 2*input; i++) {

            if (i <= input){
                counter1--;

                for (int j = counter1; j > 0; j--) {
                    System.out.print(" ");
                }

                for (int k = 0; k < 2*i - 1; k++) {
                    System.out.print("*");
                }

                System.out.println();
            }
            else break;
        }

        for (int i = input - 1; i > 0; i--) {

            counter2++;

            for (int j = 0; j < counter2; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2*i - 1; k++) {
                System.out.print("*");
            }

            if (i != 1){
                System.out.println();
            }
        }

        scanner.close();
    }
}
