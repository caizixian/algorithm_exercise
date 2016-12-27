import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pixels = in.nextInt();
        int maxWPixel = (int) Math.sqrt(pixels);
        for (int i = maxWPixel; i >= 1; i--) {
            if (pixels % i == 0) {
                System.out.print(i + " " + pixels / i);
                return;
            }
        }
    }
}