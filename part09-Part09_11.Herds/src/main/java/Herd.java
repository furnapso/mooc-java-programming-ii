/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */

import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable {
    private List<Movable> members;
    
    public Herd() {
        this.members = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable i: this.members) {
            i.move(dx, dy);
        }
    }
    
    public String toString() {
        String output = "";
        for (Movable i: this.members) {
            output = output + i.toString() + "\n";
        }
        return output.trim();
    }
}
