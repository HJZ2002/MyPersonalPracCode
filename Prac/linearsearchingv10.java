package Prac;
import java.util.Random;
public class linearsearchingv10 {

	public static void main(String[] args) {
		int num[]= linearsearchingv10.addElements();
		
	}
	public static int[]addElements(){
		int num[] = new int[Integer.MAX_VALUE/5];
		Random random = new Random();
		int val = 0;
		for(int i =0; i<num.length; i++) {
			val=random.nextInt(Integer.MAX_VALUE-1)+1;
			System.out.println(val);
			num[i]=val;
		}
		return num;
	}
	public int removeOutliers() {
		int outliers =0;
		return outliers;
	}
}
