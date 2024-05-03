package Courseratest;
import javax.swing.JOptionPane;

public class InsertionV2 {
	 public static void main(String[] args) {
		  int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
	      int[] arr = new int[length];
	      
	      for (int i = 0; i < length; i++) {
	            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
	            arr[i] = Integer.parseInt(input);
	        }
	      StringBuilder output = new StringBuilder();
	      output.append("Array at the beginning: " + arrayToString(arr) + "\n");
	      for (int i = 1; i < arr.length; i++) {
	            int key = arr[i];
	            int j = i - 1;

	            while (j >= 0 && arr[j] > key) {
	            	arr[j + 1] = arr[j];
	                j--;
	            }

	            arr[j + 1] = key;

	            output.append("After Pass #" + i + ": " + arrayToString(arr) + "\n");
	        }

	        output.append("Sorted Array: " + arrayToString(arr));

	        JOptionPane.showMessageDialog(null, output.toString());
	    }

	    public static String arrayToString(int[] array) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < array.length; i++) {
	            sb.append(array[i]);
	            if (i < array.length - 1) {
	                sb.append(" ");
	            }
	        }
	        return sb.toString();
	    }

	 }
