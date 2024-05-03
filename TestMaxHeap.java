package Week13;

import java.util.Arrays;

public class TestMaxHeap {
	public static void main(String[] args) {
		MaxHeep max = new MaxHeep(6);
		
		System.out.println("Count: " +max.heapcount());
		System.out.println("Empty: " +max.isEmpty());
		System.out.println("Capacity: " +max.getCapacity());
		System.out.println("Peek: " +max.peek());
		
		//setting up the parent
		System.out.println("Parent of 10\t:"+ max.parent(10));
		System.out.println("Parent of 7\t:"+max.parent(7));
		
		System.out.println("Right child of 10\t:"+max.rightChild(10));
		System.out.println("Right child of 7\t:"+max.rightChild(7));
		
		System.out.println("Left child of 10\t:"+max.leftChild(10));
		
		System.out.println("Left child of 7\t:"+max.leftChild(7));
		
		System.out.println("left child of the Children\t:"+max.leftChildren());
		System.out.println("Right of the Children" + max.rightChildren());
		System.out.println("Parents\t\t: "+max.parents());
		
		System.out.println("Leaves\t\t:"+max.leaves());
		System.out.println("Is 12 existing?\t:"+max.checkDuplicate(12));
		
		System.out.println("Heap of the elements\t:"+max.displayHeap());
		
		System.out.println("Sorted\t\t:"+max.heapSorting());
		
		max.upHeap(4);
		max.upHeap(8);
		max.upHeap(2);
		max.upHeap(1);
		max.upHeap(7);
		max.upHeap(10);
		
		//System.out.println("Count: " +max.heapcount());
		//System.out.println("Empty: " +max.isEmpty());
		//System.out.println("Capacity: " +max.getCapacity());
		//System.out.println("Peek: " +max.peek());
		
		//System.out.println("Parent of 10\t:"+ max.parent(10));
		//System.out.println("Parent of 7\t:"+max.parent(7));
		
		//System.out.println("Right child of 10\t:"+max.rightChild(10));
		//System.out.println("Right child of 7\t:"+max.rightChild(7));
		
		//System.out.println("Left child of 10\t:"+max.leftChild(10));
		
		//System.out.println("Left child of 7\t:"+max.leftChild(7));
		
		//System.out.println("left child of the Children\t:"+max.leftChildren());
		//System.out.println("Right of the Children" + max.rightChildren());
		//System.out.println("Parents\t\t: "+max.parents());
		
		//System.out.println("Leaves\t\t:"+max.leaves());
		//System.out.println("Is 12 existing?\t:"+max.checkDuplicate(12));
		
		//System.out.println("Heap of the elements\t:"+max.displayHeap());
		
		//int sort[]= max.heapSort();
		//for(int i=0; i<sort.length-1; i++) {
			//System.out.println(sort[i]+" ");
		
		//System.out.println("Sorted\t\t:"+Arrays.toString(max.heapSort()));
		//System.out.println("Sorted\t\t:"+max.heapSorting());
		//}
	}
}
