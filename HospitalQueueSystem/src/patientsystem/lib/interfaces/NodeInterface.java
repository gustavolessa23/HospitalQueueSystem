package patientsystem.lib.interfaces;

import patientsystem.lib.Node;

public interface NodeInterface <E> {

	public E getElement();

	public void setElement(E element);

	public Node<E> getPrev();

	public void setPrev(Node<E> prev);

	public Node<E> getNext();

	public void setNext(Node<E> next);

}