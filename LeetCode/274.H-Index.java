import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hindex = 0;
        // The definition of the index is that a scholar with an index of h has
        // published h papers each of which has been cited in other papers at
        // least h times.
        for (int i = 1; i <= citations.length; i++) {
            if (i <= citations[citations.length - i]) {
                hindex = i;
            }
        }
        return hindex;
    }
}