package SavedAlgo;

import java.util.*;
public class GraphConnectivityv1 {
	
	 public static int countConnectedComponents(List<int[]> edges) {
	        // Build the adjacency list and collect all vertices
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        
	        //inputing the graphs for the connectivity 
	        for (int[] edge : edges) {
	            int u = edge[0], v = edge[1];
	            graph.putIfAbsent(u, new ArrayList<>());
	            graph.putIfAbsent(v, new ArrayList<>());
	            graph.get(u).add(v);
	            graph.get(v).add(u);
	        }

	        Set<Integer> visited = new HashSet<>();
	        int components = 0;

	        for (int node : graph.keySet()) {
	            if (!visited.contains(node)) {
	                dfs(node, graph, visited);
	                components++;
	            }
	        }
	        // it will tell if its connected or not connected 
	        if (components == 1) {
	            System.out.println("The graph is connected.");
	        } else {
	            System.out.println("The graph is not connected. Number of connected components: " + components);
	        }

	        return components;
	    }

	    private static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
	        visited.add(node);
	        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
	            if (!visited.contains(neighbor)) {
	                dfs(neighbor, graph, visited);
	            }
	        }
	    }

	    public static void main(String[] args) {
	       // list of samples for edges for arrays
	        List<int[]> edges = Arrays.asList(
	            new int[]{1, 2},
	            new int[]{2, 3},
	            new int[]{4, 5}
	        );

	        countConnectedComponents(edges);
	    }
	}