package GraphTheory;
import java.util.*;
public class Graphs {
	//geting the data of the length
	ArrayList<Nodes> nodes;
	int[][] matrix;
	//sized of the graph
	Graphs(int size){
		// length of the vertices and edges
		nodes = new ArrayList<>();
		matrix = new int[size][size];
	} //adding the node or calue
	public void addNode(Nodes node) {
		
		nodes.add(node);
	}	//adding the edges
	public void addEdge(int src, int dst) {
		
		matrix[src][dst] = 1;
	}	//checking the edges
	public boolean checkEdge(int src, int dst) {
		//asuming if its in the right path
		if(matrix[src][dst] == 1) {
			return true;
		}
		else {
			return false;
		}
	}	
	public void print() {	
		//looping statment
		System.out.print("  ");
		for(Nodes node : nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		//looping statment and length of the vertices including the edges
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}	//dfsalgorithm
	public void depthFirstSearch(int src) {
		boolean[] visited = new boolean[matrix.length];
		dFSHelper(src, visited);
	}// if the path has been visited or not visited
	private void dFSHelper(int src, boolean[] visited) {
		
		if(visited[src]) {
			return;
		}
		else {
			visited[src] = true;
			System.out.println(nodes.get(src).data + " = Connected");
		}
		//looping one more time
		for(int i = 0; i < matrix[src].length; i++) {
			if(matrix[src][i] == 1) {
				dFSHelper(i, visited);
			}
		}
		return;
	}
}

