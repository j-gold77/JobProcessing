/**
 * The interface Positional list.
 *
 * @param <E> the type parameter
 */
public interface PositionalList<E> {

 /**
  * Size int.
  *
  * @return the int
  */
 int size( );

 /**
  * Is empty boolean.
  *
  * @return the boolean
  */
 boolean isEmpty( );

 /**
  * First position.
  *
  * @return the position
  */
 Position<E> first( );

 /**
  * Last position.
  *
  * @return the position
  */
 Position<E> last( );

 /**
  * Before position.
  *
  * @param p the p
  * @return the position
  * @throws IllegalArgumentException the illegal argument exception
  */
 Position<E> before(Position<E> p) throws IllegalArgumentException;

 /**
  * After position.
  *
  * @param p the p
  * @return the position
  * @throws IllegalArgumentException the illegal argument exception
  */
 Position<E> after(Position<E> p) throws IllegalArgumentException;

 /**
  * Add first position.
  *
  * @param e the e
  * @return the position
  */
 Position<E> addFirst(E e);

 /**
  * Add last position.
  *
  * @param e the e
  * @return the position
  */
 Position<E> addLast(E e);

 /**
  * Add before position.
  *
  * @param p the p
  * @param e the e
  * @return the position
  * @throws IllegalArgumentException the illegal argument exception
  */
 Position<E> addBefore(Position<E> p, E e)
 throws IllegalArgumentException;


 /**
  * Add after position.
  *
  * @param p the p
  * @param e the e
  * @return the position
  * @throws IllegalArgumentException the illegal argument exception
  */
 Position<E> addAfter(Position<E> p, E e)
 throws IllegalArgumentException;

 /**
  * Set e.
  *
  * @param p the p
  * @param e the e
  * @return the e
  * @throws IllegalArgumentException the illegal argument exception
  */
 E set(Position<E> p, E e) throws IllegalArgumentException;

 /**
  * Remove e.
  *
  * @param p the p
  * @return the e
  * @throws IllegalArgumentException the illegal argument exception
  */
 E remove(Position<E> p) throws IllegalArgumentException;



}