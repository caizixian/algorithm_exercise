import java.util.*;

public class Solution {
    private static int mapping(int encoded, int len) {
        boolean isEven = len % 2 == 0;
        if (isEven) {
            if (encoded % 2 == 0) {
                return len / 2 - 1 - encoded / 2;
            } else {
                return len / 2 + encoded / 2;
            }
        } else {
            if (encoded % 2 == 0) {
                return len / 2 + encoded / 2;
            } else {
                return len / 2 - 1 - encoded / 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String encoded = in.nextLine().trim();
        int len = encoded.length();
        char[] decoded = new char[len];

        for (int i = 0; i < len; i++) {
            decoded[mapping(i, len)] = encoded.charAt(i);
        }

        for (char ch : decoded) {
            System.out.print(ch);
        }
    }
}