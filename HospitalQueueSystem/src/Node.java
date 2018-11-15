
public class Node<E> implements NodeInterface<E> {

		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E element, Node<E> prev, Node<E> next) {
			super();
			this.element = element;
			this.prev = prev;
			this.next = next;
		}

		@Override
		public E getElement() {
			return element;
		}

		@Override
		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public Node<E> getPrev() {
			return prev;
		}

		@Override
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		@Override
		public Node<E> getNext() {
			return next;
		}

		@Override
		public void setNext(Node<E> next) {
			this.next = next;
		}

}
