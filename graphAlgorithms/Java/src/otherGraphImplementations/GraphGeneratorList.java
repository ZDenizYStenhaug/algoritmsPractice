package otherGraphImplementations;

import java.util.ArrayList;

public class GraphGeneratorList {

    static int numOfNodes = 5;
    static boolean[] visited = new boolean[numOfNodes];

    // Driver Code
    public static ArrayList<ArrayList<Integer>> generateGraph() {
        // Creating a graph with 5 vertices
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numOfNodes);

        for (int i = 0; i < numOfNodes; i++)
            graph.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        return graph;
    }

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > graph, int u, int v) {
        graph.get(u).add(v);

        // uncomment below for an undirected list
        //graph.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        System.out.println(graph);
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("head " + i);
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> "+graph.get(i).get(j));
            }
            System.out.println();
        }
    }


}
