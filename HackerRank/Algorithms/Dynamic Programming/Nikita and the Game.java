import java.util.ArrayDeque;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;


class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}

public class Solution {


    class State {
        int i, j, score;

        State(int i, int j, int score) {
            this.i = i;
            this.j = j;
            this.score = score;
        }
    }

    public static int nikita(int[] a) {
        int[] sum = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        ArrayDeque<State> stack = new ArrayDeque<>();

        stack.push(new Solution().new State(0, a.length - 1, 0));
        int max_score = 0;
        while (!stack.isEmpty()) {
            State s = stack.pop();
            boolean ends = true;
            for (int idx = s.i; idx < s.j; idx++) {
                if (sum[idx + 1] - sum[s.i] == sum[s.j + 1] - sum[idx + 1]) {
                    ends = false;
                    stack.push(new Solution().new State(s.i, idx, s.score + 1));
                    stack.push(new Solution().new State(idx + 1, s.j, s.score + 1));
                    break;
                }
            }
            if (ends) {
                if (s.score > max_score) {
                    max_score = s.score;
                }
            }
        }

        return max_score;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int testcases = in.nextInt();
        for (int i = 0; i < testcases; i++) {
            int problem_size = in.nextInt();
            int[] num = new int[problem_size];
            for (int j = 0; j < problem_size; j++) {
                num[j] = in.nextInt();
            }
            System.out.println(nikita(num));
        }
    }
}