/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */
public class Hideout<T> {

    private T element;

    public Hideout() {
    }

    public void putIntoHideout(T element) {
        this.element = element;
    }

    public T takeFromHideout() {
        T element = this.element;
        this.element = null;
        return element;
    }

    public boolean isInHideout() {
        return !(this.element == null);
    }

}
