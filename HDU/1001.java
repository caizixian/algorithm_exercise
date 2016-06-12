import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNextLong()) {
            Long endWith = stdin.nextLong();
            System.out.println((1L + endWith) * endWith / 2L);
            System.out.println();
        }
    }
}