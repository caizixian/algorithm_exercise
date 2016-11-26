import java.util.LinkedList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr);
            ptr = ptr.next;
        }
        list.add(null);
        int idx_del = list.size() - 1 - n;
        if (idx_del == 0) {
            return head.next;
        } else {
            list.get(idx_del - 1).next = list.get(idx_del + 1);
        }
        return head;
    }
}