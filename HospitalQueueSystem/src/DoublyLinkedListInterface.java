
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
	void addBetween(Node<E> toBeAdded, Node<E> before, Node<E> after);
	// test
}
