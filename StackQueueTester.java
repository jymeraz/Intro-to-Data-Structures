import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackQueueTester {
  // This test case tests the push method of the myStacks class.
  // This test case checks whether a string can be pushed to the stack.
  // The string chosen is "firstString" because the actual contents of the string are not of interest as long as it is a string.
  // Only one string was chosen to be pushed to the stack array because it is important to know whether a string can be pushed without any additional variables.
  // The expected output of this method call is a returned boolean value of "True" because the array is of size 10 and empty.
  // The test ended up passing, so the push method is able to add a string to the top of the stack.
  @Test
  public void testOne(){
    myStack newStack = new myStack();
    assertTrue(newStack.push("firstString"));
  }

  // This test case tests the pop method of the myStacks class.
  // This test case uses the constructor with an int parameter, which in this test case was set to 2.
  // There are three method calls to push, which include distinct strings in order to be able to differentiate them when the top value is popped.
  // The actual contents of the strings being pushed are not of interest and they were named in numerical order in order to aid in visualization.
  // The chosen integer value is set to 2 because it is used to make sure that only two of the three method calls to push actually push the string onto the stack.
  // This is testing the method pop because pop is expected to return the value at the top, which should be the string in the second method call to push.
  // This is important because when the array is filled, the top value should not be edited.
  // This test case passed, which means that the pop method removes and returns the top element of a stack.
  @Test
  public void testTwo(){
    myStack newStack = new myStack(2);
    newStack.push("firstString");
    newStack.push("secondString");
    newStack.push("thirdString");
    assertEquals("secondString", newStack.pop());
  }

  // This test case tests the getSize method of the myStacks class.
  // This test case uses a combination of method calls for pop and push.
  // This is to make sure that the number of strings in the stack is being correctly updated despite multiple changes.
  // The actual contents of the strings being pushed are not of interest and they were named in numberical order in order to aid in visualization.
  // The instantiation of the class is created by passing an integer of 5 as an argument.
  // This was done in order to allow the strings to remain part of the stack if the top value is not edited accordingly by avoiding reaching the size limit.
  // This allows to see whether the number of elements in the stack are being altered when the size limit is not an issue.
  // The expected returned integer value is 2 because two strings were pushed, one was popped, then one was pushed again, which results in a total of 2 strings in the stack.
  // This test passed, so the method is able to return the number of elements in the stack.
  @Test
  public void testThree(){
    myStack newStack = new myStack(5);
    newStack.push("firstString");
    newStack.push("secondString");
    newStack.pop();
    newStack.push("thirdString");
    assertEquals(2, newStack.getSize());
  }

  // This test case tests the method isEmpty of the myStacks class.
  // This test case includes two method calls to the push method, followed by two method calls to the pop method.
  // This was done in order to make sure that the stack will still be empty despite previous pushes.
  // The actual contents of the strings being pushed are not of interest and they were named in numerical order in order to aid in visualization.
  // The size of the array to be made was set to 3 in order to be able to contain both of the strings being pushed.
  // The method isEmpty uses the attribute "top" in order to check if the stack is empty, so this test case makes sure that this attribute is being updated correctly.
  // The expected returned boolean value is true since the end stack should be empty.
  // This test case passed, which means that the method isEmpty can successfully check if the stack is empty.
  @Test
  public void testFour(){
    myStack newStack = new myStack(3);
    newStack.push("firstString");
    newStack.push("secondString");
    newStack.pop();
    newStack.pop();
    assertTrue(newStack.isEmpty());
  }

  // This test case tests the method isFull of the myStacks class.
  // This test case creates an array of size 3 and is followed by three method calls to push.
  // The actual contents of the strings being pushed are not of interest and they were named in numerical order in order to aid in visualization.
  // Exactly 3 pushes and not additional ones are included in order to check if having the exact amount to fill the stack will return as being full.
  // Less pushes were not included in order to affirm that the method can check when a stack is fully filled.
  // The expected returned boolean value is true since there were the same number of pushes as the size of the array.
  // This test case passed, which means that the method isFull can correctly check whether a stack is full or not.
  @Test
  public void testFive(){
    myStack newStack = new myStack(3);
    newStack.push("firstString");
    newStack.push("secondString");
    newStack.push("thirdString");
    assertTrue(newStack.isFull());
  }

  // This test case tests the enqueue method from the myQueue class.
  // This test case uses the default constructor to create an array of size 10 and enqueues a single string.
  // The string chosen is "firstString" because the actual contents of the string are not of interest as long as it is a string.
  // This test is important because this method uses modulus, so it is important that it is being used correctly.
  // Since this operator works regardless if the string being enqueued has to wrap around the array, only one string is being enqueued to an empty array.
  // The expected returned boolean value of the method is true.
  // This test case passed, so the enqueue method works in adding a string to the queue.
  @Test
  public void testSix(){
    myQueue newQueue = new myQueue();
    assertTrue(newQueue.enqueue("firstString"));
  }

  // This test case tests the dequeue method from the myQueue class.
  // This test case creates an array of size 3 and enqueues 3 strings to that array.
  // The actual contents of the strings being pushed are not of interest and they were named in numerical order in order to aid in visualization.
  // This test case has three enqueues because it makes sure that when the dequeue method is checked, it does not return the second or third string enqueued.
  // This way, the additional strings provide the chance for an error to happen, which would be beneficial since it could then get fixed.
  // The expected string returned from the method call to dequeue is "firstString" because that was the first string pushed and is currently the head of the array.
  // This test case passed, so the dequeue method is able to return the first string in the queue.
  @Test
  public void testSeven(){
    myQueue newQueue = new myQueue(3);
    newQueue.enqueue("firstString");
    newQueue.enqueue("secondString");
    newQueue.enqueue("thirdString");
    assertEquals("firstString", newQueue.dequeue());
  }

  // This test case tests the method getSize from the myQueue class.
  // This test case creates an array of size 3, then enqueues three strings, then dequeues two, and finally enqueues one more string.
  // The purpose of this is to use the wrap around feature of queues.
  // This way, even though the array itself is populated, the method call to getSize should only return the number of elements that are part of the actual queue.
  // The actual contents of the strings being pushed are not of interest and they were named in numerical order in order to aid in visualization.
  // The wrap around feature also makes sure that the modulus operator was applied correctly, and the enqueue call correctly overwrites the next spot on the queue.
  // The expected returned value is 2 because after the dequeues and the additional push, only two elements are part of the queue.
  // This test case passed, so the method getSize can correctly return the number of elements in the queue.
  @Test
  public void testEight(){
    myQueue newQueue = new myQueue(3);
    newQueue.enqueue("firstString");
    newQueue.enqueue("secondString");
    newQueue.enqueue("thirdString");
    newQueue.dequeue();
    newQueue.dequeue();
    newQueue.enqueue("fourthString");
    assertEquals(2, newQueue.getSize());
  }

  // This test case tests the method isEmpty from the myQueue class.
  // This test case creates an array of size 2 and enqueues a string.
  // The string chosen is "firstString" because the actual contents of the string are not of interest as long as it is a string.
  // This test case was chosen because it makes sure that the value of the attribute "top" is being correctly updated when an element is added to the queue.
  // The size of 2 for the array was chosen in order to make sure that the single string fits in the queue while still having available space in case that could affect if the array is seen as empty.
  // The expected returned boolean value is false because a string exists in the queue.
  // This test case passed, so the method isEmpty is able to correctly return whether a queue is empty or not.
  @Test
  public void testNine(){
    myQueue newQueue = new myQueue(2);
    newQueue.enqueue("firstString");
    assertFalse(newQueue.isEmpty());
  }

  // This test case tests the method isFull from the myQueue class.
  // This test case creates an array of size 4, then enqueues four strings, then dequeues a string.
  // The actual contents of the strings being pushed are not of interest and they were named in numerical order in order to aid in visualization.
  // A string is dequeued at the end in order to mae sure that the method isFull will return a false even if the queue was full at one point.
  // This dequeue also makes sure that the number of elements is being correctly updated, which is an attribute being used in this method.
  // The expected returned boolean value is false because the queue contains one empty spot.
  // This test case passed, so the method isFull is able to return when the queue is full.
  @Test
  public void testTen(){
    myQueue newQueue = new myQueue(4);
    newQueue.enqueue("firstString");
    newQueue.enqueue("secondString");
    newQueue.enqueue("thirdString");
    newQueue.enqueue("fourthString");
    newQueue.dequeue();
    assertFalse(newQueue.isFull());
  }
}