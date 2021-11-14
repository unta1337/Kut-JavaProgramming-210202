// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 11 주차
// 과제명: 단일 연결 구조 구현하기
// 저자: 2020136018 김성녕

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
			Node ret = curr;
			curr = curr != null ? curr.next : null;
			return ret != null ? ret.item : null;
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
		
		Node ret = head;

		head = head != tail ? head.next : tail;
		size--;
		
		return ret.item;
	}
	public void pushBack(String item) {
		Node newNode = new Node(item, null);

		if (isEmpty()) {
			head = tail = newNode;
			size++;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
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
		Node dummy = new Node("", head);
		Node prev = dummy;
		Node current = head;

		while (current != null && !current.item.equals(item)) {
			prev = current;
			current = current.next;
		}
		
		prev.next = current.next;
		
		if (current == head)
			head = head.next;
		if (current == tail)
			tail = prev;

		size--;
	}
	// 리스트에서 item을 유지하는 모든 노드를 삭제함
	public void removeAll(String item) {
		Node prev = new Node("", head);
		Node current = head;

		while (current != null) {
			if (current.item.equals(item)) {
				prev.next = current.next;

				if (current == head)
					head = head.next;
				if (current == tail)
					tail = prev;

				size--;
			}

			prev = current;
			current = current.next;
		}
	}
	@Override public Iterator<String> iterator() {
		return new LinkedListIterator();
	}
}
