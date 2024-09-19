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

        int grade, score, select = 0;
        String id, name, phone;

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
                        search(scanner.next(), studentList);
                        break;
                case 3: System.out.print("통합검색 키워드: ");
                        search(scanner.next(), studentList);
                        break;
                case 4: System.out.print("점수검색 범위:");
                break;
            }

        }
        scanner.close();
    }

    void search(int min, int max, ArrayList<Student> list) {
        for (Student st: list) {
            // TODO range search
        }
    }

    void search(String key, ArrayList<Student> list) {
        for (Student st: list) {
            if (st.match(key)) {
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
        System.out.println(id + " " + name + " " + "(" + grade + " 학년)  " + phone + " - " + score + " 점");
    }

    boolean match(String key) {
        if (key.length() <= 3)  return key.equals(name) || grade == Integer.parseInt(key) || score == Integer.parseInt(key);
        return key.equals(id) || key.equals(phone);
    }
}