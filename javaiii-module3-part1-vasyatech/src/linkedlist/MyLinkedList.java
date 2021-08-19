package linkedlist;

public class MyLinkedList<T> implements LinkedListInterface<T>{
	
	private Node<T> head = null;
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		int size = 0;
		Node<T> tmpNode = head;
	    while (tmpNode!= null){
	    	size++;
	    	tmpNode = tmpNode.getNext();
	    }
	    return size;
	}

	@Override
	public void addFirst(T data) {
		head = new Node<T>(data, head);
	}

	@Override
	public void addLast(T data) {
		Node<T> newNode = new Node<T>(data, null); 
		if (head == null) {
		    head = newNode;     
		}
		else {
			int size = size();
			Node<T> tmpNode = head; 
			for (int i = 0; i < size-1; i++) {
				tmpNode = tmpNode.getNext();
			}
		    tmpNode.setNext(newNode);
		}
	}

	@Override
	public void add(T data, int index) {
		int size = size();
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Wrong index");
		}
		
		if (head == null || index == 0) {
			addFirst(data);
			return;
		}
		
		if (index == size) {
			addLast(data);
			return;
		}	
		
		Node<T> newNode = new Node<T>(data, null);
		Node<T> tmpNode = head;
		Node<T> prevNode = null;
		for (int i = 0; i < index; i++) {
			prevNode = tmpNode;
			tmpNode = tmpNode.getNext();
		}
            
		prevNode.setNext(newNode);
		newNode.setNext(tmpNode);
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		int size = size();
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Wrong index");
		}
		T deletedData = null;
		if (head == null)
            return deletedData;
		Node<T> tmpNode = head;
		if (index == 0)
        {
            head = tmpNode.getNext();
            return deletedData;
        }
		for (int i=0; tmpNode!=null && i<index-1; i++) {
			tmpNode = tmpNode.getNext();
		}
            
		 if (tmpNode == null || tmpNode.getNext() == null)
	            return deletedData;
		 
		 Node<T> nextNode = tmpNode.getNext().getNext();
		 tmpNode.setNext(nextNode);
		return deletedData;
	}

	@Override
	public void print() {
	    System.out.println(toString());
	}
	
	  @Override
	    public String toString() {
		  String result = "";
			Node<T> currNode = head;
		    while (currNode != null) {
		    	result = result + currNode.getData() + " ";
		        currNode = currNode.getNext();
		    }
		    return result;
	    }

}
