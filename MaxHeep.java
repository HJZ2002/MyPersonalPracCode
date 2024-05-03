package Week13;

public class MaxHeep {
	private int[] array;
	private int count , capacity,index;
	
	public MaxHeep() {
		capacity = 5;
		array = new int[setArrayMax(capacity)];
		count = 0;
	}
	public MaxHeep(int capacity) {
		this.capacity = capacity;
		array = new int[setArrayMax(capacity)];
		count = 0;
	}
	public int setArrayMax(int capacity) {
		index = (capacity *2 ) + 2;
		return index;
	}
	public int heapcount() {
		return count;
	}
	public boolean isEmpty() {
		return count == 0;
	}
	public boolean isFull() {
		return count>=(capacity);
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		array = new int[setArrayMax(capacity)];
		System.out.println(setArrayMax(capacity));
	}
	public int getCapacity() {
		return capacity;
	}
	public void upHeap(int value) {
		array[count + 1] = value;
		count++;
		int index = count;
		while(index > 1 && array[index]>array[index /2]) {
			//swapping the current element
			int temp = array[index];
			array[index] = array[index /2];
			array[index / 2] = temp;
			
			index = index / 2;
		}
		
	}
	public void heapify() {
		if(count <= 1) {
			return; 
		}
		
		int index = 1;
		
		while(index <= count / 2) {
			int leftChild = index * 2;
			int rightChild = index * 2 + 1;
			//Finding the larger child
			int largerChild = (rightChild <= count && array[rightChild] > array[leftChild]) ? rightChild : leftChild;
			
			//If the larger child is greater than the current element, swap them
			if(array[largerChild] > array[index]) {
				int temp = array[largerChild];
				array[largerChild] = array[index];
				array[index] = temp;
				
				index = largerChild; //Move down to the larger child index
			}else {
				break; //Heap property is restored, stop down-heaping
			}
		}
	}
	public void deleteNode(int value) {
		int index = getIndex(value);
		if(index == -1) {
			return; 
		}
		
		
		array[index] = array[count];
		count--;
		
		
		if(index > 1 && array[index] > array[index / 2]) {
			upHeap(array[index]);
		}else {
			heapify();
		}
	}
	
	
	public int extractMax() {
		if(isEmpty()) {
			return -1; 
		}
		
	
		int max = array[1];
		
	
		array[1] = array[count];
		count--;
		
		//Restore the heap
		heapify();
		
		return max;
	}
	
	
	public int[] heapSort() {
		int sorted[] = new int[count + 1];
		int index = 0;
		
		for(int i = count; i >= i; i--, index++) {
			sorted[index] = array[1]; //Store the maximum element in the sorted array
			array[1] = array[i]; //Move the last element to the root
			count--;
			
			heapify();
		}
		
		return sorted;
	}
	
	public String heapSorting() {
		String hold = "";
		for(int i = count; i >= 1; i--) {
			hold += array[1] + " "; //Store the maximum element in the sorted array
			array[1] = array[i]; //Move the last element to the root
			count--;
			
			heapify(); 
		}
		return hold;
	}
	

	public boolean checkDuplicate(int value) {
		for(int i = 1; i <= count; i++) {
			if(array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	private int getIndex(int value) {
		for(int i = 1; i <= count; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		return -1; //Value not found in the heap
	}
	

	public int parent(int value) {
		int index = getIndex(value);
		
		if(index == -1) {
			return -1; //Value not found in the heap
		}
		if(index == 1) {
			return -1; //Root Node, no parent
		}
		return array[index / 2];
	}
	
	
	public int leftChild(int value) {
		int index = getIndex(value);
		
		if(index == -1) {
			return -1; //Value not found in the heap
		}
		int leftChild = index * 2;
		if(leftChild > count) {
			return -1; //No left child exists
		}
		return array[leftChild];
	}
	
	
	public int rightChild(int value) {
		int index = getIndex(value);
		
		if(index == -1) {
			return -1; //Value not found in the heap
		}
		int rightChild = index * 2 + 1;
		if(rightChild > count) {
			return -1; //No right child exists
		}
		return array[rightChild];
	}
	
	
	public String parents() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 2; i <= count; i+= 2) {
				int parent = array[i / 2];
				hold += parent + " ";
			}
		}
		return hold;
	}
	
	
	public String leftChildren() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				int leftChild = array[i * 2];
				if(leftChild == 0) {
					break;
				}else if(leftChild != -1) {
					hold += leftChild + " ";
				}
			}
		}
		return hold;
	}
	
	
	public String rightChildren() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				int rightChild = array[i * 2 + 1];
				if(rightChild == 0) {
					break;
				}else if(rightChild != -1) {
					hold += rightChild + " ";
				}
			}
		}
		return hold;
	}
	
	
	public String leaves() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				if(array[i * 2] == -1 && array[i * 2 + 1] == -1) {
					hold += array[i] + " ";
				}
			}
		}
		return hold;
	}
	
	
	public String displayHeap() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				hold += array[i] + " ";
			}
		}
		return hold;
	}
	
	
	public void reset() {
		count = 0;
	}
	
	//Print the root
	public int peek() {
		return (isEmpty()) ? -1 : array[1];
	}
  
 }
