package spanningTrees;

import java.util.Arrays;

public class Prim {

    public static int size;
    public static int[][] graph;
    // visited will keep track of the vertices that are included in the spanning tree.
    public static boolean[] visited;
    public static int[] key;
    public static int[] parent;


    public Prim(int[][] g) {
        graph = g;
        size = graph.length;
        visited = new boolean[size];
        // key values used to pick minimum weight edge in cut ??
        key = new int[size];
        // array to store constructed MST
        parent = new int[size];

        // Initialize all keys as infinite.
        for (int i = 0; i < size; i++) {
            visited[i] = false;
            key[i] = Integer.MAX_VALUE;
        }

    }

    public static void displayGraph(){
        System.out.println("Graph:");
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void prim(){





    }

    public static int minDistance() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < size; v++) {
            if(!visited[v] && key[v] < min){
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {

        graph = new int[][]{{ 0, 2, 0, 6, 0 },
                            { 2, 0, 3, 8, 5 },
                            { 0, 3, 0, 0, 7 },
                            { 6, 8, 0, 0, 9 },
                            { 0, 5, 7, 9, 0 }};
        displayGraph();
        prim();

    }
}
