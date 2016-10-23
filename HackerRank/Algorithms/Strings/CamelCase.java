import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine().trim();
        int word_count = 1;
        for (int i = 0; i < input_str.length(); i++) {
            if ('A' <= input_str.charAt(i) && input_str.charAt(i) <= 'Z') {
                word_count++;
            }
        }
        System.out.print(word_count);
    }
}