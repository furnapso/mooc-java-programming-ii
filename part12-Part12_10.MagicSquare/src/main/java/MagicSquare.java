
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < this.square.length; i++) {
            int total = 0;
            for (int j = 0; j < this.square[i].length; j++) {
                total += this.square[i][j];
            }
            values.add(total);
        }

        return values;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < this.square.length; i++) {
            int total = 0;
            for (int j = 0; j < this.square[i].length; j++) {
                total += this.square[j][i];
            }

            values.add(total);
        }

        return values;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> values = new ArrayList<>();

        int leftTotal = 0;
        int rightTotal = 0;

        for (int i = 0; i < this.square.length; i++) {
            leftTotal += this.square[i][i];

            rightTotal += this.square[i][this.square.length - (i + 1)];
        }

        values.add(leftTotal);
        values.add(rightTotal);

        return values;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
        System.out.println(this.toString());
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }

    public int transformColumn(int column) {
        if (column < 0 || column >= this.getWidth()) {
            return 0;
        }

        return column;
    }

    public int transformRow(int row) {
        if (row < 0 || row >= this.getHeight()) {
            return this.getHeight() - 1;
        }

        return row;
    }
}
