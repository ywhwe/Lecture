package src.Practice;

import java.util.*;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> stList = new ArrayList<>();

	void mymain() {
		readAll();
		printAll();
	}
	void readAll() {
		System.out.print("학생수: ");
		int n = scan.nextInt();
		Student st;
		for (int i = 0; i < n; i++) {
			st = new Student();
			st.read(scan);
			stList.add(st);
		}
	}
	void printAll() {
		for (Student st : stList) {
			st.print();
		}
	}

	public static void main(String[] args) {
		Department my = new Department();
		my.mymain();
	}
}
