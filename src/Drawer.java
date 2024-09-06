import java.util.*;

class Figure {

    public void FullRect(int size) {

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }

    public void BlankRect(int size) {

        for (int i = 0; i < size; i++) {

            if (i == 0 || i == size - 1) {

                for (int j = 0; j < size; j++) {
                    System.out.print("*");
                }
            }
            else {
                System.out.print("*");
                
                for (int j = 1; j < size - 1; j++) {
                    System.out.print(" ");
                }

                System.out.print("*");
            }

            System.out.print("\n");
        }
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

            System.out.print("\n");
        }
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
            
            System.out.print("\n");
        }
    }

    public void RepeatRect(int size, int horiz, int vert) {
        
        int row = 0;

        while (row != vert) { 
            
            row++;

            for (int i = 0; i < size; i++) {

                if (i == 0 || i == size-1) {

                    for (int j = 0; j < horiz; j++) {

                        for (int k = 0; k < size; k++) {
                            System.out.print("*");
                        }

                        System.out.print("  ");
                    }
                }
                else {
                    for (int j = 0; j < horiz; j++) {
                        System.out.print("*");

                        for (int k = 1; k < size-1; k++) {
                            System.out.print(" ");
                        }

                        System.out.print("*");
                        System.out.print("  ");
                    }
                }

                System.out.print("\n");
            }

            System.out.print("\n");
        }
    }
}

public class Drawer {
    public static void main(String[] args) {

        int size;
        int row, column;

        Figure figure = new Figure();

        try (Scanner scanner = new Scanner(System.in)) {
            
            // Draw single figure  
            /*do {
                System.out.print("크기를 입력하세요...");
                
                size = scanner.nextInt();
                
                //figure.FullRect(size);
                //figure.BlankRect(size);
                //figure.IsoTriangle(size);
                figure.EmptyTriangle(size);
                
            } while (size != 0);*/

            // Draw multiple figure
            do { 
                System.out.print("size = ");
                
                size = scanner.nextInt();

                if (size == 0) break;
                
                System.out.print("가로 세로 박스 수: ");
 
                row = scanner.nextInt();
                column = scanner.nextInt();

                figure.RepeatRect(size, row, column);
            } while (true);

            System.out.print("안녕히 가세요");
        }
    }
}