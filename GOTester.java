import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GOTester {

  // Begin testing for the regular Game of Life.
  // Test the return value of method neighbors.

  // Use of required array from instructions.
  @Test
  public void testNeighbors1() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}};

    GameOfLife testOne = new GameOfLife(inputArray);
    assertEquals(3, testOne.neighbors(1, 2));
  }

  // Use of required array from instructions.
  @Test
  public void testNeighbors2() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0},
        {0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testTwo = new GameOfLife(inputArray);
    assertEquals(4, testTwo.neighbors(3, 3));
  }

  // Use of required array from instructions.
  @Test
  public void testNeighbors3() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testThree = new GameOfLife(inputArray);
    assertEquals(3, testThree.neighbors(3, 4));
  }

  @Test
  public void testNeighbors4() {
    int[][] inputArray = {
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}};

    GameOfLife testFour = new GameOfLife(inputArray);
    assertEquals(8, testFour.neighbors(2, 1));
  }

  @Test
  public void testNeighbors5() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 1, 1, 1, 0},
        {0, 1, 1, 1, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testFive = new GameOfLife(inputArray);
    assertEquals(6, testFive.neighbors(3, 3));
  }

  // Test the method oneStep.
  // Use of required array from instructions.
  @Test
  public void testOneStep1() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}};

    GameOfLife testOne = new GameOfLife(inputArray);
    testOne.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testOne.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testOneStep2() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0},
        {0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testTwo = new GameOfLife(inputArray);
    testTwo.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 0},
        {0, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testTwo.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testOneStep3() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testThree = new GameOfLife(inputArray);
    testThree.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testThree.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testOneStep4() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    GameOfLife testFour = new GameOfLife(inputArray);
    testFour.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray[i].length; j++) {
        assertEquals(expectedArray[i][j], testFour.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testOneStep5() {
    int[][] inputArray = {
        {1, 1},
        {1, 1}};

    GameOfLife testFive = new GameOfLife(inputArray);
    testFive.oneStep();

    int[][] expectedArray = {
        {1, 1},
        {1, 1}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray[i].length; j++) {
        assertEquals(expectedArray[i][j], testFive.getBoard()[i][j]);
      }
    }
  }

  // Test the method evolution.
  // Use of required array from instructions.
  @Test
  public void testEvolution1() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}};

    GameOfLife testOne = new GameOfLife(inputArray);
    testOne.evolution(4);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testOne.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testEvolution2() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0},
        {0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testTwo = new GameOfLife(inputArray);
    testTwo.evolution(9);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 0},
        {0, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testTwo.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testEvolution3() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    GameOfLife testThree = new GameOfLife(inputArray);
    testThree.evolution(10);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testThree.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testEvolution4() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    GameOfLife testFour = new GameOfLife(inputArray);
    testFour.evolution(2);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testFour.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testEvolution5() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 1, 1, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
        {1, 0, 1, 1, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}};

    GameOfLife testFive = new GameOfLife(inputArray);
    testFive.evolution(2);

    int[][] expectedArray = {
        {0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
        {0, 0, 1, 1, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 1, 1, 1, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 1, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0, 1, 1, 0, 1, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testFive.getBoard()[i][j]);
      }
    }
  }

  // Begin testing for the Torus Game of Life.
  // Test the method neighbors.
  @Test
  public void testTorusNeighbors1() {
    int[][] inputArray = {
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}};

    TorusGameOfLife testOne = new TorusGameOfLife(inputArray);
    assertEquals(8, testOne.neighbors(0, 0));
  }

  @Test
  public void testTorusNeighbors2() {
    int[][] inputArray = {
        {1, 1, 1, 1},
        {1, 1, 0, 1},
        {0, 0, 0, 0},
        {1, 0, 1, 0}};

    TorusGameOfLife testTwo = new TorusGameOfLife(inputArray);
    assertEquals(3, testTwo.neighbors(3, 2));
  }

  // Use of required array from instructions.
  @Test
  public void testTorusNeighbors3() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0}};

    TorusGameOfLife testThree = new TorusGameOfLife(inputArray);
    assertEquals(4, testThree.neighbors(2, 2));
  }

  // Use of required array from instructions.
  @Test
  public void testTorusNeighbors4() {
    int[][] inputArray = {
        {0, 0, 0, 1, 0, 0},
        {0, 0, 1, 1, 1, 0},
        {0, 1, 0, 1, 0, 1},
        {0, 1, 0, 1, 0, 1},
        {0, 0, 1, 1, 1, 0},
        {0, 0, 0, 1, 0, 0}};

    TorusGameOfLife testFour = new TorusGameOfLife(inputArray);
    assertEquals(4, testFour.neighbors(0, 3));
  }

  @Test
  public void testTorusNeighbors5() {
    int[][] inputArray = {
        {1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0}};

    TorusGameOfLife testFive = new TorusGameOfLife(inputArray);
    assertEquals(3, testFive.neighbors(5, 5));
  }

  // Test the method oneStep.
  // Use of required array from instructions.
  @Test
  public void testTorusOneStep1() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}};

    TorusGameOfLife testOne = new TorusGameOfLife(inputArray);
    testOne.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testOne.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusOneStep2() {
    int[][] inputArray = {
        {1, 1, 1, 1, 1},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {1, 1, 1, 1, 1}};

    TorusGameOfLife testTwo = new TorusGameOfLife(inputArray);
    testTwo.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1},
        {0, 1, 1, 1, 0},
        {1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testTwo.getBoard()[i][j]);
      }
    }
  }

  // Use of required array from instructions.
  @Test
  public void testTorusOneStep3() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    TorusGameOfLife testThree = new TorusGameOfLife(inputArray);
    testThree.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testThree.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusOneStep4() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0},
        {0, 0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    TorusGameOfLife testFour = new TorusGameOfLife(inputArray);
    testFour.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testFour.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusOneStep5() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 1, 0, 0},
        {0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}};

    TorusGameOfLife testFive = new TorusGameOfLife(inputArray);
    testFive.oneStep();

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0},
        {0, 0, 1, 1, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 1, 1, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testFive.getBoard()[i][j]);
      }
    }
  }

  // Test the method evolution.
  // Use of required array from instructions.
  @Test
  public void testTorusEvolution1() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    TorusGameOfLife testOne = new TorusGameOfLife(inputArray);
    testOne.evolution(7);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testOne.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusEvolution2() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0}};

    TorusGameOfLife testTwo = new TorusGameOfLife(inputArray);
    testTwo.evolution(7);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testTwo.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusEvolution3() {
    int[][] inputArray = {
        {1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0}};

    TorusGameOfLife testThree = new TorusGameOfLife(inputArray);
    testThree.evolution(1);

    int[][] expectedArray = {
        {1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testThree.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusEvolution4() {
    int[][] inputArray = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1}};

    TorusGameOfLife testFour = new TorusGameOfLife(inputArray);
    testFour.evolution(30);

    int[][] expectedArray = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testFour.getBoard()[i][j]);
      }
    }
  }

  @Test
  public void testTorusEvolution5() {
    int[][] inputArray = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 1, 1, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    TorusGameOfLife testFive = new TorusGameOfLife(inputArray);
    testFive.evolution(5);

    int[][] expectedArray = {
        {0, 0, 0, 1, 0, 0},
        {0, 1, 1, 0, 1, 1},
        {0, 1, 0, 0, 1, 0},
        {0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        assertEquals(expectedArray[i][j], testFive.getBoard()[i][j]);
      }
    }
  }
}
