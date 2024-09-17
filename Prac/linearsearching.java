package Prac;
import java.util.*;
public class linearsearching {

	public static void main(String[] args) {
		int num [] = linearsearching.addElements();
		int maxelement = MAX(num);
	}
	public static int []addElements(){
		int num []= new int [Integer.MAX_VALUE/5];
		Random random = new Random();
		int val = 0;
		for(int i = 0; i<num.length;i++) {
			val = random.nextInt(Integer.MAX_VALUE)-num.length;
			num[i]=val;
		}
		return num;
	}
	
	public static int MAX(int num[]) {
		long start = System.nanoTime();
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<num.length;i++) {
			if(num[i]>max) {
				max = num[i];
			}
		}
		long end = System.nanoTime();
		System.out.println("Processing Time\t:" + (end - start));
		System.out.println("The highest number is: "+max);
		System.out.println("Made by Hosea James Zacarias ");
		return max;
	}
}
