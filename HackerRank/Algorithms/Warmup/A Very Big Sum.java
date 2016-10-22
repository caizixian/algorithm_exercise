import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            sum = sum.add(new BigInteger(in.next()));
        }
        System.out.println(sum);
    }
}