package BrocodeJava;
import javax.swing.JOptionPane;
public class CalculatorUsingJoptionPane {
	public static void main(String[] args) {
		
		int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter Number 1"));
	
		int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Number 2"));
		
		
		String Operator = JOptionPane.showInputDialog("Choose The Operator + - * % /");
		// getting the results
		int results = 0;
		
		switch(Operator) {
		case"+":
			results = number1 + number2;
			break;
		case"-":
			results = number1 - number2;
			break;
		case"*":
			results = number1 * number2;
			break;
		case"%":
			results = number1 % number2;
			break;
		case"/":
			if(number2!=0) {
				results = number1/number2;
			} else {
				JOptionPane.showMessageDialog(null,"Sorry no zero must be remainder only");
			}
			default:
			JOptionPane.showMessageDialog(null,"Invalid Operator");
			break;
		} JOptionPane.showMessageDialog(null, results);
	}

}
