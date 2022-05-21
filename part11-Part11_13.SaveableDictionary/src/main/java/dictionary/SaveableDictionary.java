/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.*;
import java.io.*;

/**
 *
 * @author lukeb
 */
public class SaveableDictionary {

    private Map<String, String> words;
    private Map<String, String> translations;
    private String filename;

    public SaveableDictionary() {
        this.words = new HashMap<>();
        this.translations = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.filename = file;
    }

    public boolean save() {
        try {
            File file = new File(this.filename);
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);
            for (String i : this.words.keySet()) {
                writer.println(i + ":" + this.words.get(i));
            }

            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean load() {
        try {
            Scanner scanner = new Scanner(new File(this.filename));
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(":");
                this.add(data[0], data[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void add(String word, String translation) {
        this.words.putIfAbsent(word, translation);
        this.translations.putIfAbsent(translation, word);
    }

    public void delete(String word) {
        if (this.words.containsKey(word)) {
            this.translations.remove(this.words.get(word));
            this.words.remove(word);
        } else {
            this.words.remove(this.translations.get(word));
            this.translations.remove(word);
        }
    }

    public String translate(String word) {
        return this.words.getOrDefault(word,
                this.translations.getOrDefault(word, null));
    }

}
