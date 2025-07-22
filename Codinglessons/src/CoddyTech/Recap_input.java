package CoddyTech;
import java.util.Scanner;
public class Recap_input {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int number = scan.nextInt();
		int sum = 0;
		
		for(int i = 0; i < number; i ++) {
			int count = scan.nextInt();
			sum += count;
		}
		System.out.println("The sum of the numbers is: " + sum); 
	}

}
