package CoddyTech;
import java.util.Scanner;
public class Scan_class {
	
	public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter their name
         System.out.print("Enter your name: ");
        
        // Read the user's name
        String name = scanner.nextLine();
        
        // Print the greeting message
           System.out.println("Hello, " + name);
    }
}

