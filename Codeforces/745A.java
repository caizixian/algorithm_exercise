import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        HashSet<String> variants = new HashSet<>();
        Scanner in = new Scanner(System.in);
        String originalString = in.next();
        for (int i = 0; i < originalString.length(); i++) {
            variants.add(originalString.substring(i, originalString.length()) + originalString.substring(0, i));
        }
        System.out.print(variants.size());
    }
}