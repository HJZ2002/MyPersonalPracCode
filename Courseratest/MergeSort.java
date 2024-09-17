package Courseratest;

import java.util.Arrays;
import javax.swing.*;
public class MergeSort {
	public static void main(String[] args) {
		int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
        int[] arr = new int[length];
        
        for (int i = 0; i < length; i++) {
            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
            arr[i] = Integer.parseInt(input);
        }
        StringBuilder msg = new StringBuilder();
        msg.append("Merge Sort" + "\nArray at the beginning: ").append(Arrays.toString(arr)).append("\n");
        mergeSort(arr, 0, arr.length - 1, msg);
        
        JOptionPane.showMessageDialog(null, msg.toString(),"Made by Hosea James Zacarias",JOptionPane.INFORMATION_MESSAGE);
	}
	public static void mergeSort(int[] arr,int left,int right,StringBuilder msg) {
		if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, msg);
            mergeSort(arr, mid + 1, right, msg);
            merge(arr, left, mid, right, msg);
        }	
	}
	public static void merge(int[] arr,int left,int mid,int right,StringBuilder msg) {
		int[] array = new int[arr.length];
		for(int i = left; i <=right;i++) {
			 array[i] = arr[i];
		}
		int i = left;
		int j = mid + 1;
		int k = left;
		while(i <= mid && j <= right) {
				if(array[i] <= array[j]) {
                array[k] = array[i];
                i++;
            }
            else {
                array[k] = array[j];
                j++;
            }
            k++;
		}
		 while (i <= mid && j <= right) {
	            if (array[i] <= array[j]) {
	                array[k] = array[i];
	                i++;
	            } else {
	                array[k] = array[j];
	                j++;
	            }
	            k++;
	        }

	        while (i <= mid) {
	            array[k] = array[i];
	            k++;
	            i++;
	        }
	        passNumber++;
	        msg.append("After Pass #").append(passNumber).append(": ").append(Arrays.toString(array)).append("\n");
	}
	private static int passNumber = 0;
}
