/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }
    
    public void play() {
        System.out.println(this.name  + " played a turn.");
    }
    
    public void printName() {
        System.out.println(this.name);
    }
}
