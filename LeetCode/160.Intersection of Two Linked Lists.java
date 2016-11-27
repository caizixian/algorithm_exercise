public class Solution {
    private int listLength(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = listLength(headA);
        int lengthB = listLength(headB);
        int lengthDiff = Math.abs(lengthA - lengthB);
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        if (lengthA > lengthB) {
            int i = 0;
            while (i < lengthDiff) {
                ptr1 = ptr1.next;
                i++;
            }
        } else {
            int i = 0;
            while (i < lengthDiff) {
                ptr2 = ptr2.next;
                i++;
            }
        }

        while (ptr1 != null && ptr2 != null) {
            if (ptr1 == ptr2) {
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
}