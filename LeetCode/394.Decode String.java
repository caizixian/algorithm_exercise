public class Solution {
    class Result {
        int end;
        String body;

        Result(int end, String body) {
            this.end = end;
            this.body = body;
        }
    }

    private String repeat(String count, String pattern) {
        StringBuilder sb = new StringBuilder();
        if (count.length() == 0) {
            sb.append(pattern);
        }
        if (count.length() > 0) {
            for (int i = 0; i < Integer.parseInt(count); i++) {
                sb.append(pattern);
            }
        }
        return sb.toString();
    }

    public Result decodeString(String s, int start) {
        StringBuilder resultSb = new StringBuilder();
        StringBuilder prefixSb = new StringBuilder();
        StringBuilder bodySb = new StringBuilder();
        int i;
        for (i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (bodySb.length() != 0) {
                    resultSb.append(repeat(prefixSb.toString(), bodySb.toString()));
                    prefixSb.setLength(0);
                    bodySb.setLength(0);
                }
                prefixSb.append(ch);
            } else if (ch == '[') {
                Result r = decodeString(s, i + 1);
                bodySb.append(r.body);
                i = r.end;
                resultSb.append(repeat(prefixSb.toString(), bodySb.toString()));
                prefixSb.setLength(0);
                bodySb.setLength(0);
            } else if (ch == ']') {
                break;
            } else {
                bodySb.append(ch);
            }
        }
        resultSb.append(repeat(prefixSb.toString(), bodySb.toString()));
        return new Result(
                i,
                resultSb.toString());
    }

    public String decodeString(String s) {
        return decodeString(s, 0).body;
    }
}