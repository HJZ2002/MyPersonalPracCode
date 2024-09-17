package Prac;

public class Algo {

	public static void main(String[] args) {
		// largest elements
		
		int []arr ={4,8,10,20,30,12,56,79,15};
		//min to maximum
		int maxelements = sumofN(arr);
		System.out.println("Largest Maximum element of the array in linear :" +maxelements);
		System.out.println("Largest Maximum element of the array in Division :" +maxelements);
		System.out.println("Made by Hosea James Zacarias");
	}
	
	public static int linear(int[]arr) {
		int largestnum = arr[0];
		for(int i = 1; i<arr.length;i++) {
			if(arr[i]>largestnum) {
				
			}
		}
		return largestnum;
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
		public static int dvided(int[]arr,int left,int right) {
			if(left==right) {
				return arr[left];
			}
			int mid = left + (right - left)/2;
			int max = dvided(arr,left,mid);
			int max2 = dvided(arr,mid + 1,right);
			return Math.max(left,right);
		}
}
