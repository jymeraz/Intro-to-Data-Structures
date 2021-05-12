public class IntBT {
  private int data;
  private IntBT left;
  private IntBT right;

  public IntBT(){
    data = 0;
    left = null;
    right = null;
  }

  public void setData(int d){
    data = d;
  }
  public void setLeft(IntBT L){
    left = L;
  }
  public void setRight(IntBT R){
    right = R;
  }
  public int getData(){
    return data;
  }
  public IntBT getLeft(){
    return left;
  }
  public IntBT getRight(){
    return right;
  }
  public void levelOrder(){

    IntQueue queue = new IntQueue();

    System.out.print(data + " ");
    if (left != null){
      queue.enqueue(left);
    }
    if(right != null) {
      queue.enqueue(right);
    }

    while (!queue.isEmpty()){
      IntBT front = queue.dequeue();

      System.out.print(front.data + " ");
      if (front.left != null){
        queue.enqueue(front.left);
      }
      if(front.right != null){
        queue.enqueue(front.right);
      }
    }

  }

}
