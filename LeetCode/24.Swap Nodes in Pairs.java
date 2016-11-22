public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        if (second == null){
            return first;
        }
        ListNode tail = head.next.next;
        second.next = first;
        first.next = swapPairs(tail);
        return second;
    }
}