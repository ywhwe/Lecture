package src.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class AppendixBook extends Book{
    ArrayList<String> appendix = new ArrayList<>();

    int num;

    @Override
    public void read(Scanner scan) {
        super.read(scan);

        num = Integer.parseInt(scan.next().replaceAll(" {2}", ""));

        for (int i = 0; i < num; i++) {
            appendix.add(scan.next());
        }
    }

    @Override
    String getBookType() {
        return "[부록책]";
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("\t별책 %d권: ", appendix.size());

        for (var s : appendix) {
            System.out.printf("%s ", s);
        }

        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        if (super.matches(kwd)) return true;
        if (kwd.equals("appendix")) return true;

        for (var s : appendix) {
            if (s.contains(kwd)) return true;
        }

        return false;
    }
}
