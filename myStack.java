public class myStack {
	private String[] data;
	private int top;
	
	/* ********** Constructors ********** */
	public myStack(int size) {
		// Initialize an array of custom size.
		data = new String[size];
		// Initialize top to -1 because the array is empty.
		top = -1;
	}
	
	public myStack() {
		// Initialize an array of size 10.
		data = new String[10];
		// Initialize top to -1 because the array is empty.
		top = -1;
	}
	
	/* ********** Operations ********** */
	public boolean push(String s){
		// Add a string to the top of the stack if it is not full.
		if(!isFull()){
			data[top + 1] = s;
			top++;
			// Return true if the stack was not full.
			return true;
    } else {
			// Return null if the stack was full.
      return false;
		}
	}

	public String pop(){
		// Return and remove the string in the top index if the stack is not empty.
		if(!isEmpty()){
			String topValue = data[top];
			top--;
			// Return true if the stack was not empty.
			return topValue;
		} else {
			// Return null if the stack was empty.
			return null;
		}
	}

	public String peek(){
		// Return the string at the top of the stack if it is not empty.
		if(!isEmpty()){
			return data[top];
		}
		// Return null if the stack was empty.
		return null;
	}

	public int getSize(){
		// Return the number of elements in the stack.
		return top + 1;
	}

	public boolean isEmpty(){
		// Return true if the index of top is -1, which means there are no elements.
		return top == -1;
	}

	public boolean isFull(){
		// Return true if the number of elements in the stack is the same as the length of the array.
		return getSize() == data.length;
	}
}