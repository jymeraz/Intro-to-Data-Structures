public class TorusGameOfLife extends GameOfLife {

  // Default constructor.
  public TorusGameOfLife(){ }

  // Constructor that takes size as input.
  // Size will be the size of the board and previous.
  public TorusGameOfLife(int s){
    size = s;
    board = new int[size][size];
    previous = new int[size][size];
  }

  // Constructor that takes a 2D array as input.
  // Size of array will be the size of the board and previous.
  public TorusGameOfLife(int[][] inputArray){
    size = inputArray.length;

    board = new int[size][size];
    previous = new int[size][size];

    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        previous[i][j] = inputArray[i][j];
      }
    }
  }

  // Count the number of neighbors.
  @Override
  public int neighbors(int row, int col){
    // Return the summation of the values around the target.
    return
        previous[(row - 1 + size) % size][(col - 1 + size) % size] +
        previous[(row - 1 + size) % size][(col) % size] +
        previous[(row - 1 + size) % size][(col + 1) % size] +
        previous[(row) % size][(col - 1 + size) % size] +
        previous[(row) % size][(col + 1) % size] +
        previous[(row + 1) % size][(col - 1 + size) % size] +
        previous[(row + 1) % size][(col) % size] +
        previous[(row + 1) % size][(col + 1) % size];
  }
}
