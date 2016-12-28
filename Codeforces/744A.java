import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int verticesLeft = vertices;

        int edges = in.nextInt();
        int edgesLeft = edges;

        int governmentCnt = in.nextInt();
        int maxGovernmentSize = -1;
        Government maxGovernment = new Government(-1); // dummy value
        Government[] governments = new Government[governmentCnt];
        for (int i = 0; i < governmentCnt; i++) {
            governments[i] = new Government(in.nextInt());
        }
        Graph g = new Graph(vertices);
        for (int i = 1; i <= edges; i++) {
            g.addEdge(in.nextInt(), in.nextInt());
        }

        int edgesToAdd = 0;

        for (Government government : governments) {
            government.dfs(g);
            verticesLeft -= government.size();
            edgesLeft -= government.edges();
            edgesToAdd += government.edgesToAdd(); // Not fully connected
            if (government.size() > maxGovernmentSize) {
                maxGovernmentSize = government.size();
                maxGovernment = government;
            }
        }

        // Biggest governments can expand using vertices left
        edgesToAdd -= maxGovernment.edgesToAdd(); // Duplication
        edgesToAdd += maxGovernment.edgesToAdd(verticesLeft);
        edgesToAdd -= edgesLeft;

        System.out.println(edgesToAdd);
    }
}

class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    Graph(int _V) {
        V = _V;
        adj = (LinkedList<Integer>[]) new LinkedList[V + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    int V() {
        return V;
    }

    int E() {
        return E;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    LinkedList<Integer> adj(int v) {
        return adj[v];
    }
}

class Government {
    private int capital;
    private int edges;
    HashSet<Integer> territory;

    Government(int _capital) {
        capital = _capital;
        territory = new HashSet<>();
        edges = 0;
    }

    void dfs(Graph g) {
        dfs(g, capital);
        for (Integer v : territory) {
            edges += g.adj(v).size();
        }
        edges /= 2;
    }

    private void dfs(Graph g, int v) {
        territory.add(v);
        for (int w : g.adj(v)) {
            if (!territory.contains(w)) {
                dfs(g, w);
            }
        }
    }

    int size() {
        return territory.size();
    }

    int edges() {
        return edges;
    }

    int edgesToAdd() {
        return size() * (size() - 1) / 2 - edges();
    }

    int edgesToAdd(int supplementary) {
        int a = size() + supplementary;
        return a * (a - 1) / 2 - edges();
    }
}