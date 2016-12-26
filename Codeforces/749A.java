import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = n / 2;
        System.out.println(n / 2);
        if (n % 2 == 0) {
            for (int i = 1; i <= count; i++) {
                System.out.print(2);
                System.out.print(' ');
            }
        } else {
            for (int i = 1; i < count; i++) {
                System.out.print(2);
                System.out.print(' ');
            }
            System.out.println(3);
        }
    }
}