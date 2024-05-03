package GraphTheory;
import java.util.*;
public class GraphCycle {
	public static void main(String[] args) {
		//input of vertices
        Scanner sc = new Scanner(System.in);

        // Get number of vertices 
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        // Get adjacency matrix 
        int[][] matrix = new int[V][V];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Create graph from adjacency matrix
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] != 0) {
                    neighbors.add(j);
                }
            }
            graph.add(neighbors);
        }

        // Check if graph has a cycle or not cycle
        boolean hasCycle = hasCycle(graph);

        // Print result
        if (hasCycle) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }
	// checking if the graph pass the neighbor
    private static boolean hasCycle(List<List<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        // using loop statment
        for (int i = 0; i < V; i++) {
        	// using if else statment assuming that the graph has pass the neighbor
            if (hasCycleUtil(graph, i, visited, recStack)) {
                return true;
            }
        }
        // if failed return to false
        return false;
    }

    private static boolean hasCycleUtil(List<List<Integer>> graph, int vertex, boolean[] visited, boolean[] recStack) {
    	// assuming that all are true and it surpass the graph method
        visited[vertex] = true;
        recStack[vertex] = true;
        
        List<Integer> neighbors = graph.get(vertex);
        // using loops statement 
        for (int neighbor : neighbors) {
        	// using if else again if it pass the graph it will ask for one more time since it stack up
            if (!visited[neighbor] && hasCycleUtil(graph, neighbor, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        // if failed to meet it will be false and go back
        recStack[vertex] = false;
        return false;
    }
}


	