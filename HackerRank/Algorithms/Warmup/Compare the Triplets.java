import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int[] alice = new int[3];
        int[] bob = new int[3];

        for (int i = 0; i < 3; i++) {
            alice[i] = in.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            bob[i] = in.nextInt();
        }

        int alice_pt = 0;
        int bob_pt = 0;
        for (int i = 0; i < 3; i++) {
            if (alice[i] > bob[i]) {
                alice_pt++;
            } else if (bob[i] > alice[i]) {
                bob_pt++;
            }
        }

        System.out.printf("%d %d", alice_pt, bob_pt);
    }
}