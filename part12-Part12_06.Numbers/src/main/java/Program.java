
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int num = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            System.out.println(random.nextInt(11));
        }
    }

}
