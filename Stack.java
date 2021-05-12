public class Stack {
  public int[] data;
  public int top;

  /* ********** Constructors ********** */
  public Stack(int size) {
    // Initialize an array of custom size.
    data = new int[size];
    // Initialize top to -1 because the array is empty.
    top = -1;
  }

  /* ********** Operations ********** */
  public boolean push(int s){
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

  public int pop(){
    // Return and remove the string in the top index if the stack is not empty.
    if(!isEmpty()){
      int topValue = data[top];
      top--;
      // Return true if the stack was not empty.
      return topValue;
    } else {
      // Return null if the stack was empty.
      return 0;
    }
  }

  public int peek(){
    // Return the string at the top of the stack if it is not empty.
    if(!isEmpty()){
      return data[top];
    }
    // Return null if the stack was empty.
    return 0;
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
