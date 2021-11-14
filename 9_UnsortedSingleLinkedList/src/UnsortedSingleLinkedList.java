import java.util.Iterator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * 11장 내부 클래스
 * 단일 연결구조
 */
public class UnsortedSingleLinkedList implements Iterable<String> {
	private static class Node{
		private String item = null;
		private Node next = null;
		private Node(String item) {
			this(item, null);
		}
		private Node(String item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	private class LinkedListIterator implements Iterator<String>{
		private Node curr = head;
		@Override public boolean hasNext() {
			return curr!=null;
		}
		@Override public String next() {
			// 완성하세요
			return null;
		}
	}
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public boolean isFull() {
		return false;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public void clear() {
		head = tail = null;
		size = 0;
	}
	public void pushFront(String item) {
		Node newNode = new Node(item, head);
		head = newNode;
		if(isEmpty()) tail = newNode;
		++size;
	}
	public String popFront() {
		if(isEmpty()) throw new IllegalStateException();
		// 완성하세요 
		return null;
	}
	public void pushBack(String item) {
		// 완성하세요
	}
	public String popBack() {
		if(isEmpty()) throw new IllegalStateException();
		Node popNode = tail;
		Node dummy = new Node("",head);
		Node prev = dummy;
		while(prev.next!=tail) prev = prev.next;
		prev.next = null;
		head = dummy.next;
		dummy.next = null; // 꼭 필요한 요소는 아님
		tail = (head==null)? null: prev;
		--size;
		return popNode.item;
	}
	public String peekFront() {
		if(isEmpty()) throw new IllegalStateException();
		return head.item;
	}
	public String peekBack() {
		if(isEmpty()) throw new IllegalStateException();
		return tail.item;
	}
	public boolean find(String item) {
		if(isEmpty()) return false;
		Node curr = head;
		while(curr!=null) {
			if(curr.item.equals(item)) return true;
			curr = curr.next;
		}
		return false;
	}
	// head부터 검색하여 item을 유지하는 첫 번째 노드를 삭제함 
	public void removeFirst(String item) {
		// 완성하세요
	}
	// 리스트에서 item을 유지하는 모든 노드를 삭제함
	public void removeAll(String item) {
		// 완성하세
	}
	@Override public Iterator<String> iterator() {
		return new LinkedListIterator();
	}
}
