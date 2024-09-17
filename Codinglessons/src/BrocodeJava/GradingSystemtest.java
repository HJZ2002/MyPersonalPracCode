package BrocodeJava;
import java.util.Scanner;
public class GradingSystemtest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//setting up for each subject grade
		String grade[] = {"Math","Science","English","Computer","PE"};
		
		//asking the user on what subject
		System.out.println("What Subject ?");
		String subject = scan.nextLine();
		
		//first grade
		System.out.println("Enter your first grade number");
		int firstgrade = scan.nextInt();
		//second grade
		System.out.println("Enter your second grade number");
		int secondgrade = scan.nextInt();
	
		int result = (firstgrade + secondgrade) / 2;
				
		if(result >= 95) {
			System.out.println("A+");
		} else if(result >= 90) {
			System.out.println("A");
		} else if(result >=85) {
			System.out.println("B+");
		} else if(result >=80) {
			System.out.println("B");
		} else if(result >= 75) {
			System.out.println("C");
		} else {
			System.out.println("Failed better luck next time");
		}
	}

}
