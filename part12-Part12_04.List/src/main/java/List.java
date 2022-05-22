/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */
import java.util.*;

public class List<Type> {

    private Type[] values;
    private int nextIndex;

    public List() {
        this.values = (Type[]) new Object[10];
        this.nextIndex = 0;
    }

    public void add(Type value) {

        if (this.nextIndex == this.values.length) {
            grow();
        }

        this.values[this.nextIndex] = value;
        this.nextIndex++;
    }

    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
    }

    public int indexOf(Type value) {
        for (int i = 0; i < this.nextIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = 0; i < this.nextIndex; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public void remove(Type value) {
        int index = indexOf(value);
        if (index < 0) {
            return;
        }

        moveToTheLeft(index);
        this.nextIndex--;
    }

    public boolean contains(Type value) {
        return indexOf(value) >= 0;
    }

    public Type get(int index) {
        if (index < 0 || index >= this.nextIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is outside bounds.");
        }

        return this.values[index];
    }

    public int size() {
        return this.nextIndex;
    }
}
