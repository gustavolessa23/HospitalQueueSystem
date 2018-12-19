package patientsystem.lib.interfaces;

import patientsystem.lib.Node;

public interface DoublyLinkedListInterface<E> {
	
	public int size();
	public void addFirst(Node<E> node);
	public void addLast(Node<E> node);
	public boolean isEmpty();
	public E first();
	public E last();
	public E removeFirst();
	public E removeLast();
	public E remove(Node<E> node);
	public void addBefore(Node<E> toBeAdded, Node<E> after);

}
