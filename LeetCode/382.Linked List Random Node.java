import java.util.Random;

public class Solution {
    final private ListNode root;
    final private Random rand;
    private int idx = 1;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        root = head;
        rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        // Reservoir sampling
        ListNode result = root;
        ListNode current = root;

        int idx = 1;

        while (current != null) {
            int i = rand.nextInt(idx);
            if (i == 0) {
                result = current;
            }
            idx++;
            current = current.next;
        }
        return result.val;
    }
}
