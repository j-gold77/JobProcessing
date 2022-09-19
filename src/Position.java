/**
 * The interface Position.
 *
 * @param <E> the type parameter
 */
public interface Position<E> {
    /**
     * Gets element.
     *
     * @return the element
     * @throws IllegalStateException the illegal state exception
     */
    E getElement( ) throws IllegalStateException;
}
