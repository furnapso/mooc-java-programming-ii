package dictionary;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary dict = new SaveableDictionary("words.txt");
        dict.load();
    }
}
