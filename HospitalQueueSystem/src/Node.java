
public class Node<E> implements NodeInterface<E> {

		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		/**
		 * Node constructor
		 * @param element
		 * @param prev
		 * @param next
		 */
		public Node(E element, Node<E> prev, Node<E> next) {
			super();
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		/**
		 * Node constructor
		 * @param element
		 */
		public Node(E element) {
			super();
			this.element = element;
			this.prev = null;
			this.next = null;
		}

		/**
		 * This method gets a Node element
		 */
		@Override
		public E getElement() {
			return element;
		}

		/**
		 * This method sets a Node element
		 */
		@Override
		public void setElement(E element) {
			this.element = element;
		}

		/**
		 * This method gets a Node previous element
		 */
		@Override
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * This method set a Node previous element
		 */
		@Override
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		/**
		 * This method gets a Node next element.
		 */
		@Override
		public Node<E> getNext() {
			return next;
		}

		/**
		 * This method set a Node next element.
		 */
		@Override
		public void setNext(Node<E> next) {
			this.next = next;
		}

		

}
