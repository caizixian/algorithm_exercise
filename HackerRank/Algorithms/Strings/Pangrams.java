import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine().trim().toLowerCase().replace(" ", "");
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (char i = 'a'; i <= 'z'; i++) {
            count.put(i, 0);
        }

        for (char ch : input_str.toCharArray()) {
            count.put(ch, count.get(ch) + 1);
        }

        boolean result = true;
        for (Integer value : count.values()) {
            if (value == 0) {
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}