public class Solution {
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head; // p.tail = head
        head.next = null;
        return p;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // Find another half (slow.next)
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = reverseList(slow.next);
        while (middle != null) {
            if (middle.val != head.val) {
                return false;
            }
            middle = middle.next;
            head = head.next;
        }
        return true;
    }
}