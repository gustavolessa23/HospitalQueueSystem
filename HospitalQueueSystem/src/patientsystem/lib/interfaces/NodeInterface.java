package patientsystem.lib.interfaces;

import patientsystem.lib.Node;

/**
 * Interface responsible for the basic structure a Node should contain.
 * @author Gustavo Lessa
 *
 * @param <E>
 */
public interface NodeInterface <E> {

	public E getElement(); // return element

	public void setElement(E element); // set element

	public Node<E> getPrev(); // get previous node

	public void setPrev(Node<E> prev); // set previous node

	public Node<E> getNext(); // get next node

	public void setNext(Node<E> next); // set next node

}