import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Heap priority queue.
 *
 * @param <K>    the type parameter
 * @param <Jobs> the type parameter
 */
public class HeapPriorityQueue<K,Jobs> extends AbstractPriorityQueue<K,Jobs> {

    /**
     * The Heap.
     */
    protected ArrayList<Entry<K,Jobs>> heap = new ArrayList<>( );

    /**
     * Instantiates a new Heap priority queue.
     */
    public HeapPriorityQueue( ) {
        super( );
    }

    /**
     * Instantiates a new Heap priority queue.
     *
     * @param comp the comp
     */
    public HeapPriorityQueue(Comparator<K> comp){
        super(comp);
    }



    /**
     * Parent int.
     *
     * @param j the j
     * @return the int
     */
    protected int parent(int j) {
        return (j-1)/2;
    }

    /**
     * Left int.
     *
     * @param j the j
     * @return the int
     */
    protected int left(int j) {
        return 2*j + 1;
    }

    /**
     * Right int.
     *
     * @param j the j
     * @return the int
     */
    protected int right(int j) {
        return 2*j + 2;
    }

    /**
     * Has left boolean.
     *
     * @param j the j
     * @return the boolean
     */
    protected boolean hasLeft(int j){
        return left(j) < heap.size( );
    }

    /**
     * Has right boolean.
     *
     * @param j the j
     * @return the boolean
     */
    protected boolean hasRight(int j) {
        return right(j) < heap.size( );
    }

    /**
     * Swap.
     *
     * @param i the
     * @param j the j
     */
    protected void swap(int i, int j) {
         Entry<K,Jobs> temp = heap.get(i);
         heap.set(i, heap.get(j));
         heap.set(j, temp);
         }


    /**
     * Upheap.
     *
     * @param j the j
     */
    protected void upheap(int j) {

        while (j > 0) { // continue until reaching root (or break statement)
             int p = parent(j);
             if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
             swap(j, p);
             j = p; // continue from the parent's location
        }
    }



    /**
     * Downheap.
     *
     * @param j the j
     */
    protected void downheap(int j) {
        while (hasLeft(j)) { // continue to bottom (or break statement)
             int leftIndex = left(j);
             int smallChildIndex = leftIndex; // although right may be smaller
             if (hasRight(j)) {
                 int rightIndex = right(j);
                 if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                     smallChildIndex = rightIndex; // right child is smaller
                 }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                 break; // heap property has been restored
            swap(j, smallChildIndex);
             j = smallChildIndex; // continue at position of the child
             }
    }

    public int size( ) {
        return heap.size( );
    }

    public Entry<K,Jobs> min( ) {
         if (heap.isEmpty( )) return null;
         return heap.get(0);
    }

    /**
     * Set min.
     *
     * @param e the e
     */
    public void setMin(Entry<K,Jobs> e){
        heap.remove(e);
        heapify();
        heap.add(0,e);
    }




    public Entry<K,Jobs> insert(K key, Jobs jobs) throws IllegalArgumentException {
         checkKey(key); // auxiliary key-checking method (could throw exception)
         Entry<K,Jobs> newest = new PQEntry<>(key, jobs);
         heap.add(newest); // add to the end of the list
         upheap(heap.size() - 1); // upheap newly added entry
         return newest;
         }

     public Entry<K,Jobs> removeMin() {
         if (heap.isEmpty()) return null;
         Entry<K,Jobs> answer = heap.get(0);
         swap(0, heap.size() - 1); // put minimum item at the end
         heap.remove(heap.size() - 1); // and remove it from the list;
         downheap(0);
         return answer;
    }



    protected void heapify( ) {
        int startIndex = parent(size( )-1); // start at PARENT of last entry
        for (int j=startIndex; j >= 0; j--) // loop until processing the root
        downheap(j);
    }
    /**
     * Find entry.
     *
     * @param j the j
     * @return the entry
     */
    public Entry<K,Jobs> find(Jobs j){
        if(heap.isEmpty()) return null;

        for(int i=0;i<heap.size();i++){
            if(heap.get(i).getJob()==j){
               Entry<K,Jobs> answer = heap.get(i);
               return answer;
            }
        }
        return null;

    }






}