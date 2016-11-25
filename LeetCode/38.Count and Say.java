public class Solution {
    private String toSay(String s) {
        int num = s.charAt(0) - '0';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == num) {
                count++;
            } else {
                sb.append(count).append(num);
                num = s.charAt(i) - '0';
                count = 1;
            }
        }
        sb.append(count).append(num);
        return sb.toString();
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = toSay(s);
        }
        return s;
    }
}