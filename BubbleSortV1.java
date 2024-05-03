package Courseratest;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class BubbleSortV1 {
	
	//Made by Hosea James Zacarias
	public static void main(String[] args) {
		int array [] = {43,67,98,90,-50};
		int hold =0;
		String all = "";
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-i-1;j++) {
                if(array[j]>array[j+1]) {
                    hold = array[j];
                    array[j] = array[j+1];
                    array[j+1] = hold;
                }}
		}
		for(int val:array) {
			all+=val+"\t";
		}
		all+="\n";
		JOptionPane.showMessageDialog(null, new JTextArea(all));
		
	}
}
