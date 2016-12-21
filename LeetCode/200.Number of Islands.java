class UF {
    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components

    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n - 1));
        }
    }
}

public class Solution {
    private int columns;
    private char[][] grid;

    private Integer toIdx(int i, int j) {
        return i * columns + j;
    }

    private Integer up(int i, int j) {
        if (i == 0) {
            return null;
        } else {
            if (grid[i - 1][j] == '1') {
                return toIdx(i - 1, j);
            } else {
                return null;
            }
        }
    }

    private Integer left(int i, int j) {
        if (j == 0) {
            return null;
        } else {
            if (grid[i][j - 1] == '1') {
                return toIdx(i, j - 1);
            } else {
                return null;
            }
        }
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;

        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        if (grid[0].length == 0) {
            return 0;
        }
        columns = grid[0].length;

        int waterCell = 0;

        UF uf = new UF(rows * columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '0') {
                    waterCell++;
                } else {
                    int idx = toIdx(i, j);
                    Integer up = up(i, j);
                    Integer left = left(i, j);
                    if (up != null) {
                        uf.union(idx, up);
                    }
                    if (left != null) {
                        uf.union(idx, left);
                    }
                }
            }
        }

        return uf.count() - waterCell;
    }
}