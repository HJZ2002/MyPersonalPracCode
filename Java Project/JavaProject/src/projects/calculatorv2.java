package projects;
import javax.swing.JOptionPane;
public class calculatorv2 {
	public static void main(String[] args) {
		
		int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first number"));
		
		int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second number"));
		
		String operation = JOptionPane.showInputDialog("Enter the operation (+, -, *, /)");
		
		int result = 0;
		
		switch(operation) {
		    case "+":
		    	result = number1 + number2;
                break;
            case "-":
            	result = number1 - number2;
                break;
            case "*":
            	result = number1 * number2;
                break;
            case "/":
            	if(number2 != 0) {
                    result = number1 / number2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                    System.exit(0);
                }
                break;
            default:
            	JOptionPane.showMessageDialog(null, "Invalid operation. Please enter +, -, *, or /");
                break;
        } JOptionPane.showMessageDialog(null, "Result: " + result);
		}
	}

