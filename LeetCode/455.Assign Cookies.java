import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int satisfied_children = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                satisfied_children++; //Satisfied
                i++; // Move on to the next child
            }
            j++; // Move on to the next cookie
        }
        return satisfied_children;
    }
}