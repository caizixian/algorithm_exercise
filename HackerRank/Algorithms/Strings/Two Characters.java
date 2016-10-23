import java.util.Scanner;

public class Solution {

    private static boolean isTwoChar(String s) {
        if (s.length() < 2) {
            return false;
        }
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        if (c1 == c2) {
            return false;
        }
        for (int i = 0; i < s.length() - 2; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i + 2) != c1) {
                    return false;
                }
            } else {
                if (s.charAt(i + 2) != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String filteredString(String s, char c1, char c2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1 || s.charAt(i) == c2) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        in.nextLine();
        String input_str = in.nextLine().trim();
        int max_length = 0;
        String temp;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                temp = filteredString(input_str, i, j);
                if (isTwoChar(temp) && temp.length() > max_length) {
                    max_length = temp.length();
                }
            }
        }

        System.out.print(max_length);
    }
}