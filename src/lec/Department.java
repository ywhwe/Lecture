package src.lec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import src.mgr.Manager;

public class Department{
	Scanner scan = new Scanner(System.in);
	Manager<Student> stMgr = new Manager<>();
	static Manager<Lecture> lecMgr = new Manager<>();

	void mymain() {
		lecMgr.readAll("lecture.txt", Lecture::new);
		lecMgr.printAll();

		System.out.println("===================== 코드순 =====================");
		lecMgr.printAllSortBy(new Comparator<Lecture>(){

			@Override
			public int compare(Lecture o1, Lecture o2) {
				return o1.code.compareTo(o2.code);
			}
		});

		System.out.println("===================== 이름순 =====================");
		lecMgr.printAllSortBy(new Comparator<Lecture>(){

			@Override
			public int compare(Lecture o1, Lecture o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		stMgr.readAll("student.txt", Student::new);
		stMgr.printAll();
		ArrayList<Student> newList = new ArrayList<>(stMgr.mList);
		Collections.sort(newList);
		for (Student s : newList) {
			s.printStudent();
		}
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