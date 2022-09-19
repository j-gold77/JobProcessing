import java.util.Comparator;

/**
 * The type Abstract priority queue.
 *
 * @param <K>    the type parameter
 * @param <Jobs> the type parameter
 */
public abstract class AbstractPriorityQueue<K,Jobs> extends ArrayList implements PriorityQueue<K,Jobs>  {

    /**
     * The type Pq entry.
     *
     * @param <K>    the type parameter
     * @param <Jobs> the type parameter
     */
    protected static class PQEntry<K, Jobs> implements Entry<K, Jobs> {
            private K k; // key
            private Jobs j; // value


        /**
         * Instantiates a new Pq entry.
         *
         * @param key the key
         * @param job the job
         */
        public PQEntry(K key, Jobs job) {
            k = key;
            j = job;
            }

        // methods of the Entry interface
            public K getKey() {
                return k;
          }

              public Jobs getJob() {
                 return j;
            }

            @Override
            public K setKey(int i) {
                return null;
            }

            @Override
            public Jobs setJobs(Jobs j) {
                return null;
            }

            @Override
            public String toString() {
                return "PQEntry{" +
                        "k=" + k +
                        ", j=" + j +
                        '}';
            }

        /**
         * Sets key.
         *
         * @param key the key
         */
// utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        /**
         * Sets job.
         *
         * @param job the job
         */
        protected void setJob(Jobs job) {
            j = job;
        }
    } //----------- end of nested PQEntry class -----------


    private Comparator<K> comp;

    /**
     * Instantiates a new Abstract priority queue.
     *
     * @param c the c
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Instantiates a new Abstract priority queue.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    /**
     * Compare int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    protected int compare(Entry<K, Jobs> a, Entry<K, Jobs> b) {
        return comp.compare(a.getKey(), b.getKey());
    }


    /**
     * Check key boolean.
     *
     * @param key the key
     * @return the boolean
     * @throws IllegalArgumentException the illegal argument exception
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }



}
