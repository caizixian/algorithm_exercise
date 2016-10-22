import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        // Calc primary diag

        int primary_sum = 0;
        for (int i = 0; i < n; i++) {
            primary_sum += matrix[i][i];
        }

        // Calc secondary diag
        
        int secondary_sum = 0;
        for (int i = 0; i < n; i++) {
            secondary_sum += matrix[i][n - 1 - i];
        }

        System.out.println(Math.abs(primary_sum - secondary_sum));
    }
}