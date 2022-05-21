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
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stock;

    public Warehouse() {
        this.products = new HashMap<String, Integer>();
        this.stock = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stock.put(product, this.stock.getOrDefault(product, 0) + stock);
    }
    
    public int price(String product) {
        return this.products.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.stock.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        boolean taken = false;
        if (this.stock.getOrDefault(product, 0) > 0) {
            this.stock.put(product, this.stock.get(product) - 1);
            taken = true;
        }
        
        return taken;
    }
    
    public Set<String> products() {
        return this.products.keySet();
    }
    
}
