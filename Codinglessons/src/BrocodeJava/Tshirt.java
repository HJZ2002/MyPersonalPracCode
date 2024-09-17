package BrocodeJava;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Tshirt {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String onlycolor = "Blue,Yellow,Red,Grey";
		String onlysize = "Small,Medium,Large,XL,XXL";
		
		//empty
		String color = "";
		String size = "";
		double price = 0.0;
		double change = 0.0;
		double amount = 0.0;
		while(color.isEmpty()|| !onlycolor.contains(color)) {
			System.out.println(" Choose your color");
			color = scan.nextLine();
			if(color.isEmpty()|| !onlycolor.contains(color)) {
				System.out.println(" Invalid color please choose again");
			}
		}
		while(size.isEmpty()|| !onlysize.contains(size)) {
			System.out.println(" Choose your size");
			size = scan.nextLine();
			if(size.isEmpty()||!onlysize.contains(size)) {
				System.out.println(" Invalid size please try again");
			} 
		}

		System.out.println(" Enter the price of the t-shirt");
		price = scan.nextDouble();
		System.out.println(" ------------------------------------------------------------");
		System.out.println(" Color " + color );
		System.out.println(" size " +  size );
		System.out.println(" price " + price );
		
		System.out.println(" Enter the amount on how much it pay ");
		amount = scan.nextDouble();
		change = amount - price ;
		System.out.println(" Here is your change " + change );
		scan.close();
	}
}
