package Courseratest;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
public class SortAlgoSelectionV2 {
	private int num[], sorted[];
	private int hold;
	private String all;
	private long startTime, stopTime, elapsedTime;

	SortAlgoSelectionV2() {
		num = new int[0];
	}

	SortAlgoSelectionV2(int num[]) {
		this.num = num;
	}

	public boolean isEmpty() {
		return (num.length < 0);
	}

	public void setElements(int num[]) {
		this.num = num;
	}

	public void setElements(int max) {
		if (max > 0) {
			Random rnd = new Random();
			num = new int[max];
			for (int i = 0; i < max; i++) {
				num[i] = rnd.nextInt(2 * max + 1)-max;
			}
		} else {
			System.err.println(max + " is invalid! Array cannot be empty!");
		}
	}

	public void setElements(String elements) {
		String data[] = elements.split(",\\s*");

		if (data.length < 2 || data[data.length - 1].isEmpty()) {
			System.out.println("Format invalid! Elements must be at least 2.");
		} else {
			for (String val : data) {
				if (!val.matches("-?\\d+")) {
					System.out.println("Format invalid! Only numbers are allowed.");
				}
			}

			num = new int[data.length];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(data[i]);
			}
		}
	}

	public void setData(int max) {
		if (max > 0) {
			num = new int[max];
			for (int i = 0; i < max; i++) {
				num[i] = Integer.parseInt(JOptionPane.showInputDialog("Num: "));
			}
		} else {
			System.err.println(max + " is invalid! Array cannot be empty!");
		}
	}

	public String getElements() {
		all = "";
		if (!isEmpty()) {
			for (int val : num) {
				all += val + " ";
			}
		} else {
			all = "Array is empty!";
		}
		return all;
	}

	public int size() {
		return num.length;
	}

	public void bubbleSort_1() {
		//Made by Hosea James Zacarias
		all = "";
		startTime = System.nanoTime();
		for (int x = 0; x < num.length; x++) {
			for (int y = 0; y < num.length - 1; y++) {
				if (num[y] > num[y + 1]) {
					hold = num[y + 1];
					num[y + 1] = num[y];
					num[y] = hold;
				}
			}
			for (int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		System.out.println(all);
	}

	//Made by Hosea James Zacarias
	public String bubbleSort_2() {
		all = "";
		startTime = System.nanoTime();
		for (int x = 0; x < num.length; x++) {
			for (int y = 0; y < num.length - 1; y++) {
				if (num[y] > num[y + 1]) {
					hold = num[y + 1];
					num[y + 1] = num[y];
					num[y] = hold;
				}
			}
			for (int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}

	//Made by Hosea James Zacarias
	public String bubbleSort_3() {
		all = "";
		bubbleSort_1();
		return all;
	}

	//Made by Hosea James Zacarias
	public int[] bubbleSort_4() {
		all = "";
		startTime = System.nanoTime();
		for (int x = 0; x < num.length; x++) {
			for (int y = 0; y < num.length - 1; y++) {
				if (num[y] > num[y + 1]) {
					hold = num[y + 1];
					num[y + 1] = num[y];
					num[y] = hold;
				}
			}
			for (int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return num;
	}
	//Made by Hosea James Zacarias
	public String bubbleSort_5(int num[]) {
		all = "";
		startTime = System.nanoTime();
		for (int x = 0; x < num.length; x++) {
			for (int y = 0; y < num.length - 1; y++) {
				if (num[y] > num[y + 1]) {
					hold = num[y + 1];
					num[y + 1] = num[y];
					num[y] = hold;
				}
			}
			for (int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}
	//Made by Hosea James Zacarias
	public String bubbleSort() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();
		for (int x = 0; x < sorted.length; x++) {
			for (int y = 0; y < sorted.length - 1; y++) {
				if (sorted[y] > sorted[y + 1]) {
					hold = sorted[y + 1];
					sorted[y + 1] = sorted[y];
					sorted[y] = hold;
				}
			}
			for (int val : sorted) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}
	//Made by Hosea James Zacarias
	public String exchangeSort() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();
		for (int i = 0; i < sorted.length - 1; i++) {
			for (int j = (i + 1); j < sorted.length; j++) {
				if (sorted[i] > sorted[j]) {
					hold = sorted[j];
					sorted[j] = sorted[i];
					sorted[i] = hold;
				}
			}
			for (int val : sorted) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}

	//Made by Hosea James Zacarias
	public String selectionSort() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();

		for (int i = 0; i < sorted.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < sorted.length; j++) {
				if (sorted[j] < sorted[minIndex]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				int temp = sorted[i];
				sorted[i] = sorted[minIndex];
				sorted[minIndex] = temp;
			}

			for (int val : sorted) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}

	//Made by Hosea James Zacarias
	public String insertionSort() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();

		for (int i = 1; i < sorted.length; i++) {
			int key = sorted[i];
			int j = i - 1;

			while (j >= 0 && sorted[j] > key) {
				sorted[j + 1] = sorted[j];
				j = j - 1;
			}
			sorted[j + 1] = key;

			for (int val : sorted) {
				all += val + "\t";
			}
			all += "\n";
		}

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}

	//Made by Hosea James Zacarias
	public String mergeSort() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();
		mergeSorter(sorted, 0, sorted.length - 1);

		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t: " + elapsedTime + " units";
		return all;
	}

	private void mergeSorter(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSorter(arr, left, mid);
			mergeSorter(arr, mid + 1, right);
			merge(arr, left, mid, right);

			for (int val : arr) {
				all += val + "\t";
			}
			all += "\n";
		}
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[left + i];
		}
		for (int i = 0; i < n2; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	//Made by Hosea James Zacarias
	public String quickSort() {
	    sorted = Arrays.copyOf(num, num.length);
	    all = "";
	    startTime = System.nanoTime();
	    quickSorter(sorted, 0, sorted.length - 1);

	    stopTime = System.nanoTime();
	    elapsedTime = stopTime - startTime;
	    all += "Time efficiency\t: " + elapsedTime + " units";
	    return all;
	}

	private void quickSorter(int[] arr, int low, int high) {
	    if (low < high) {
	        int partitionIndex = partition(arr, low, high);
	        quickSorter(arr, low, partitionIndex - 1);
	        quickSorter(arr, partitionIndex + 1, high);

	        for (int val : arr) {
	            all += val + "\t";
	        }
	        all += "\n";
	    }
	}
	
	private int partition(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    int temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	    return i + 1;
	}
	//Made by Hosea James Zacarias
	
	public String RadixSort() {
	   

	    int maxVal = Arrays.stream(sorted).max().orElse(0);
	    int minVal = Arrays.stream(sorted).min().orElse(0);

	    int range = maxVal - minVal + 1;
	    int[] countArray = new int[range];
	    int[] outputArray = new int[sorted.length];

	    all += "Original Array\t: ";
	    for (int val : sorted) {
	        all += val + "\t";
	    }
	    all += "\n\n";

	    for (int i = 0; i < sorted.length; i++) {
	        countArray[sorted[i] - minVal]++;
	    }

	    for (int i = 1; i < range; i++) {
	        countArray[i] += countArray[i - 1];
	    }

	    for (int i = sorted.length - 1; i >= 0; i--) {
	        outputArray[countArray[sorted[i] - minVal] - 1] = sorted[i];
	        countArray[sorted[i] - minVal]--;

	        all += "Step " + (sorted.length - i) + ":\t";
	        for (int val : outputArray) {
	            all += val + "\t";
	        }
	        all += "\n";
	    }

	    all += "\nSorted Array\t: ";
	    for (int val : outputArray) {
	        all += val + "\t";
	    }

	    stopTime = System.nanoTime();
	    elapsedTime = stopTime - startTime;
	    all += "\n\nTime efficiency\t: " + elapsedTime + " units";
	    return all;
	}

	// --------------------------------------------------------------------------------

	public String getSortedElements() {
		all = "";
		if (!isEmpty()) {
			for (int val : sorted) {
				all += val + " ";
			}
		} else {
			all = "Array is empty!";
		}
		return all;
	}

	public long getStartTime() {
		startTime = System.nanoTime();
		return startTime;
	}

	public long getStopTime() {
		stopTime = System.nanoTime();
		return stopTime;
	}

	public long getElapsedTime() {
		elapsedTime = stopTime - startTime;
		return elapsedTime;
	}

}

