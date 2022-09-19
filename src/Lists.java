/**
 * The interface Lists.
 *
 * @param <E> the type parameter
 */
public interface Lists<E> {
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
     * Get e.
     *
     * @param i the
     * @return the e
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Set e.
     *
     * @param i the
     * @param e the e
     * @return the e
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Add.
     *
     * @param i the
     * @param e the e
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Remove e.
     *
     * @param i the
     * @return the e
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    E remove(int i) throws IndexOutOfBoundsException;
}