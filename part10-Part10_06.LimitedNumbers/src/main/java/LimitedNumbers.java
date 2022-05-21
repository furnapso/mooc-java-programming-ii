
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine();
            if (input.contains("-")) {
                break;
            }
            
            list.add(Integer.valueOf(input));
        }
        
        String output = list.stream()
                .filter(i -> i >= 1 && i <= 5)
                .map(i -> "" + i)
                .reduce("", (out, next) -> out + next + "\n");
        
        System.out.println(output);

    }
}
