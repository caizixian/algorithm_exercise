import java.util.Arrays;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapping = new int[256];
        boolean[] used = new boolean[256];
        Arrays.fill(mapping, -1); // Map ascii i to mapping[i]

        for (int i = 0; i < s.length(); i++) {
            if (mapping[(int) s.charAt(i)] == -1 && !used[(int) t.charAt(i)]) {
                mapping[(int) s.charAt(i)] = (int) t.charAt(i);
                used[(int) t.charAt(i)] = true;
            } else {
                if (mapping[(int) s.charAt(i)] != (int) t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}