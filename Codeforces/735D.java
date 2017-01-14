import java.math.BigInteger;
import java.util.*;

public class Solution {
    private static boolean isPrime(int num) {
        return BigInteger.valueOf(num).isProbablePrime(50);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int result;

        if (isPrime(num)) {
            result = 1;
        } else if (num % 2 == 0) {
            // Goldbach's conjecture
            // Even, not prime
            result = 2;
        } else {
            // Odd, not prime
            if (isPrime(num - 2)) {
                // Odd = Odd + Even
                // Only even prime number is 2
                result = 2;
            } else {
                result = 3;
            }
        }

        System.out.println(result);
    }
}