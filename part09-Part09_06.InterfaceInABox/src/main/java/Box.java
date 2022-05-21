/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */
import java.util.ArrayList;

public class Box implements Packable{
    private double maxWeight;
    private ArrayList<Packable> items;
    

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<Packable>();
    }
    
    public void add(Packable packable) {
        if ((this.weight() + packable.weight()) <= this.maxWeight) {
            this.items.add(packable);
        }
    }
    
    public String toString() {
        String multiple = "";
        if (this.items.size() > 0) {
            multiple = "s";
        }
        
        return "Box: " + this.items.size() + " item" + multiple + ", " +
                "total weight " + this.weight() + " kg";
    }
    
    public double weight() {
        double weight = 0;
        for (Packable i: this.items) {
            weight = weight + i.weight();
        }
        return weight;
    }
}
