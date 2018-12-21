package patientsystem.lib;

import patientsystem.lib.interfaces.DoublyLinkedListInterface;

/**
 * Class responsible for the DoublyLinkedList data type.
 * @author Gustavo Lessa
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements DoublyLinkedListInterface<E> {

	private Node<E> header; // header node
	private Node<E> trailer; // trailer node
	private int size = 0; // list size

	/**
	 * Constructor for a new list.
	 */
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	/**
	 * Method responsible for adding an element into a specific position.
	 * @param e element to be added
	 * @param position int
	 */
	public void addInPosition(E e, int position) {
		Node<E> currentPosition = getNode(position); // get the node currently at chosen position
		Node<E> toInsert = new Node<>(e); // create a new node with the given element

		addBefore(toInsert, currentPosition); // add new node before the node currently at chosen position
	}

	/**
	 * Method responsible for getting the element from specified position
	 * @param position
	 * @return return element found
	 */
	public E get(int position) {
		if(position <= 0 || position > size) // if position is invalid
			return null; // return null
		
		return getNode(position).getElement(); // otherwise, return the element at chosen position
	}

	/**
	 * Method responsible for getting a Node object from specified position
	 * @param position
	 * @return Node object from position.
	 */
	public Node<E> getNode(int position) {		
		
		if (position > size || position == 0) return null; // if position is invalid

		Node<E> currentNode = null; // new variable

		if(position < (this.size/2)) { // if position is in the first half of the list
			currentNode = header; // start from the header
			for(int x = 0; x<position; x++) // iterate until one before last position
				currentNode = currentNode.getNext(); // get next element

		} else { // if position is in the second half of the list
			currentNode = trailer; // start from the trailer
			for(int x = this.size; x>=position; x--) // iterate from list size until the position
				currentNode = currentNode.getPrev(); // get previous node.
		}
		
		return currentNode; // return efficiently found node.
	}

	/**
	 * Method responsible for adding an element to the front of the list.
	 * @param e Element to be added
	 */
	public void addFirst(E e) {
		addFirst(new Node<>(e, null, header)); 
		size++;
	}


	/**
	 * Method responsible for adding an element to the end of the list.
	 * @param e Element to be added
	 */
	public void addLast(E e) { 
		 addLast(new Node<>(e, null, null)); 

	}

	/**
	 * Method responsible for getting the next node of a given node.
	 * @param e Node to be read.
	 * @return next node from given node.
	 */
	public Node<E> getNextNode(Node<E> e) {
		return e.getNext();
	}
	

	/**
	 * Method responsible for removing the last N number of Nodes from the list
	 * @param numberOfNodes to be removed
	 * @return the N number of Nodes that were actually removed.
	 */
	public int removeLastNodes(int numberOfNodes) {
		if(numberOfNodes > size) {
			return -1;
		} else {
			Node<E> lastNode = getNode(size-numberOfNodes); // get the new last node
			//lastNode.setNext(trailer); // set its next node as the trailer
			trailer.setPrev(lastNode); // the the previous node from the trailer as the new last node
			size = size - numberOfNodes; // remove the number of nodes from the size
			return numberOfNodes; // return the number of nodes removed.
		}
	}

	/**
	 * Method responsible for returning the list size.
	 * @return list size.
	 */
	@Override
	public int size() { return size; }

	/**
	 * Method responsible for checking if the list is empty.
	 * @return true if list is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() { return size == 0; }

	/**
	 * Method responsible for returning the first element of the list.
	 * @return first element of the list.
	 */
	@Override
	public E first() {
		if (isEmpty()) return null;
		return header.getNext().getElement();
	}

	/**
	 * Method responsible for returning the last element of the list.
	 * @return last element of the list.
	 */
	@Override
	public E last() {
		if (isEmpty()) return null;
		return trailer.getPrev().getElement();
	}

	/**
	 * Method responsible for adding a node before a given node.
	 * @param toBeAdded Node to be added
	 * @param before Node before of which the toBeAdded will be added.
	 */
	@Override
	public void addBefore(Node<E> toBeAdded, Node<E> before) {
		toBeAdded.setNext(before);
		toBeAdded.setPrev(before.getPrev());
		before.getPrev().setNext(toBeAdded);
		before.setPrev(toBeAdded);
		size++;	
	}

	/**
	 * Method responsible for removing a specific node from the list.
	 * @param node to be removed.
	 * @return element removed.
	 */
	@Override
	public E remove(Node<E> node) {
		Node<E> before = node.getPrev();
		Node<E> after = node.getNext();

		before.setNext(after);
		after.setPrev(before);
		before.setNext(trailer);
		after.setPrev(header);
		size--;

		return node.getElement();
	}

	/**
	 * Method responsible for removing the first element from the list.
	 * @return first element of the list.
	 */
	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(header.getNext());
	}

	/**
	 * Method responsible for removing the last element from the list.
	 * @return last element of the list.
	 */
	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}

	/**
	 * Method responsible for removing a specific node from the list, according to its position.
	 * @param position to be removed
	 * @return element removed
	 */
	public E remove(int position) {
		return remove(getNode(position));
	}

	/**
	 * Method responsible for adding a Node to the first position.
	 * @param node to be added.
	 */
	@Override
	public void addFirst(Node<E> node) { 
		addBefore(node, header.getNext()); 
	}
	
	/**
	 * Method responsible for adding a Node to the last position.
	 * @param node to be added.
	 */
	@Override
	public void addLast(Node<E> node) { 
		addBefore(node, trailer); 
	}

	/**
	 * Method responsible for generating a String using the list information
	 * @return list as a String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		Node<E> p = header;
		if (p != null) {
			p = p.getNext();
			while (p.getNext() != null) {
				sb.append(p.getElement().toString());
				sb.append(" ==> ");
				p = p.getNext();
			}
			sb.append(p.getElement().toString());
		}
		sb.append(" ");
		return sb.toString();
	}

}
