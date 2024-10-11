package src.Lecture4;

import java.util.*;

public class Ebook extends Book {
    String url;
    String format;

    @Override
    public void read(Scanner scan) {
        super.read(scan);

        url = scan.next();
        format = scan.next();
    }

    @Override
    String getBookType() {
        return "[전자책]";
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("%s [%s]\n", url, format);
    }

    @Override
    public boolean matches(String kwd) {
        if (super.matches(kwd)) return true;
        if (url.contains(kwd)) return true;
        if (format.equals(kwd)) return true;
        return false;
    }
}
