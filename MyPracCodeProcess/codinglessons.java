package MyPracCodeProcess;
import java.util.Scanner;
import java.util.Random;
public class codinglessons {
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
			
			//System.out.println(grocerylist.get(0).get(2));
		
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
	//}
	//static void hello1(String name,int age) {
		//System.out.println("Hello " + name);
		//System.out.println(" You are " + age);
	//}
	
	//static int add(int x , int y) {
		//int z = x+y;
		//return z;
		
	//}
}
