package GraphTheory;
import java.util.*;

class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (Integer neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Breadth First Search starting from vertex 0:");
        graph.breadthFirstSearch(9);
    }
}
