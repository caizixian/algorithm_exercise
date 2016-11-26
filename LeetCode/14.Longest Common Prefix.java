public class Solution {
    private String commonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            lcp = commonPrefix(lcp, strs[i]);
            if (lcp.equals("")) {
                break;
            }
        }
        return lcp;
    }
}