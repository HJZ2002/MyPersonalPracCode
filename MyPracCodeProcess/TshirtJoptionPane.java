package MyPracCodeProcess;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class TshirtJoptionPane {

	public static void main(String[] args) {
		String onlycolor = "Blue ,Yellow ,Red, BLack";
		String onlysize = "ExtraSmall,Small,Medium,Large,XL";
		
		String color = "";
		String size = "";
		
		while(color.isEmpty()||!onlycolor.contains(color)) {
			color=JOptionPane.showInputDialog("Enter your color brader");
			if(color.isEmpty()||!onlycolor.contains(color)) {
				JOptionPane.showMessageDialog(null,"Color Not available brader");
			}
		}
		while(size.isEmpty()||!onlysize.contains(size)) {
			size=JOptionPane.showInputDialog(" Enter the size brader");
			if(size.isEmpty()||!onlysize.contains(size)) {
				JOptionPane.showMessageDialog(null, " Size Not Availabled Brader");
			}
		}
		String option = " Here is your color u have pick "
				+ color + "\n Here is the size you have pick " + size;
		JOptionPane.showMessageDialog(null, option);
	}
}
