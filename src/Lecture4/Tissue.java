package src.Lecture4;

import src.Manager.Manageable;

import java.util.Scanner;

public class Tissue implements Manageable {
    String tissueName;
    int nSheets;
    int price;

    @Override
    public void read(Scanner scan) {
        tissueName = scan.next();
        nSheets = scan.nextInt();
        price = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("%s (%d장) [%d원]", tissueName, nSheets, price);
    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }
}
