package graphTraversal;

import java.util.LinkedList;

public class DFS {

    public static LinkedList<Integer>[] adjList;
    public static boolean[] isVisited;
    public static int numOfVertices = 5;

    public DFS() {
        adjList = new LinkedList[numOfVertices];
        isVisited = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public static void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public static void displayGraph() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print(i + " --> ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(adjList[i].get(j) + "  ");
            }
            System.out.print("\n");
        }
    }

    public static void depthFirstTraversal(int vertex) {
        isVisited[vertex] = true;
        System.out.println("visited: " + vertex);

        for (int adj : adjList[vertex]) {
            if (!isVisited[adj]) {
                depthFirstTraversal(adj);
            }
        }
    }

    public static void main(String[] args) {
        new DFS();
        addEdge(0,1);
        addEdge(0,4);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,3);
        addEdge(3,4);

        displayGraph();

        depthFirstTraversal(0);
    }
}
