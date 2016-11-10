public class Solution {
    public ListNode traverse(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }
        int sum;
        int new_carry = 0;
        ListNode next;
        if (l1 == null) {
            sum = l2.val + carry;
            if (sum > 9) {
                new_carry = 1;
                sum = sum % 10;
            }
            next = traverse(null, l2.next, new_carry);
        } else if (l2 == null) {
            sum = l1.val + carry;
            if (sum > 9) {
                new_carry = 1;
                sum = sum % 10;
            }
            next = traverse(null, l1.next, new_carry);
        } else {
            sum = l1.val + l2.val + carry;
            if (sum > 9) {
                new_carry = 1;
                sum = sum % 10;
            }
            next = traverse(l1.next, l2.next, new_carry);
        }
        ListNode result = new ListNode(sum);
        if (next != null) {
            result.next = next;
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return traverse(l1, l2, 0);
    }
}