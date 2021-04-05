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

    public int getKey() {
        return key.intValue();
    }

    public int getValue() {
        return value.intValue();
    }

    public void setKey(int key) {
        this.key = Integer.valueOf(key);
    }

    public int setValue(int value) {
        Integer old = this.value;
        this.value = Integer.valueOf(value);
        return old;
    }

    public static int randomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        return randomNum;
    }

    public int hashCode(int N) {
        return key % N;
    }
}
