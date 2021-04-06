package Entry;

import java.util.Random;

public class Entry {
    private Integer key; // key
    private Integer value; // value

    public Entry() {
        key = Integer.valueOf(randomNum());
        value = Integer.valueOf(randomNum());
    }

    public Entry(int key, int value) {
        this.key = Integer.valueOf(key);
        this.value = Integer.valueOf(value);
    }

    
    /** 
     * gets key
     * @return int
     */
    public int getKey() {
        return key.intValue();
    }

    
    /** 
     * gets value
     * @return int
     */
    public int getValue() {
        return value.intValue();
    }

    
    /** 
     * sets key
     * @param key
     */
    public void setKey(int key) {
        this.key = Integer.valueOf(key);
    }

    
    /** 
     * sets value
     * @param value
     * @return int
     */
    public int setValue(int value) {
        Integer old = this.value;
        this.value = Integer.valueOf(value);
        return old;
    }

    
    /** 
     * generates random number
     * @return int
     */
    public static int randomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        return randomNum;
    }

    
    /**
     * returns hash code value 
     * @param N
     * @return int
     */
    public int hashCode(int N) {
        return key % N;
    }
}
