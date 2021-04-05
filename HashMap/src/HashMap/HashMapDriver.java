package HashMap;

import java.util.ArrayList;
import Entry.Entry;

public class HashMapDriver {

    // void validate method
    static void validate() {
        // create arraylist of 50 random entries
        ArrayList<Entry> list = new ArrayList<>(50);

        for (int i = 0; i < 50; i++) {
            Entry newEntry = new Entry(Entry.randomNum(), Entry.randomNum());
            list.add(newEntry);
        }

        // create a MyHashMap with 100 max capacity
        MyHashMap HashMap = new MyHashMap(100);
        // add all 50 entries from list to the hash map
        for (int i = 0; i < list.size(); i++) {
            HashMap.Put(list.get(i).getKey(), list.get(i).getValue());
        }
        // run get(k) on each of the elements
        for (int i = 0; i < list.size(); i++) {
            HashMap.get(list.get(i).getKey());
        }
        // run remove(k) on first 25 keys followed by get(k) on each of the 50 keys
        for (int i = 0; i < list.size(); i++) {
            if (i < 25) {
                HashMap.remove(list.get(i).getKey());
            } else {
                break;
            }
            i++;
        }
        for (int i = 0; i < list.size(); i++) {
            HashMap.get(list.get(i).getKey());
        }
    }

    // void experiment interpret
    static void experiment_interpret() {
        // create hash map of initial capacity 100
        MyHashMap HashMap = new MyHashMap(100);

        // create a local ArrayList of 150 random
        ArrayList<Entry> list = new ArrayList<>(150);
        for (int i = 0; i < 150; i++) {
            Entry newEntry = new Entry(Entry.randomNum(), Entry.randomNum());
            list.add(newEntry);
        }
        // adds data to hash map
        for (int i = 0; i < list.size(); i++) {
            HashMap.Put(list.get(i).getKey(), list.get(i).getValue());
        }
    }

    public static void main(String[] args) {

        System.out.println("Validate() method");
        System.out.println("------------------------------------------------");
        validate();
        System.out.println("------------------------------------------------");
        System.out.println("experiment_interpret() method");
        System.out.println("------------------------------------------------");
        experiment_interpret();
        System.out.println("------------------------------------------------");
    }

}
