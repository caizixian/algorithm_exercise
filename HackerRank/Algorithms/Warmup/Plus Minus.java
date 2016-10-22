import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int temp;
        float positive_count = 0, zero_count = 0, negative_count = 0;
        for (int i = 0; i < n; i++) {
            temp = in.nextInt();
            if (temp > 0) {
                positive_count++;
            } else if (temp == 0) {
                zero_count++;
            } else {
                negative_count++;
            }
        }

        System.out.printf("%.6f\n%.6f\n%.6f", positive_count / n, negative_count / n, zero_count / n);
    }
}