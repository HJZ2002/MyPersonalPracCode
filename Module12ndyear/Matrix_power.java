package Prac;

public class Matrix_power {
	//Made by Hosea James Zacarias
		//multiply the components
	public static int [][]multiplymatrix(int[][]a,int[][]b, int N){
		int[][]answer = new int[N][N];
		for(int i =0; i<N;i++) {
			for(int j =0; j<N;j++) {
				for(int x=0; x<N;x++) {
					answer[i][j]+=a[i][x]*b[x][j];
				}
			}
		}
		return answer;
	}
	//getting matrix
	public static int[][]matrixExpo(int[][]a,int b, int N){
		if(b==1) {
			return a;
		}
		if((b % 2)==0) {
			int[][]equalpower = matrixExpo(a,b/2,N);
			return multiplymatrix(equalpower,equalpower,N);
		}
		else {
			int[][]equalpower = matrixExpo(a,(b-1)/2,N);
			return multiplymatrix(multiplymatrix(equalpower,equalpower,N),a,N);
		}
	}
	public static void displayMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	//finalizing with display
	public static void main(String[]args) {
		int [][] matrix = {{1,2},{3,4}};
		int exp = 5;
		
		int[][]totalmatrix = matrixExpo(matrix, exp,matrix.length);
		System.out.println("Input your matrix");
		displayMatrix(totalmatrix);
		System.out.println("\nMatrix raised to the power of " + exp + ":");
	    displayMatrix(totalmatrix);
		}
  }
