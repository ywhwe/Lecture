package Lecture1;

import java.util.*;

public class ChessBoard {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int[] chess = new int[6];
        int[] chessRule = {1, 1, 2, 2, 2, 8};
        int count = 0;

        do {
            chess[count] = scanner.nextInt();
            count++;
        } while (count < chessRule.length);

        for (int i = 0; i < chessRule.length; i++) {
            chess[i] = chessRule[i] - chess[i];
        }

        for (int i = 0; i < chessRule.length; i++) {
            System.out.print(chess[i]+" ");
        }

        scanner.close();
    }
}
