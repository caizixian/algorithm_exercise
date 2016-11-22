import java.util.LinkedList;

class MyQueue {
    // Push element x to the back of queue.

    final LinkedList<Integer> inbox = new LinkedList();
    final LinkedList<Integer> outbox = new LinkedList();

    public void push(int x) {
        inbox.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        outbox.pop();
    }

    // Get the front element.
    public int peek() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }
}