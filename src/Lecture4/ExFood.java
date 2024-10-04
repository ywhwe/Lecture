package src.Lecture4;

import java.util.*;

public class ExFood extends Food{
    int amount;
    String cap;

    @Override
    void read(Scanner scan) {
        super.read(scan);
        amount = scan.nextInt();
        cap = scan.next();
    }


    @Override
    void printNoLn() {
        // 빵-샌드위치 (468kcal/개) 250 g
        System.out.format("%s-%s (%dkcal/%s) %d%s", type, name, cal, unit, amount, cap);
    }

    @Override
    void printEat(int n, String u) {
        // 우유 100ml(0kcal) - 125kcal/1개(0ml) -> 0kcal*100/0ml=0kcal
        System.out.format("%s %d%s(%dkcal)", name, n, u, getKcal(n, u));
        System.out.format(" - %dkcal/%d%s(%d%s)", cal, 1, unit, amount, cap);
        printDetail(n, u);
        System.out.println();
    }

    @Override
    int getKcal(int n, String u) {
        return cal * n / amount;
    }

    @Override
    void printDetail(int n, String u) {
        System.out.format(" -> %dkcal*%d/%d%s=%dkcal", cal, n, amount, cap, getKcal(n, u));
    }

    @Override
    public boolean matches(String name2) {
        return super.matches(name2);
    }
}