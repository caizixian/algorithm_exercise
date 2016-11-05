import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ribbon_len = in.nextInt();

        HashMap<Integer, Integer> max_value = new HashMap<>();


        for (int i = 0; i < 3; i++) {
            max_value.put(in.nextInt(), 1);
        }

        Integer[] possible_lens = max_value.keySet().toArray(new Integer[max_value.size()]);

        for (int i = 0; i <= ribbon_len; i++) {
            for (Integer a_possible_len : possible_lens) {
                if (max_value.containsKey(i - a_possible_len)) {
                    // A valid case
                    if (!max_value.containsKey(i) || max_value.get(i - a_possible_len) + 1 > max_value.get(i)) {
                        {
                            max_value.put(i, max_value.get(i - a_possible_len) + 1);
                        }
                    }
                }
            }
        }

        System.out.println(max_value.getOrDefault(ribbon_len, 0));

    }
}