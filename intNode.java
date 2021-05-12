public class intNode {

  private int data;
  private intNode next;

  public intNode() {}

  public intNode(int data) {
    this.data = data;
  }

  /**
   * @return the data
   */
  public int getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(int data) {
    this.data = data;
  }

  /**
   * @return the next
   */
  public intNode getNext() {
    return next;
  }

  /**
   * @param next the next to set
   */
  public void setNext(intNode next) {
    this.next = next;
  }

  // Other methods ***************************************************************
  public int sizeFromNode() {
    intNode iter = this;
    int size = 0;
    while (iter != null) {
      size++;
      iter = iter.getNext();
    }
    return size;
  }

  public String toString() {
    if (next == null)	return "" + data + ".";
    return "" + data + ", ";
  }
}

