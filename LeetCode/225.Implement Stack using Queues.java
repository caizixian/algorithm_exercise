import java.util.LinkedList;

class MyStack {
    LinkedList<Integer> inbox = new LinkedList<>();
    LinkedList<Integer> outbox = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        inbox.addLast(x);
        while (!outbox.isEmpty()) {
            inbox.addLast(outbox.pollFirst());
        }
        LinkedList temp = inbox;
        inbox = outbox;
        outbox = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        outbox.removeFirst();
    }

    // Get the top element.
    public int top() {
        return outbox.getFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return outbox.isEmpty();
    }
}