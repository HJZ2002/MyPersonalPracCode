package MyPracCodeProcess;
import java.util.Random;
import javax.swing.JOptionPane;
public class RandomWInner {

	public static void main(String[] args) {
		String winner[]= {
				"Cellphone with projector",
	            "Washing Machine with ironing",
	            "House and Lot with lot and house",
	            "Trip to Afghanistan for 2",
	            "Summer Vacation at Sahara desert",
	            "LED TV without TV",
	            "Ferrari with dining room",
	            "1 year supply of baygon katol",
	            "1-day long boxing practice with Bradley and Pacquiao",
	            "A kiss from Mommy Dionisia",
	            "Lifetime Driver of Delima",
	            "Unlimited family vacation package to Syria"
	        };
		Random random = new Random();
		String message = "";
		for(int people=1; people<=3; people++) {
			message += " Person " +people+ " wins :\n";
			for (int gift = 1; gift<=4; gift++) {
				int randomx = random.nextInt(winner.length);
				 String randomPrize = winner[randomx];
	                message += "- " + randomPrize + "\n";
	            }
	            message += "\n";
			}
		  JOptionPane.showMessageDialog(null, message," created by Hosea James Zacarias",JOptionPane.INFORMATION_MESSAGE);
		}
}

