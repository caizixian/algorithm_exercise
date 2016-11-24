public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int current = low + (high - low) / 2;
            int result = guess(current);
            if (result == 0) {
                return current;
            }
            if (result == 1) {
                low = current + 1;

            } else {
                high = current - 1;
            }
        }
        return -1;
    }
}