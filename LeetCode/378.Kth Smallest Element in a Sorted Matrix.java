import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] i : matrix) {
            for (int j : i) {
                heap.add(j);
            }
        }
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.peek();
    }
}