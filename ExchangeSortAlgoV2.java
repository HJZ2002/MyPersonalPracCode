package Courseratest;
import javax.swing.*;
public class ExchangeSortAlgoV2 {

	public static void main(String[] args) {
		int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array"));
		int[] arr = new int[length];
		
		//filling the array
		
		for(int i = 0; i < length; i++) {
			String input = JOptionPane.showInputDialog("Enter the element at index " + i + ": ");
			arr[i] = Integer.parseInt(input);
		}
		int hold =0;
		String output = "Array at the beginning: " + arrayToString(arr);
		for(int i = 0 ; i<arr.length; i++) {
			for(int j = (i+1); j<arr.length; j++) {
					if(arr[i] > arr[j]) {
                    hold = arr[i];
                    arr[i] = arr[j];
                    arr[j] = hold;
                    output += "After Pass #" + (i + 1) + ": " + arrayToString(arr);
                    if (i < arr.length - 1) {
                    	output += "\n";
                    } else {
                    	output += " (done): " + arrayToString(arr);
                    }
                    output += "\n";
                }

                JOptionPane.showMessageDialog(null, new JTextArea(output));
            }
		}
	}
	
	private static String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int val:arr) {
			sb.append(val).append(" ");
		}
		return sb.toString().trim();
	}

}
