package Lecture1;

import java.util.*;

class Students {
    String studentInfo[];
    
    public void InputInfo(int num) {
        Scanner scanner2 = new Scanner(System.in);
        studentInfo = new String[num];
        int count = 0;

        do { 
            studentInfo[count] = scanner2.nextLine();
            count++;
        } while (count < num);

        for (int i = 0; i < studentInfo.length-1; i++) {
            System.out.println(studentInfo[i]);
        }

        scanner2.close();
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        StudentGrade main = new StudentGrade();
        main.MyMain();
    }

    public void MyMain() {
        Students students = new Students();
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생수: ");
        students.InputInfo(scanner.nextInt());
    }
}