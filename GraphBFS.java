package GraphTheory;
import java.util.*;
public class GraphBFS {
	//array nad int
	ArrayList<Nodes>nodes;
	int[][]matrix;
	
	//setting the graph size
	GraphBFS(int size){
		
		nodes = new ArrayList<>();
		matrix = new int[size][size];
		
	}
	//adding the row
	public void addNode(Nodes node) {
		
		nodes.add(node);
	}
	//knowing the edge
	public void addEdge(int src, int dst) {
		matrix[src][dst] = 1;
	}
	public boolean checkEdge(int src, int dst) {
		if(matrix[src][dst]==1) {
			return true;
		} else {
			return false;
		}
	}
	public void print() {	
		//looping area
		System.out.println(" ");
		for (Nodes nodes:nodes ) {
			System.out.println(nodes.data + " ");
			
		}
		System.out.println();
		//for loop again
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			//for loop method
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void breadthFirstSearch(int src) {
		//linkedlist
		Queue<Integer> queue = new LinkedList<>();
		boolean[]connected = new boolean[matrix.length];
		
		queue.offer(src);
		connected[src]=true;
		
		while(queue.size()!=0) {
			src = queue.poll();
			System.out.println(nodes.get(src).data+" =Visited:");
			//looping again one more time
			for (int i = 0; i<matrix[src].length; i++) {
				//if statment
				if(matrix[src][i]==1&& !connected[i]) {
					queue.offer(i);
					connected[i]=true;
				}
			}
		}
	}

}
