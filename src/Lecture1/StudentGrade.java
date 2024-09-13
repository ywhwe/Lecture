package src.Lecture1;

import java.nio.charset.Charset;
import java.util.*;

public class StudentGrade {
    public static void main(String[] args) {
        StudentGrade main = new StudentGrade();
        main.myMain();
    }

    public void myMain() {
        Scanner scanner = new Scanner(System.in, Charset.forName("EUC-KR"));
        Student[] students;

        System.out.print("학생수: ");
        int n = scanner.nextInt();

        students = new Student[n];
        IntArray intArray = new IntArray(n);

        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].write(scanner);
        }

        for (int i = 0; i < n; i++) {
            students[i].print();
        }

        do {
            System.out.print("계속하시겠습니까?(y/n)");

            if (!questYesNo(scanner.next())) break;

            System.out.print("점수를 수정할 과목 번호 (1)국어 (2)영어 (3)수학 ...");
            int sbjNum = scanner.nextInt();

            System.out.println(students.length + "명 점수 입력...");

            intArray.generate(0, 100);

            System.out.print("점수 반영하시겠습니까? (y/n)");

            if (questYesNo(scanner.next())) {
                for (int i = 0; i < students.length; i++) {
                    students[i].revise(sbjNum, intArray.numbers[i]);
                } // this adjusts new score
            }
            else {
                System.out.print("조정할 점수 구간 최소 최대 ");
                intArray.generate(scanner.nextInt(), scanner.nextInt());
            }
        } while (true);

        System.out.print("안녕히 가세요");
    }

    boolean questYesNo(String ans) {
        return ans.equals("y");
    }
}

class Student {
    int id;
    String name;
    int year;
    int[] score = new int[3];

    final char[] Grade = {'A', 'B', 'C', 'D', 'F'};
    char[] grade = new char[3];

    void write(Scanner scan) {
        id = scan.nextInt();
        name = scan.next();
        year = scan.nextInt();

        for (int i = 0; i < 3; i++) {
            score[i] = scan.nextInt();

            if (score[i] < 60) grade[i] = Grade[4];
            else if (score[i] < 70) grade[i] = Grade[3];
            else if (score[i] < 80) grade[i] = Grade[2];
            else if (score[i] < 90) grade[i] = Grade[1];
            else grade[i] = Grade[0];
        }
    }

    void print() {
        System.out.print(id + "     " + name + "    " + "(" + year + "학년)  ");

        for (int i = 0; i < 3; i++) {
            System.out.print(score[i] + "(" + grade[i] + ") ");
        }

        System.out.println();
    }

    void revise(int num, int newScore) {
        score[num] = newScore;
    }
}

class IntArray {
    int[] numbers;
    Random rand = new Random();

    IntArray(int size) {
        numbers = new int[size];
    }

    void generate(int lower, int upper) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(lower, upper);
            System.out.print(" " + numbers[i]);
        }
    }

    void compScore(int origin, int newScore) {

    }


}