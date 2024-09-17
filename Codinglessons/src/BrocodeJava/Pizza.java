package BrocodeJava;

public class Pizza {
	
	String bread;
	String cheese;
	String Sauce;
	String toppings;
	
	
	Pizza(String bread, String cheese, String Sauce){
		this.bread = bread;
		this.cheese = cheese;
		this.Sauce = Sauce;
		
	}
	
	Pizza(String bread, String cheese, String Sauce, String Toppings){
		this.bread = bread;
		this.cheese = cheese;
		this.Sauce = Sauce;
		this.toppings = toppings;
	}
}
