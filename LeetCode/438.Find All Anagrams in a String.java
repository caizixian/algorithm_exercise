import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> count = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (char c : p.toCharArray()) {
            count.merge(c, 1, (v, one) -> v + one);
        }
        int add_start = 0;
        int add_end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.compute(s.charAt(i), (k, v) -> v - 1 == 0 ? null : v - 1);
                add_end = i + 1;

                if (count.size() == 0) {
                    result.add(i - p.length() + 1);
                    add_start = i - p.length() + 2;
                    // Add back s[i-p.length()+1]
                    count.put(s.charAt(i - p.length() + 1), 1);
                }
            } else {
                if (s.charAt(add_start) == s.charAt(i)) {
                    add_start++;
                } else {
                    for (int j = add_start; j < add_end; j++) {
                        // Put back all previous valid one
                        count.merge(s.charAt(j), 1, (v, one) -> v + one);
                    }
                    add_start = add_end = i + 1;
                }
            }
        }
        return result;
    }
}