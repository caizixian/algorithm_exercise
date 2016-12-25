import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    class LinkedListC {
        ListNode root;
        ListNode end;
        int size = 0;

        void add(int val) {
            ListNode toInsert = new ListNode(val);
            if (size == 0) {
                this.root = toInsert;
                this.end = this.root;
            } else {
                this.end.next = toInsert;
                this.end = this.end.next;
            }
            size++;
        }

        int poll() {
            int val = root.val;
            this.root = this.root.next;
            size--;
            return val;
        }

        int size() {
            return this.size;
        }

        void merge(LinkedListC other) {
            ListNode head, tail;
            head = new ListNode(Integer.MIN_VALUE);
            tail = head;
            ListNode l1 = root;
            ListNode l2 = other.root;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    tail = tail.next;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    tail = tail.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                tail.next = l1;
            } else {
                tail.next = l2;
            }
            this.root = head.next;
            this.size += other.size;
        }

        public String toString() {
            ListNode root = this.root;
            StringBuilder sb = new StringBuilder();
            while (root != null) {
                sb.append(root.val);
                sb.append(", ");
                root = root.next;
            }
            return sb.toString();
        }
    }

    class Event {
        int startTime;
        LinkedListC content;

        Event(int startTime, LinkedListC content) {
            this.startTime = startTime;
            this.content = content;
        }

        void simulate() {
            server.merge(content);
        }
    }

    private LinkedListC server;
    private PriorityQueue<Event> events;

    Solution(int server) {
        this.server = new LinkedListC();
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
            LinkedListC serverUsed = new LinkedListC();
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