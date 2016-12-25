import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    class Event {
        int startTime;
        LinkedList<Integer> content;

        Event(int startTime, LinkedList<Integer> content) {
            this.startTime = startTime;
            this.content = content;
        }

        void simulate() {
            while (content.size() > 0) {
                server.add(content.poll());
            }
        }
    }

    private PriorityQueue<Integer> server;
    private PriorityQueue<Event> events;

    Solution(int server) {
        this.server = new PriorityQueue<>();
        this.events = new PriorityQueue<>(Comparator.comparingInt(a -> a.startTime));
        for (int i = 1; i <= server; i++) {
            this.server.add(i);
        }
    }

    private int schedule(int startTime, int serverCount, int duration) {
        while (events.size() > 0 && events.peek().startTime <= startTime) {
            events.poll().simulate();
        }
        if (serverCount <= server.size()) {
            int idSum = 0;
            LinkedList<Integer> serverUsed = new LinkedList<>();
            for (int i = 0; i < serverCount; i++) {
                int server = this.server.poll();
                idSum += server;
                serverUsed.add(server);
            }
            events.add(new Event(startTime + duration, serverUsed));
            return idSum;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int server = in.nextInt();
        int caseSize = in.nextInt();
        Solution s = new Solution(server);
        for (int i = 0; i < caseSize; i++) {
            int startTime = in.nextInt();
            int serverCount = in.nextInt();
            int duration = in.nextInt();
            System.out.println(s.schedule(startTime, serverCount, duration));
        }
    }
}