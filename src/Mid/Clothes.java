package src.Mid;

import java.util.*;

public class Clothes {
    String sex, type, name, s;
    int num, price;

    ArrayList<String> color = new ArrayList<>();
    ArrayList<String> size = new ArrayList<>();

    public void read(int index, Scanner scan) {
        num = index;
        sex = scan.next();
        type = scan.next();
        name = scan.next();
        price = scan.nextInt();

        while(true) {
            var c = scan.next();
            if (c.equals("0")) break;
            color.add(c);
        }

        while(true) {
            var s = scan.next();
            if (s.equals("0")) break;
            size.add(s);
        }

        if (sex.equals("M")) {
            s = "남성용";
        }
        else if (sex.equals("W")) {
            s = "여성용";
        }
        else {
            s = "공용";
        }
    }

    public void print() {
        System.out.printf("%d) [%s/%s] %s (%d원) 색상: ", num, s, type, name, price);

        for (var c : color) {
            System.out.printf("%s ", c);
        }

        System.out.print("사이즈:");

        for (var s : size) {
            System.out.printf("%s ", s);
        }

        System.out.println();
    }

    public boolean matches(int index) {
        return index == num;
    }
}
