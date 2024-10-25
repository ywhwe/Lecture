package src.Mid;

import java.io.*;
import java.util.*;

public class Store{
    int index, temp = 0;

    boolean flag = true;

    String sex, type;

    Scanner scanner = new Scanner(System.in);

    ArrayList<Clothes> clothes = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Store store = new Store();
        store.newMain();
    }

    void newMain() {
        readC("apparel.txt");

        for (var c : clothes) {
            c.print();
        }

        index = 0;

        System.out.println("===== 주문 =====");
        readO("order.txt");
        printO();

        System.out.println("===== 선택검색 =====");

        do {
            System.out.print("선택검색 하시겠습니까(y/n)");

            switch (scanner.next()) {
                case "n":
                    flag = false; break;
                case "y":
                    System.out.print("(1) 여성용  (2) 남성용  (3) 공용");
                    temp = scanner.nextInt();
                    if (temp == 1) {
                        sex = "여성용";
                    } else if (temp == 2) {
                        sex = "남성용";
                    } else {
                        sex = "공용";
                    }
                    System.out.print("(1) 상의  (2) 하의  (3) 세트  (4) 아우터");
                    temp = scanner.nextInt();
                    if (temp == 1) {
                        type = "상의";
                    } else if (temp == 2) {
                        type = "하의";
                    } else if (temp == 3) {
                        type = "세트";
                    } else {
                        type = "아우터";
                    }

                    for (var c : clothes) {
                        if (c.s.equals(sex) && c.type.equals(type)) {
                            c.print();
                            temp = 1;
                        }
                        else {
                            temp = 0;
                        }
                    }

                    if (temp != 1) System.out.println("해당 상품이 없습니다.");
                    break;
            }
        } while(flag);
    }

    void readC(String fileName) {
        Scanner filein = openFile(fileName);
        while (filein.hasNext()) {
            Clothes c = new Clothes();

            index++;
            c.read(index, filein);

            clothes.add(c);
        }

        filein.close();
    }

    void readO(String fileName) {
        Scanner filein = openFile(fileName);
        while (filein.hasNext()) {
            Order o = new Order();

            index++;
            o.read(index, filein);

            orders.add(o);
        }

        filein.close();
    }

    void printO() {
        int sum = 0;
        for (var o : orders) {
            for (var c : clothes) {
                if (c.matches(o.index)) {
                    System.out.printf("[%d] ", o.num);
                    System.out.printf("[%s/%s] %s (%s/%s) %d개 %d원\n", c.s, c.type, c.name, o.color, o.size, o.quantity, c.price);
                    sum += c.price;
                }
            }
        }
        System.out.println("주문 총계: " + sum);
    }

    public Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("File open failed : " + filename);
            throw new RuntimeException(e);
        }
        return filein;
    }
}
