// Iterator Pattern
import java.util.ArrayList;
import java.util.List;

interface Iterator {
    Object next();
    boolean hasNext();
}

interface Aggregate {
    Iterator createIterator();
}

class ConcreteIterator implements Iterator {
    private List<Object> collection;
    private int position = 0;
    
    public ConcreteIterator(List<Object> collection) {
        this.collection = collection;
    }
    
    @Override
    public Object next() {
        if (hasNext()) {
            Object item = collection.get(position);
            position++;
            return item;
        }
        throw new IndexOutOfBoundsException("No more elements");
    }
    
    @Override
    public boolean hasNext() {
        return position < collection.size();
    }
}

class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();
    
    public void addItem(Object item) {
        items.add(item);
    }
    
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}

// Usage
class IteratorDemo {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");
        
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
