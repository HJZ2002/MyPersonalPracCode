
package projects;
import javax.swing.JOptionPane;

public class TshirtModifiedusingJoption {

    public static void main(String[] args) {
        String[] colorsaccepted = {"Blue", "Yellow", "Red", "Grey", "Orange", "Black"};
        String[] sizesaccepted = {"Small", "Medium", "Large", "XL", "XXL"};
        String buyagain;

        JOptionPane.showMessageDialog(null, "Welcome to HJZ-Store!");

        do {
            String color = "";
            String size = "";
            double price = 0.0;
            double change = 0.0;
            double amount = 0.0;

            // Color selection with buttons
            int colorChoice = JOptionPane.showOptionDialog(
                null,
                "Choose your color:",
                "Color Selection",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                colorsaccepted,
                colorsaccepted[0]
            );
            if (colorChoice == JOptionPane.CLOSED_OPTION) return;
            color = colorsaccepted[colorChoice];

            // Size selection with buttons
            int sizeChoice = JOptionPane.showOptionDialog(
                null,
                "Choose your size:",
                "Size Selection",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                sizesaccepted,
                sizesaccepted[0]
            );
            if (sizeChoice == JOptionPane.CLOSED_OPTION) return;
            size = sizesaccepted[sizeChoice];

            // Price input
            boolean validPrice = false;
            while (!validPrice) {
                String priceInput = JOptionPane.showInputDialog(null, "Enter the price of the t-shirt:");
                if (priceInput == null) return;
                try {
                    price = Double.parseDouble(priceInput);
                    validPrice = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid price. Please enter a number.");
                }
            }

            // Payment input
            boolean validPayment = false;
            while (!validPayment) {
                String amountInput = JOptionPane.showInputDialog(null, "Enter the amount paid:");
                if (amountInput == null) return;
                try {
                    amount = Double.parseDouble(amountInput);
                    if (amount >= price) {
                        validPayment = true;
                        change = amount - price;
                        JOptionPane.showMessageDialog(null,
                                "------------------------------------------------------------\n" +
                                "Color: " + color + "\n" +
                                "Size: " + size + "\n" +
                                "Price: " + price + "\n" +
                                "Amount Paid: " + amount + "\n" +
                                "Here is your change: " + change + "\n" +
                                "------------------------------------------------------------");
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment not accepted. The amount is less than the price.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a number.");
                }
            }

            // Buy again?
            buyagain = JOptionPane.showInputDialog(null, "Do you want to buy another t-shirt? (y/n)");
            if (buyagain == null) return;

        } while (buyagain.equalsIgnoreCase("y"));

        JOptionPane.showMessageDialog(null, "Thank you for shopping!");
    }
}
