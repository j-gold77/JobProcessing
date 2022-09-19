import java.util.Comparator;

/**
 * The type Default comparator.
 *
 * @param <E> the type parameter
 */
public class DefaultComparator<E> implements Comparator<E> {
 public int compare(E a, E b) throws ClassCastException {
         return ((Comparable<E>) a).compareTo(b);
 }
}