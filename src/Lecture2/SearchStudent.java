package src.Lecture2;

import java.util.*;
import java.nio.charset.Charset;

public class SearchStudent {
    ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        SearchStudent main = new SearchStudent();
        main.newMain();
    }

    public void newMain() {
        Scanner scanner = new Scanner(System.in, Charset.forName("EUC-KR"));

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
                        nameSearch(scanner.next());
                        break;
                case 3: System.out.print("통합검색 키워드: ");
                        integSearch(scanner.next());
                        break;
                case 4: System.out.print("점수검색 범위:");
                        scanner.skip("\r\n");

                        var input = scanner.nextLine().trim();
                        int min, max;

                        if (input.startsWith("-")) {
                            max = Integer.parseInt(input.substring(1).trim());
                            scoreSearch(max, false);
                        }
                        else if (input.endsWith("-")) {
                            min = Integer.parseInt(input.substring(0, 2).trim());
                            scoreSearch(min, true);
                        }
                        else {
                            max = Integer.parseInt(input.substring(2, 5).trim());
                            min = Integer.parseInt(input.substring(0, 2).trim());
                            scoreSearch(min, max);
                        }
                        break;
            } // End of switch
        } // End of while
        scanner.close();
    }

    void scoreSearch(int min, int max) {
        for (Student st: studentList) {
            if (st.rangeMatch(min, max)) {
                st.print();
            }
        }
    }

    void scoreSearch(int num, boolean flag) {
        for (Student st: studentList) {
            if (st.rangeMatch(num, flag)) {
                st.print();
            }
        }
    }

    void integSearch(String key) {
        for (Student st: studentList) {
            if (st.keywordMatch(key)) {
                st.print();
            }
        }
    }

    void nameSearch(String name) {
        int count = 0;

        for (Student st: studentList) {
            if (st.nameMatch(name)) {
                st.print();
                count++;
            }
        }

        if (count == 0) System.out.println("없는 이름입니다.");
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

    boolean keywordMatch(String key) {
        int parsed = 0;

        try {
            parsed = Integer.parseInt(key);
        } catch (NumberFormatException ignored) {

        }

        if (key.length() <= 3)  {
            if (name.contains(key)) {
                return true;
            }
            else return grade == parsed;
        }
        return id.contains(key) || phone.contains(key);
    }

    boolean rangeMatch(int min, int max) {
        return score >= min && score < max;
    }

    boolean rangeMatch(int num, boolean flag) {
        if (!flag) return score < num;
        return score >= num;
    }
}