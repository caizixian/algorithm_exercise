public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= 26) {
            sb.insert(0, (char) ('A' + n - 1));
            return sb.toString();
        }
        while (n > 26) {
            if (n % 26 == 0) {
                sb.insert(0, 'Z');
                n /= 26;
                n--;
            } else {
                sb.insert(0, (char) ('A' + n % 26 - 1));
                n /= 26;
            }
        }
        if (n == 26)
            sb.insert(0, 'Z');
        else
            sb.insert(0, (char) ('A' + n % 26 - 1));
        return sb.toString();
    }
}