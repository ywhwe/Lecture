package src.Lecture3;

import java.nio.charset.Charset;
import java.util.*;

public class Department {
    public static void main(String[] args) {
        Department dp = new Department();
        dp.newMain();
    }

    ArrayList<Student> stList = new ArrayList<>();
    ArrayList<Lecture> lecList = new ArrayList<>();

    void newMain() {
        Scanner scanner = new Scanner(System.in, Charset.forName("EUC-KR"));

        readAllLectures(scanner);

        readAllStudents(scanner);

        scanner.close();
    }

    void readAllStudents(Scanner scan) {
        String stId;
        Student st;
        do {
            stId = scan.next();
            if (stId.equals("0")) break;
            st = new Student();
            st.read(stId, scan, this);

            stList.add(st);
        } while(true);

        printAllStudents();
    }

    void printAllStudents() {
        for (var value : stList) {
            value.print();
        }
    }

    void readAllLectures(Scanner scan) {
        String lecCode;
        Lecture lec;

        do {
            lecCode = scan.next();
            if (lecCode.equals("0")) break;
            lec = new Lecture();
            lec.read(lecCode, scan);

            lecList.add(lec);
        } while(true);

        for (var v : lecList) {
            v.print();
        }
    }

    Lecture findLecture(String code) {
        for (var value: lecList) {
            if(value.match(code)) {
                return value;
            }
        }

        return null;
    }
}

class Lecture {
    String code, lectureName, day, time;
    int year;

    void read(String code, Scanner scan) {
        this.code = code;
        lectureName = scan.next();
        year = scan.nextInt();
        day = scan.next();
        time = scan.next();
    }

    void print() {
        System.out.printf("\t [%s] %s %d학년 (%s요일 %s)\n", code, lectureName, year, day, time);
    }

    boolean match(String code) {
        return code.equals(this.code);
    }
}

class Student {
    String id, name, dp, phone, year, lecCode;

    ArrayList<Lecture> registeredList = new ArrayList<>();

    Lecture lecture = null;

    void read(String id, Scanner scanner, Department dp) {
        this.id = id;
        name = scanner.next();
        this.dp = scanner.next();
        phone = scanner.next();
        year = scanner.next();

        while (true) {
            lecCode = scanner.next();
            if (lecCode.equals("0")) break;
            lecture = dp.findLecture(lecCode);
            registeredList.add(lecture);
        }
    }

    void print() {
        System.out.printf("%s %s %s (%s학년)\n", id, name, phone, year);
        for (var lec : registeredList) {
            lec.print();
        }
    }

    boolean match(String key) {
        return key.equals(name);
    }
}