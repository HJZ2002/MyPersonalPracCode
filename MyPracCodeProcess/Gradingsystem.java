package MyPracCodeProcess;
import java.util.Scanner;
public class Gradingsystem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		//entering the score
		System.out.println(" Enter your Math Score");
		int Math= scan.nextInt();
		System.out.println(" Enter your PE Score");
		int PE= scan.nextInt();
		System.out.println(" Enter your Filipino Score");
		int Filipino= scan.nextInt();
		System.out.println(" Enter your Science Score");
		int Science= scan.nextInt();
		System.out.println(" Enter your Computer Score");
		int Computer= scan.nextInt();
		System.out.println(" Enter your Art Score");
		int Art= scan.nextInt();
		
		//getting the score
		int result = (Math + PE + Filipino + Science + Computer + Art)/6;
		//getting the score of each subject
		String grade = calculate(result);
		System.out.println("Your Average score is "+ result);
		System.out.println("Grade is " +grade);
		
	}
	private static String calculate(int result) {
		//getting the grades of the student
		if (result>=100) {
			return"Excellent";
		} else if (result>=95) {
			return"Super Satisfactory";
		} else if (result>=90) {
			return"Over Satisfactory";
		} else if (result>=87) {
			return"Over Satisfied";
		} else if (result>=75) {
			return"Passed";
		} else {
			return"Failed see you next term";
		}
	}

}
