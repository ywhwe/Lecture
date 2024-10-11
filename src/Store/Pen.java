package src.Store;

import src.Manager.Manageable;

import java.util.Scanner;

public class Pen implements Manageable {
    String itemName;
    float mmThick;
    int price;

    @Override
    public void read(Scanner scan) {
        itemName = scan.next();
        mmThick = scan.nextFloat();
        price = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("[Pen] %s (%.2fmm) %d원\n", itemName, mmThick, price);
    }

    @Override
    public boolean matches(String kwd) {
        return kwd.equals(itemName) || kwd.equals(mmThick + "");
    }
}
