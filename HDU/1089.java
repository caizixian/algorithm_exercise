import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNextLong()) {
            Long a = stdin.nextLong();
            Long b;
            if (stdin.hasNextLong()) {
                b = stdin.nextLong();
                System.out.println(a + b);
            }
        }
    }
}