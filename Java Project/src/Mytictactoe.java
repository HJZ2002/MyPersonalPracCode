package Tictactoe;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Mytictactoe {
	  static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String playAgain = "y"; // default to 'y' to enter the loop

	        while (playAgain.equalsIgnoreCase("y")) {
	            // Reset positions for a new game
	            playerPosition.clear();
	            cpuPosition.clear();

	            char[][] gameBoard = {
	                {' ', '|', ' ', '|', ' '},
	                {'-', '+', '-', '+', '-'},
	                {' ', '|', ' ', '|', ' '},
	                {'-', '+', '-', '+', '-'},
	                {' ', '|', ' ', '|', ' '}
	            };

	            printGameboard(gameBoard);

	            while (true) {
	                // Player turn
	                System.out.println("Enter your place (1-9): ");
	                int Playerpos = scan.nextInt();

	                while (playerPosition.contains(Playerpos) || cpuPosition.contains(Playerpos)) {
	                    System.out.println("Position has been taken. Please choose another position.");
	                    Playerpos = scan.nextInt();
	                }

	                placePiece(gameBoard, Playerpos, "player");

	                String result = checkWinner();
	                if (result.length() > 0) {
	                    System.out.println(result);
	                    break;
	                }

	                // CPU's turn
	                Random rand = new Random();
	                int cpupos = rand.nextInt(9) + 1;
	                while (playerPosition.contains(cpupos) || cpuPosition.contains(cpupos)) {
	                    cpupos = rand.nextInt(9) + 1;
	                }

	                placePiece(gameBoard, cpupos, "cpu");

	                printGameboard(gameBoard);

	                result = checkWinner();
	                if (result.length() > 0) {
	                    System.out.println(result);
	                    break;
	                }
	            }

	            // Asking if want to play again
	            System.out.println("Do you want to play again? (y/n): ");
	            playAgain = scan.next();
	        }

	        System.out.println("Thanks for playing!");
	        scan.close();
	    }

	    public static void printGameboard(char[][] gameBoard) {
	        for (char[] row : gameBoard) {
	            for (char cell : row) {
	                System.out.print(cell);
	            }
	            System.out.println(); // Print a new line after each row
	        }
	    }

	    public static void placePiece(char[][] gameBoard, int pos, String user) {
	        char symbol = ' ';
	        if (user.equals("player")) {
	            symbol = 'X';
	            playerPosition.add(pos);
	        } else if (user.equals("cpu")) {
	            symbol = 'O';
	            cpuPosition.add(pos);
	        }

	        // Convert pos to the game board row and column
	        switch (pos) {
	            case 1:
	                gameBoard[0][0] = symbol;
	                break;
	            case 2:
	                gameBoard[0][2] = symbol;
	                break;
	            case 3:
	                gameBoard[0][4] = symbol;
	                break;
	            case 4:
	                gameBoard[2][0] = symbol;
	                break;
	            case 5:
	                gameBoard[2][2] = symbol;
	                break;
	            case 6:
	                gameBoard[2][4] = symbol;
	                break;
	            case 7:
	                gameBoard[4][0] = symbol;
	                break;
	            case 8:
	                gameBoard[4][2] = symbol;
	                break;
	            case 9:
	                gameBoard[4][4] = symbol;
	                break;
	            default:
	                break;
	        }
	    }

	    public static String checkWinner() {
	        List<Integer> topRow = Arrays.asList(1, 2, 3);
	        List<Integer> midRow = Arrays.asList(4, 5, 6);
	        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
	        List<Integer> leftCol = Arrays.asList(1, 4, 7);
	        List<Integer> midCol = Arrays.asList(2, 5, 8);
	        List<Integer> rightCol = Arrays.asList(3, 6, 9);
	        List<Integer> cross1 = Arrays.asList(1, 5, 9);
	        List<Integer> cross2 = Arrays.asList(7, 5, 3);

	        List<List<Integer>> winningConditions = new ArrayList<>();
	        winningConditions.add(topRow);
	        winningConditions.add(midRow);
	        winningConditions.add(bottomRow);
	        winningConditions.add(leftCol);
	        winningConditions.add(midCol);
	        winningConditions.add(rightCol);
	        winningConditions.add(cross1);
	        winningConditions.add(cross2);

	        for (List<Integer> condition : winningConditions) {
	            if (playerPosition.containsAll(condition)) {
	                return "Congratulations, you win!";
	            } else if (cpuPosition.containsAll(condition)) {
	                return "CPU wins! Sorry, try again.";
	            }
	        }

	        if (playerPosition.size() + cpuPosition.size() == 9) {
	            return "It's a tie!";
	        }

	        return "";
	    }
	}