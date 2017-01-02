import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] division = new int[count];
        int[] change = new int[count];
        for (int i = 0; i < count; i++) {
            change[i] = in.nextInt();
            division[i] = in.nextInt();
        }

        long upperBound;
        long lowerBound;
        if (division[0] == 1) {
            lowerBound = 1900;
            upperBound = Integer.MAX_VALUE;
        } else {
            lowerBound = Integer.MIN_VALUE;
            upperBound = 1899;
        }

        for (int i = 0; i < count - 1; i++) {
            if (upperBound != Integer.MAX_VALUE) {
                upperBound += change[i];
            }

            if (lowerBound != Integer.MIN_VALUE) {
                lowerBound += change[i];
            }

            if (division[i + 1] == 1) {
                if (upperBound >= 1900) {
                    lowerBound = Math.max(1900, lowerBound);
                } else {
                    System.out.println("Impossible");
                    return;
                }
            } else {
                if (lowerBound <= 1899) {
                    upperBound = Math.min(upperBound, 1899);
                } else {
                    System.out.println("Impossible");
                    return;
                }
            }
        }

        if (upperBound != Integer.MAX_VALUE) {
            upperBound += change[count - 1];
        }

        if (lowerBound != Integer.MIN_VALUE) {
            lowerBound += change[count - 1];
        }

        if (upperBound == Integer.MAX_VALUE) {
            System.out.println("Infinity");
        } else {
            System.out.println(upperBound);
        }
    }
}