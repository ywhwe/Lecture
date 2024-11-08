package src.lec;

import java.util.Scanner;

import src.mgr.Manager;

public class Department{
	Scanner scan = new Scanner(System.in);
	Manager<Student> stMgr = new Manager<>();
	static Manager<Lecture> lecMgr = new Manager<>();

	void mymain() {
		lecMgr.readAll("lecture.txt", Lecture::new);
		lecMgr.printAll();
		stMgr.readAll("student.txt", Student::new);
		stMgr.printAll();
		searchMenu();
	}

	void searchMenu() {
		while (true) {
			System.out.print("(1) 학생   (2) 과목  (3) 학생 요일 검색  (4) 종료");
			int menu = scan.nextInt();
			if (menu == 1)
				stMgr.search(scan);
			if (menu == 2)
				lecMgr.search(scan);
			if (menu == 3)
				searchByDay();
			else break;
		}
	}

	void searchByDay() {
		System.out.print("요일:");
		String kwd = scan.next();
		for (Student st : stMgr.mList) {
			if (st.matchDay(kwd))
				st.printStudent();
		}
	}

	public static void main(String[] args) {
		Department dpt = new Department();
		dpt.mymain();
	}

	static public Lecture findLecture(String code) {
		return lecMgr.find(code);
	}
}
