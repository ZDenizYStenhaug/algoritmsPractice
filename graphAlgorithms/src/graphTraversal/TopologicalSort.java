// https://www.geeksforgeeks.org/topological-sorting/

/*
注意！！
Here, I used stack as in the website.
But in the book, the same step goes like:
"as each vertex is finished, insert it onto the front of a linked list"
 */

package graphTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    public static LinkedList<Integer>[] adjList;
    public static boolean[] isVisited;
    public static int numOfVertices;

    public TopologicalSort(int n) {
        numOfVertices = n;
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

    public static void topologicalSort() {

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < numOfVertices; i++) {
            if (!isVisited[i]) {
                DFSWithStack(stk, i);
            }
        }
        System.out.println(Arrays.toString(stk.toArray()));
    }

    // the recursive method for the topological sort
    public static void DFSWithStack(Stack<Integer> stk, int vertex){
        isVisited[vertex] = true;
        for (int n : adjList[vertex]) {
            if (!isVisited[n]) {
                DFSWithStack(stk, n);
            }
        }
        stk.push(vertex);
    }

    public static void main(String[] args) {
        new TopologicalSort(5);
        addEdge(0,1);
        addEdge(0,4);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,3);
        addEdge(3,4);

        displayGraph();

        topologicalSort();
    }

}
