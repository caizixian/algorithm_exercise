import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    class Edge {
        String start;
        String end;
        double val;

        Edge(String start, String end, double val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        double getVal(String start) {
            if (start.equals(this.start)) {
                return val;
            } else {
                return 1.0 / val;
            }
        }

        String other(String start) {
            if (start.equals(this.start)) {
                return end;
            } else {
                return this.start;
            }
        }

        public String toString() {
            return start + " " + end + " " + val;
        }
    }

    class DFS {
        HashMap<String, LinkedList<Edge>> adjacencyList;
        HashMap<String, Double> result;

        DFS(HashMap<String, LinkedList<Edge>> adjacencyList) {
            this.adjacencyList = adjacencyList;
            this.result = new HashMap<>();
        }

        void dfs(String s) {
            dfs(s, 1.0);
        }

        void dfs(String s, double val) {
            if (adjacencyList.containsKey(s)) {
                result.put(s, val);
                for (Edge e : adjacencyList.get(s)) {
                    if (!result.containsKey(e.other(s))) {
                        dfs(e.other(s), val * e.getVal(s));
                    }
                }
            }
        }

        double getResult(String s) {
            if (result.containsKey(s)) {
                return result.get(s);
            } else {
                return -1.0;
            }
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, LinkedList<Edge>> adjacencyList = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            Edge e = new Edge(equation[0], equation[1], values[i]);
            adjacencyList.putIfAbsent(equation[0], new LinkedList<>());
            adjacencyList.putIfAbsent(equation[1], new LinkedList<>());
            adjacencyList.get(equation[0]).add(e);
            adjacencyList.get(equation[1]).add(e);
        }
        double[] result = new double[queries.length];
        HashMap<String, DFS> cache = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            if (cache.containsKey(query[0])) {
                DFS dfs = cache.get(query[0]);
                result[i] = dfs.getResult(query[1]);
            } else if (cache.containsKey(query[1])) {
                DFS dfs = cache.get(query[1]);
                result[i] = 1.0 / dfs.getResult(query[0]);
            } else {
                DFS dfs = new DFS(adjacencyList);
                dfs.dfs(query[0]);
                double r = dfs.getResult(query[1]);
                result[i] = r;
                cache.put(query[0], dfs);
            }
        }
        return result;
    }
}