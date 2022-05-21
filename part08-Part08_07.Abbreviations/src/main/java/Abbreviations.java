/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
/**
 *
 * @author lukeb
 */
public class Abbreviations {
    private HashMap<String, String> lookup;

    public Abbreviations() {
        this.lookup = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        if (!this.lookup.containsKey(abbreviation)) {
            this.lookup.put(abbreviation, explanation);
        }
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return this.lookup.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        if (this.lookup.containsKey(abbreviation)) {
            return this.lookup.get(abbreviation);
        }
        
        return null;
    }
}
