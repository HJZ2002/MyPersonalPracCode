package lessons;

public class Team_Member {
	//calling the class what i just created
	Member member;
	// making a constructor to initialize the member variable
	public Team_Member(Member member) {
		this.member = member;
	}
	
	public static void main(String[]args) {
		Member member = new Member("John Doe", "Senior Manager", "25", 3, 1);
		Team_Member teamMember = new Team_Member(member);
		
		// Displaying the member details for each
		System.out.println("Member Name: " + teamMember.member.getName());
		System.out.println("Member Type: " + teamMember.member.getType());
		System.out.println("Member Age: " + teamMember.member.getAge());
		System.out.println("Member Level: " + teamMember.member.getLevel());
		System.out.println("Member Rank: " + teamMember.member.getRank());
	}
}
