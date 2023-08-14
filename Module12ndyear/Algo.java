package Prac;

public class Algo {

	public static void main(String[] args) {
		// largest elements
		
		int []arr ={4,8,10,20,30,12};
		//min to maximum
		int maxelements = sumofN(arr);
		int minelements = sumofN2(arr);
		System.out.println("Maximum element of the array:" +maxelements);
		System.out.println("Minimum element of the array:" +minelements);
		System.out.println("Made by Hosea James Zacarias");
	}
		//method
		public static int sumofN(int[] arr) {
		int maxelements =arr[0];
		for(int num :arr) {
			if(num>maxelements) {
				maxelements = num;
			}
		}
		return maxelements;
	}
		public static int sumofN2(int[]arr) {
			int minelements =arr[0];
			for(int num2:arr) {
				if(num2<minelements) {
					minelements = num2;
				}
			}
			return minelements;
		}
}
