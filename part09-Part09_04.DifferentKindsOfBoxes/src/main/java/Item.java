
public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }
        
        if (obj == this) {
            return true;
        }
        
        Item item = (Item) obj;
        
        return this.getName().equals(item.getName());
    }
    
    public int hashCode() {
        return this.getName().hashCode();
    }

}
