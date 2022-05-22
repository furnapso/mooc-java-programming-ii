
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here

        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare square = msFactory.createMagicSquare(5);
        System.out.println(square);
        System.out.println("Cols: " + square.sumsOfColumns());
        System.out.println("Rows: " + square.sumsOfRows());
        System.out.println("Diagonals: " + square.sumsOfDiagonals());
    }
}
