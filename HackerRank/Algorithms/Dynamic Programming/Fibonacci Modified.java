import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BigInteger t1 = new BigInteger(in.next());
        BigInteger t2 = new BigInteger(in.next());
        int n = in.nextInt();
        for (int i = 0; i < n - 2; i++) {
            BigInteger temp = t2;
            t2 = t1.add(t2.multiply(t2));
            t1 = temp;
        }

        System.out.println(t2);
    }
}