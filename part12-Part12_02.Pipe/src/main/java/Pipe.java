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

public class Pipe<T> {

    private List<T> elements;

    public Pipe() {
        this.elements = new ArrayList<>();
    }

    public void putIntoPipe(T element) {
        this.elements.add(element);
    }

    public T takeFromPipe() {
        if (this.elements.size() > 0) {
            T element = this.elements.get(0);
            this.elements.remove(0);
            return element;
        } else {
            return null;
        }
    }

    public boolean isInPipe() {
        return this.elements.size() > 0;
    }
}
