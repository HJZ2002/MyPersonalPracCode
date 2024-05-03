package Prac;

public class Bignotation {

	public static void main(String[] args) {
		
	}
	public int printf(int data[]) {
		return data[0];
	}
	public int test2(int data[],int index) {
		return data[index];
	}
	public String printall(int data[]) {
		String hold = "";
		
		for(int value: data) {
			hold+= value + " ";
		}
		return hold;
	}
	public String printstaticofn(int n) {
		int prod =1;
		String hold = "";
		
		for(int a = 1; a<=n; a++) {
			prod = a*a;
			hold+= a+ "^2"+ "="+prod+"\n";
			//end
		}
		return hold;
	}
	public int sumofcube(int n) {
		int sum = 0;
		for(int a =1; a<=n; a*=3) {
			sum+=a;
		}
		return sum;
	}
}
