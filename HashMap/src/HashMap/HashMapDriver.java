package HashMap;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        HashMap.getWriter().flush();
    }

    // void experiment interpret
    static void experiment_interpret() {
        PrintWriter os = null;
        try
        {
            os = new PrintWriter(new FileWriter("InputTimes.txt", true));
        }catch(FileNotFoundException e)
        {
            System.out.println(e.toString());
        }catch(IOException e)
        {
            System.out.println(e.toString());
        }

        // create hash map of initial capacity 100
        MyHashMap HashMap = new MyHashMap(100);

        // create a local ArrayList of 150 random
        ArrayList<Entry> list = new ArrayList<>(150);
        for (int i = 0; i < 150; i++) {
            Entry newEntry = new Entry(Entry.randomNum(), Entry.randomNum());
            list.add(newEntry);
        }
        // adds data to hash map
        long startTime = System.currentTimeMillis();
        long endTime;
        long elapsedNow;
        for (int i = 0; i < list.size(); i++) {
            if(i == 24){
                 endTime = System.currentTimeMillis();
                 elapsedNow = endTime - startTime;
                os.write("Time taken to add 25 Entries using Put(k): " + elapsedNow + "ms\n");
            }
            if(i == 49){
                 endTime = System.currentTimeMillis();
                 elapsedNow = endTime - startTime;
                os.write ("Time taken to add 50 Entries using Put(k): " + elapsedNow + "ms\n");    
            }
            
            if(i == 74){
                endTime = System.currentTimeMillis();
                elapsedNow = endTime - startTime;
               os.write ("Time taken to add 75 Entries using Put(k): " + elapsedNow + "ms\n");    
           }
           
           if(i == 99){
            endTime = System.currentTimeMillis();
            elapsedNow = endTime - startTime;
           os.write ("Time taken to add 100 Entries using Put(k): " + elapsedNow + "ms\n");    
            }
       
            if(i == 124){
            endTime = System.currentTimeMillis();
            elapsedNow = endTime - startTime;
            os.write ("Time taken to add 125 Entries using Put(k): " + elapsedNow + "ms\n");    
            }
            
            if(i == 149){
                endTime = System.currentTimeMillis();
                elapsedNow = endTime - startTime;
               os.write ("Time taken to add 150 Entries using Put(k): " + elapsedNow + "ms\n");    
           }

            HashMap.Put(list.get(i).getKey(), list.get(i).getValue());
        }
        os.close();
        HashMap.getWriter().flush();
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        validate();
        experiment_interpret();
        
    }

}
