package MyPracCodeProcess;
import java.util.Random;
import java.util.Scanner;
public class guessnumbertest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//randomizing;
		Random random = new Random();
		
		int number = random.nextInt(70);
		
		//using while method
		
		while(number<70) {
			System.out.println("Enter number please ");
			int guess = scanner.nextInt();
			if(guess == number) {
				System.out.println("Handsome si kashi");
				break;
			} else if(guess<number) {
				System.out.println("Kashi must do 10 pull");
			} else if (guess>number) {
				System.out.println("Mananalo si kashi ng venti");
			}
		}
	}

}
