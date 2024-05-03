package Courseratest;
import java.util.Arrays;

import javax.swing.JOptionPane;
public class SelectionV2 {

	public static void main(String[] args) {
		int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
		
		int[] arr = new int[length];
		
		for(int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter element #" + (i + 1) + ":"));
		}
		String msg = "Array at the beginning: " + Arrays.toString(arr) + "\n\n";
		
		int num = arr.length;
		
		for(int i = 0; i < num - 1; i++) {
			int mindex = 1;
			for (int j = i + 1; j < num; j++) {
                if (arr[j] < arr[mindex]) {
                    mindex = j;
                }
            }
			int swap = arr[i];
			arr[i]=arr[mindex];
			arr[mindex]=swap;
			
			//each output string
			msg+= "After Pass #" + (i + 1) + ": " + Arrays.toString(arr) + "\n\n";
		}
		//final sorted array
		msg += "After Pass #" + num + " (done): " + Arrays.toString(arr);
		JOptionPane.showMessageDialog(null, msg);
	}
	//display
}
