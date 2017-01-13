import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long players = in.nextLong();
        long fibA = 1, fibB = 1, fibIdx = 0;

        while (fibB <= players) {
            long temp = fibB;
            fibB = fibA + fibB;
            fibA = temp;
            fibIdx++;
        }

        System.out.println(fibIdx - 1);
    }
}