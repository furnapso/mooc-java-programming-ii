/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author lukeb
 */
public class UserInterface {
    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command:");
            String input = scanner.nextLine();
            
            if (input.equals("add")) {
                System.out.println("To add:");
                String task = scanner.nextLine();
                this.list.add(task);
            }
            
            if (input.equals("list")) {
                list.print();
            }
            
            if (input.equals("remove")) {
                System.out.println("Which one to remove?");
                int id = Integer.valueOf(scanner.nextLine());
                list.remove(id);
            }
            
            if (input.equals("stop")) {
                break;
            }
        }
    }
}
