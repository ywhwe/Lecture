package src.Team;

import java.util.Scanner;

import src.Manager.Manageable;

public class Member implements Manageable {
	static int Count;
	String name;
	int id;

	public void read(Scanner scan) {
		name = scan.next();
		id = ++Count;
	}

	public void print() {
		System.out.printf("  %d)%s", id, name);
	}

	public boolean matches(String kwd) {
		if (name.equals(kwd))
			return true;
		if (("" + id).equals(kwd))
			return true;
		return false;
	}

	boolean matches(String n1, String n2) {
		return n1.equals(n2);
	}
}