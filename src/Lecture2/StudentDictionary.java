package src.Lecture2;

import java.util.*;

public class StudentDictionary {
    public static void main(String[] args) {
        StudentDictionary main = new StudentDictionary();
        main.newMain();
    }

    public void newMain() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();

        int select;
        String id;

        Student student;

        do {
            id = scanner.next();
            if (id.equals("0")) break;

            student = new Student();

            student.write(id, scanner);

            studentList.add(student);

        } while(true);

        for (Student st : studentList) {
            st.print();
        }

        while (true) {
            System.out.print("(1)전체검색 (2)이름검색 (3)통합검색 (4)점수검색 (5)종료");
            select = scanner.nextInt();
            if (select == 5) break;

            switch (select) {
                case 1: for (Student st: studentList) {
                            st.print();
                        }
                        break;
                case 2: System.out.print("이름: ");
                        nameSearch(scanner.next(), studentList);
                        break;
                case 3: System.out.print("통합검색 키워드: ");
                        integSearch(scanner.next(), studentList);
                        break;
                case 4: System.out.print("점수검색 범위:");
                        scoreSearch(scanner.nextInt(), scanner.nextInt(), studentList);
                        break;
            }

        }
        scanner.close();
    }

    void scoreSearch(int min, int max, ArrayList<Student> list) {
        for (Student st: list) {
            if (st.rangeMatch(min, max)) {
                st.print();
            }
        }
    }

    void integSearch(String key, ArrayList<Student> list) {
        for (Student st: list) {
            if (st.match(key)) {
                st.print();
            }
        }
    }

    void nameSearch(String name, ArrayList<Student> list) {
        for (Student st: list) {
            if (st.nameMatch(name)) {
                st.print();
            }
        }
    }
}

class Student {
    int grade, score;
    String id, name, phone;

    void write(String id, Scanner scanner) {
        this.id = id;
        name = scanner.next();
        grade = scanner.nextInt();
        phone = scanner.next();
        score = scanner.nextInt();
    }

    void print() {
        System.out.printf("%s %s (%d학년) %s - %d점\n", id, name, grade, phone, score);
    }

    boolean nameMatch(String key) {
        return key.equals(name);
    }

    boolean match(String key) {
        int parsed = 0;
        try {
            parsed = Integer.parseInt(key);
        } catch (NumberFormatException ignored) {

        }

        if (key.length() <= 3)  {
            if (name.contains(key)) {
                return true;
            }
            else return grade == parsed || score == parsed;
        }
        return key.equals(id) || key.equals(phone);
    }

    boolean rangeMatch(int min, int max) {
        return score >= min && score < max;
    }
}