import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    private LinkedList<Integer> D;
    private LinkedList<Integer> R;
    private int count = 0;

    private void input() {
        D = new LinkedList<>();
        R = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        in.next();
        String factionStr = in.next();
        for (int i = 0; i < factionStr.length(); i++) {
            if (factionStr.charAt(i) == 'D') {
                D.add(count);
            } else {
                R.add(count);
            }
            count++;
        }
    }

    private void predict() {
        while (D.size() != 0 && R.size() != 0) {
            int d = D.removeFirst();
            int r = R.removeFirst();
            if (d < r) {
                D.add(count);
            } else {
                R.add(count);
            }
            count++;
        }
        if (D.size() != 0) {
            System.out.println("D");
        } else {
            System.out.println("R");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.input();
        s.predict();
    }
}