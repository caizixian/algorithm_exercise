import java.util.LinkedList;

public class MinStack {

    final private LinkedList<Integer> min_element;
    final private LinkedList<Integer> stack;

    public MinStack() {
        min_element = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_element.isEmpty() || min_element.peek() > x) {
            min_element.push(x);
        } else {
            min_element.push(min_element.peek());
        }
    }

    public void pop() {
        stack.pop();
        min_element.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_element.peek();
    }
}