
public class DoublyLinkedList<E> implements DoublyLinkedListInterface<E> {

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	public void addInPosition(E e, int position) {
		Node<E> currentPosition = getNode(position);
		Node<E> toInsert = new Node<>(e);

		addBefore(toInsert, currentPosition);	
	}

	public E get(int position) {
		return getNode(position).getElement();
	}

	public Node<E> getNode(int position) {		

		if (position > size) return null;
		Node<E> currentNode = null;


		if(position < (size/2)) {
			currentNode = header;
			for(int x = 0; x<position; x++) 
				currentNode = currentNode.getNext();

		} else {
			currentNode = trailer;
			for(int x = size; x>position; x--) 
				currentNode = currentNode.getPrev();

		}
		return currentNode;
	}

	public void addFirst(E e) {
		addFirst(new Node<>(e, null, header)); 
		size++;
	}

	public void addLast(E e) { 
		addLast(new Node<>(e, null, null)); 
		size++;
	}

	public Node<E> getNextNode(Node<E> e) {
		return e.getNext();
	}


	public void removeLastNodes(int numberOfNodes) {
		Node<E> lastNode = getNode(size-numberOfNodes);
		lastNode.setNext(trailer);
		trailer.setPrev(lastNode);
		size = size - numberOfNodes;
	}
	public E set(int index, int newPosition) {
		if (index < 0 || index >= size) {
			throw new           
			IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.getElement();
		Node<E> element = getNode(newPosition);
		E newElement = element.getElement();
		node.setElement(newElement);
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
	public void addBefore(Node<E> toBeAdded, Node<E> after) {
		toBeAdded.setNext(after);
		toBeAdded.setPrev(after.getPrev());
		after.getPrev().setNext(toBeAdded);
		after.setPrev(toBeAdded);
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
