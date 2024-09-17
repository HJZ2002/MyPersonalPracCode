package BrocodeJava;
import java.util.Scanner;
public class pinattempts {

	public static void main(String[] args) {
		//variables
		Scanner scan = new Scanner(System.in);
		int attempts = 3;
		int pin= 181;
		int user;
		
		while(attempts >0) {
			System.out.println(" Please enter the pin provided ");
			user = scan.nextInt();
			if(user == pin) {
				System.out.println(" Access granted");
				break;
			} else if (attempts == 1) {
				System.out.println("Your account is temporarlily suspened please vist the nearest branch\n");
				attempts--;
			} else {
				System.out.println("Incorrect pin you have "+attempts+" left");
				attempts--;
			}
		}
	}
}
