public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            if (current.val != tail.val) {
                tail = current;
            } else {
                tail.next = current.next;
            }
        }
        return head;
    }
}