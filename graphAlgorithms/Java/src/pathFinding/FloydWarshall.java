package pathFinding;

public class FloydWarshall {
    public static int size;
    public static int[][] graph;
    public static int[][] matrix;
    // when you set INF to Integer.MAX_VALUE, you get an overflow error
    public static int INF = 9999;

    public FloydWarshall(int[][] g) {
        graph = g;
        matrix = g;
        size = g.length;

    }

    public static void displayGraph() {
        System.out.println("Graph:");
        for (int[] row : graph) {
            for (int i = 0; i < size; i++)
                System.out.print(row[i] == INF ? "  ∞" : "  " + row[i]);
            System.out.print("\n");
        }
    }

    public static void floydWarshall() {

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }

    }

    public static void main(String[] args) {
        graph = new int[][] { { 0, 3, INF, 5 },
                              { 2, 0, INF, 4 },
                              { INF, 1, 0, INF },
                              { INF, INF, 2, 0 } };
        new FloydWarshall(graph);

        displayGraph();

        floydWarshall();

        displayGraph();

    }


}
