package projects;
import java.util.Scanner;
import java.util.Random;
public class calculatornimohamad {
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	boolean Playagain = true;
	
	
	//implementing the methods
	while(Playagain) {
		int number = random.nextInt(30) + 1;
		boolean guess = false;
		
		System.out.println("Would u like to play guessing number ?");
		while(!guess) {
			System.out.println("Enter your guess : ");
            int userGuess = scanner.nextInt();
            
            if(userGuess == number) {
                System.out.println("Congratulations! You guessed the correct number");
                guess = true;
            } else if(userGuess < number) {
                System.out.println("Too low, try again!");
            } else {
                System.out.println("Too high, try again!");
            }
		}
		//asking if u want to play again
		System.out.println("Would you like to play again Y/N");
		scanner.nextLine();
		
		String response = scanner.nextLine().trim();
		
		if(!response.equalsIgnoreCase("Y")) {
            Playagain = false;
            System.out.println("GGWP");
        }
	
	}
}
}
