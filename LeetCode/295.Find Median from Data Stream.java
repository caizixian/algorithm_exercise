import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    private PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (min_heap.size() == 0 && max_heap.size() == 0) {
            max_heap.add(num);
            return;
        }
        if (num < max_heap.peek()) { // Add new element
            max_heap.add(num);
        } else {
            min_heap.add(num);
        }

        if (Math.abs(max_heap.size() - min_heap.size()) > 1) { // Rebalance
            if (max_heap.size() > min_heap.size()) {
                min_heap.add(max_heap.poll());
            } else {
                max_heap.add(min_heap.poll());
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (min_heap.size() == max_heap.size()) {
            // if k is even, then mk is the (k/2)th smallest
            // number among x1,…,xk
            return ((double)max_heap.peek()+min_heap.peek())/2;
        } else if (min_heap.size() > max_heap.size()) {
            return min_heap.peek();
        } else {
            return max_heap.peek();
        }
    }
}