
package GraphTheory;

public class Main {

	public static void main(String[] args) {
		//1 Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected 
		//and find the number of connected components if it is not connected
		
		// Depth First Search we have to find if its connected or not connected so we have to assume = Pick a route, keep going.
				//					 If you reach a dead end, or an already visited node,
				//					 backtrack to a previous node with unvisited adjacent neighbors
		
		Graphs graph = new Graphs(5);
		//connecting the node class together and adding them
		graph.addNode(new Nodes('A'));
		graph.addNode(new Nodes('B'));
		graph.addNode(new Nodes('C'));
		graph.addNode(new Nodes('D'));
		graph.addNode(new Nodes('E'));
		//adding the edges from the graphs class 
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		//inputing the variable ranges from 0>4 since starting point is 0 any outside of the length will catch an error since the starting point of an array is 0
		graph.depthFirstSearch(0);
	}

}
