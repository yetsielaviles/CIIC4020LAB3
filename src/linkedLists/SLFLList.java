package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		((SNode<E>)nuevo).setNext(first);
		first = (SNode<E>) nuevo;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		((SNode<E>) nuevo).setNext(((SNode<E>)target).getNext());
		((SNode<E>) target).setNext(((SNode<E>) nuevo));
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(target==first)
			this.addFirstNode(nuevo);
		else{
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			this.addNodeAfter(prev, nuevo);
}
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(first == null)
			throw new NoSuchElementException("getLastNode(): Empty list."); 
		else{
			SNode<E> current = first; 
			while (((SNode<E>) current).getNext() != null)
				current = current.getNext(); 
			return current;
}
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(first==null)
			throw new NoSuchElementException("getFirstNode() : Empty List"); 
		else
			return first;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		// TODO Auto-generated method stub
		SNode<E> aNode = ((SNode<E>) target).getNext();
		if (aNode==null)
			throw new NoSuchElementException("getNodeAfter(...) : target is the last node."); 
		else
			return aNode;
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(target==first)
			throw new NoSuchElementException("getNodeBefore(...) : target is the first node."); 
		else{
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}

	}

	public int length() {
		// TODO Auto-generated method stub
		return this.length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		if(target==first){
			SNode<E> ntr = first; 
			first = first.getNext(); 
			ntr.setNext(null); 
		}
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		length--; 

	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
