package MyPracCodeProcess;
import java.util.Scanner;
public class test_class {

	public static void main(String[] args) {
		String [][] randomstuff = new String[3][3];
		randomstuff[0][0]= "Ford";
		randomstuff[0][1]= "BMW";
		randomstuff[0][2]= "Nigro";
		randomstuff[1][0]= "Black car";
		randomstuff[1][1]= "Tesla";
		randomstuff[1][2]= "300 Black man";
		randomstuff[2][0]= "For only 2 pounds";
		randomstuff[2][1]= "Yes sir";
		randomstuff[2][2]= "Black women";
		
		for(int i =0 ; i<randomstuff.length;i++) {
			System.out.println();
			for(int j =0; j<randomstuff[i].length;j++) {
				System.out.println(randomstuff[i][j]+ " ");
			}
		}
	}

}
