/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author lukeb
 */
public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    public void add(Item item) {
        int currentWeight = 0;
        
        for (Item i: this.items) {
            currentWeight += i.getWeight();
        }
        
        if (currentWeight + item.getWeight() <= capacity) {
            this.items.add(item);
        }
    }
    
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
    
    
}
