
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {        
        try {
            String text;
            text = Files.lines(Paths.get("literacy.csv"))
                    .map(i -> i.split(","))
                    .sorted((x, y) -> Double.valueOf(x[5]).compareTo(Double.valueOf(y[5])))
                    .map(i -> i[3] + " (" + i[4] + ")," +
                            i[2].replace(" (%)", "") + ", " + i[5])
                    .reduce("", (out, next) -> out + next + "\n")
                    .trim();
            System.out.println(text);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
