package Module12ndyear;

public class Course {
	//setting up the variables
	private String code;
	
	private String description;
	
	Course(){}
	public Course (String code, String description) {
		this.code = code;
		this.description = description;
		
	}//end of constructor
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}//end of method
	public void setCourse(String code,String description) {
		this.code = code;
		this.description = description;
	}//finish of method
	public String getCourse() {
		return code + "\t" + description + "\t";
	}
	public void viewCourseInfo() {
		System.out.println("Code\t\t"+ code);
		System.out.println("Description\t:" + description);
	}//end of method
	public String showCourseInfo() {
		return"Code\t\t:"+code+
		"\nDescription\t:"+description;
	}//end of method
}//end of class
