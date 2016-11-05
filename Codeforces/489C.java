import java.util.Scanner;

public class Solution {

    public static void max(int length, int sum) {
        int[] numbers = new int[length];
        numbers[0] = 1;
        sum -= 1;
        for (int i = 0; i < length && sum > 0; i++) {
            if (sum > 9 - numbers[i]) {
                sum -= 9 - numbers[i];
                numbers[i] = 9;
            } else {
                numbers[i] += sum;
                sum = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i]);
        }
    }

    public static void min(int length, int sum) {
        int[] numbers = new int[length];
        numbers[0] = 1;
        sum -= 1;
        for (int i = length - 1; i >= 0 && sum > 0; i--) {
            if (sum > 9 - numbers[i]) {
                sum -= 9 - numbers[i];
                numbers[i] = 9;
            } else {
                numbers[i] += sum;
                sum = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int sum = in.nextInt();
        if (sum == 0) {
            // Given sum is too small considering the length of the number
            if (length == 1) {
                System.out.println("0 0");
            } else {
                System.out.println("-1 -1");
            }
        } else {
            if (sum > 9 * length) {
                // Given sum is too large considering the length of the number
                System.out.println("-1 -1");
            } else {
                min(length, sum);
                System.out.print(" ");
                max(length, sum);
            }
        }
    }
}