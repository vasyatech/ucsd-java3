package linkedlist;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<String> l = new MyLinkedList<String>();
		
		//l.addFirst("1");
		//l.addFirst("2");
		l.addLast("3");
		l.addLast("4");
		l.addFirst("1");
		l.add("2", 1);
		l.add("5", 4);
		l.print();
		
		l.remove(4);
		l.print();
		//l.addFirst("4");
		//System.out.println("------------");
		//l.print();
		//System.out.println(l.size());
		//System.out.print(l.toString());
	}

}
