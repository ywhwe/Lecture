package src.Student;

import src.Manager.Factory;
import src.Manager.Manageable;
import src.Manager.Manager;

import java.util.ArrayList;
import java.util.Scanner;

public class Department extends Manager implements Factory {
	Scanner scan = new Scanner(System.in);
//	static ArrayList<Student> studentList = new ArrayList<>();
	static ArrayList<Lecture> lectureList = new ArrayList<>();

	void run() {
		readLectures();
		printLectures();
		readAll("student.txt", this);
		printAll();
		search(scan);
	}

	void readLectures() {
		Scanner filein = openFile("lecture.txt");
		Lecture lec = null;
		while (filein.hasNext()) {
			lec = new Lecture();
			lec.read(filein);
			lectureList.add(lec);
		}		
		filein.close();
	}

	private void printLectures() {
		for (Lecture lec: lectureList) {
			lec.print();
		}
	}

	public static void main(String[] args) {
		Department my = new Department();
		my.run();
	}

	static public Lecture findLecture(String code) {
		for (Lecture lec: lectureList) {
			if (lec.matches(code))
				return lec;
		}
		return null;
	}

	@Override
	public Manageable create(Scanner scan) {
		return new Student();
	}
}