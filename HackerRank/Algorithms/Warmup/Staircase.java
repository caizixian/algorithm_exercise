import java.util.Scanner;

public class Solution {

    static void printRepeat(int n, char c) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            printRepeat(n - i, ' ');
            printRepeat(i, '#');
            System.out.print("\n");
        }
    }
}