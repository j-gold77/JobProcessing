import java.util.Comparator;

/**
 * The type Sorted priority queue.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();


    /**
     * Instantiates a new Sorted priority queue.
     */
    public SortedPriorityQueue() {
        super();
    }

    /**
     * Instantiates a new Sorted priority queue.
     *
     * @param comp the comp
     */
    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        Position<Entry<K, V>> check = list.last();
        while (check != null && compare(newest, check.getElement()) < 0)
            check = list.before(check);
        if (check == null)
            list.addFirst(newest);
        else
            list.addAfter(check, newest);
        return newest;
    }


    public Entry<K, V> min() {
        if (list.isEmpty()) return null;
        return list.first().getElement();
    }

    public Entry<K, V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(list.first());
    }

    public int size() {
        return list.size();
    }

    /**
     * Set min entry.
     *
     * @param key   the key
     * @param value the value
     * @return the entry
     */
    public Entry<K,V> setMin(K key, V value){
        Entry<K,V> answer = new PQEntry<>(key,value);
        list.addFirst(answer);
        return list.first().getElement();

    }




}