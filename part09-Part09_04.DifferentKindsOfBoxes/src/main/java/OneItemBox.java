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
public class OneItemBox extends Box {
    private Item item;

    public OneItemBox() {
        this.item = null;
    }
    
    public void add(Item item) {
        if (this.item == null) {
            this.item = item;
        }
    }
    
    public boolean isInBox(Item item) {
        if (this.item == null) {
            return false;
        } else {
            return this.item.equals(item);
        }
    }
}
