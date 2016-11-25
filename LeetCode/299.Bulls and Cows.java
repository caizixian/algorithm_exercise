public class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        boolean[] isBull = new boolean[guess.length()];

        int bull = 0;// A
        int cow = 0;// B

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                isBull[i] = true;
            } else {
                count[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (!isBull[i]) {
                if (count[guess.charAt(i) - '0'] > 0) {
                    count[guess.charAt(i) - '0']--;
                    cow++;
                }
            }
        }

        return bull + "A" + cow + "B";
    }
}