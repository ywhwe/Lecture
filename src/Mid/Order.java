package src.Mid;

import java.util.*;

public class Order {
    int num, index, quantity;
    String color, size;

    public void read(int n, Scanner scan) {
        num = n;

        index = scan.nextInt();
        color = scan.next();
        size = scan.next();
        quantity = scan.nextInt();
    }
}
