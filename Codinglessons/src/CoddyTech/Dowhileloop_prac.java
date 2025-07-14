package CoddyTech;

public class Dowhileloop_prac {

	public static void main(String[] args) {
		int number = 1;
		int sum = 0;
		
		//your code here
		
		do {
			sum += number; // will do plus 1
			System.out.println("Sum is: " + sum);
			number+= 2;
			System.out.println("Number is: " + number);
		} while (number <= 49);
		System.out.println("Final Sum is: " + sum);
	}

}
