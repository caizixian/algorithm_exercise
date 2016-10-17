import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caizixian on 17/10/2016.
 */

public class LongestRepeatedSubstring {

    private static int longestCommonPrefix(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }

        return minLength;
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();

        String[] suffixes = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            suffixes[i] = str.substring(i);
        }

        Arrays.sort(suffixes);

        int longestRepeatedSubstringLength = 0;
        String longestRepeatedSubstring = "";
        for (int i = 0; i < suffixes.length - 1; i++) {
            int lcp = longestCommonPrefix(suffixes[i], suffixes[i + 1]);
            if (lcp > longestRepeatedSubstringLength) {
                longestRepeatedSubstringLength = lcp;
                longestRepeatedSubstring = suffixes[i].substring(0, lcp);
            }
        }

        System.out.printf("%d \"%s\"\n", longestRepeatedSubstringLength, longestRepeatedSubstring);
    }
}
