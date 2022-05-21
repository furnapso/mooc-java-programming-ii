/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author lukeb
 */
public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history = new ArrayList<>();
    }
    
    public String toString() {
        return this.history.toString();
    }
    
    public double maxValue() {
        double maxValue = 0;
        
        for (double i: this.history) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        
        return maxValue;
    }
    
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        } else {
            double minValue = this.history.get(0);
            for (double i: this.history) {
                if (i < minValue) {
                    minValue = i;
                }
            }
            
            return minValue;
        }
    }
    
    public double average() {
        if (this.history.isEmpty()) {
            return 0;
        } else {
            double sum = 0;
            for (double i: this.history) {
                sum += i;
            }
            
            return sum / (double) this.history.size();
        }
    }
}
