package CoddyTech;
import java.util.Scanner;
public class loops_prac {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number that needs to be filled below ");
		
		double number = scan.nextDouble();
		
		while(number >= 3.5) {
			number = number/2;
		}
		System.out.println("" + number);
		scan.close();
	}

}
