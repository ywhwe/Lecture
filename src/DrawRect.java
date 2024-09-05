import java.util.*;

public class DrawRect {
    public static void main(String[] args) {

        int input;

        try (Scanner scanner = new Scanner(System.in)) {
                        
            do {
                System.out.print("크기를 입력하세요...");
                
                input = scanner.nextInt();
                
                //FullRect(input); // Draw full rectangle
                //BlankRect(input); // Draw empty rectangle
                IsoTriangle(input); // Draw isosceles triangle
                
            } while (input != 0);

            System.out.print("안녕히 가세요");
        }
    }
    
    public static void FullRect(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void BlankRect(int num) {
        for (int i = 0; i < num; i++) {
            if (i == 0 || i == num - 1) {
                for (int j = 0; j < num; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            } else {
                System.out.print("*");
                for (int j = 1; j < num - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.print("\n");
            }
        }
    }
    
    public static void IsoTriangle(int num) {
        
        int counter = num;

        for (int i = 0; i < num; i++) {
            counter--;
            for (int j = counter; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        } 
    }
}
