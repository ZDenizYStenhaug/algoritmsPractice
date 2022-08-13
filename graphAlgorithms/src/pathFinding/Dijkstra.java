package pathFinding;

import java.util.Arrays;

public class Dijkstra {

    public static int size;
    public static int[][] graph;
    public static boolean[] visited;
    // distance[i] will hold the shortest path from src to i
    public static int[] distance;

    public Dijkstra(int[][] g) {
        graph = g;
        size = g.length;
        visited = new boolean[size];
        distance = new int[size];


        // Initialize the distance and visited arrays
        for (int i = 0; i < size; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public static void displayGraph(){
        System.out.println("Graph:");
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }

    /*
    注意！！
    when you are on a node (u below), you update the distances of the neighboring nodes (v).
    imagine the distance array being updated one step ahead of the traversal.
     */
    public static void dijkstra(int src) {
        // the distance to the starting node will always be 0
        distance[src] = 0;

        //iterate through every node
        for (int i = 0; i < size; i++) {
            // get the node that is closest to the current node.
            int u = minDistance();
            visited[u] = true;

            //iterate through every other node.
            for (int v = 0; v < size; v++) {
                /*
                 if node v is not already set, AND if the current source node (u) and v are connected,
                 AND if the new distance is smaller than the previously set one, update distance[v].
                 */
                if (!visited[v] && graph[u][v] != 0 && distance[u] + graph[u][v] < distance[v]){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
    }

    /*
     returns the index of the node that has the smallest distance value
     (and has not been visited yet) in the distance[] array
     */
    public static int minDistance() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < size; v++) {
            if (!visited[v] && distance[v] < min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void printSolution() {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < size; i++)
            System.out.println(i + " \t\t " + distance[i]);
    }

    public static void main(String[] args) {
        graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                            {4, 0, 8, 0, 0, 0, 0, 11, 0},
                            {0, 8, 0, 7, 0, 4, 0, 0, 2},
                            {0, 0, 7, 0, 9, 14, 0, 0, 0},
                            {0, 0, 0, 9, 0, 10, 0, 0, 0},
                            {0, 0, 4, 14, 10, 0, 2, 0, 0},
                            {0, 0, 0, 0, 0, 2, 0, 1, 6},
                            {8, 11, 0, 0, 0, 0, 1, 0, 7},
                            {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        new Dijkstra(graph);
        displayGraph();
        dijkstra(0);
        printSolution();
    }
}
