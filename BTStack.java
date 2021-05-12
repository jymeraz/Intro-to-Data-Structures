/* BTStack:
 * Complete code below where you read "COMPLETE CODE HERE" 
 * or "MODIFY THIS"
 * You may also want to add methods where it says "ADD METHODS AS NEEDED"
 */

public class BTStack {
	// Attributes
	private Node top;

	// Create a node class.
	private class Node{
		// Attributes
		private ExpressionBT data;
		private Node next;

		// Constructor
		public Node(){
			data = null;
			next = null;
		}

		// Getters
		public ExpressionBT getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		// Setters
		public void setData(ExpressionBT data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	// Constructors
	public BTStack() {
		top = null;
	}
	
	// Modifiers
	public ExpressionBT peek() {
		// Return the data at the top of the stack without modifying the stack.
		if(top != null){
			return top.data;
		}
		return null;
	}

	public void push(ExpressionBT Node) {
		// Create a new top node if the top is null.
		// Add a node to the top of the stack if the top was not null.
    if (top != null) {
    	Node newTop = new Node();
    	newTop.data = Node;

      Node temp = top;
      top = newTop;
      top.next = temp;
		} else {
    	top = new Node();
    	top.data = Node;
			top.next = null;
		}
	}

	public ExpressionBT pop() {
		// Remove and return the top value of the stack.
    if (top != null) {
      Node temp = top;
      top = top.next;
      return temp.data;
		}
    return null;
	}

	public boolean isEmpty() {
		// Return true if the stack is empty.
		return top == null;
	}
}
