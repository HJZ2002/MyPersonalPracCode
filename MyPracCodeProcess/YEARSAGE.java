package MyPracCodeProcess;
import javax.swing.JOptionPane;
public class YEARSAGE {
	public static void main(String[] args) {
		
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
		
		if(age>60) {
			JOptionPane.showMessageDialog(null,"Your Later Maturity");
		} else if(age>=36 && age<=60) {
			JOptionPane.showMessageDialog(null,"Your MIDDLE AGE Maturity");
		}else if(age>=18 && age <=35) {
			JOptionPane.showMessageDialog(null,"Your EARLY ADULTHOOD Maturity");
		}else if(age>=13 && age<=17) {
			JOptionPane.showMessageDialog(null,"Your ADOLESCENSCE Maturity");
		}else if(age>=6 && age<=12) {
			JOptionPane.showMessageDialog(null,"Your MIDDLE CHILDHOOD Maturity");
		}else if(age<=5) {
			JOptionPane.showMessageDialog(null,"Your BIRTH Maturity");
	}
}
}