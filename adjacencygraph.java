package GraphTheory;
import java.util.*;
public class adjacencygraph {
	
	//arraylist method for data
	ArrayList<adjacencynode> nodes;
	
	// declaring array integers
	int [][] matrix;
	
	//setting the parameter
	adjacencygraph(int size){
		nodes = new ArrayList<>();
		//number of vertices and edges
		matrix = new int [size][size];
		
	}
	//getting the node
	public void addNode(adjacencynode node ) {
		nodes.add(node);
	}
	//adding the edges
	public void addingedges(int src,int dst) {
		matrix[src][dst]=1;
		
	}//checking the row and colomn
	public boolean checkedges(int src,int dst) {
		//assuming if the row and column are correct
		if(matrix[src][dst] ==1) {
			return true;
		} else {
			return false;
		}
	}
	//displaying the output
	public void print() {
		System.out.print("  ");
		for (adjacencynode node :nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		//looping statment and nestedloop statment
		for(int i = 0; i<matrix.length;i++) {
			System.out.print(nodes.get(i).data + " ");
			for(int j = 0; j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
