/* BTQueue:
 * Complete code below where you read "COMPLETE CODE HERE" 
 * or "MODIFY THIS"
 * You may also want to add methods where it says "ADD METHODS AS NEEDED"
 */


public class BTQueue {
	// Attributes
	private Node front;
	private Node end;
	private int numElements;

	// Create a Node class.
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
	public BTQueue() {
		front = null;
		end = null;
		numElements = 0;
	}

	public ExpressionBT peek() {
		// Return the value at the front without modifying the queue.
		if(front != null){
			return front.data;
		}
		return null;
	}

	public void enqueue(ExpressionBT Node) {
		// Create a new front if the front was null.
		// Append to the end of the queue if the front was not null.
		// Update the number of elements.
		if(front == null){
			Node newFront = new Node();
			newFront.data = Node;

			front = newFront;
			end = newFront;
			front.next = null;
		} else {
			Node newEnd = new Node();
			newEnd.data = Node;
			end.next = newEnd;
			end = newEnd;
		}
		numElements++;
	}

	public ExpressionBT dequeue() {
		// Remove and return the value at the front of the queue.
    if (front != null) {
    	numElements--;
      ExpressionBT frontData = front.data;
      // Update the pointers to front and end if there are no more elements.
			// Set front to point to the next element if there are still elements.
      if (front.next == null) {
        front = null;
        end = null;
			} else {
      	front = front.next;
			}
      return frontData;
		}
		return null;
	}

	public boolean isEmpty(){
		// Return true if the queue is empty.
		return front == null;
	}
}
