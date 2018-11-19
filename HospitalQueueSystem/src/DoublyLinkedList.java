
public class DoublyLinkedList<E> implements DoublyLinkedListInterface<E> {
	
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	public void addBetween(E e, Node<E> before, Node<E> after) {
		Node<E> toInsert = new Node<>(e, before, after);
		addBetween(toInsert, before, after);	
	}

	public void addFirst(E e) {
		addFirst(new Node<>(e, null, header)); 
		size++;
	}
	
	public void addLast(E e) { 
		addLast(new Node<>(e, null, null)); 
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
	public void addBetween(Node<E> toBeAdded, Node<E> before, Node<E> after) {
		before.setNext(toBeAdded);
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

	@Override
	public void addFirst(Node<E> node) { 
		addBetween(node, header, header.getNext()); 
	}

	@Override
	public void addLast(Node<E> node) { 
		addBetween(node, trailer.getPrev(), trailer); 
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
		sb.append("]");
		return sb.toString();
	}
	
	

}
