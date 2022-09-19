/**
 * The interface Priority queue.
 *
 * @param <K>    the type parameter
 * @param <Jobs> the type parameter
 */
public interface PriorityQueue<K,Jobs> {

    /**
     * Size int.
     *
     * @return the int
     */
    int size();

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    boolean isEmpty();

    /**
     * Insert entry.
     *
     * @param key the key
     * @param job the job
     * @return the entry
     * @throws IllegalArgumentException the illegal argument exception
     */
    Entry<K,Jobs> insert (K key, Jobs job) throws IllegalArgumentException;

    /**
     * Min entry.
     *
     * @return the entry
     */
    Entry<K,Jobs> min();

    /**
     * Remove min entry.
     *
     * @return the entry
     */
    Entry<K,Jobs> removeMin();




}