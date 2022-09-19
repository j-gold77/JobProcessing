/**
 * The type Linked positional list.
 *
 * @param <E> the type parameter
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
     private static class Node<E> implements Position<E> {
         private E element; // reference to the element stored at this node
         private Node<E> prev; // reference to the previous node in the list
         private Node<E> next; // reference to the subsequent node in the list

         @Override
         public String toString() {
             return "Node{" +
                     "element=" + element +
                     ", prev=" + prev +
                     ", next=" + next +
                     '}';
         }

         /**
          * Instantiates a new Node.
          *
          * @param e the e
          * @param p the p
          * @param n the n
          */
         public Node(E e, Node<E> p, Node<E> n) {
             element = e;
             prev = p;
             next = n;
         }

         public E getElement() throws IllegalStateException {
             if (next == null) // convention for defunct node
                 throw new IllegalStateException("Position no longer valid");
             return element;
         }

         /**
          * Gets prev.
          *
          * @return the prev
          */
         public Node<E> getPrev() {
             return prev;
         }

         /**
          * Gets next.
          *
          * @return the next
          */
         public Node<E> getNext() {
             return next;
         }

         /**
          * Sets element.
          *
          * @param e the e
          */
         public void setElement(E e) {
             element = e;
         }

         /**
          * Sets prev.
          *
          * @param p the p
          */
         public void setPrev(Node<E> p) {
             prev = p;
         }

         /**
          * Sets next.
          *
          * @param n the n
          */
         public void setNext(Node<E> n) {
             next = n;
         }
     }

     private Node<E> head; // head sentinel
     private Node<E> previous; // previous sentinel
     private int size = 0; // number of elements in the list

    /**
     * Instantiates a new Linked positional list.
     */
    public LinkedPositionalList() {
         head = new Node<>(null, null, null); // create head
         previous = new Node<>(null, head, null); // previous is preceded by head
         head.setNext(previous); // head is followed by previous
     }

     private Node<E> validate(Position<E> p) throws IllegalArgumentException {
         if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
         Node<E> node = (Node<E>) p; // safe cast
         if (node.getNext() == null) // convention for defunct node
             throw new IllegalArgumentException("p is no longer in the list");
         return node;
     }

    /**
     * Position position.
     *
     * @param node the node
     * @return the position
     */
    public Position<E> position(Node<E> node) {
         if (node == head || node == previous)
             return null; // do not expose user to the sentinels
         return node;
     }




     public int size() {
         return size;
     }

     public boolean isEmpty() {
         return size == 0;
     }

     public Position<E> first() {
         return position(head.getNext());
     }


     public Position<E> last() {
         return position(previous.getPrev());
     }

     public Position<E> before(Position<E> p) throws IllegalArgumentException {
         Node<E> node = validate(p);
         return position(node.getPrev());
     }

     public Position<E> after(Position<E> p) throws IllegalArgumentException {
         Node<E> node = validate(p);
         return position(node.getNext());
     }

     private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
         Node<E> newest = new Node<>(e, pred, succ); // create and link a new node
         pred.setNext(newest);
         succ.setPrev(newest);
         size++;
         return newest;
     }


     public Position<E> addFirst(E e) {
         return addBetween(e, head, head.getNext()); // just after the head
     }

     public Position<E> addLast(E e) {
         return addBetween(e, previous.getPrev(), previous); // just before the previous
     }

     public Position<E> addBefore(Position<E> p, E e)
             throws IllegalArgumentException {
         Node<E> node = validate(p);
         return addBetween(e, node.getPrev(), node);
     }

     public Position<E> addAfter(Position<E> p, E e)
             throws IllegalArgumentException {
         Node<E> node = validate(p);
         return addBetween(e, node, node.getNext());
     }

     public E set(Position<E> p, E e) throws IllegalArgumentException {
         Node<E> node = validate(p);
         E answer = node.getElement();
         node.setElement(e);
         return answer;
     }

     public E remove(Position<E> p) throws IllegalArgumentException {

         Node<E> node = validate(p);
         Node<E> predecessor = node.getPrev();
         Node<E> successor = node.getNext();
         predecessor.setNext(successor);
         successor.setPrev(predecessor);
         size--;
         E answer = node.getElement();
         node.setElement(null); // help with garbage collection
         node.setNext(null); // and convention for defunct node
         node.setPrev(null);
         return answer;
     }

 }