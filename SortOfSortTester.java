import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SortOfSortTester {
  // This test case tests whether the method can handle an odd length integer array.
  // The integers in the array are all positive because the ability to handle negative numbers is not being tested.
  // The integers in the array were all randomly chosen and are placed in no particular order in the array.
  // This test is important because it tests whether the method can handle having only one element to compare at the end.
  // This test failed at first because the resultant array was {5, 2, 3, 7, 8}.
  // This error was occurring because instead of comparing 2 to 3, 2 was only being compared to itself, which resulted in 2 being chosen as the maximum.
  // This error was fixed by fixing the condition in the for-loop that allows it to keep looping to only decrement if a maximum value was placed at the end of the array.
  @Test
  public void testOne(){
    int[] inputArray = {8, 7, 3, 2, 5};
    int[] expectedOutput = {5, 3, 2, 7, 8};

    SortOfSort testOne = new SortOfSort();
    testOne.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }

  // This test case tests whether the method can handle an even length array.
  // The integers in the array are all positive because the ability to handle negative numbers is not being tested.
  // The integers in the array were all randomly chosen.
  // The integers were placed in such a way that the method would have to move each one in order to be sort of sorted.
  // This was done to make sure that each integer is being inspected despite being in the correct place.
  // This test is important because it tests whether the method can handle having two values at the end to compare rather than a singular one as the previous test.
  // This test passed, so the method can handle arrays of even length and inspects each element despite being in the correct index.
  @Test
  public void testTwo(){
    int[] inputArray = {9, 8, 5, 6, 4, 3};
    int[] expectedOutput = {6, 5, 3, 4, 8, 9};

    SortOfSort testTwo = new SortOfSort();
    testTwo.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }

  // This test case tests whether the method can handle arrays that are longer.
  // The integers in the array are all positive because the ability to handle negative numbers is not being tested.
  // The integers in the array were all randomly chosen and are placed in no particular order in the array.
  // This test is important because a methods ability to handle shorter arrays does not mean it can handle longer arrays.
  // The statement above was confirmed when this test case failed at first.
  // Although the test case is of even length, the method was not iterating through the entire desired array of numbers in order to find the max.
  // This error was fixed by changing the for-loop condition to stop right before the sorted elements.
  @Test
  public void testThree(){
    int[] inputArray = {3, 5, 4, 6, 9, 8, 2, 1};
    int[] expectedOutput = {6, 5, 2, 1, 3, 4, 8, 9};

    SortOfSort testThree = new SortOfSort();
    testThree.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }

  // This test case tests whether the method can handle negative numbers.
  // The integers in the array were all randomly chosen apart from 2, -2, and -4.
  // These values are essential because the comparison between -2 and 2 ensures that they are not being treated as the same value.
  // In addition, the comparison between -2 and -4 ensures that -4 is being selected as the smaller element.
  // This test is important because it tests whether the negative values are being compared correctly and placed in the correct order.
  // This test failed at first due to an error on my part by placing the expected array to be {-2, -4, 0, 0, 3, 6}.
  // The error in this expectation was that 0 is actually greater and not less than -2 or -4.
  // The test was successful and passed otherwise.
  @Test
  public void testFour(){
    int[] inputArray = {-2, 0, 2, 3, -4, 6};
    int[] expectedOutput = {2, 0, -4, -2, 3, 6};

    SortOfSort testFour = new SortOfSort();
    testFour.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }

  // This test case tests whether the method can handle duplicates within the array.
  // The integers in the array were chosen randomly with the addition of duplicates for the number 1 and 3.
  // This test is important because the method should be able to handle this unique case.
  // This test passed and handled the duplicates normally.
  // This shows that the method is able to handle arrays with repeating integers.
  @Test
  public void testFive(){
    int[] inputArray = {1, 3, 4, 5, 1, 1, 3, 7};
    int[] expectedOutput = {4, 3, 1, 1, 1, 3, 5, 7};

    SortOfSort testFive = new SortOfSort();
    testFive.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }

  // This test case tests whether the method can handle the smallest possible odd length array.
  // The integer in the array was randomly chosen since the value of the integers itself is unimportant.
  // This test case is important because a program should always be prepared to handle unexpected cases.
  // This test case passed and the resultant array was the same as the input array.
  // This shows that the method is able to handle arrays of length 1.
  @Test
  public void testSix(){
    int[] inputArray = {1};
    int[] expectedOutput = {1};

    SortOfSort testSix = new SortOfSort();
    testSix.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }

  // This test case tests whether the method can handle the smallest possible even length array.
  // The integers in the array were randomly chosen.
  // The order of the integers was in the order of largest to smallest in order to make sure that the method actually switches their positions.
  // This test case is important because there might be overlooked statements within the method that result in tests like these failing.
  // In order to prevent that, they must be tested.
  // This test case passed, which means that the method can handle arrays with the smallest possible even length of 2.
  @Test
  public void testSeven(){
    int[] inputArray = {1, 0};
    int[] expectedOutput = {0, 1};

    SortOfSort testSeven = new SortOfSort();
    testSeven.sortOfSort(inputArray);

    for(int i = 0; i < inputArray.length; i++){
      assertEquals(expectedOutput[i], inputArray[i]);
    }
  }
}
