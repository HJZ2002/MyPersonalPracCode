package MyPracCodeProcess;
import java.util.Scanner;
import java.util.Random;
public class truthordare {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		String[]truth = {"Have u been ever fall in love with someone:","did u ever cheat on exam:","what is your lowest grade:",
				"How many ex u have its ok if u don't wanna know but count it:","Are u gay:","Is marky gay"};
		String[]dare = {"I dare u too say i wanna match with someone:","I dare u too make 9/11 jokes:",""
				+ "I dare u to @everyone in discord:","Make joke about african children:"};
		
		System.out.println("Welcome user kindly pick the options if truth or dare:");
		
			while(true) {
				// letting the user pick the choices
				System.out.println("Choose truth or dare");
				String choice = scan.nextLine().toLowerCase();
				
				if(choice.equals("exit")) {
					System.out.println("Tnx for playing good bye");
					break;
				} else if(choice.equals("truth")) {
					int randomIndex = ran.nextInt(truth.length);
					System.out.println("truth: "+ truth[randomIndex]);
				} else if (choice.equals("dare")) {
					int randomIndex = ran.nextInt(dare.length);
					System.out.println("dare: " + dare[randomIndex]);
				} else {
					System.out.println("Invalid options");
				}
				
			}
		}
	}
