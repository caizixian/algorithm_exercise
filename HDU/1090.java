import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        int caseCount = Integer.parseInt(stdin.nextLine());
        for (int i = 1; i <= caseCount; i++) {
            String line = stdin.nextLine();
            String[] numbers = line.split(" ");
            BigInteger a = new BigInteger(numbers[0]);
            BigInteger b = new BigInteger(numbers[1]);
            System.out.println(a.add(b));
        }
    }
}