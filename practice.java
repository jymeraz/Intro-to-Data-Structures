

public class practice {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
    int[][] arr3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    System.out.println("FIND: " + FIND(arr, 2));
    System.out.println("FIND2D: " + FIND2D(arr2, 7));
    System.out.println("FIND: " + FIND2DBIS(arr2, 7));
    System.out.println("diagonal: " + HighestDiagonal(arr3));
    System.out.println("codingbat: " + bigDiff(arr));


    }

  public static boolean FIND(int[] a, int b){
    for (int i = 0; i < a.length; i++) {
      if (b == a[i]) {
        return true;
      }
    }
    return false;
    }

  public static boolean FIND2D(int[][] a, int b){
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (b == a[i][j]) {
          return true;
        }
      }
    }
    return false;
    }

  public static boolean FIND2DBIS(int[][] a, int b){
    for (int i = 0; i<a[i].length; i++){
      if (FIND(a[i], b)){
        return true;
      }
    }
    return false;
  }


  //A method HighestDiagonal that takes a 2D array of integers A.
  // It returns true if the sum of the elements on the main diagonal
  // is larger than the sum of elements on the secondary diagonal.
  public static boolean HighestDiagonal(int[][] a){
    int sumDiag1 = 0;
    int sumDiag2 = 0;

    for (int i = 0; i<a.length; i++){
      sumDiag1 += a[i][i];
    }

    int counter = 1;

//    for (int i = 0; i<a.length; i++){
//      sumDiag2 += a[i][a[i].length - counter];
//      //System.out.println(a[i][a[i].length - counter]);
//      counter++;
//    }

    for (int i = 0; i<a.length; i++){
        sumDiag2 += a[i][a.length - 1 -i];
        System.out.println(a[i][a.length - 1 - i]);
    }

    System.out.println("Diag1: " + sumDiag1);
    System.out.println("Diag2: " + sumDiag2);

//    if (sumDiag1 > sumDiag2){
//      return true;
//    }
//    return false;
    // OR
    return (sumDiag1 > sumDiag2);
  }
  public static int[] reverse3(int[] nums) {
    int[] reverse = new int[nums.length];
    for (int i = 0; i < nums.length; i++){
      for (int j = nums.length - 1; j >= 0; j--){
        System.out.println("nums: " + j + " " + nums[j]);
        reverse[i] = nums[j];
        System.out.println("reverse: " + i + " " + reverse[i]);
      }
    }
    return reverse;
  }
  public static int bigDiff(int[] nums) {
    int max = nums[0];
    int min = nums[0];

    for (int i = 0; i< nums.length - 1; i++){
      if (nums[i] > max){
        max = nums[i];
        System.out.println("if max: " + max);
      }
      if (nums[i] < min){
        min = nums[i];
        System.out.println("if min: " + min);
      }
      System.out.println("max: " + max);
      System.out.println("min: " + min);
      //max = Math.max(max, nums[i + 1]);
      //min = Math.min(max, nums[i + 1]);
    }
    return max-min;
  }
}
