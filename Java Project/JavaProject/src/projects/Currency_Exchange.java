package projects;
import java.util.Scanner;
public class Currency_Exchange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			//menu
			System.out.println("Welcome to the Currency Exchange Program!");
			System.out.println("" +
					"Please select the currency you want to exchange:\n" +
					"1. USD to Euro\n" +
					"2. Euro to USD\n" +
					"3. Pounds to USD\n" +
					"4. Exit");
					
			
			int exchangeAmount = sc.nextInt();
			switch(exchangeAmount) {
			case 1:
				System.out.println("Enter the number of USD");
				
				double usd = sc.nextDouble();
				if(usd >=0) {
					System.out.println(usd + "USD is equal to " + (usd * 0.908)+ "€. ");
				} else {
					System.out.println("Invalid amount. Please enter numbers that is USD.");
				}
				break;
			case 2:
				System.out.println("Enter the number of Euros");
				
				double euros = sc.nextDouble();
				if(euros >=0) {
					System.out.println(euros + "€ is " + (euros * 1.101)+ "USD. ");
				} else {
					System.out.println("Invalid amount. Please enter a numbers that is €");
				}
				break;
			case 3:
				System.out.println("Enter the number of pounds");
				
				double pounds = sc.nextDouble();
				if(pounds >=0) {
					System.out.println(pounds + "£ is " + (pounds * 1.28)+ "USD. ");
				} else {
					System.out.println("Invalid amount. Please enter numbers that is pounds.");
				}
				break;
			case 4:
				System.out.println("Thank you for using the Currency Exchange Program. Goodbye!");
				System.exit(0);
				break;
				default:
					System.out.println("Invalid choice. Please select a valid currency option.");
			}
		}
	}
}
		