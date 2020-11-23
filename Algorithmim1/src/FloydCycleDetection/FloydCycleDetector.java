package FloydCycleDetection;

public class FloydCycleDetector {
	private int position;
	private int length;
	private boolean cycle;
	private Node head, tortoise, hare;

	/**
	 *
	 * @param head
	 */
	public void detect(Node head) {
		this.head = head;
		this.tortoise = this.hare = head;
		this.cycle = detectCycle();
		if (cycle) {
			System.out.println("Found cycle.");
			this.position = findPosition();
			this.length = cycleLength();
		} else {
			System.out.println("No cycle.");
			this.position = -1;
			this.length = 0;
		}
	}

	public boolean hasCycle() {
		return cycle;
	}

	public int length() {
		return length;
	}

	public int position() {
		return position;
	}
	/**
	 * Cycle detection in linked list
	 * @return lists have cycles or no
	 */
	private boolean detectCycle() {
		// Empty and one element lists have no cycles:
		if (tortoise == null || tortoise.next == null) {
			return false;
		}
		// Keep going until there are elements in list:
		while (hare != null && hare.next != null) {
			System.out.print("(" + tortoise.data + ", " + hare.data + "), ");
			// Advance both, but at their own speeds:
			tortoise = tortoise.next;  // 1 hop
			hare = hare.next.next; // 2 hops
			if (tortoise == hare) {
				// hare can meet the tortoise only in a loop!
				System.out.print("turtle: " + tortoise.data + 
						" == hare: " + hare.data +"\n");
				return true;
			}
		}
		// hare found the end of the list, so no cycle:
		return false;
	}
	/**
	 * Start of cycle/loop in linked list:
	 * Move tortoise to the beginning,
	 * then advance tortoise and hare at the same speed. 
	 * The distance covered by the tortoise is the beginning of the cycle. 
	 * @return where is the beginning of the cycle
	 */
	private int findPosition() {
		int i = 1;
		tortoise = head;
		System.out.print("(" + tortoise.data + ", " + hare.data + "), ");
		while (tortoise != hare) {
			tortoise = tortoise.next;
			hare = hare.next;
			++i;
		}
		return i;
	}
	/**
	 * Cycle/Loop length in linked list
	 * @return
	 */
	private int cycleLength() {
		int i = 0;
		do {
			hare = hare.next;
			++i;
		} 
		while (tortoise != hare);
		return i;
	}

	static private Node createList(int n) {
		Node head = new Node(1);
		Node node = head;
		for (int i = 2; i <= n; ++i) {
			node.next = new Node(i);
			node = node.next;
		}
		return head;
	}
	public static void main(String[] args) {
		FloydCycleDetector detector = new FloydCycleDetector();
		Node head = createList(10);
		//create circle
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head.next;
 
        detector.detect(head);
        System.out.println("Has the list a cycle? " + detector.hasCycle());
        System.out.println("A length of the cycle is " + detector.length());
        System.out.println("Start of cycle in the list is " + detector.position());
	}
}
