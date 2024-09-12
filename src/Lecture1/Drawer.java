package Lecture1;

import java.util.*;

class PrintCharacter {
    
    public void PrintBlank(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public void PrintStar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }
}

class Figure {

    PrintCharacter printCharacter = new PrintCharacter();

    public void FullRect(int size) {

        for (int i = 0; i < size; i++) {

            printCharacter.PrintStar(size);

            System.out.println();
        }

        System.out.println();
    }

    public void BlankRect(int size) {

        for (int i = 0; i < size; i++) {

            if (i == 0 || i == size - 1) {
                printCharacter.PrintStar(size);
            }
            else {
                System.out.print("*");
                
                printCharacter.PrintBlank(size-2);

                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();
    }
    
    public void IsoTriangle(int size) {
        
        int counter = size;

        for (int i = 0; i < size; i++) {
            
            counter--;
            
            for (int j = counter; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2*i+1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();
    }

    public void EmptyTriangle(int size) {
        
        int counter = size;

        for (int i = 0; i < size; i++) {
            
            counter--;
            
            for (int j = counter; j > 0; j--) {
                System.out.print(" ");
            }

            if (!(i == 0 || i == size-1)) {
                System.out.print("*");

                for (int k = 0; k < 2*i-1; k++) {
                    System.out.print(" ");
                }

                System.out.print("*");
            }
            else {
                for (int k = 0; k < 2*i+1; k++) {
                System.out.print("*");
                }
            }
            
            System.out.println();
        }

        System.out.println();
    }

    public void RepeatRect(int size, int horiz, int vert) {
        
        int row = 0;

        while (row != vert) { 
            
            row++;

            for (int i = 0; i < size; i++) {

                if (i == 0 || i == size-1) {

                    for (int j = 0; j < horiz; j++) {

                        printCharacter.PrintStar(size);

                        System.out.print("  ");
                    }
                }
                else {
                    for (int j = 0; j < horiz; j++) {
                        System.out.print("*");

                        printCharacter.PrintBlank(size-2);

                        System.out.print("*");
                        System.out.print("  ");
                    }
                }

                System.out.println();
            }

            System.out.println();
        }
    }
}

public class Drawer {
    public static void main(String[] args) {

        int size;
        int row, column;

        Figure figure = new Figure();

        try (Scanner scanner = new Scanner(System.in)) {
            
            do {
                System.out.print("크기를 입력하세요...");

                size = scanner.nextInt();
                
                if (size == 0) break;

                figure.FullRect(size);
                figure.BlankRect(size);
                figure.IsoTriangle(size);
                figure.EmptyTriangle(size);

                System.out.print("가로 세로 박스 수: ");
 
                row = scanner.nextInt();
                column = scanner.nextInt();

                figure.RepeatRect(size, row, column);

            } while (true);            

            System.out.print("안녕히 가세요");
        }
    }
}