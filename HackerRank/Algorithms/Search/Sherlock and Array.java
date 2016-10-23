import java.util.Scanner;

public class Solution {

    private static boolean checkArray(int[] a) {
        if (a.length == 1) {
            return true;
        }
        int leftsum = 0;
        int rightsum = 0;

        for (int i = 1; i <= a.length - 1; i++) {
            rightsum += a[i];
        }

        for (int i = 0; i <= a.length - 2; i++) {
            leftsum += a[i];
            rightsum -= a[i + 1];
            if (leftsum == rightsum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[] a = new int[size];
            for (int j = 0; j < size; j++) {
                a[j] = in.nextInt();
            }
            if (checkArray(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}