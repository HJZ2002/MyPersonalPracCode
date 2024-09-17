package Courseratest;
import javax.swing.*;
public class BubbleSortV2 {

	public static void main(String[] args) {
		//Taking the array size
		int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
		
		int array[] = new int[length];
		
        for(int i = 0; i < length; i++) {
            String input = JOptionPane.showInputDialog("Enter elemet of the index"+ i + ": ");
            array[i] = Integer.parseInt(input);
        }
        bubbleSort(array);
        
        //Displaying the array and index
        StringBuilder result = new StringBuilder("Sorted Array:");
        for(int num:array) {
        	result.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, result.toString());
	}
	
    public static void bubbleSort(int array[]) {
	    int length = array.length;
	    boolean swapped;
	    
	    for(int i = 0; i < length - 1; i++) {
	    		swapped = false;
            for(int j = 0; j < length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            //If no two elements where swapped
            if(!swapped) {
                break;}
	    }
    }
}
