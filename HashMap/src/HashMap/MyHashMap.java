package HashMap;

import java.util.*;
import java.io.*;

import Entry.Entry;

public class MyHashMap extends AbsHashMap {
    /**
     * PrintWriter object to output results to text file
     */
    PrintWriter writer = null;

    // attributes
    /**
     * hashmap table
     */
    private ArrayList<ArrayList<Entry>> table;
    /**
     * quantity of collisions 
     */
    static int collisions = 0;

    // constructor
    /**
     * default constructor calls super constructor
     */
    public MyHashMap() {
        super();
    }
    /**
     * parametrized constructor calls super parametrized constructor
     * @param capacity int for initial capacity of table
     */
    public MyHashMap(int capacity) {
        super(capacity);
        try
        {
            writer = new PrintWriter(new FileWriter("MyHashMap.txt", true));
        }catch(FileNotFoundException e)
        {
            System.out.println(e.toString());
        }catch(IOException e)
        {
            System.out.println(e.toString());
        }
        for (int i = 0; i < capacity; i++) {
            table.add(new ArrayList<Entry>());
        }
    }
    
    /** 
     * @return PrintWriter returns output object PrintWriter
     */
    public PrintWriter getWriter(){
        return writer;
    }

    
    /** 
     * @return int number of entries
     */
    @Override
    public int size() {
        return getEntries();
    }

    
    /** 
     * @return boolean for if the size is equal to 0
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    
    /** 
     * @param k
     * @return int
     */

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
        writer.write("get(k) time taken = " + elapsed + "\n");
        writer.flush();
        return -1;
    }

    
    /** 
     * @param k int for key
     * @param v int for value 
     * @return int returns the value of the entry
     */
    @Override
    public int Put(int k, int v) {
        long startTime = System.currentTimeMillis();
        int hashOfKey = hashCode(k);
        int returnValue = 0;
        boolean added = false;
       // if(size() > (getCapacity()/2)){
        //    resize((2* getCapacity()) - 1);
       // }
       ArrayList<Entry> innerTable = table.get(hashOfKey);
        if (innerTable.isEmpty()) {
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
        double loadFactor = (float) size() / getCapacity();
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        writer.write("--------------------------------------\n" );
        writer.write("Method to insert key " + k + " took " + elapsed + "ms\n");
        writer.write("Size of the table: " + table.size() + "\n");
        writer.write("Number of elements: " + (size() - 1) + "\n");
        writer.write("Number of collisions: " + collisions + "\n");
        writer.write("Items in bucket: " + innerTable.size() + "\n");
        writer.write("Load factor: " + loadFactor + "\n");
        writer.write("--------------------------------------\n");
        writer.flush();
        return returnValue;
    }

    
    /** 
     * Removes from the map the entry with key equal to k, and returns its value; if
     * the map has no such entry, then it returns null. 
     * @param k int for key being removed
     * @return int returns the removed value
     */
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
                    int temp = innerTable.get(i).getValue();
                    innerTable.remove(i);
                    return temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        writer.write("remove(k) time taken = " + elapsed + "\n");
        writer.flush();
        return -1;
    }

    /*
    public void resize(int newCapacity){
        ArrayList<ArrayList<Entry>> buffer = new ArrayList<>(size());
        
        for(int i = 0; i < table.size(); i++){
            buffer.add(table.get(i));
        }
            setCapacity(newCapacity);
            createTable();
            setSize(0);
            for(int i = 0; i < buffer.size(); i++){
                 if(buffer.get(i).isEmpty()){
                     continue;
                 } else {
                     for(int j = 0; j < buffer.get(i).size(); j++){
                         Put(buffer.get(i).get(j).getKey(), buffer.get(i).get(j).getValue());
                     }
                 }
            }
    }
    */
    /**
     * created 2d table of arrayLists
     */
    @Override
    public void createTable() {
        table = (ArrayList<ArrayList<Entry>>) new ArrayList<ArrayList<Entry>>(getCapacity());
    }

    
    /** 
     * returns hash code v
     * @param k int for key
     * @return int the mod of int k and the capacity
     */
    @Override
    public int hashCode(int k) {
        return k % (getCapacity());
    }
}
