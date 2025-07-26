package CoddyTech;
import java.util.Scanner;
public class Declare_Methods {

	public static void sumNumbers() {
		int sum = 0;
		for(int i = 1; i<= 1000; i++) {
			sum += i;
		}
		System.out.println("" + sum);
		
	}
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++) {
			sumNumbers();
		}
		scan.close();
	}

}
