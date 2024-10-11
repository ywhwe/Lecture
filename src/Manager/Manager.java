package src.Manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager{
    ArrayList<Manageable> mList = new ArrayList<>();

    String kwd;

    void find(String kwd) {
        for (var i : mList) {
            if(i.matches(kwd)) {
                i.print();
            }
        }
    }

    public void search(Scanner scan) {
        do {
            kwd = scan.next();
            find(kwd);
        } while (!kwd.equals("exit"));
    }

    public void readAll(String fileName, Factory fac) {
        Scanner filein = openFile(fileName);
        while (filein.hasNext()) {

            Manageable m;

            m = fac.create(filein);
            m.read(filein);

            mList.add(m);
        }

        filein.close();
    }

    public void printAll() {
        for(Manageable m : mList) {
            m.print();
        }
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
