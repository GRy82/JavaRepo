import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private String value;
        private int key;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] buckets = new LinkedList[10];

    public void put(int key, String value){
        var bucket = buckets[hash(key)];
        if (bucket == null)
            bucket = new LinkedList<>();
        
        bucket.add(new Entry(key, value));
    }

    private int hash(int key){
        return key % buckets.length;
    }

    public String get(int key){
        Entry entry = getEntry(key);
        return entry != null ? entry.value : null;   
    }

    public void remove(int key){
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();

        buckets[hash(key)].remove(entry);
    }

    private Entry getEntry(int key){
        var bucket = buckets[hash(key)];

        if(bucket != null){
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry;
        }
        return null;
    }
}
