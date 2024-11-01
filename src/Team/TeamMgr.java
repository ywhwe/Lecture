package src.Team;

import src.Manager.*;

import java.util.Scanner;

public class TeamMgr {
	Scanner scan = new Scanner(System.in);
	Manager teamMgr = new Manager();
	static Manager memberMgr = new Manager();

	void myMain() {
		memberMgr.readAll("members.txt", new MemberFactory());
		teamMgr.readAll("teams.txt", new TeamFactory());
		teamMgr.printAll();
		askSameTeam();
	}

	static class MemberFactory implements Factory {

		@Override
		public Manageable create(Scanner scan) {
			int n = scan.nextInt();
			if (n == 1) return new Member();
			if (n == 2) return new NMember();
			return null;
		}
	}

	static class TeamFactory implements Factory {

		@Override
		public Manageable create(Scanner scan) {
			return new Team();
		}
	}

	void askSameTeam() {
		Outer: while (true) {
			System.out.print("\n같은팀 검사(두 개 이름): ");
			String name1 = scan.next();

			if (name1.equals("end")) break;

			String name2 = scan.next();

			for (Manageable m : memberMgr.mList) {
				if (m.matches(name1) && m.matches(name2)) {
					System.out.println("같은 팀이 아님(동일인)");
					continue Outer;
				}
			}

			Team result = null;

			for (Manageable m : teamMgr.mList) {
				if (m.matches(name1) && m.matches(name2)) {
					result = (Team) m;
					break;
				}
			}

			if (result != null)
				System.out.printf("%s팀에 속함", result.teamName);
			else
				System.out.printf("같은 팀이 아님");
		}
	}

	static Member findMember(String kwd) {
		for (Manageable m : memberMgr.mList)
			if (m.matches(kwd))
				return (Member) m;
		return null;
	}

	public static void main(String[] args) {
		TeamMgr m = new TeamMgr();
		m.myMain();
	}
}