package projects;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
public class TshirtModified {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String onlycolor = "Blue,Yellow,Red,Grey,Black,Orange";
		String onlysize = "Small,Medium,Large,XL,XXL";
		
		String buyagain;
		//empty
		do{
			  // Variables for each transaction
            String color = "";
            String size = "";
            double price = 0.0;
            double change = 0.0;
            double amount = 0.0;

            // Color input
            String[] colorsaccepted = {"Blue", "Yellow", "Red", "Grey","Orange","Black"};
            boolean validColor = false;

            while (!validColor) {
                System.out.println("Choose your color (Blue, Yellow, Red, Grey,Orange,Black):");
                color = scan.nextLine().trim();

                for (String allowed : colorsaccepted) {
                    if (allowed.equalsIgnoreCase(color)) {
                        color = allowed; // normalize to correct casing
                        validColor = true;
                        break;
                    }
                }

                if (!validColor) {
                    System.out.println("Invalid color. Please choose a valid color from the list.");
                }
            }

            // Input Size
            while (size.isEmpty() || !onlysize.toLowerCase().contains(size.toLowerCase())) {
                System.out.println("Choose your size (Small, Medium, Large, XL, XXL):");
                size = scan.nextLine();
                if (size.isEmpty() || !onlysize.toLowerCase().contains(size.toLowerCase())) {
                    System.out.println("Invalid size. Please try again.");
                }
            }

            // Input Price
            System.out.println("Enter the price of the t-shirt:");
            price = scan.nextDouble();

            // Validate Payment
            boolean validPayment = false;
            while (!validPayment) {
                System.out.println("Enter the amount paid:");
                amount = scan.nextDouble();
                scan.nextLine(); // consume newline

                if (amount >= price) {
                    validPayment = true;
                    change = amount - price;

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Color: " + color);
                    System.out.println("Size: " + size);
                    System.out.println("Price: " + price);
                    System.out.println("Amount Paid: " + amount);
                    System.out.println("Here is your change: " + change);
                    System.out.println("------------------------------------------------------------");
                } else {
                    System.out.println("Payment not accepted. The amount is less than the price.");
                }
            }

            // Buy again?
            System.out.println("Do you want to buy another t-shirt? (y/n)");
            buyagain = scan.nextLine();

        } while (buyagain.equalsIgnoreCase("y"));

        System.out.println("Thank you for shopping!");
        scan.close();
    }
}