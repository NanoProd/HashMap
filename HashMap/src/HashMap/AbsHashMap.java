package HashMap;

public abstract class AbsHashMap {
    /**
     * int for number of entries
     */
    private int n;
    /**
     * int formax capacity of hash map
     */
    private int capacity;

    /**
     * default constructor sets capacity to 10 and creates table
     */
    public AbsHashMap() {
        n = 0;
        capacity = 10;
        createTable();
    }

    /**
     * parametrized constructor sets capacity to initial size
     * @param initialSize int capacity of table
     */
    public AbsHashMap(int initialSize) {
        n = 0;
        capacity = initialSize;
        createTable();
    }

    
    /**
     * Gets capacity 
     * @return int represents capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * increments entries by 1
    */
    public void incrementEntries() {
        n++;
    }

    
    /** 
     * gets entries
     * @return int n returns the number of entries
     */
    public int getEntries() {
        return n;
    }
    /**
     * sets capacity
     * @param newCapacity int for newCapacity of table
     */
    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }
    /**
     * sets size
     * @param newSize int for new size of table
     */
    public void setSize(int newSize){
        this.n = newSize;
     }

    /**
     * Creates table
     */  
    abstract void createTable();

    /**
     *Returns the number of entries in the map
     */
    abstract int size();

    /**
     * Returns a Boolean indicating weather the map is empty
     */  
    abstract boolean isEmpty();

    /** 
     *return null.
     *Returns the value v associated with key k, if such an entry exists; otherwise
     *abstract int get(int k);
     */ 

    /**
     * if the map does not have an entry with key k, then adds entry (k,v) to it and
     * returns null; else replaces with v the existing value of the entry with key
     * equal to k and returns the old value.
     */
    abstract int Put(int k, int v);

    /**
     * Removes from the map the entry with key equal to k, and returns its value; if
     * the map has no such entry, then it returns null.
     */
    abstract int remove(int k);

    /**
     * Returns the hash value
     */
    abstract int hashCode(int k);
}
