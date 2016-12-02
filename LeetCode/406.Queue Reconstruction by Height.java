import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people first by their heights (higher, larger) and
        // then people in front of them (a.k.a "index") (less, larger)
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        ArrayList<int[]> queue = new ArrayList();
        for (int[] person : people) {
            // we can insert a person without affecting inserted people
            // but we need to consider his/her "index"
            int index = person[1];
            queue.add(index, person);
        }
        return queue.toArray(new int[people.length][2]);
    }
}