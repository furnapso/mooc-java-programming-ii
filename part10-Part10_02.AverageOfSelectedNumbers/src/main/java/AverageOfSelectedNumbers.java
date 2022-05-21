
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<Integer> list = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            
            list.add(Integer.valueOf(input));
        }
        
        double average = 0;
        String numberType = "";
        String input = scanner.nextLine();
        if (input.equals("n")) {
            numberType = "negative";
            average = list.stream()
                    .mapToInt(n -> n)
                    .filter(n -> n < 0)
                    .average()
                    .getAsDouble();
        }
        else if (input.equals("p")) {
            numberType = "positive";
            average = list.stream()
                    .mapToInt(n -> n)
                    .filter(n -> n > 0)
                    .average()
                    .getAsDouble();
        }
        
        System.out.println("Average of the " + numberType + " numbers: " + average);
    }
}
