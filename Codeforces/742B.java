import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int target = in.nextInt();
        HashMap<Integer, Integer> count = new HashMap<>();
        long result = 0;
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = in.nextInt();
            count.merge(num[i], 1, (_a, _b) -> _a + _b);
        }

        for (int i = 0; i < size; i++) {
            int counterPart = num[i] ^ target;
            if (count.containsKey(counterPart)) {
                if (counterPart == num[i]) {
                    result += count.get(counterPart) - 1;
                } else {
                    result += count.get(counterPart);
                }
            }
        }

        System.out.println(result / 2);
    }
}