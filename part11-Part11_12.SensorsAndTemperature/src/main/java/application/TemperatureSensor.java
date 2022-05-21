/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.*;

/**
 *
 * @author lukeb
 */
public class TemperatureSensor implements Sensor {

    private boolean on;

    public TemperatureSensor() {
        this.on = false;
    }

    public void setOn() {
        this.on = true;
    }

    public void setOff() {
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public int read() {
        if (!this.on) {
            throw new IllegalStateException("Sensor is not on.");
        } else {
            return new Random().nextInt(30 - -30) + -30;
        }
    }
}
