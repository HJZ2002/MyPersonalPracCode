package CoddyTech;

public class Formatting_output {

	public static void main(String[] args) {
        // Item information
        String item1 = "T-shirt";
        String item2 = "Jeans";
        String item3 = "Hat";
        double price1 = 19.99;
        double price2 = 45.50;
        double price3 = 12.00;

        // Calculate totals
        double subtotal = price1 + price2 + price3;
        double tax = subtotal * 0.08;
        double total = subtotal + tax;

        // Print formatted receipt
        System.out.println("STORE RECEIPT");
        System.out.println("-------------");
        System.out.println("Item            Price");
        System.out.printf("%-15s $ %5.2f\n", item1, price1);
        System.out.printf("%-15s $ %5.2f\n", item2, price2);
        System.out.printf("%-15s $ %5.2f\n", item3, price3);
        System.out.println("-------------");
        System.out.printf("%-15s $ %6.2f\n", "Subtotal:", subtotal);
        System.out.printf("%-15s $ %6.2f\n", "Tax (8%):", tax);
        System.out.printf("%-15s $ %6.2f\n", "Total:", total);
    }
}
