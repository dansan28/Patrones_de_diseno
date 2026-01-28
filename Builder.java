// Builder Pattern
import java.util.ArrayList;
import java.util.List;

class Product {
    private List<String> parts = new ArrayList<>();
    
    public void add(String part) {
        parts.add(part);
    }
    
    public String listParts() {
        return String.join(", ", parts);
    }
}

abstract class Builder {
    public abstract Builder buildPartA();
    public abstract Builder buildPartB();
    public abstract Product getResult();
}

class ConcreteBuilder1 extends Builder {
    private Product product;
    
    public ConcreteBuilder1() {
        this.reset();
    }
    
    public void reset() {
        this.product = new Product();
    }
    
    @Override
    public Builder buildPartA() {
        product.add("PartA1");
        return this;
    }
    
    @Override
    public Builder buildPartB() {
        product.add("PartB1");
        return this;
    }
    
    @Override
    public Product getResult() {
        Product result = this.product;
        this.reset();
        return result;
    }
}

class Director {
    private Builder builder;
    
    public Director(Builder builder) {
        this.builder = builder;
    }
    
    public Product buildMinimalViableProduct() {
        return builder.buildPartA().getResult();
    }
    
    public Product buildFullFeaturedProduct() {
        return builder.buildPartA().buildPartB().getResult();
    }
}

// Usage
class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder1();
        Director director = new Director(builder);
        
        Product minimal = director.buildMinimalViableProduct();
        System.out.println("Minimal product: " + minimal.listParts());
        
        Product full = director.buildFullFeaturedProduct();
        System.out.println("Full product: " + full.listParts());
    }
}
