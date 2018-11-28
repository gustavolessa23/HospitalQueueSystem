package patientsystem.lib;

import patientsystem.lib.interfaces.DoublyLinkedListInterface;

public class DoublyLinkedList<E> implements DoublyLinkedListInterface<E> {

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	public void addDNode(Node<E> node) {
		if (header == null) {  // means list is empty, so add first element
			if (trailer != null)  
				throw new AssertionError(); // if head points to null then tail should too

			header = node;
			trailer = header;  // first element so (head == tail)
		} else {
			trailer.setNext(node);
			node.setPrev(trailer);
			node.setNext(null);
			trailer = node;
			this.size++;
		}
	}

	public void addInPosition(E e, int position) {
		Node<E> currentPosition = getNode(position);
		Node<E> toInsert = new Node<>(e);

		addBefore(toInsert, currentPosition);	
	}

	public E get(int position) {
		if(position <= 0 || position > size)
			return null;
		
		return getNode(position).getElement();
	}

	/**
	 * Method responsible to get a Node element position the a given index number
	 * @param position
	 * @returns element position.
	 */
	public Node<E> getNode(int position) {		

		//View.display("Position chosen: "+ position);
		// System.out.println("Size: "+this.size);
		
		if (position > size) return null;

		if (position == 0) return null;

		Node<E> currentNode = null;


		if(position < (this.size/2)) {
			currentNode = header;
			for(int x = 0; x<position; x++) 
				currentNode = currentNode.getNext();

		} else {
			currentNode = trailer;
			for(int x = this.size; x>=position; x--) 
				currentNode = currentNode.getPrev();
	
		}
		return currentNode;
	}

	/**
	 * Method responsible to ad an element in front of the list.
	 * @param e
	 */
	public void addFirst(E e) {
		addFirst(new Node<>(e, null, header)); 
		size++;
	}


	/**
	 * Method responsible to add an element in end of the list.
	 * @param e
	 */
	public void addLast(E e) { 
//		Node<E> newNode = new Node<E>(e, header, trailer);
//		if(isEmpty()) {
//			this.header = newNode;
//			this.trailer = this.header;
//		} else {
//			Node<E> temp = this.trailer;
//			newNode.setPrev(temp.getPrev());
//			temp.setNext(temp);
//			temp.getPrev().setNext(newNode);
//			this.trailer = temp.getNext();
//		}
//		this.size++;
		 addLast(new Node<>(e, null, null)); 

	}

	
	public Node<E> getNextNode(Node<E> e) {
		return e.getNext();
	}

	//	public void removeLastNodes(int numberOfNodes) {
	//		Node<E> lastNode = getNode(size-numberOfNodes);
	//		lastNode.setNext(trailer);
	//		trailer.setPrev(lastNode);
	//		size = size - numberOfNodes;
	//
	//	}
	

	/**
	 * Method responsible to remove the last N number of Node
	 * @param numberOfNodes
	 * @returns the N number of Node removed.
	 */
	public int removeLastNodes(int numberOfNodes) {
		if(numberOfNodes > size) {
			return -1;
		} else {
			Node<E> lastNode = getNode(size-numberOfNodes);
			lastNode.setNext(trailer);
			trailer.setPrev(lastNode);
			size = size - numberOfNodes;
			return numberOfNodes;
		}

	}
	
	/**
	 * Method to set a new Node position 
	 * @param index
	 * @param newPosition
	 * @return new Node position.
	 */
	public E set(int index, int newPosition) {
		if (index < 0 || index >= size || newPosition < 0 || newPosition >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index, newPosition));
		}
		Node<E> node = getNode(index);
		E result = node.getElement();
		Node<E> element = getNode(newPosition);
		E result2 = element.getElement();
		result = result2;	
		return result;
	}

	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public E first() {
		if (isEmpty()) return null;
		return header.getNext().getElement();
	}

	@Override
	public E last() {
		if (isEmpty()) return null;
		return trailer.getPrev().getElement();
	}

	@Override
	public void addBefore(Node<E> toBeAdded, Node<E> before) {
		toBeAdded.setNext(before);
		toBeAdded.setPrev(before.getPrev());
		before.getPrev().setNext(toBeAdded);
		before.setPrev(toBeAdded);
		size++;	
	}

	public void addFirstEnhanced(E e) {
		Node<E> currentFirst = header.getNext();
		Node<E> newNode = new Node<>(e, currentFirst, header);

		currentFirst.setPrev(newNode);
		header.setNext(newNode);
		size++;

	}

	public void addLastEnhanced(E e) {
		Node<E> currentLast = trailer.getPrev();
		Node<E> newNode = new Node<>(e, trailer, currentLast);

		currentLast.setNext(newNode);
		trailer.setPrev(newNode);
		size++;

	}

	@Override
	public E remove(Node<E> node) {
		Node<E> before = node.getPrev();
		Node<E> after = node.getNext();

		before.setNext(after);
		after.setPrev(before);
		size--;

		return node.getElement();
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(header.getNext());
	}

	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}

	public E remove(int position) {
		return remove(getNode(position));
	}

	@Override
	public void addFirst(Node<E> node) { 
		addBefore(node, header.getNext()); 
	}

	@Override
	public void addLast(Node<E> node) { 
		addBefore(node, trailer); 
	}

	public void concatList(DoublyLinkedList<E> list) {
		//	list.
	}

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
