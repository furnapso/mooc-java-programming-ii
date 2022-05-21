/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */
import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (!(this.items.containsKey(product))) {
            this.items.put(product, new Item(product, 1, price));
        }
        else {
            this.items.get(product).increaseQuantity();
        }
    }
    
    public int price() {
        int total = 0;
        for (Item i: this.items.values()) {
            total = total + i.price();
        }
        
        return total;
    }
    
    public void print() {
        for (Item i: this.items.values()) {
            System.out.println(i);
        }
    }
}
