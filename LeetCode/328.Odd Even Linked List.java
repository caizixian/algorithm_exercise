public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode even_start = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while (odd != null && even != null) {
            if (even.next == null) {
                break;
            }
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = even_start;
        return head;
    }
}