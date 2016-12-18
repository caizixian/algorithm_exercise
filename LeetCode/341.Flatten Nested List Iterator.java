import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class NestedIterator implements Iterator<Integer> {
    // Without speculating about implementation of NestedInteger,
    // whose list might be implemented using LinkedList instead of ArrayList, and
    // therefore tends to be slow when being accessed using index, we can achieve
    // better performance when encountering worst case of scenario.
    private final Deque<Iterator<NestedInteger>> stack = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.addFirst(nestedList.iterator());
    }

    @Override
    public Integer next() {
        Iterator<NestedInteger> topIter = stack.peekFirst();
        if (topIter.hasNext()) {
            NestedInteger nextItem = topIter.next();
            if (nextItem.isInteger()) {
                return nextItem.getInteger();
            } else {
                stack.addFirst(nextItem.getList().iterator());
                return next();
            }
        } else {
            stack.removeFirst();
            return next();
        }
    }

    @Override
    public boolean hasNext() {
        if (stack.size() == 0) {
            return false;
        } else {
            Iterator<NestedInteger> topIter = stack.peekFirst();
            if (topIter.hasNext()) {
                NestedInteger nextItem = topIter.next();
                if (nextItem.isInteger()) {
                    if (!topIter.hasNext()) {
                        stack.removeFirst();
                    }
                    LinkedList<NestedInteger> placeholder = new LinkedList<>();
                    placeholder.add(nextItem);
                    stack.addFirst(placeholder.iterator());
                    return true;
                } else {
                    stack.addFirst(nextItem.getList().iterator());
                    return hasNext();
                }
            } else {
                stack.removeFirst();
                return hasNext();
            }
        }
    }
}