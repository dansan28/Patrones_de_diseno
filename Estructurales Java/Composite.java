// Composite Pattern
import java.util.ArrayList;
import java.util.List;

abstract class Component {
    public abstract String operation();
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract Component getChild(int index);
}

class Leaf extends Component {
    private String name;
    
    public Leaf(String name) {
        this.name = name;
    }
    
    @Override
    public String operation() {
        return "Leaf " + name;
    }
    
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to leaf");
    }
    
    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from leaf");
    }
    
    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Leaf has no children");
    }
}

class Composite extends Component {
    private String name;
    private List<Component> children = new ArrayList<>();
    
    public Composite(String name) {
        this.name = name;
    }
    
    @Override
    public String operation() {
        StringBuilder result = new StringBuilder("Composite " + name);
        for (Component child : children) {
            result.append("\n").append(child.operation());
        }
        return result.toString();
    }
    
    @Override
    public void add(Component component) {
        children.add(component);
    }
    
    @Override
    public void remove(Component component) {
        children.remove(component);
    }
    
    @Override
    public Component getChild(int index) {
        return children.get(index);
    }
}

// Usage
class CompositeDemo {
    public static void main(String[] args) {
        Composite tree = new Composite("root");
        Composite branch1 = new Composite("branch1");
        Composite branch2 = new Composite("branch2");
        
        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");
        Leaf leaf3 = new Leaf("leaf3");
        
        branch1.add(leaf1);
        branch1.add(leaf2);
        branch2.add(leaf3);
        
        tree.add(branch1);
        tree.add(branch2);
        
        System.out.println(tree.operation());
    }
}
