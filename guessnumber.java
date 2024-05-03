package BrocodeJava;
import java.util.Scanner;
import java.util.Random;
public class guessnumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		Random random = new Random();
		//randomizing 
		int number = random.nextInt(10);
		
		//while system
		while(number<10) {
			System.out.println(" Enter the number to guess");
			int guess = scan.nextInt();
			if(guess == number) {
				System.out.println(" You won nigga ");
				break;
			} else if (guess<number) {
				System.out.println(" Number is too low try again");
			} else if (guess>number) {
				System.out.println(" Number is too high try again");
			}
		}
		
	}
}
