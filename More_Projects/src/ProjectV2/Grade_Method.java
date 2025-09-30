package ProjectV2;
import java.util.Scanner;
public class Grade_Method {

	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your Name");
			// once it entered the grade, it will check if the grade is valid or not
			String name = sc.next();
			// enter the grade
			System.out.println("Enter your Grade:");
			int grade = sc.nextInt();
			// Check if the grade is within the valid range 
			if (grade >= 0 && grade <= 100) {
				if(grade >= 90) {
					System.out.println(name + "your grade is A");// passed
				} else if (grade >= 80) {
					System.out.println(name + "your grade is B");// satisfactory
				} else if ( grade >= 75) {
					System.out.println(name + "your grade is C");// average
				} else if (grade >= 70) {
					System.out.println(name + "your grade is D");// below average
				} else if (grade < 70) {// failed
					System.out.println("Goodbye see you next year " + name);
				} else {
					System.out.println("Invalid grade entered. Please enter a grade between 0 and 100.");
				}
				// Exit the loop after processing a valid grade
			}
		    // exit if they are sure of there grade
            System.out.print("Do you want to enter another grade? (yes/no): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("no")) {
            	System.out.println("Thank you for using the grade checker. Goodbye!");
                break;
            }
        }

    }

}
