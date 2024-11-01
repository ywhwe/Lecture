package src.Team;

import java.util.Scanner;

public class NMember extends Member {
	String nick;

	public void read(Scanner scan) {
		super.read(scan);
		nick = scan.next();
	}

	public void print() {
		super.print();
		System.out.printf(" [%s]", nick);
	}

	public boolean matches(String kwd) {
		return super.matches(kwd) || nick.equals(kwd);
	}
}