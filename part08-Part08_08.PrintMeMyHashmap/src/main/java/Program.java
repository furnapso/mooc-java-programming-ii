
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }
    
    public static void printKeys(HashMap<String, String> map) {
        for (String i: map.keySet()) {
            System.out.println(i);
        }
    }
    
    public static void printKeysWhere(HashMap<String, String> map, String text) {
        for (String i: map.keySet()) {
            if (i.contains(text)) {
                System.out.println(i);
            }
        }
    }
    
    public static void printValuesOfKeysWhere(HashMap<String, String> map,
            String text) {
        for (String i: map.keySet()) {
            if (i.contains(text)) {
                System.out.println(map.get(i));
            }
        }
    }

}
