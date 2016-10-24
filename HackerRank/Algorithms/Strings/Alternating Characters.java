import java.util.Scanner;

public class Solution {

    private static int calc_oper_count(String s) {
        int oper_count = 0;
        int i, j;
        for (i = 0; i < s.length(); i++) {
            for (j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    oper_count++;
                } else {
                    break;
                }
            }
            i = j - 1;
        }
        return oper_count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n; i++) {
            System.out.println(calc_oper_count(in.nextLine().trim()));
        }
    }
}