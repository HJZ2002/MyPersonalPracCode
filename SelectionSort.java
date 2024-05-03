package Courseratest;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class SelectionSort {

	public static void main(String[] args) {
		//Made by Hosea James Zacarias
		int array[] = {16,30,-24,7,62,45,5,-55}; //input array
		int hold = 0;
		String msg = "Array at the beginning: " + arrayToString(array) + "\n"; 
		

		int lowest = 0, i = 0, j = 0;
		for(i = 0; i < array.length; i++) {	
			lowest = i;
			for(j = (i+1); j < array.length; j++) {
				if(array[lowest] < array[j]) {
					lowest = j;
				}
			}
			
			hold = array[lowest];
			array[lowest] = array[i];
			array[i] = hold;
			
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
		StringBuilder sb = new StringBuilder();
		for(int val:array) {
			sb.append(val).append(" ");
		}
		return sb.toString().trim();
	}

}
//end
