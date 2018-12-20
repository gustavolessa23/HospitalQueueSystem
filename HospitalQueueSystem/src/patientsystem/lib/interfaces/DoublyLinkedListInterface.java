package patientsystem.lib.interfaces;

import patientsystem.lib.Node;

/**
 * This interface represents the basic methods a DoublyLinkedList should have.
 * @author Gustavo Lessa
 *
 * @param <E>
 */
public interface DoublyLinkedListInterface<E> {
	
	public int size(); // return size
	public void addFirst(Node<E> node); // add node to first position 
	public void addBefore(Node<E> toBeAdded, Node<E> before); // add node before given node.
	public void addLast(Node<E> node); // add node to last position
	public boolean isEmpty(); // check if list is empty
	public E first(); // return first item
	public E last(); // return last item
	public E removeFirst(); // remove and return first item
	public E removeLast(); // remove and return last item
	public E remove(Node<E> node); // remove given node and return its item

}
