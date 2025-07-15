package CoddyTech;

public class Balance {

	public static void main(String[] args) {
			double balance = 1000.00;
	        double yearlyDeposit = 500.00;
	        double interestRate = 0.05;
	        double targetAmount = 5000.00;
	        int years = 0;
	        
	        // Write your while loop here
	        while(balance < targetAmount){
	            years++;
	            balance += yearlyDeposit;
	            balance += balance *interestRate;
	            System.out.printf("Year %d: $%.2f%n", years, balance);
	        }
	        
	        // Don't modify the code below
	        System.out.println("------------------------");
	        System.out.println("Goal reached in " + years + " years!");
	        System.out.printf("Final balance: $%.2f", balance);
	    }
	}