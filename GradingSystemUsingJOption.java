package BrocodeJava;
import javax.swing.JOptionPane;
public class GradingSystemUsingJOption {

	public static void main(String[] args) {
		
		double math = Double.parseDouble(JOptionPane.showInputDialog("Enter Math Score"));
		double PE = Double.parseDouble(JOptionPane.showInputDialog("Enter PE Score"));
		double Science = Double.parseDouble(JOptionPane.showInputDialog("Enter Science Score"));
		double Filipino = Double.parseDouble(JOptionPane.showInputDialog("Enter Filipino Score"));
		double Computer = Double.parseDouble(JOptionPane.showInputDialog("Enter Computer Score"));
		double Art = Double.parseDouble(JOptionPane.showInputDialog("Enter Art Score"));
		
		//getting the grade
		double grade =(math + PE + Science + Filipino + Computer + Art)/6.0;
		
		JOptionPane.showMessageDialog(null,"Your grade is "+ grade);
		// getting the results
			if(grade>=100) {
				JOptionPane.showMessageDialog(null,"Excellent");
			} else if (grade>=95) {
				JOptionPane.showMessageDialog(null,"Super Satisfactory");
			}  else if (grade>=90) {
				JOptionPane.showMessageDialog(null,"Over Satisfactory");
			}  else if (grade>=87) {
				JOptionPane.showMessageDialog(null,"Satisfactory");
			} else if (grade>=75) {
				JOptionPane.showMessageDialog(null, "Passed");
			} else {
				JOptionPane.showMessageDialog(null, "FAILED");
			}
		}
}

