package MyPracCodeProcess;
import javax.swing.JOptionPane;
public class TwoNumbersUsingJOptionPane {

	public static void main(String[] args) {
		//number 1
		int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter First number"));
		// number 2
		
		int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Second number"));
		
		//methods
		int sum,difference,product;
		
		double quotient;
		
		sum = number1 + number2;
		difference = number1 - number2;
		product = number1 * number2;
		
		quotient = (double) number1/number2;
		
		String result = (number1 +"+" +number2 +"="+sum+
				"\n" + number1 + "-" + number2 + "=" + difference+
				"\n" + number1 + "*" + number2 + "=" + product+ 
				"\n" + number1 + "/" + number2 + "=" + quotient);
		JOptionPane.showMessageDialog(null, result);
	}

}
