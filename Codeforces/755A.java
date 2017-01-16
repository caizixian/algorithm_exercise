import java.math.BigInteger;
import java.util.*;

public class Solution {
    private static boolean isPrime(int num) {
        return BigInteger.valueOf(num).isProbablePrime(50);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i = 1; i <= 1000; i++) {
            if (!isPrime(num * i + 1)) {
                System.out.println(i);
                return;
            }
        }
    }
}