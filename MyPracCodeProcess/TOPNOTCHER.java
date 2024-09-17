package MyPracCodeProcess;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class TOPNOTCHER {
	public static void main(String[] args) {
		
		int player1 = Integer.parseInt(JOptionPane.showInputDialog("Enter player score"));
		int player2 = Integer.parseInt(JOptionPane.showInputDialog("Enter player score"));
		int player3 = Integer.parseInt(JOptionPane.showInputDialog("Enter player score"));
		
		int total = player1 + player2 + player3;
		
		int player4 = Integer.parseInt(JOptionPane.showInputDialog("Enter player 2 score"));
		int player5 = Integer.parseInt(JOptionPane.showInputDialog("Enter player 2 score"));
		int player6 = Integer.parseInt(JOptionPane.showInputDialog("Enter player 2 score"));
		
		int total1 = player4 + player5 + player6;
		
		String winner = "";
		
		if(total>total1) {
			winner = (" Congrats player 1 u win");
		} else {
			winner = (" Congrats player 2 u win");
		}
		
		String result =(" Player 1 totalscore "+total+
				"\n"+ " Player 2 total score" + total1+
				"\n"+ winner);
		JOptionPane.showMessageDialog(null, result,"CONGRATS NIGGA",JOptionPane.INFORMATION_MESSAGE);
	}
}
