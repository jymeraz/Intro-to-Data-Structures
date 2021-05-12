public class intList {

  private intNode head;
  private int size;

  public intList() {}

  public intList(intNode head) {
    this.head = head;
    size = head.sizeFromNode();
  }

  /* intList(int[] D):
   * This constructor builds a linked list out of an
   * array D of data of generic type D.
   * Example: When D is {1,2,3,4,5}, your constructor should build a list:
   *      1 → 2 → 3 → 4 → 5 → null
   * where head is the node that contains 1 and size is 5.
   */
  public intList(int[] D) {
    // Create the head node with the value of the first index of the array.
    head = new intNode(D[0]);

    intNode iter = head;
    // Create the rest of the nodes with the remaining values in the array.
    for(int i = 1; i < D.length; i++){
      intNode newNode = new intNode(D[i]);
      iter.setNext(newNode);
      iter = iter.getNext();
    }
  }

  /**
   * @return the head
   */
  public intNode getHead() {
    return head;
  }

  /**
   * @param head the head to set
   */
  public void setHead(intNode head) {
    this.head = head;
  }

  /**
   * @return the size
   */
  public int getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(int size) {
    this.size = size;
  }

  /* visitReverse():
   * This method traverses the linked list backwards:
   * from the last node to the first node, and as it does so,
   * it creates a String of the values it encounters, separated by a space.
   * Your method should be RECURSIVE.
   * Example: When our linked list L is:
   *      head → 1 → 2 → 3 → 4 → 5 → null,
   * your method visitReverse should return the string “5 4 3 2 1”.
   */
  public String visitReverse() {
    // Check if the current node is the last node in the linked list.
    if(head.getNext() == null){
      return Integer.toString(head.getData());
    }
    // Save the current data value.
    String result = Integer.toString(head.getData());
    head = head.getNext();

    // Concatenate the returned string of the method call to the current string.
    return visitReverse() + " " + result;
  }

  /* isSorted():
   * This method returns true if the linked list is sorted in increasing
   * order, false otherwise.
   * Your method should be ITERATIVE.
   * Example: When your linked list L is:
   *      head → 1 → 2 → 3 → 4 → 5 → null,
   * your method isSorted should return true.
   * When your linked list L is:
   *      head → 1 → 6 → 2 → 7→ 5 → null,
   * your method isSorted should return false.
   */
  public boolean isSorted() {
    intNode iter = head;
    while(iter.getNext() != null){
      // If the value in current node is greater than the value in the next node, return false.
      if(iter.getData() > iter.getNext().getData()){
        return false;
      }
      // Update the iterator.
      iter = iter.getNext();
    }
    // Return true once the whole linked list has been traversed.
    return true;
  }

}

