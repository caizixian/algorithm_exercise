import java.util.HashMap;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> abCount = new HashMap<>();
        HashMap<Integer, Integer> cdCount = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                abCount.merge(a + b, 1, (v, one) -> v + one);
            }
        }
        for (int c : C) {
            for (int d : D) {
                cdCount.merge(-(c + d), 1, (v, one) -> v + one);
            }
        }
        for (HashMap.Entry<Integer, Integer> e : abCount.entrySet()) {
            count += cdCount.getOrDefault(e.getKey(), 0) * e.getValue();
        }
        return count;
    }
}