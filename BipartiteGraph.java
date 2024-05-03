package GraphTheory;
import java.util.*;
public class BipartiteGraph {
	// inputing the bipartite 
	static class Graph {
        private int V; // Number of vertices
        private List<List<Integer>> adjList; // Adjacency list method

        public Graph(int v) {
            V = v;
            adjList = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        public boolean isBipartite() {
            int[] colors = new int[V]; // array to store colors for vertices 
            Arrays.fill(colors, -1); // Initialize colors to -1

            for (int i = 0; i < V; i++) {
                if (colors[i] == -1) { // If color is not assigned 
                    if (!bfs(i, colors)) { //if the bfs has perform and check if it is bipartite
                        return false;
                    }
                }
            }

            return true; // If no conflicts are found, the graph is bipartite if found it is not bipartite
        }

        private boolean bfs(int src, int[] colors) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src); // Add source vertex to queue
            colors[src] = 0; // Assign color 0 to source vertex

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : adjList.get(u)) {
                    if (colors[v] == -1) { // If color is not assigned to vertex v
                        colors[v] = 1 - colors[u]; // Assign opposite color to vertex v
                        queue.add(v); // Add vertex v to queue
                    } else if (colors[v] == colors[u]) { // If adjacent vertices have same color
                        return false; // Graph is not bipartite
                    }
                }
            }

            return true; // If BFS completes without conflicts, the graph is bipartite
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int v = sc.nextInt();

        Graph graph = new Graph(v);

        System.out.print("Enter the number of edges in the graph: ");
        int e = sc.nextInt();

        System.out.println("Enter the edges in the format (0 1):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int edgeV = sc.nextInt();
            graph.addEdge(u, edgeV);
        }
        
        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}