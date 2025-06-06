package lessons;

public class Member {
	private String name; // name
	private String type; // type of member (e.g., Developer, Designer)
	private String Age; // age of the member
	private int level; // level of expertise or experience
	private int rank; // rank of the member in the team or organization
	
	// Setting up the constructor to initialize the member variables
	public Member(String name, String type, String age, int level, int rank) {
		this.name = name;
		this.type = type;
		this.Age = age;
		this.level = level;
		this.rank = rank;
	}
	public String getName() { // returns the name of the member if called
		return this.name; // returns the name of the member
	}
	public String getType() { // returns the type of member if called
		return this.type; // returns the type of member
	}
	public String getAge() { // returns the age of the member if called
		return this.Age; // returns the age of the member
	}
	public int getLevel() {
		// returns the level of expertise or experience of the member if called
		return this.level;
	}
	public int getRank() {
		// returns the rank of the member in the team or organization if called
		return this.rank;
	}
}
