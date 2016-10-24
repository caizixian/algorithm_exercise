import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Character> char_lst = new ArrayList<>();
        String input_str = in.nextLine().trim();
        for (int i = 0; i < input_str.length(); i++) {
            char_lst.add(input_str.charAt(i));
        }

        for (int i = 0; i < char_lst.size() - 1; i++) {
            if (char_lst.get(i) == char_lst.get(i + 1)) {
                char_lst.remove(i);
                char_lst.remove(i); // remove a pair of adjacent letters
                if (i != 0) {
                    i -= 2;
                } else {
                    i -= 1;
                }
            }
        }

        if (char_lst.size() == 0) {
            System.out.print("Empty String");
        } else {
            for (Character c : char_lst) {
                System.out.print(c);
            }
        }
    }
}