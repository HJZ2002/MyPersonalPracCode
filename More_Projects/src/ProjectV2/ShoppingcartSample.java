package ProjectV2;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingcartSample {

    // Quantity discount rules:
    // 2 -> 5%, 3-4 -> 10%, 5-9 -> 15%, 10+ -> 20%
    private static double quantityDiscountRate(int qty) {
        if (qty >= 10) return 0.20;
        if (qty >= 5)  return 0.15;
        if (qty >= 3)  return 0.10;
        if (qty == 2)  return 0.05;
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Localize currency (PH as example)
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
        DecimalFormat pct = new DecimalFormat("0.#%");

        // Expanded catalog (add/remove freely)
        String[] items = {
            "Apple", "Banana", "Orange", "Grapes", "Mango",
            "Pineapple", "Watermelon", "Strawberry", "Blueberry", "Cherry",
            "Papaya", "Pear", "Kiwi", "Peach", "Avocado"
        };
        double[] prices = {
            0.99, 0.59, 0.79, 2.99, 1.49,
            3.49, 4.99, 2.59, 3.79, 2.19,
            1.99, 1.29, 2.49, 2.29, 2.99
        };

        double cartSubtotalAfterLineDiscounts = 0.0;
        double totalLineSavings = 0.0;

        System.out.println("Welcome to the Shopping Cart Program!");
        System.out.println("Here is a list of items you can purchase:\n");
        System.out.println("Code\tItem\t\tPrice");
        for (int i = 0; i < items.length; i++) {
            String name = items[i];
            // simple padding for nicer display
            String padded = name.length() < 8 ? name + "\t\t" : name + "\t";
            System.out.println((i + 1) + ".\t" + padded + currency.format(prices[i]));
        }
        System.out.println();

        String choice = null;
        do {
            System.out.print("Enter the item code you want to purchase (or '0' to finish): ");
            int itemNumber = safeNextInt(sc);

            if (itemNumber == 0) {
                break;
            } else if (itemNumber < 1 || itemNumber > items.length) {
                System.out.println("Invalid item code. Please try again.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = safeNextInt(sc);
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please try again.");
                continue;
            }

            String itemName = items[itemNumber - 1];
            double unitPrice = prices[itemNumber - 1];

            // price scales with quantity
            double lineSubtotal = unitPrice * quantity;

            // apply quantity tier discount
            double lineDiscRate = quantityDiscountRate(quantity);
            double lineDiscount = lineSubtotal * lineDiscRate;
            double lineTotal = lineSubtotal - lineDiscount;

            cartSubtotalAfterLineDiscounts += lineTotal;
            totalLineSavings += lineDiscount;

            System.out.println(
                "Added: " + quantity + " x " + itemName +
                " @ " + currency.format(unitPrice) +
                " = " + currency.format(lineSubtotal) +
                (lineDiscRate > 0
                    ? "  | Qty Discount " + pct.format(lineDiscRate) + ": -" + currency.format(lineDiscount)
                    : "") +
                "  -> Line Total: " + currency.format(lineTotal)
            );

            System.out.print("Do you want to add more items? (yes/no): ");
            choice = sc.next().trim();

        } while (choice.equalsIgnoreCase("yes"));

        // Optional storewide sale (e.g., 15 means 15% off the discounted cart)
        System.out.print("Apply storewide sale? Enter percent (e.g., 15 for 15, or 0 for none): ");
        double salePercent = safeNextDouble(sc);
        if (salePercent < 0) salePercent = 0;
        if (salePercent > 100) salePercent = 100;
        double saleRate = salePercent / 100.0;

        double saleDiscount = cartSubtotalAfterLineDiscounts * saleRate;
        double grandTotal = cartSubtotalAfterLineDiscounts - saleDiscount;

        // Receipt
        System.out.println("\n==================== RECEIPT ====================");
        System.out.println("Subtotal (after qty discounts): " + currency.format(cartSubtotalAfterLineDiscounts));
        System.out.println("Savings from quantity discounts: -" + currency.format(totalLineSavings));
        if (saleRate > 0) {
            System.out.println("Storewide sale " + pct.format(saleRate) + ": -" + currency.format(saleDiscount));
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Grand Total: " + currency.format(grandTotal));
        System.out.println("================================================");
        System.out.println("Thank you for shopping with us!");

        sc.close();
    }

    // Safe integer input (handles non-integers gracefully)
    private static int safeNextInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // Safe double input
    private static double safeNextDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
