public class Solution {
    public int countPrimes(int n) {
        // Count the number of prime numbers less than a non-negative number, n.
        if (n <= 2) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) { // Is prime
                for (int j = 0; i * i + j * i < n; j++) {
                    notPrime[i * i + j * i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}