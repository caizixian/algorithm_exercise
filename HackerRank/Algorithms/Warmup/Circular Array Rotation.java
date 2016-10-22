import java.util.Scanner;
import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            ad.add(in.nextInt());
        }

        // Perform rotations
        for (int i = 0; i < k; i++) {
            ad.addFirst(ad.pollLast());
        }

        Integer[] result = new Integer[n];
        ad.toArray(result);
        
        for (int i = 0; i < q; i++) {
            System.out.println(result[in.nextInt()]);
        }
    }
}