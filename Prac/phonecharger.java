package Prac;
import java.util.Scanner;
public class phonecharger {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		battery Battery = new battery();
		
		while(true) {
			System.out.println("\nOptions");
			System.out.println("1 Plug Charger");
			System.out.println("2 Unplug Charger");
			System.out.println("3 Check Battery");
			System.out.println("4 Exit program");
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				Battery.charge();
				break;
			case 2:
				Battery.unplugcharger();
				break;
			case 3:
				Battery.checkBattery();
				break;
			case 4:
				System.out.println("Now Exiting the program");
				System.exit(0);
			default:
				System.out.println(" Invalid option");
			}
		}
	}
}
