/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukeb
 */
import java.util.*;

public class HashMap<K, V> {

    private List<KeyValuePair<K, V>>[] values;
    private int nextIndex;

    public HashMap() {
        this.values = new List[32];
        this.nextIndex = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }

        List<KeyValuePair<K, V>> valuesAtIndex = this.values[hashValue];

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }

        return null;
    }

    private int getHashValue(Object value, int length) {
        return Math.abs(value.hashCode() % length);
    }

    public void add(K key, V value) {
        List<KeyValuePair<K, V>> valuesAtIndex = getListByKey(key);

        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new KeyValuePair<>(key, value));
            this.nextIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }

        if (1.0 * this.nextIndex / this.values.length > 0.75) {
            grow();
        }
    }

    private List<KeyValuePair<K, V>> getListByKey(K key) {
        int hashValue = getHashValue(key, this.values.length);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }

        return values[hashValue];
    }

    private int getIndexOfKey(List<KeyValuePair<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    public void grow() {
        List<KeyValuePair<K, V>>[] newValues = new ArrayList[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            copy(newValues, i);
        }

        this.values = newValues;
    }

    private void copy(List<KeyValuePair<K, V>>[] newArray, int fromIndex) {
        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            KeyValuePair<K, V> value = this.values[fromIndex].get(i);

            int hashValue = getHashValue(value, newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(value);
        }
    }

    public V remove(K key) {
        List<KeyValuePair<K, V>> valuesAtIndex = getListByKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        KeyValuePair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);

        return pair.getValue();
    }

}
