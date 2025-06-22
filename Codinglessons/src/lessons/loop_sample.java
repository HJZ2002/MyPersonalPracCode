package projects;
import javax.swing.JOptionPane;

public class loop_sample {
	public static void main(String[] args) {
		int n =5; // height of the diamond
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" "); // first empty for the diamond
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*"); //first part of the diamond
			}
			System.out.println(); // new line after each row
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" "); // second empty for the diamond
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*"); // second part of the diamond
			}
			System.out.println(); // new line after each row
		}
    }
}