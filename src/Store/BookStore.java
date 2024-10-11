package src.Store;

import src.Manager.Factory;
import src.Manager.Manageable;
import src.Manager.Manager;

import java.util.*;
import java.nio.charset.*;

public class BookStore extends Manager implements Factory {
    Scanner scan = new Scanner(System.in, Charset.forName("EUC-KR"));

    public static void main(String[] args) {
        BookStore main = new BookStore();
        main.newMain();
    }

    void newMain() {
        readAll("book4.txt", this);
        printAll();
        search(scan);
    }

    @Override
    public Manageable create(Scanner filein) {
        int type = filein.nextInt();

        Manageable m = null;

        switch(type) {
            case 1: m = new Book(); break;
            case 2: m = new Ebook(); break;
            case 3: m = new AppendixBook(); break;
            case 4: m = new Pen(); break;
            case 5: m = new Tissue(); break;
            default: break;
        }
        
        return m;
    }
}
