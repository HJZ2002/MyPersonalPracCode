package Prac;
import java.util.Random;
public class linearsearchingv2 {

	public static void main(String[] args) {
		int num []= linearsearchingv2.addElements();
		int postive[]= removenegative(num);
		
		System.out.println("Postive values that we had ");
		for(int value: postive) {
		System.out.println(value);
		}
		System.out.println("Made by Hosea James Zacarias");
	}
	public static int[] addElements() {
		int num[] = new int [Integer.MAX_VALUE/5];	
		Random random = new Random();
		int value = 0;
		
		for(int i = 0; i<num.length;i++) {
			value = random.nextInt(num.length-1)+1;
			num[i] = value;
		}
		return num;
	}
	public static int MAX(int num[]) {
		int highest = 0;
		for (int i =0; i<num.length; i++) {
			if(num[i]>highest ) {
				highest = num[i];
			}
		}
		return highest;
	}
	public static int[] removenegative(int []num) {
		int count = 0;
		for(int value : num) {
			if(value>=0) {
				count++;
			}
		}
		int[]num2 = new int[count];
		int index =0;
		for(int value : num) {
			if(value >= 0) {
				num2[index++]=value;
			}
		}
		return num2;
	}
}