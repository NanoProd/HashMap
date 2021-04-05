package HashMap;

import java.util.ArrayList;

import Entry.Entry;

public class MyHashMap extends AbsHashMap {

    // attributes
    private ArrayList<ArrayList<Entry>> table;
    static int collisions = 0;

    // constructor
    public MyHashMap() {
        super();
    }

    public MyHashMap(int capacity) {
        super(capacity);
        for(int i = 0; i < capacity; i++){
            table.add(new ArrayList<Entry>());
        }
    }

    @Override
    public int size() {
        return getEntries();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int get(int k) {
        long startTime = System.currentTimeMillis();
        int hashOfKey = hashCode(k);
        if (table.get(hashOfKey) == null) {
            return -1;
        } else {
            ArrayList<Entry> innerTable = table.get(hashOfKey);
            for (int i = 0; i < innerTable.size(); i++) {
                if (innerTable.get(i).getKey() == k) {
                    return innerTable.get(i).getValue();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("get(k) time taken = " + elapsed);
        return -1;
    }

    @Override
    public int Put(int k, int v) {
        long startTime = System.currentTimeMillis();
        int hashOfKey = hashCode(k);
        int returnValue = 0;
        boolean added = false;
        ArrayList<Entry> innerTable = table.get(hashOfKey);
        if (innerTable == null) {
            innerTable = new ArrayList<Entry>();
            Entry newEntry = new Entry(k, v);
            innerTable.add(newEntry);
            returnValue = -1;
            added = true;
        } else {
            collisions++; // increment quantity of collisions
            for (int i = 0; i < innerTable.size(); i++) {
                if (innerTable.get(i).getKey() == k) {
                    returnValue = innerTable.get(i).setValue(v);
                    added = true;
                }
            }
            if (added != true) {
                Entry newEntry = new Entry(k, v);
                table.get(hashOfKey).add(newEntry);
                returnValue = -1;
            }
        }
        incrementEntries(); // increment quantity of entries
        double loadFactor = size() / getCapacity();
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("--------------------------------------");
        System.out.println("Method to insert key " + k + " took " + elapsed + "ms");
        System.out.println("Size of the table: " + (size() - 1));
        System.out.println("Number of elements: " + size());
        System.out.println("Number of collisions: " + collisions);
        System.out.println("Items in bucket: " + innerTable.size());
        System.out.println("Load factor: " + loadFactor);
        System.out.println("--------------------------------------");
        return returnValue;
    }

    @Override
    public int remove(int k) {
        long startTime = System.currentTimeMillis();
        int hashOfKey = hashCode(k);
        if (table.get(hashOfKey) == null) {
            return -1;
        } else {
            ArrayList<Entry> innerTable = table.get(hashOfKey);
            for (int i = 0; i < innerTable.size(); i++) {
                if (innerTable.get(i).getKey() == k) {
                    innerTable.remove(i);
                    return innerTable.get(i).getValue();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("remove(k) time taken = " + elapsed);
        return -1;
    }

    @Override
    public void createTable() {
        table = (ArrayList<ArrayList<Entry>>) new ArrayList<ArrayList<Entry>>(getCapacity());
    }

    @Override
    public int hashCode(int k) {
        return k % (getCapacity());
    }

}
