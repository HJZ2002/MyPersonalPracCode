package Courseratest;
import javax.swing.*;
public class ExchangeSortAlgoV1 {

	public static void main(String[] args) {
		//Made by Hosea James Zacarias
		int array[] = {34, -34, 87, 65, 9}; //input array
		int hold = 0; 
		String msg = "Array at the beginning: " + arrayToString(array) + "\n"; 
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = (i+1); j < array.length; j++) {
				if(array[i] > array[j]) {
					hold = array[j];
					array[j] = array[i];
					array[i] = hold;
				}
			}
			
			msg += "After Pass #" + (i + 1) + ": " + arrayToString(array);
            if (i < array.length - 1) {
            	msg += "\n";
            } else {
            	msg += " (done): " + arrayToString(array);
            }
            msg += "\n";
        }

        JOptionPane.showMessageDialog(null, new JTextArea(msg));
    }

    
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString().trim();
	}

}
