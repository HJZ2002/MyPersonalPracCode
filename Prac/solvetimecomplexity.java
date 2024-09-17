package Prac;

import java.util.Iterator;

public class solvetimecomplexity {
	
	public static void main(String[] args) {
		int data[]= {5,6,7,3,10};
		
		System.out.println("Largest element is "+ max(data));
	}
	public static int max(int data[]) {
		long start = System.nanoTime();
		
		int highest =data[0];
		for(int i = 1; i<data.length;i++) {
			if(highest<data[i]) {
				highest = data[i];
				
			}
		}
		return highest;
	}
	
}