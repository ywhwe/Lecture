package src;

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

        int counter = 2*input-1;

        for (int i = 0; i < 2*input-1; i++) {

            counter--;

            for (int j = counter; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2*i+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
