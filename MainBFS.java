package GraphTheory;

public class MainBFS {
	
	public static void main(String[] args) {
		
		// Breadth FS = Traverse a graph level by level
		//			   Utilizes a Queue
		//			   Better if destination is on average close to start
		//			   Siblings are visited before children
		
		// Depth FS   = Traverse a graph branch by branch
		//			   Utilizes a Stack
		//			   Better if destination is on average far from the start
		//			   Children are visited before siblings
		//			   More popular for games/puzzles
		
		GraphBFS graph = new GraphBFS(5);
		graph.addNode(new Nodes('A'));
		graph.addNode(new Nodes('B'));
		graph.addNode(new Nodes('C'));
		graph.addNode(new Nodes('D'));
		graph.addNode(new Nodes('E'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		
		graph.breadthFirstSearch(4);
	}
}