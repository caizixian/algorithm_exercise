import java.util.Scanner;


public class Solution {

    public static int calc_non_contiguous(int[] a) {
        int sum = 0;
        int max_elem = -2147483600;
        boolean selected = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max_elem) {
                max_elem = a[i];
            }
            if (a[i] > 0) {
                sum += a[i];
                selected = true;
            }
        }
        if (selected) {
            return sum;
        }
        return max_elem;
    }

    public static int calc_contiguous(int[] a) {
        int max_sum = a[0]; // The subarray and subsequences you consider should have at least one element.
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max_sum + a[i] > a[i]) {
                max_sum += a[i];
            } else {
                max_sum = a[i];
            }

            if (max_sum > max) {
                max = max_sum;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int i = 0; i < testcases; i++) {
            int problem_size = in.nextInt();
            int[] num = new int[problem_size];
            for (int j = 0; j < problem_size; j++) {
                num[j] = in.nextInt();
            }
            System.out.printf("%d %d\n", calc_contiguous(num), calc_non_contiguous(num));
        }
    }
}