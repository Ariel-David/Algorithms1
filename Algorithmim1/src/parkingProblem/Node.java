package parkingProblem;

public class Node {
	char data;
	Node prev,next;

	public Node(char data, Node prev, Node next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	
}
