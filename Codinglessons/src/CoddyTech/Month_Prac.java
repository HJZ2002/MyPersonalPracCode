package CoddyTech;
import java.util.Scanner; 
public class Month_Prac {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// determines on what month if the user wants to put a number\
		
		// setting up a string for the season
		String season = ""; // setting up a complete season
		
		// determines on what season it is based on the month
		while(true) {
			System.out.println("Enter a month (1-12): ");
			int month = scan.nextInt();
			if(month == 0) {
				System.out.println("Invalid month. Please enter a number between 1 and 12.");
				continue; // skip the rest of the loop and ask for input again
			}
			switch (month) {
			// winter
			case 12:
			case 1:
			case 2:
			case 3 :
			season = "Winter";
			break;
			// spring
			case 4:
			case 5:
			case 6:
			season = "Spring";
			break;
			// summer
			case 7:
			case 8:
			case 9 :
			season = "Summer";
			break;
			// fall 
			case 10:
			case 11:
			season = "Fall";
			break;
			// will determine if the user puts in a number that is not between 1 and 12
			default:
			season = "Invalid month";
			break;
			}
			System.out.println(season);
		}

	}
}
		
