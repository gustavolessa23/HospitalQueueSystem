package patientsystem.lib;

import patientsystem.lib.interfaces.NodeInterface;

/**
 * Class representing a Node from a DoublyLinkedList.
 * @author Gustavo Lessa
 *
 * @param <E>
 */
public class Node<E> implements NodeInterface<E> {

		private E element; // the data
		private Node<E> prev; // previous node
		private Node<E> next; // next node
		
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
		 * This method returns the data hold by the node.
		 */
		@Override
		public E getElement() {
			return element;
		}

		/**
		 * This method sets the node's data
		 */
		@Override
		public void setElement(E element) {
			this.element = element;
		}

		/**
		 * This method returns the previous node.
		 */
		@Override
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * This method sets the previous node variable.
		 */
		@Override
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		/**
		 * This method returns the next node variable.
		 */
		@Override
		public Node<E> getNext() {
			return next;
		}

		/**
		 * This method sets the next node variable.
		 */
		@Override
		public void setNext(Node<E> next) {
			this.next = next;
		}

}
