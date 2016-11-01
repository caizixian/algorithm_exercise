import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine().trim();

        int min_jump_ability = 0;

        int previous_location = -1;
        for (int i = 0; i < input_str.length(); i++) {

            if ("AEIOUY".indexOf(input_str.charAt(i)) >= 0) { // 'Y' is vowel as well
                // Is vowel
                int required_jump = i - previous_location;
                previous_location = i;
                if (required_jump > min_jump_ability) {
                    min_jump_ability = required_jump;
                }
            }

        }

        // Check the end of string
        if (input_str.length() - previous_location > min_jump_ability) {
            min_jump_ability = input_str.length() - previous_location;
        }

        System.out.println(min_jump_ability);
    }
}