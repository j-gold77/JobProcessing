/**
 * The type Array list.
 *
 * @param <E> the type parameter
 */
public class ArrayList<E> implements Lists<E> {
    /**
     * The constant CAPACITY.
     */
    public static final int CAPACITY = 16; // default array capacity
    private E[] data; // generic array used for storage
    private int size = 0; // current number of elements

    /**
     * Instantiates a new Array list.
     */
    public ArrayList() {
        this(CAPACITY);
    } // constructs list with default capacity

    /**
     * Instantiates a new Array list.
     *
     * @param capacity the capacity
     */
    public ArrayList(int capacity) { // constructs list with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length){
            resize(2 * data.length);// not enough capacity
            throw new IllegalStateException("Array is full");
        }
        for (int k = size - 1; k >= i; k--) // start by shifting rightmost
            data[k + 1] = data[k];
        data[i] = e; // ready to place the new element
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) // shift elements to fill hole
            data[k] = data[k + 1];
        data[size - 1] = null; // help garbage collection
        size--;
        return temp;
    }

    /**
     * Check index.
     *
     * @param i the
     * @param n the n
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    /**
     * Resize.
     *
     * @param capacity the capacity
     */
    protected void resize(int capacity) {
        E[ ] temp = (E[ ]) new Object[capacity]; // safe cast; compiler may give warning
        for (int k=0; k < size; k++)
            temp[k] = data[k];
        data = temp; // start using the new array
    }


}