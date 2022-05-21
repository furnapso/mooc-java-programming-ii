
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            int age = Integer.valueOf(scanner.nextLine());
            books.add(new Book(name, age));
        }
        
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getName);
        
        System.out.println(books.size() + " books in total.");
        System.out.println("Books:");
        
        String output = books.stream()
                .sorted(comparator)
                .map(i -> i.toString())
                .reduce("", (out, next) -> out + next + "\n")
                .trim();
        
        System.out.println(output);
    }

}
