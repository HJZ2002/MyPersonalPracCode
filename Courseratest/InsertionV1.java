package Courseratest;
import javax.swing.JOptionPane;

public class InsertionV1 {

	public static void main(String[] args) {
		//Made by Hosea James Zacarias
		int array[] = {12,5 ,50,15,20,10,2};
		int hold =0;
		String msg = "Array at the beginning: " + arrayToString(array) + "\n";; 
		
		int i = 0, j = 0, key;
		
		for(i = 1; i < array.length; i++) {
			key=array[i];
			for(j = (i-1); (j >=0 && array[j] > key); j--) {
				array[j+1] = array[j];
			}
			
			array[j+1] = key;
			msg += "After Pass #" + (i + 1) + ": " + arrayToString(array);
			
			 if (i < array.length - 1) {
	                msg += "\n";
	            } else {
	                msg += " (done): " + arrayToString(array);
	            }
	            msg += "\n";
			}
			
			JOptionPane.showMessageDialog(null, msg);

		}

	private static String arrayToString(int[] array) {
		StringBuilder builder = new StringBuilder();
		for (int val : array) {
            builder.append(val).append(" ");
        }
        return builder.toString().trim();
	}
		
}

