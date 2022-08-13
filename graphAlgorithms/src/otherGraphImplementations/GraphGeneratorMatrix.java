package otherGraphImplementations;

import java.util.ArrayList;

public class GraphGeneratorMatrix {
    static int numOfNodes = 5;
    static boolean[] visited = new boolean[numOfNodes];

    // Driver Code
    public static int[][] generateGraph() {
        int[][] graph = initiateGraph();

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        return graph;
    }

    public static int[][] initiateGraph() {
        int[][] graph = new int[numOfNodes][numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                graph[i][i] = 0;
            }
        }
        return graph;
    }
    // add edge from u to v
    public static void addEdge(int[][] graph, int u, int v) {
        graph[u][v] = 1;
    }
}

