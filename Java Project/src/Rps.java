package projects;
import java.util.Random;
import java.util.Scanner;
public class RPS {

	public static void main(String[] args) {
		// Rock, Paper, Scissors game
		Scanner scanner = new Scanner(System.in);
		int userMoveWins=0;
		int ComputerWins=0;
		while(true) {
			String[] rps = {"r","p","s"};
			String move = rps[new Random().nextInt(rps.length)];
			
			
			String userMove;
			// Loop until a valid move is entered
			while(true) {
				System.out.println("Take a guess is it r p or s?");
				 userMove = scanner.nextLine();
				if(userMove.equals("r") || userMove.equals("p") || userMove.equals("s")) {
					break;
				}
				System.out.println(userMove + " is not a valid move try again.");
				
			}
			System.out.println("Computer turn: " + move);
			
			if(userMove.equals(move)) {
				System.out.println("it is a tie!!!!!!");
			}
			else if (userMove.equals("r")) {
				if(move.equals("p")) {
					System.out.println("computer wins!");
					ComputerWins++;
				} else if (move.equals("s")) {
					System.out.println("You win!");
					userMoveWins++;
				}
			}
			else if (userMove.equals("p")) {
				if(move.equals("r")) {
					System.out.println("Computer Wins!");
					ComputerWins++;
				} else if (move.equals("s")) {
					System.out.println("You Win!");
					userMoveWins++;
				}
			}
			else if (userMove.equals("s")) {
				if(move.equals("p")) {
					System.out.println("You wins!");
					userMoveWins++;
				} else if (move.equals("r")) {
					System.out.println("computer wins");
					ComputerWins++;
				}
			}
			System.out.println("Score: player " + userMoveWins + ", Computer  " + ComputerWins);
			System.out.println("Wanna try again ? y/n");
			String playAgain = scanner.nextLine();
			
			if(playAgain.equals("n")) {
				System.out.println("Thanks for playing!");
				System.out.println("Final Score: player " + userMoveWins + ", Computer  " + ComputerWins);
				
			} else if (!playAgain.equals("y")) {
				System.out.println("Invalid input, exiting game.");
				userMoveWins = 0; // if the game is exited, reset scores
				ComputerWins = 0;
			}
		}
	}
}
