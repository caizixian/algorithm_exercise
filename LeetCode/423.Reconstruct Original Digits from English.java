public class Solution {
    public String originalDigits(String s) {
        int[] alphaCount = new int[26];
        int[] digitCount = new int[10];
        for (char c : s.toCharArray()) {
            alphaCount[c - 'a']++;
        }
        digitCount[0] = alphaCount['z' - 'a'];
        digitCount[2] = alphaCount['w' - 'a'];
        digitCount[4] = alphaCount['u' - 'a'];
        digitCount[6] = alphaCount['x' - 'a'];
        digitCount[8] = alphaCount['g' - 'a'];
        digitCount[5] = alphaCount['f' - 'a'] - digitCount[4];
        digitCount[7] = alphaCount['v' - 'a'] - digitCount[5];
        digitCount[9] = alphaCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8];
        digitCount[3] = alphaCount['r' - 'a'] - digitCount[4] - digitCount[0];
        digitCount[1] = alphaCount['o' - 'a'] - digitCount[0] - digitCount[4] - digitCount[2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 1; j <= digitCount[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}