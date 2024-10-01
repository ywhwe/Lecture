package src.Lecture3;

import java.util.*;
import java.util.regex.*;
import java.nio.charset.Charset;

public class Store {
    public static void main(String[] args) {
        Store main = new Store();

        main.newMain();
    }

    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();

    void newMain() {
        Scanner scanner = new Scanner(System.in, Charset.forName("EUC-KR"));

        int select = -1;

        String key;

        readAllItems(scanner);

        readAllUsers(scanner);

        System.out.println();

        while (select != 0) {
            System.out.print("""
            (1) 상품출력 (2) 사용자출력 (3) 상품검색 (4) 사용자검색
            (5) 상품으로사용자검색 (6) 상품별판매현황 (7) 같이판매된상품
            (0) 종료 =>\s""");

            select = scanner.nextInt();

            switch (select) {
                case 1: printAllItems();
                        break;
                case 2: printAllUsers();
                        break;
                case 3: System.out.print("상품검색 키워드: ");
                        key = scanner.next();
                        findItem(key);
                        break;
                case 4: System.out.print("사용자 검색 키워드: ");
                        findUser(scanner.next());
                        break;
            }
        }


        scanner.close();
    }

    void readAllItems(Scanner scanner) {
        String id;
        int itemIndex = 1;
        Item item;

        do {
            id = scanner.next();
            if (id.equals("0")) break;

            item = new Item();

            item.read(itemIndex, id, scanner);

            itemList.add(item);

            itemIndex++;
        } while(true);

    }

    void readAllUsers(Scanner scanner) {
        String id;
        User user;

        while (true) {
            id = scanner.next();

            if (id.equals("0")) break;

            user = new User();

            user.read(id, scanner, this);

            userList.add(user);
        }
    }

    void printAllItems() {
        for (var item : itemList) {
            item.print();
        }

        System.out.println();
    }

    void printAllUsers() {
        for (var user : userList) {
            user.print();
        }

        System.out.println();
    }

    Item findItem(int index) {
        for (var item : itemList) {
            if (item.num == index) return item;
        }
        return null;
    }

    void findItem(String key) {
        Pattern codePattern = Pattern.compile("^[A-Z]\\d{4}$");
        Pattern indexPattern = Pattern.compile("^\\d+$");
        Pattern kwdPattern = Pattern.compile("^[가-힣a-zA-Z0-9]+$");
        int parsed;

        if (codePattern.matcher(key).matches()) {
            for (var item : itemList) {
                if (item.matches(key)) item.print();
            }
        }
        else if (indexPattern.matcher(key).matches()) {
            parsed = Integer.parseInt(key);
            for (var item : itemList) {
                if (item.matches(parsed)) item.print();
            }
        }
        else if (kwdPattern.matcher(key).matches()) {
            for (var item : itemList) {
                if (item.contains(key)) item.print();
            }
        }
    }

    void findUser(String id) {
        for (var user : userList) {
            if (user.matches(id)) user.print();
        }
    }
}

class Item {
    int num, price;
    String code, name;

    void read(int index, String id, Scanner scan) {
        num = index;
        code = id;
        name = scan.next();
        price = scan.nextInt();
    }

    void print() {
        System.out.printf("[%d] %s %s (%d원)\n", num, code, name, price);
    }

    boolean matches(String code) {
        return code.equals(this.code);
    }

    boolean matches(int num) {
        return num == this.num;
    }

    boolean contains(String key) {
        return name.contains(key);
    }
}

class User {
    String id, pw;
    int sum, point, tmp;

    ArrayList<Item> basket = new ArrayList<>();

    void read(String id, Scanner scan, Store store) {

        this.id = id;

        if (id.equals("0")) return;

        pw = scan.next();
        point = scan.nextInt();

        while(true) {
            tmp = scan.nextInt();
            if (tmp == 0) break;

            basket.add(store.findItem(tmp));
        }

        for (var item: basket) {
            sum += item.price;
        }
    }

    void print() {
        System.out.printf("[%s] 총구매 %d건 %d원 (%d점)\n", id, basket.size(), sum, point);

        for (var item : basket) {
                System.out.printf("%s ", item.name);
            }

        System.out.println();
    }

    boolean matches(String id) {
        return id.equals(this.id);
    }
}