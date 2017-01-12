import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int jumpAbility = in.nextInt();

        boolean[] reachable = new boolean[size];
        boolean[] visited = new boolean[size];
        boolean[] hasObstacles = new boolean[size];

        String cells = in.next();

        int start = -1;
        int target = -1;

        for (int i = 0; i < cells.length(); i++) {
            switch (cells.charAt(i)) {
                case '#':
                    hasObstacles[i] = true;
                    break;
                case 'G':
                    start = i;
                    break;
                case 'T':
                    target = i;
                    break;
                default:
                    break;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int toVisit = queue.poll();
            visited[toVisit] = true;
            if (hasObstacles[toVisit]) {
                continue; // Has obstacles, invalid
            }
            reachable[toVisit] = true;

            int left = toVisit - jumpAbility;
            int right = toVisit + jumpAbility;

            if (left >= 0 && left < size && !visited[left]) {
                queue.add(left);
            }

            if (right >= 0 && right < size && !visited[right]) {
                queue.add(right);
            }
        }

        if (reachable[target]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}