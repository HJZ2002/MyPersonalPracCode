import java.util.Scanner;
public class Pinattempt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int attempts =3; //max attempts
		int pin =181;
		
		int user;
		String retry; // if it wants to log in again if the user press "y"
		// implementing a loop to allow user to enter pin
		do {
			System.out.print("Enter your pin: ");
            user = scan.nextInt();
            
            if (user == pin) {
                System.out.println("Pin accepted.");
                break; // exit the loop if pin is correct
            } else if (user != pin) {
                attempts--; // decrement attempts
                System.out.println("Incorrect pin. You have " + attempts + " attempts left.");
            }
            // exiting the game
            if (attempts == 0) {
                System.out.println("No more attempts left. Exiting.");
                return; // exit the program if no attempts left
            }
            System.out.print("Do you want to try again? (y/n): ");
            retry = scan.next();
		}
		while (retry.equalsIgnoreCase("y") && attempts > 0);
	}
}