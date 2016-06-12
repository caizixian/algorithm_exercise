import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNextLine()) {
            String line = stdin.nextLine();
            String[] numbers = line.split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            System.out.println(a + b);
        }
    }
}