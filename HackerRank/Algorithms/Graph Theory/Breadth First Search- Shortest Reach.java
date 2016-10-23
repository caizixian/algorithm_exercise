import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


class Graph {

    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Graph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return V;
    }


    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

}

class BFSShortestPath {

    private final int source;
    private int[] edgeTo;
    private boolean[] marked;

    public BFSShortestPath(Graph g, int source) {
        this.source = source;
        this.edgeTo = new int[g.V()];
        this.marked = new boolean[g.V()];


        bfs(g, source);
    }

    private void bfs(Graph g, int source) {

        LinkedList<Integer> queue = new LinkedList<Integer>();
        this.marked[source] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }


    public int distTo(int vertex) {
        if (!this.marked[vertex]) {
            return -1; // Cannot be accessed through source
        }
        int length = 0;
        while (vertex != this.source) {
            length += 6;
            vertex = edgeTo[vertex];
        }
        return length;
    }

    public void printDebug() {
        System.out.println("edgeTo: ");
        for (int i = 0; i < this.edgeTo.length; i++) {
            System.out.printf("%d - %d\n", this.edgeTo[i], i);
        }
        System.out.println("marked: ");
        for (int i = 0; i < this.marked.length; i++) {
            System.out.printf("%d: %b\n", i, this.marked[i]);
        }
    }

    public void printShortestPath() {
        for (int i = 0; i < this.edgeTo.length; i++) {
            if (i == this.source) {
                continue;
            }
            System.out.printf("%d ", distTo(i));
        }
        System.out.println();
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int query_size = in.nextInt();
        for (int i = 0; i < query_size; i++) {
            int v_count = in.nextInt();
            int e_count = in.nextInt();
            Graph g = new Graph(v_count);
            for (int j = 0; j < e_count; j++) {
                g.addEdge(in.nextInt() - 1, in.nextInt() - 1);
            }
            int source = in.nextInt() - 1;
            BFSShortestPath bfs = new BFSShortestPath(g, source);
            //bfs.printDebug();
            bfs.printShortestPath();
        }
    }
}