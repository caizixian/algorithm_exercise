import java.util.*;
import java.io.*;

public class Solution {
    private String[] commentBody;
    private int[] commentChild;
    private List<String>[] comments;
    private int commentsSize;
    private PrintWriter out = new PrintWriter(System.out);

    private void input() {
        Scanner in = new Scanner(System.in);
        String input_str = in.next();

        String[] tokens = input_str.split(",");
        this.commentBody = new String[tokens.length / 2];
        this.commentChild = new int[tokens.length / 2];

        for (int i = 0; i < tokens.length / 2; i++) {
            commentBody[i] = tokens[i * 2];
            commentChild[i] = Integer.parseInt(tokens[i * 2 + 1]);
        }

        this.comments = new List[330000];
        this.commentsSize = 0;
    }

    private void appendComment(int level, String body) {
        if (level >= commentsSize) {
            comments[level] = new LinkedList<>();
            commentsSize++;
        }
        comments[level].add(body);
    }

    private int traverse(int idx, int level) {
        appendComment(level, commentBody[idx]);
        int childs = commentChild[idx];
        for (int i = 0; i < childs; i++) {
            idx = traverse(idx + 1, level + 1);
        }
        return idx;
    }

    private void output() {
        this.out.println(commentsSize);
        for (int i = 0; i < commentsSize; i++) {
            for (String comment : comments[i]) {
                this.out.print(comment + " ");
            }
            this.out.println();
        }
    }

    private Solution() {
        input();
        int idx = -1;
        while (idx + 1 < commentBody.length) {
            idx = traverse(idx + 1, 0);
        }
        output();
        out.close();
    }

    public static void main(String[] args) {
        new Solution();
    }
}