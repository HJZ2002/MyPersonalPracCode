package BrocodeJava;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class codinglessons {
	public static void main(String[] args) {
		
		//scanner
		
		//Scanner scan = new Scanner(System.in);
		
		//System.out.println(" What is your name nigga");
		//String name = scan.nextLine();
		//System.out.println(" Hello " +name);
		//System.out.println(" What is your color nigga");
		//String color = scan.nextLine();
		//System.out.println(" How black are you?");
		
		//String percent = scan.nextLine();
		
		//System.out.println(" Hello " + name);
		//System.out.println(" Your color is " + color);
		//System.out.println(" Ah i see you have " + percent + "\nBlack Certified nigga momment");
		
	 //if statements blocks the code
		//double friends = 2;
		//friends =(double) friends+1;
		//System.out.println(friends);
		
		//sample of logic operator
		
		// AND LOGIC
		//int temp = 25;
		
		//if(temp>30) {
			//System.out.println(" it is hot outside");
		//}
		//else if(temp>=20 && temp<=30) {
			//System.out.println(" it is warm outside");
		//} else {
			//System.out.println(" it is cold");
		//}
		
		// OR LOGIC
		//Scanner scan = new Scanner (System.in);
		//System.out.println("You are a nigger press q to change color or Q to leave");
		//String response = scan.next();
		
		//if(response.equals("q") || response.equals("Q")) {
			//System.out.println(" you change color congrats");
		//}
		//else {
			//System.out.println(" you leave ");
		//}
		
		// NOT LOGIC
		
		//Scanner scan = new Scanner (System.in);
		//System.out.println(" Hello press q if your a cuh and Q for a giga");
		//String response = scan.next();
		
		//if(!response.equals("q") && !response.equals("Q")) {
			//System.out.println(" Your certified cuh momment");
		//}
		//else {
			//System.out.println(" NIGRO ");
		//}
		
		//WHILE AND DO LOOP
		//Scanner scan = new Scanner(System.in);
		//String name ="";
		//do {
			//System.out.println(" Enter your name pls");
			//name = scan.nextLine();
		//} while(name.isEmpty());
		//System.out.println(" Hello nigro "+ name);
		
		
		//for loop
		//for(int i = 0; i<=100; i++) {
			//System.out.println(i+"HI");
		//}
		
		
		//nested loop
		//Scanner scan = new Scanner(System.in);
		//int rows;
		//int column;
		//String symbol = "";
		
		//System.out.println(" Enter number of rows");
		//rows = scan.nextInt();
		//System.out.println(" Enter number of columns");
		//column = scan.nextInt();
		//System.out.println(" Enter symbol to use ");
		//symbol = scan.next();
		
		//for (int i = 1; i<=rows; i++) {
			//System.out.println();
			//for (int j = 1; j<=column; j++) {
				//System.out.print(symbol);
			//}
		
		//Array stuff collecting data 
		//String[]cars = {"Camero","tesla","ford"};
		//cars[0]= "Mustang";
		
		//for(int i =0; i<cars.length;i++) {
			//System.out.println(cars[i]);
		//}
		
		//extra array shortcut
		//String []cars = new String[3];
		//cars[0]="BMW";
		//cars[1]="Ford";
		//cars[2]="Corvette";
		
		
		//for(int i =0; i<cars.length;i++) {
			//System.out.println(cars[i]);
		//}
		
		//2D array
		//String[][] cars = new String[3][3];
		
		//cars[0][0] = "Camero";
		//cars[0][1] = "BMW";
		//cars[0][2] = "Tesla";
		//cars[1][0] = "Ferrari";
		//cars[1][1] = "Mustang";
		//cars[1][2] = "F-150";
		//cars[2][0] = "Lambo";
		//cars[2][1] = "Bugatti";
		//cars[2][2] = "Honda";
		
		
		//for(int i =0; i<cars.length;i++) {
			//System.out.println();
			//for(int j = 0; j<cars[i].length; j++) {
				//System.out.print(cars[i][j]+ " ");
			//}
		//}
		
		//String methods 
		
		//String name = "Bro";
		//boolean result = name.equalsIgnoreCase("bro");
		//int result = name.length();
		//char result = name.charAt(0);
		//int result = name.indexOf("B");
		//boolean result = name.isEmpty();
		//String result = name.toUpperCase();
		//String result = name.toLowerCase();
		//String result = name.trim();
		//String result = name.replace("o", "a");
		
		//System.out.println(result);
		
		
		//Wrapper classes provides a data types as reference
		
		//Boolean a = true;
		//Character b = 'x';
		//Integer c = 123;
		//Double d = 3.14;
		//String e = "Hi";
		
		//if(a==true) {
			//System.out.println(" This is true");
		//} 
		
		//Arraylist a resizable array 
		//          Elements can be added and remove compilation 
		
		//ArrayList<String> food = new ArrayList<String>();
		
		//food.add("pizza");
		//food.add("egg");
		//food.add("hamburger");
		//food.add("spagheti");
		
		//food.set(0, "sushi");
		//food.remove(2);
		//food.clear();
		
		//for(int i = 0; i<food.size();i++) {
			//System.out.println(food.get(i));
			
			//}
		
		//2D Array list = a dynamic list of list of size during runtime 
			
			//ArrayList<ArrayList<String>> grocerylist = new ArrayList();
			
			//ArrayList<String> bakerylist = new ArrayList<String>();
			//bakerylist.add("Spag");
			//bakerylist.add("donuts");
			//bakerylist.add("bread");
			
			//ArrayList<String> produce = new ArrayList<String>();
			//produce.add("tomato");
			//produce.add("pasta");
			//produce.add("juice");
			
			//grocerylist.add(bakerylist);
			//grocerylist.add(produce);
			
			//System.out.println(grocerylist.get(1).get(1));
			//System.out.println(grocerylist.get(0).get(1));
		
		//for each loop == less steps and more readable
		//				   less flexible 
		
		
		//String[] animals = {"cat","dog","bird"};
		//ArrayList<String> animals = new ArrayList<String>();
		
		//animals.add("cat");
		
		//animals.add("dog");
		
		//animals.add("bird");
		
		//animals.add("rat");
		//for (String i : animals) {
			//System.out.println(i);
			//} 
	
	//methods == blocks of that is executed whenever it is called upon
	//public static void main(String[]args) {
		//String name = ("Bro");
		//int age = 21;
		//hello1(name,age);
		
		//xample 2
		//int x = 3;
		//int y = 4;
		//int z = add(x,y);
		//System.out.println(z);
	//}
	//static void hello1(String name,int age) {
		//System.out.println("Hello " + name);
		//System.out.println(" You are " + age);
	//}
	
	//static int add(int x , int y) {
		//int z = x+y;
		//return z;
		
	//}
		
	//overload methods :) = methods that share same name but have different parameters
		//double x = add (1.0,2.0,3.0,4.0);
		//int y = add (1,2,3,4,5);
		//System.out.println(x);
		//System.out.println(y);
	//}
		//static int add(int a , int b) {
			//System.out.println(" Overload method 1 ");
			//return a + b;
		//}
		//static int add(int a , int b,int c,int d) {
			//System.out.println(" Overload method 2 ");
			//return a + b +c + d;
		//}
		//static int add(int a , int b, int c) {
			//System.out.println(" Overload method 3 ");
			//return a + b + c;
		//}
		//static int add(int a , int b,int c,int d,int e) {
			//System.out.println(" Overload method 4 ");
			//return a + b +c + d + e;
		//}
		//static double add(double a , double b,double c,double d) {
			//System.out.println(" Overload method 5 ");
			//return a + b +c + d;
		//}
		//static double add(double a , double b, double c) {
			//System.out.println(" Overload method 6 ");
			//return a + b + c;
		//}
		//static double add(double a , double b,double c,double d,double e) {
			//System.out.println(" Overload method 7 ");
			//return a + b +c + d + e;
		
		//printf method an optional method to control format and display text to the console window
		// two arguments format can be object/variables/value
		
		//boolean test = true;
		//char mychar = '@';
		//String mystring = "NI";
		//int myint = 50;
		//double mydouble = 1000;
		
		//System.out.printf("%b",test);
		//System.out.printf("%c",mychar);
		//System.out.printf("%s",mystring);
		//System.out.printf("%d",myint);
		//System.out.printf("%f",mydouble);
		
		//[width]
		//minimum number of characters in the written output
		//System.out.printf("Hello  %-10s",mystring);
		
		//[precisions]
		//sets the numbers of digits of precision when outputting floating-point values
		//System.out.printf(" here is your money %.2f",mydouble);
		
		//[flags]
		// adds an effect to the output based on the flag added to format specifier
		// - left-justify
		// + output a plus (+) or minus (-) for a numeric value
		// 0 numeric values are zero padded 
		// , comma grouping separator if number>1000
		//System.out.printf(" here is your money %.2f",mydouble);
		
		//final meaning anything that has been place under the variable for example name or bla bla bla cannot be change
		// due to final data type
		//final double pi =3.1459;
		
		//System.out.println(pi);
		
		
		
		//Object oriented programming // attributes that has characteristics and methods
		// example (phone desktop coffee computer table)
		
		//lesson for the oop
		
		//String make = "Chervolet";
		//String model = "Corvette";
		//int year = 2020;
		//String color = "blue";
		//double price = 500000.00;
		
		//void drive() {
			//System.out.println("U drive the car:");
		//}
		//void brake() {
			//System.out.println("U step the brake:");
		//}
	//}
			//car mycar = new car();
			
			//System.out.println(mycar.color);
			//System.out.println(mycar.make);
			
			//mycar.drive();
			//mycar.brake();
		
		//constructors special method that is called when an object is instantiated
		
		//Human human = new Human("Kashi",18,40,"White","Stylish");
		//human.eat();
		//human.age();
		//human.describe();		
		
		//local = declared inside of a method
		//      = visable only to a method
		
		//global = declared outside of a method but within a class
		// 		= visable to all parts of a class
		
		// overloaded constructors multiple constructors inside the class as long as its same name as long as its different name parameters and signatures
		Pizza pizza = new Pizza("Thiccc crust","tomato","mozorella","");
		System.out.println("Here is the list of ingridients for the pizza");
		System.out.println(pizza.bread);
		System.out.println(pizza.Sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.toppings);
		}
		
	}
