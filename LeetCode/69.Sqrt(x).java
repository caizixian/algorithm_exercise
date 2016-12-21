public class Solution {
    private boolean goodEnough(double target, double guess) {
        return Math.abs(target - guess * guess) < 0.1;
    }

    private double improve(double target, double guess) {
        return (guess + (target / guess)) / 2;
    }

    public int mySqrt(int x) {
        double guess = 1;
        while (!goodEnough(x, guess)) {
            guess = improve(x, guess);
        }
        return (int) guess;
    }
}