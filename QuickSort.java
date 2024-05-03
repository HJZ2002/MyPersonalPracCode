package Courseratest;
import java.util.Arrays;
import javax.swing.*;

public class QuickSort {

	public static void main(String[] args) {
		int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
		int[] arr = new int[length];
		
		for (int i = 0; i < length; i++) {
            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
            arr[i] = Integer.parseInt(input);
        }
		  StringBuilder msg = new StringBuilder();
		  msg.append("Quick Sort" + "\nArray at the beginning: ").append(Arrays.toString(arr)).append("\n");
		  
		  quickSort(arr, 0, arr.length - 1, msg);
		  JOptionPane.showMessageDialog(null, msg.toString(),"Made by Hosea James Zacarias ",JOptionPane.INFORMATION_MESSAGE);
	}
	public static void quickSort(int[] array, int low, int high, StringBuilder output) {
        if (low < high) {
            int index = par(array, low, high, output);
            quickSort(array, low, index - 1, output);
            quickSort(array, index + 1, high, output);
        }
    }
	private static int par(int[] array, int low, int high, StringBuilder output) {
		 int pivot = array[high];
	        int i = low - 1;

	        for (int j = low; j < high; j++) {
	            if (array[j] <= pivot) {
	                i++;
	                int temp = array[i];
	                array[i] = array[j];
	                array[j] = temp;
	            }
	        }

	        int temp = array[i + 1];
	        array[i + 1] = array[high];
	        array[high] = temp;

	        output.append("After Partition with pivot " + pivot + ": ").append(Arrays.toString(array)).append("\n");

	        return i + 1;
	    }
		
	}