package Courseratest;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class RadixSort {

	 private static int getMax(int[] arr) {
	        int max = arr[0];
	        for (int value : arr) {
	            if (value > max) {
	                max = value;
	            }
	        }
	        return max;
	    }

	    
	    private static void countingSort(int[] arr, int exp) {
	        int n = arr.length;
	        int[] output = new int[n];
	        int[] count = new int[10]; 

	        
	        Arrays.fill(count, 0);

	       
	        for (int value : arr) {
	            count[(value / exp) % 10]++;
	        }

	        
	        for (int i = 1; i < 10; i++) {
	            count[i] += count[i - 1];
	        }

	        
	        for (int i = n - 1; i >= 0; i--) {
	            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	            count[(arr[i] / exp) % 10]--;
	        }

	       
	        System.arraycopy(output, 0, arr, 0, n);
	    }

	    public static void radixSort(int[] arr) {
	        int max = getMax(arr);

	       
	        for (int exp = 1; max / exp > 0; exp *= 10) {
	            countingSort(arr, exp);
	        }
	    }

	    public static String arrayToString(int[] arr) {
	        StringBuilder builder = new StringBuilder();
	        builder.append("[");
	        for (int i = 0; i < arr.length; i++) {
	            builder.append(arr[i]);
	            if (i < arr.length - 1) {
	                builder.append(", ");
	            }
	        }
	        builder.append("]");
	        return builder.toString();
	    }

	    public static void main(String[] args) {
	        int arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
	        int[] arr = new int[arraySize];

	        for (int i = 0; i < arraySize; i++) {
	            arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter element at index " + i + ":"));
	        }

	        StringBuilder msg = new StringBuilder();
	        msg.append("RadixSort" + "\nArray at the beginning: ").append(Arrays.toString(arr)).append("\n");

	        radixSort(arr);

	        for (int i = 1; i <= arraySize; i++) {
	            msg.append("After Pass #" + i + ": " + arrayToString(arr) + "\n");
	        }

	        JOptionPane.showMessageDialog(null, msg.toString(), "Made by Hosea James Zacarias", JOptionPane.INFORMATION_MESSAGE);
	    }
	}