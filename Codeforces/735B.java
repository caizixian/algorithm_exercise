import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int people = in.nextInt();
        int size1 = in.nextInt();
        int size2 = in.nextInt();
        int minSize = Math.min(size1, size2);
        int maxSize = Math.max(size1, size2);

        Integer[] wealth = new Integer[people];

        for (int i = 0; i < people; i++) {
            wealth[i] = in.nextInt();
        }

        Arrays.sort(wealth, Collections.reverseOrder());

        double sumMin = 0;
        double sumMax = 0;

        for (int i = 0; i < minSize; i++) {
            sumMin += wealth[i];
        }

        for (int i = minSize; i < minSize + maxSize; i++) {
            sumMax += wealth[i];
        }

        double result = sumMin / minSize + sumMax / maxSize;

        System.out.println(result);
    }
}