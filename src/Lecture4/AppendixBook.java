package src.Lecture4;

import java.util.ArrayList;
import java.util.Scanner;

public class AppendixBook extends Book{
    ArrayList<String> appendix = new ArrayList<>();

    @Override
    public void read(Scanner scan) {
        super.read(scan);

        for (int i = 0; i < scan.nextInt(); i++) {
            appendix.add(scan.next());
        }
    }

    @Override
    String getBookType() {
        return "별책";
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("\t%s %d권: ", getBookType(), appendix.size());

        for (var s : appendix) {
            System.out.printf("%s ", s);
        }
    }

    @Override
    public boolean matches(String kwd) {
        if (super.matches(kwd)) return true;

        for (var s : appendix) {
            if (s.equals(kwd)) return true;
        }

        return false;
    }
}
