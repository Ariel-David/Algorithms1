package parkingProblem;

class LinkedListCycle {

	class Node {
		private char data;
		private Node prev, next;
		public Node(char data, Node prev, Node next){
			this.data = data;
			this.next = next;
			this.prev = prev;
		} 
		public String toString(){ return ""+this.data; }
		public void setData(char c){ this.data = c; }
		public char getData(){ return this.data; }
		public Node getNext(){ return this.next;}
		public Node getPrev(){ return this.prev; }
	}
	
	private Node head, tail;
	private int size;
	
	// Constructor,  constructs an empty list
	public LinkedListCycle(){
		head = tail = null;
		size = 0;
	} 
	
	// Appends the specified element to the end of this list. 
	public void add(char obj){
		if (head == null){
			head = new Node(obj, null, null);
			tail = head;
			head.next = head.prev = tail;
		}
		else{
			Node n = new Node(obj, tail, head);
			tail.next = n;
			tail = n;
			head.prev = tail;
		}
		size++;
	}
	
	public Node getHead(){
		return head;
	}
	
	public Node getNext(Node n){
		return n.next;
	}
	
	public String toString(){
		String s = "[";
		if (head != null){
			s = s + head.toString() + ", ";
			for (Node n = head.next; n != head; n=n.next){
				s = s + n.toString() + ", ";
			}
			s = s.substring(0, s.length()-2);
		}
		return s+"]";
	}
}// end LinkedListCycle

public class CalcCarsLinkList {
	LinkedListCycle cars;
	final int nLetters = 23, size = 13;
	final char v='v',  w = 'w';
	
	public CalcCarsLinkList(){
		// build parking
		cars = new LinkedListCycle();
		for (int i=0; i<size; i++){
			char c = (char)('a' + (int)(Math.random()*nLetters));
			cars.add(c);
		}
		System.out.println(cars.toString());
	}
	 
	// cars calculation
	/**
	 * Cars calculation: parking problem with double cycle linked list
	 * Complexity: O(n^2)
	 * @return number of cars
	 */
	public int calcCars(){
		cars.getHead().setData(v);
		LinkedListCycle.Node t = cars.getHead().getNext();
		boolean flag = true; //continue
		int count = 1;
		while(flag){
			if (t.getData()==v){
				t.setData(w);
				int i = count;
				while(i>0){
					t = t.getPrev();
					i--;
				}
				if (t.getData() == w) flag = false;
				else{
					count = 1;
					t = cars.getHead().getNext();
				}
			}
			else{
				t = t.getNext();
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Cars calculation: parking problem with two pointers
	 * Complexity: O(n)
	 * @return number of cars
	 */
	public int calcCarsPointers(){
		int result = 1;
		LinkedListCycle.Node nodeForward = cars.getHead().getNext();
		LinkedListCycle.Node headNode = cars.getHead();
		while(nodeForward != headNode) {
			nodeForward = nodeForward.getNext();
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		CalcCarsLinkList parking = new CalcCarsLinkList();
		System.out.println("number of cars by DCLL = " + parking.calcCars());
		System.out.println("number of cars by two pointers = " + parking.calcCarsPointers());
	}
}
