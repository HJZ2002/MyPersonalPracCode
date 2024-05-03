package GraphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndirectedGraph {

	public static void main(String[] args) {
		// 4 Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of vertex
		// input vertices 
		Scanner input = new Scanner(System.in);
		//inputing the vertices
		System.out.print("Enter the number of vertices: ");
        int V = input.nextInt();
     // input of the edges
        System.out.print("Enter the number of edges: ");
        int E = input.nextInt();

        // Get list of edges by using array
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (as pairs of vertices):");
        for (int i = 0; i < E; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            edges.add(new int[]{u, v});
        }

        // Create adjacency list from list of edges using for loop statment
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        // for looping statment
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Calculating the  degree of each vertex
        int[] degrees = new int[V];
        for (int u = 0; u < V; u++) {
            degrees[u] = adjList.get(u).size();
        }

        // Displaying the degree of vertices
        System.out.println("Degrees of vertices:");
        for (int u = 0; u < V; u++) {
            System.out.println("Vertex " + u + ": " + degrees[u]);
        }
    }
}
