import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int search = in.nextInt();
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            if (in.nextInt() == search) {
                System.out.println(i);
            }
        }
    }
}