public class SortOfSort {
  public void sortOfSort(int[] integerArray){
    // Declare variable to hold the index of the max value.
    int maxIndex;
    // Declare and initialize variable that makes sure the values swapped at the end of the array come before the sorted section.
    int endIndex = integerArray.length - 1;
    // Declare and initialize variable that makes sure the array be2gins after the sorted section.
    int beginningIndex = 0;
    // Declare and initialize variable that checks if the value is added to the beginning or the end.
    int counter = 1;
    // Declare and initialize variable that makes sure the array is only iterated up until the sorted section.
    int arrayEndLimit = 0;

    // Iterate through the array for the length of the array in order to place each value in its desired place.
    for(int l = 0; l < integerArray.length; l++) {
      // Declare the max index to be the beginning of the section being iterated through.
      maxIndex = beginningIndex;
      // Iterate through the rest of the section to find the index of the max.
      for (int i = beginningIndex; i < integerArray.length - arrayEndLimit; i++) {
        if (integerArray[i] > integerArray[maxIndex]) {
          maxIndex = i;
        }
      }

      // Check whether the value should be added to the beginning or the end.
      if(counter == 1){
        // Call the method swap to swap the desired values.
        swap(integerArray, maxIndex, endIndex);
        // Decrease the stopping point for the end of the array.
        endIndex--;
        // Increase counter.
        counter++;
        // Increase the stopping point for the end of the array in order for it to be subtracted in the for-loop.
        arrayEndLimit++;
      } else if(counter == 2){
        swap(integerArray, maxIndex, endIndex);
        endIndex--;
        // Set counter equal to -1 in order to place the next values in the beginning.
        counter = -1;
        arrayEndLimit++;
      } else if (counter == -1){
        swap(integerArray, maxIndex, beginningIndex);
        // Increment the beginning index in order to separate the sorted from the unsorted part.
        beginningIndex++;
        counter--;
      } else {
        swap(integerArray, maxIndex, beginningIndex);
        beginningIndex++;
        // Set counter equal to 1 in order to place the next values in the end.
        counter = 1;
      }
    }
  }
  // Method used to swap two values.
  public void swap(int[] integerArray, int largest, int toSwap){
    int temp = integerArray[largest];
    integerArray[largest] = integerArray[toSwap];
    integerArray[toSwap] = temp;
  }
}
