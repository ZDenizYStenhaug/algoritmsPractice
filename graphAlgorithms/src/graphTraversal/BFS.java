package graphTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static LinkedList<Integer>[] adjList;
    public static boolean[] isVisited;
    public static int numOfVertices;

    public BFS(int n) {
        numOfVertices = n;
        adjList = new LinkedList[numOfVertices];
        isVisited = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++){
            adjList[i] = new LinkedList<Integer>();
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

    // .poll()  retrieves and removes the head (first element) of this list.
    public static void breadthFirstTraversal(int vertex) {

        Queue<Integer> queue = new LinkedList<>();

        isVisited[vertex] = true;
        queue.add(vertex);

        while (queue.size() > 0) {
            vertex = queue.poll();

            System.out.println("visited: " + vertex);

            for (int n : adjList[vertex]) {
                if (!isVisited[n]) {
                    isVisited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        new BFS(5);
        addEdge(0,1);
        addEdge(0,4);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,3);
        addEdge(3,4);

        displayGraph();

        breadthFirstTraversal(0);
    }
}
