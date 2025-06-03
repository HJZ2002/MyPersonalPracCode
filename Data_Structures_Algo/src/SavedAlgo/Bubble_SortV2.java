package SavedAlgo;
import java.util.Arrays;
public class Bubble_SortV2 {
	public static void main(String[] args) {
		int[] n = {3,5,1,4,-3,};
		int hold;
		
		System.out.println("Original array:");
		for (int num : n) {
			System.out.println(num + " ");
		}
		System.out.println("\n");
		
		 for (int r = 0; r < n.length - 1; r++) {
	            for (int c = 0; c < n.length - 1 - r; c++) {
	                if (n[c] > n[c + 1]) {
	                    // Proper swap
	                    hold = n[c];
	                    n[c] = n[c + 1];
	                    n[c + 1] = hold;
	                }
	            }
	            System.out.println("After pass " + (r + 1) + ": " + Arrays.toString(n));
	            for (int num : n) {
	                System.out.print(num + " ");
	            }
	            System.out.println();
	        }

	        // Output the sorted array
	        System.out.println("Sorted array:");
	        for (int i = 0; i < n.length; i++) {
	            System.out.print(n[i] + " ");
	        }
	    }
	}

