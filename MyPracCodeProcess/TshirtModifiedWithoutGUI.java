package ProjectV2;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TshirtModifiedWithoutGUI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String onlycolor = "Blue,Yellow,Red,Grey,Black,Orange,Violet,YellowGreen";
        String onlysize = "Small,Medium,Large,XL,XXL";
        String buyagain;

        do {
            String color = "";
            String size = "";
            double price = 0.0;
            double change = 0.0;
            double amount = 0.0;

            String[] colorsaccepted = {"Blue", "Yellow", "Red", "Grey", "Orange", "Black", "Violet", "YellowGreen"};
            boolean validColor = false;

            while (!validColor) {
                System.out.println("Choose your color (Blue, Yellow, Red, Grey, Orange, Black, Violet, YellowGreen):");
                color = scan.nextLine().trim();
                for (String allowed : colorsaccepted) {
                    if (allowed.equalsIgnoreCase(color)) {
                        color = allowed;
                        validColor = true;
                        break;
                    }
                }
                if (!validColor) {
                    System.out.println("Invalid color. Please choose a valid color from the list.");
                }
            }

            while (size.isEmpty() || !onlysize.toLowerCase().contains(size.toLowerCase())) {
                System.out.println("Choose your size (Small, Medium, Large, XL, XXL):");
                size = scan.nextLine();
                if (size.isEmpty() || !onlysize.toLowerCase().contains(size.toLowerCase())) {
                    System.out.println("Invalid size. Please try again.");
                }
            }

            System.out.println("Enter the price of the t-shirt:");
            price = scan.nextDouble();

            boolean validPayment = false;
            while (!validPayment) {
                System.out.println("Enter the amount paid:");
                amount = scan.nextDouble();
                scan.nextLine(); // consume newline

                if (amount >= price) {
                    validPayment = true;
                    change = amount - price;

                    
                    // Generate receipt with realtime date and time
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    try (FileWriter writer = new FileWriter("Receipt.txt", true)) { 
                        writer.write("=== T-SHIRT RECEIPT ===\n");
                        writer.write("Date & Time: " + dtf.format(now) + "\n");
                        writer.write("Color      : " + color + "\n");
                        writer.write("Size       : " + size + "\n");
                        writer.write("Price      : " + price + "\n");
                        writer.write("Amount Paid: " + amount + "\n");
                        writer.write("Change     : " + change + "\n");
                        writer.write("-------------------------------\n");
                    } catch (IOException e) {
                        System.out.println("Error writing to Receipt.txt: " + e.getMessage());
                    }

                } else {
                    System.out.println("Payment not accepted. The amount is less than the price.");
                }
            }

            System.out.println("Do you want to buy another t-shirt? (y/n)");
            buyagain = scan.nextLine();

        } while (buyagain.equalsIgnoreCase("y"));

        System.out.println("Thank you for shopping!");
        scan.close();
    }
}
