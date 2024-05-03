package GraphTheory;

public class adjacencymatrix {

	public static void main(String[] args) {
		//2 Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give 
		//the number of times each edge appears.
		
		// Adjacency Matrix = An array to store 1's/0's to represent edges
		  // # of rows =    # of unique nodes
		//				       # of columns
		
		adjacencygraph graph = new adjacencygraph(6);
		// addding the data type of the matrix
		graph.addNode(new adjacencynode ('A'));
		graph.addNode(new adjacencynode ('B'));
		graph.addNode(new adjacencynode ('C'));
		graph.addNode(new adjacencynode ('D'));
		graph.addNode(new adjacencynode ('E'));
		graph.addNode(new adjacencynode ('F'));
		
		//displaying the edges and adding all at once
		graph.addingedges(0, 1);
		graph.addingedges(1, 2);
		graph.addingedges(2, 3);
		graph.addingedges(2, 4);
		graph.addingedges(3, 0);
		graph.addingedges(4, 2);
		
		//display
		graph.print();
		////inputing the variable ranges from 0>5 since starting point is 0 any outside of the length will catch an error since the starting point of an array is 0
		System.out.println(graph.checkedges(2, 3));
	}

}
