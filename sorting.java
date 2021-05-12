public class sorting {
  public static void main(String[] args){
    int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };

    System.out.println("UNSORTED: ");
    for(int i = 0; i < numbers.length; ++i) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    MergeSort(numbers, 0, numbers.length - 1);

    System.out.println("SORTED: ");
    for(int i = 0; i < numbers.length; ++i) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    int numbers2[] = { 10, 2, 78, 4, 45, 32, 7, 11 };
    int NUMBERS_SIZE = 8;
    int i = 0;

    System.out.println("UNSORTED: ");
    for(i = 0; i < NUMBERS_SIZE; ++i) {
      System.out.print(numbers2[i] + " ");
    }
    System.out.println();

    // Initial call to quicksort
    Quicksort(numbers2, 0, NUMBERS_SIZE - 1);

    System.out.println("SORTED: ");
    for(i = 0; i < NUMBERS_SIZE; ++i) {
      System.out.print(numbers2[i] + " ");
    }
    System.out.println();
  }
  public static void Quicksort(int[] numbers, int i, int k) {
    // Base case: If there are 1 or zero elements to sort,
    // partition is already sorted
    if (i >= k) {
      return;
    }

    // Partition the data within the array. Value j returned
    // from partitioning is location of last element in low partition.
    int j = Partition(numbers, i, k);


    // Recursively sort low partition (i to j) and
    // high partition (j + 1 to k)
    Quicksort(numbers, i, j);
    Quicksort(numbers, j+ 1, k);
  }

  public static int Partition(int[] numbers, int i, int k) {
    // Pick middle element as pivot
    int pivot = numbers[i];

    int less = i + 1;
    int more = k;

    while (less < more) {

      // Increment l while numbers[l] < pivot
      while (less<= k && numbers[less] <= pivot) {
        ++less;
      }

      // Decrement h while pivot < numbers[h]
      while (more >= i && numbers[more]> pivot) {
        more--;
      }

      // If there are zero or one elements remaining,
      // all numbers are partitioned. Return h
      if (less < more) {
        // Swap numbers[l] and numbers[h],
        // update l and h
        int temp = numbers[less];
        numbers[less] = numbers[more];
        numbers[more] = temp;

        less++;
        more--;
      }
    }
    int temp = numbers[i];
    numbers[i] = numbers[more];
    numbers[more] = temp;
    System.out.println("more: " + more);
    return more;
  }
  public static void MergeSort(int[] numbers, int i, int k) {
    if (i>=k){
      return;
    }

      int j = (i + k) / 2 ; // Find the midpoint in the partition

      // Recursively sort left and right partitions
      MergeSort(numbers, i, j);
      MergeSort(numbers, j + 1, k);

      // Merge left and right partition in sorted order
      Merge(numbers, i, j, k);

  }
  public static void Merge(int[] numbers, int i, int j, int k) {
    int mergedSize = k - i + 1;                // Size of merged partition
    int mergePos = 0;                         // Position to insert merged number
    int leftPos = 0;                          // Position of elements in left partition
    int rightPos = 0;                          // Position of elements in right partition
    int[] mergedNumbers = new int[numbers.length];   // Dynamically allocates temporary array
    // for merged numbers

    leftPos = i;                           // Initialize left partition position
    rightPos = j + 1;                      // Initialize right partition position

    // Add smallest element from left or right partition to merged numbers
    while (leftPos <= j && rightPos <= k) {
      if (numbers[leftPos] <= numbers[rightPos]) {
        mergedNumbers[mergePos] = numbers[leftPos];
        leftPos++;
      }
      else {
        mergedNumbers[mergePos] = numbers[rightPos];
        rightPos++;

      }
      mergePos++;
    }

    // If left partition is not empty, add remaining elements to merged numbers
    while (leftPos <= j) {
      mergedNumbers[mergePos] = numbers[leftPos];
      leftPos++;
      mergePos++;
    }

    // If right partition is not empty, add remaining elements to merged numbers
    while (rightPos <= k) {
      mergedNumbers[mergePos] = numbers[rightPos];
      rightPos++;
      mergePos++;
    }

    // Copy merge number back to numbers
    for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
      numbers[i + mergePos] = mergedNumbers[mergePos];
    }
  }
}
