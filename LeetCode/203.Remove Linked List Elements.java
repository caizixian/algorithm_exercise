public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr.next != null) {
            if (ptr.next.val != val) {
                ptr = ptr.next;
            } else {
                ptr.next = ptr.next.next;
            }
        }
        return dummy.next;
    }
}