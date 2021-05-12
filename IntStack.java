/* IntStack:
 * Complete code below where you read "COMPLETE CODE HERE" 
 * or "MODIFY THIS"
 * You may also want to add methods where it says "ADD METHODS AS NEEDED"
 */
public class IntStack {
	// Attributes
	private Node top;

	// Create a Node class.
	private class Node{
		// Attributes
		private int data;
		private Node next;

		// Constructor
		public Node(){
			data = -1;
			next = null;
		}

		// Getters
		public int getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		// Setters
		public void setData(int data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	// Constructors
	public IntStack() {
		top = null;
	}

	public int peek() {
		// Return the value at the top without modifying the stack.
		if(top != null){
			return top.data;
		}
		return -1;
	}
	
	/* Push:
	 */
	public void push(int value) {
		// Create a new top node if the top is null.
		// Add a node to the top of the stack if the top was not null.
		if (top != null) {
			Node newTop = new Node();
			newTop.data = value;

			Node temp = top;
			top = newTop;
			top.next = temp;
		} else {
			top = new Node();
			top.data = value;
			top.next = null;
		}
	}

	public int pop() {
		// Remove and return the top value of the stack.
		if (top != null) {
			Node temp = top;
			top = top.next;
			return temp.data;
		}
		return -1;
	}
}
