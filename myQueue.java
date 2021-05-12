public class myQueue {
	private String[] data;
	private int head;
	private int numElements;
	
	/* ********** Constructors ********** */
	public myQueue(int size) {
		// Initialize an array of custom size.
		data = new String[size];
		// Initialize head to -1 because the array is empty.
		head = -1;
		// Initialize numElements to 0 because the array is empty.
		numElements = 0;
	}
	
	public myQueue() {
		// Initialize an array of size 10.
		data = new String[10];
		// Initialize head to -1 because the array is empty.
		head = -1;
		// Initialize numElements to 0 because the array is empty.
		numElements = 0;
	}
	
	/* ********** Operations ********** */
	public boolean enqueue(String s){
		// Add a String to the queue if the queue is not full.
    if (!isFull()) {
    	if(numElements == 0){
    		head++;
			}
    	// Use the modulus operator to find out where the index of the last String in the queue is.
			// Use the modulus operator again to find the index after the last String in the queue and insert the String in that index.
			data[((head + numElements - 1) % data.length + 1) % data.length] = s;
      numElements++;
      // Return true if the queue is not full.
      return true;
		}
		return false;
	}

	public String dequeue(){
		// Remove the String at the index head if the queue is not empty.
		if(!isEmpty()){
			// Save the String at index head.
			String headValue = data[head];
			// Set the index of head to the index after it.
			head = (head + 1) % data.length;
			numElements--;
			// Set head to -1 if after dequeueing there are no elements.
			if(numElements == 0){
				head = -1;
			}
			// Return the String at the index head.
			return headValue;
		}
		// Return null if the queue is empty.
		return null;
	}

	public String peek(){
		// Return the String in the front of the queue if the queue is not empty.
		if(!isEmpty()){
			return data[head];
		}
		// Return null if the queue is empty.
		return null;
	}

	public int getSize(){
		// Return the number of elements.
		return numElements;
	}

	public boolean isEmpty(){
		// Return true if the index of head is -1, which means there are no elements.
		return head == -1;
	}

	public boolean isFull(){
		// Return true if the number of elements in the queue is the same as the length of the array.
		return numElements == data.length;
	}
}