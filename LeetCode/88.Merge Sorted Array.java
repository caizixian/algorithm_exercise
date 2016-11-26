public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_ori = new int[m];

        System.arraycopy(nums1, 0, nums1_ori, 0, m);
        int ptr = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < m && ptr2 < n) {
            if (nums1_ori[ptr1] < nums2[ptr2]) {
                nums1[ptr] = nums1_ori[ptr1];
                ptr1++;
            } else {
                nums1[ptr] = nums2[ptr2];
                ptr2++;
            }
            ptr++;
        }
        while (ptr1 < m) {
            nums1[ptr] = nums1_ori[ptr1];
            ptr1++;
            ptr++;
        }
        while (ptr2 < n) {
            nums1[ptr] = nums2[ptr2];
            ptr2++;
            ptr++;
        }
    }
}