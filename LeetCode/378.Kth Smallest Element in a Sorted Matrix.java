import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (max_heap.size() < k) {
                    max_heap.add(row[i]);
                } else {
                    // use 0~i-1 to fill the heap
                    int idx = Arrays.binarySearch(row, i, row.length, max_heap.peek());
                    if (idx < 0) {
                        idx = -(idx + 1); // insertion point
                    }
                    for (int j = i; j < idx; j++) {
                        max_heap.add(row[j]);
                        if (max_heap.size() > k) {
                            max_heap.poll();
                        }
                    }
                    break;
                }
            }
        }
        return max_heap.peek();
    }
}