/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.*;
import java.util.stream.*;

/**
 *
 * @author lukeb
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public boolean isOn() {
        for (Sensor i : this.sensors) {
            if (!i.isOn()) {
                return false;
            }
        }

        return true;
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public void setOn() {

        for (Sensor i : this.sensors) {
            i.setOn();
        }
    }

    public void setOff() {

        for (Sensor i : this.sensors) {
            i.setOff();
        }
    }

    public int read() {
        int total = 0;

        for (Sensor i : this.sensors) {
            total += i.read();
        }

        int average = (int) total / this.sensors.size();
        this.readings.add(average);

        return average;
    }

    public List<Integer> readings() {
        return this.readings;
    }

}
