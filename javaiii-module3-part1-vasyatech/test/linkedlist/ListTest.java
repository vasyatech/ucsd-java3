package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linkedlist.MyLinkedList;

class ListTest {
	
	@Test
	void testAddLast() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLast("1");
		assertEquals("1 ", l.toString());
		l.addLast("2");
		assertEquals("1 2 ", l.toString());
	}
	
	@Test
	void testAddFirst() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addFirst("1");
		assertEquals("1 ", l.toString());
		l.addFirst("2");
		assertEquals("2 1 ", l.toString());
	}
	
	@Test
	public void testSize() {
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l.addLast(4);
		l.addLast(5);
		assertTrue(l.size() == 5);
		MyLinkedList<String> l2 = new MyLinkedList<String>();
		assertTrue(l2.size() == 0);
	}
	
	@Test
	void testRemove() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLast("1");
		l.addLast("2");
		l.addLast("3");
		l.remove(1);
		assertTrue(l.size() == 2);
		assertEquals("1 3 ", l.toString());	
	}
	
	@Test
	public void testIsEmpty() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		assertTrue(l.isEmpty());
		l.addLast("1");
		assertFalse(l.isEmpty());
	}
}
