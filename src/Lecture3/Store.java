package src.Lecture3;

import java.util.*;
import java.nio.charset.Charset;

public class Store {
    public static void main(String[] args) {
        Store main = new Store();
        main.newMain();
    }

    HashMap<Integer, Item> itemSet = new HashMap<>();
    HashMap<String, User> userSet = new HashMap<>();

    void newMain() {
        Scanner scanner = new Scanner(System.in, Charset.forName("EUC-KR"));

        String id;
        Item item;
        User user;

        int itemIndex = 1;

        do {
            id = scanner.next();
            if (id.equals("0")) break;
            item = new Item();
            item.write(itemIndex, id, scanner);
            itemSet.put(itemIndex, item);
            itemIndex++;
        } while(true);

        printAllItems();

        do {
            id = scanner.next();
            if (id.equals("0")) break;

            user = new User();

            user.write(id, scanner);

            while(scanner.nextInt() != 0) {
                user.basket.add(itemSet.get(scanner.nextInt()));
            }

            userSet.put(user.id, user);
        } while (scanner.nextInt() != 0);

        printAllUsers();

        scanner.close();
    }

    void writeAllItems() {

    }

    void writeAllUsers() {

    }

    void printAllItems() {
        for (var value : itemSet.values()) {
            System.out.printf("[%d] %s %s (%d원)\n",value.num, value.code, value.name, value.price);
        }
    }

    void printAllUsers() {
        int sum, size;

        for (var value : userSet.values()) {
            sum = 0;
            size = value.basket.size();

            for (int i = 0; i < size; i++) {
                sum += value.basket.get(i).price;
            }

            System.out.printf("[%s] 총구매 %d건 %d원 (%d점)\n", value.id, size, sum, sum);

            for (var item : value.basket) {
                System.out.printf("%s ", item.name);
            }
        }
    }
}

class Item {
    int num, price;
    String code, name;

    void write(int index, String id, Scanner scan) {
        num = index;
        code = id;
        name = scan.next();
        price = scan.nextInt();
    }

    void print() {

    }

    void matches() {

    }
}

class User {
    String id, pw;
    ArrayList<Item> basket = new ArrayList<>();

    void write(String uid, Scanner scan) {
        id = uid;
        pw = scan.next();

        scan.skip("0");
    }

    void print() {

    }

    void matches() {

    }
}