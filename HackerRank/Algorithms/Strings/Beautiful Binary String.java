import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Character> char_lst = new ArrayList<>();
        in.nextLine();
        String input_str = in.nextLine().trim();
        for (int i = 0; i < input_str.length(); i++) {
            char_lst.add(input_str.charAt(i));
        }
        int operation_count = 0;
        for (int i = 0; i < char_lst.size() - 2; i++) {
            if (char_lst.get(i) == '0' && char_lst.get(i + 1) == '1' && char_lst.get(i + 2) == '0') {
                char_lst.set(i + 2, '1');
                operation_count++;
            }
        }

        System.out.println(operation_count);
    }
}