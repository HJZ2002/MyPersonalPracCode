package MyPracCodeProcess;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class TwoNumbers {
	public static void main(String[] args) {
		//variables
		Scanner sc = new Scanner (System.in);
		System.out.println(" Enter the first number");
		int num1 = sc.nextInt();
		System.out.println(" Enter the secound number");
		int num2 = sc.nextInt();
		
		//methods
		int addition,subtraction,product;
		double quotient;
		
		addition = num1+num2;
		subtraction = num1-num2;
		product = num1*num2;
		quotient=(double)num1/num2;
		
		String result = num1+ "+"+num2+"="+addition+
				"\n" + num1 + "-" + num2+ "=" + subtraction +
				"\n" + num1 + "*" + num2 + "=" + product + 
				"\n" + num1 + "/" + num2 + "=" + quotient;
		
		System.out.println(" Here is the answer:" + result);
	}
}
