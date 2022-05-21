/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 *
 * @author lukeb
 */
public class StorageFacility {

    private HashMap<String, ArrayList<String>> items;

    public StorageFacility() {
        this.items = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.items.putIfAbsent(unit, new ArrayList<>());
        this.items.get(unit).add(item);
    }

    public ArrayList<String> contents(String unit) {
        return this.items.getOrDefault(unit, new ArrayList<>());
    }

    public void remove(String unit, String item) {
        if (this.items.keySet().contains(unit)) {
            ArrayList<String> foundUnit = this.items.get(unit);

            for (int i = 0; i < foundUnit.size(); i++) {
                if (foundUnit.get(i).equals(item)) {
                    foundUnit.remove(i);
                    break;
                }
            }

            if (foundUnit.isEmpty()) {
                {
                    this.items.remove(unit);
                }
            }
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<>();
        for (String i: this.items.keySet()) {
            if (!this.items.get(i).isEmpty()) {
                storageUnits.add(i);
            }
        }
        
        return storageUnits;
    }

}
