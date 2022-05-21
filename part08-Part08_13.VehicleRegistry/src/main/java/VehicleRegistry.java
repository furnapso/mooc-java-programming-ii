/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author lukeb
 */
public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.keySet().contains(licensePlate)) {
            return false;
        }
        
        registry.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate) {
        return this.registry.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (this.registry.keySet().contains(licensePlate)) {
            this.registry.remove(licensePlate);
            return true;
        }
        
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate plate: this.registry.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> uniqueOwners = new ArrayList<>();
        for (String owner: this.registry.values()) {
            if (!uniqueOwners.contains(owner)) {
                uniqueOwners.add(owner);
            }
        }
        
        for (String owner: uniqueOwners) {
            System.out.println(owner);
        }
    }
}
