package lessons;
import java.util.Scanner;
public class Calculator_Upgrade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean keeponrunning = true;
		do {
			//setting up the calculator
			System.out.println("Welcome to the Calculator!");
			// Create a Scanner object to read input from the user
			System.out.println("Enter Var 1: ");
			
			int var1 = scanner.nextInt();
			
			System.out.println("Enter Var 2: ");
			
			int var2 = scanner.nextInt();
			
			String operation =("Enter the operation (+,- *, /): ");
			System.out.println(operation);
			int result;
			
			// Read the operation from the user
			operation = scanner.next();
			switch(operation) {
			case "+":
				result = var1 + var2;
				System.out.println("Result: " + result);
				break;
			case "-":
				result = var1 - var2;
				System.out.println("Result: " + result);
				break;
			case "*":
				result = var1 * var2;
				System.out.println("Result: " + result);
				break;
			case "/":
				if (var2 != 0) {
					result = var1 / var2;
					System.out.println("Result: " + result);
				} else {
					System.out.println("Error: Division by zero is not allowed.");
				}
				break;
				default:
					System.out.println("Invalid operation. Please enter one of the following: +, -, *, /");
			   }
			// Ask the user if they want to try again
            System.out.println("Do you want to try again? (yes/no): "); // prompting the user to try again
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("no")) {
				keeponrunning = false;
				System.out.println("Thank you for using the calculator!");
			} else if (!answer.equalsIgnoreCase("yes")) {
				System.out.println("Invalid input. Exiting the calculator.");
				keeponrunning = false;
			}
		} while (keeponrunning);
		scanner.close();
		System.out.println("Calculator has been closed.");

    }
}

