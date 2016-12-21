import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Integer current;
    Iterator<Integer> iterator;


    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        fetchNext();
    }

    private void fetchNext() {
        if (iterator.hasNext()){
            current = iterator.next();
        }else{
            current = null;
        }
    }

    public Integer peek() {
        return current;
    }

    @Override
    public Integer next() {
        Integer result = current;
        fetchNext();
        return result;
    }

    @Override
    public boolean hasNext() {
        if (current == null){
            return iterator.hasNext();
        }else{
            return true;
        }
    }
}