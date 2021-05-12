import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BTSQTester {
  // This test case is for the method evaluate in the PostfixExpression class.
  // This test case uses a simple summation expression in order to test the method without introducing too many variables at once.
  // The sum operator was chosen because the order of the operands does not matter.
  // The values of 3 and 4 were arbitrarily chosen with the condition that they were each a single digit long.
  // This test passed, so the method is able to correctly sum two integers.
  @Test
  public void evaluateOne(){
    PostfixExpression expression = new PostfixExpression("34+");
    assertEquals(7, expression.evaluate());
  }

  // This test case is for the method evaluate in the PostfixExpression class.
  // This test case increases the number of levels that the method has to evaluate.
  // This is to make sure that the correct expressions are being handled in the correct order.
  // Multiplication operators were used in this case because the order of the operands does not matter and it checks that the multiplication operator can be used.
  // The integers used in this test were chosen randomly with the condition that they were each a single digit.
  // This test passed, so the method is able to correctly multiply integers with multiple operators.
  @Test
  public void evaluateTwo(){
    PostfixExpression expression = new PostfixExpression("765**");
    assertEquals(210, expression.evaluate());
  }

  // This test case is for the method evaluate in the PostfixExpression class.
  // This test case has only one level and it uses the subtraction operator.
  // The subtraction operator is used to make sure that the numbers are being subtracted in the correct order.
  // The integers used in this test were chosen randomly with the condition that they were each a single digit.
  // This test passed, so the method is able to correctly subtract two digits.
  @Test
  public void evaluateThree(){
    PostfixExpression expression = new PostfixExpression("56-");
    assertEquals(-1, expression.evaluate());
  }

  // This test case is for the method evaluate in the PostfixExpression class.
  // This test case increases the number of levels that the method has to evaluate.
  // This is to make sure that the correct expressions are being handled in the correct order.
  // Division operators were used in this case because the order of the operands matters, so it checks that they are being evaluated correctly.
  // The integers used in this test were chosen randomly with the condition that they were each a single digit.
  // This test passed, so the method is able to correctly divide integers with multiple operators.
  @Test
  public void evaluateFour(){
    PostfixExpression expression = new PostfixExpression("731//");
    assertEquals(2, expression.evaluate());
  }

  // This test case is for the method evaluate in the PostfixExpression class.
  // This test case increases the number of levels that the method has to evaluate and it includes all the available operators.
  // This is to make sure that the correct expressions are being handled in the correct order with the correct operator.
  // The integers used in this test were chosen randomly with the condition that they were each a single digit.
  // This test passed, so the method is able to correctly evaluate an expression with multiple different operators.
  @Test
  public void evaluateFive(){
    PostfixExpression expression = new PostfixExpression("22^6-798/+*");
    assertEquals(-16, expression.evaluate());
  }

  // This test case is for the method evaluate in the ExpressionBT class.
  // This test case is an edge test case that tests what will happen if an operator only has one child.
  // In order to achieve this, the root is an operator with only a right node.
  // This is important because a mistake could be made in the future (which I did do) where only one node is typed and there needs to be a way to alert the user of it.
  // At first, the test resulted in a null pointer exception.
  // After adding an additional condition to the method, the test passed and the tree was not evaluated.
  @Test
  public void evaluateBTOne(){
    String[] s = {"*", null, "9"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    assertEquals(0, expressionBT.evaluate());
  }

  // This test case is for the method evaluate in the ExpressionBT class.
  // This test case checks that the method can evaluate a tree with multiplication and addition operators.
  // The array {"+", "2", "*", null, null, "6", "9"} was chosen to create the tree because it has multiple levels to accommodate for the multiple operators.
  // The integers values were chosen randomly as long as they are of type int.
  // This test case passed, so the method is able to evaluate a tree with multiplication and addition operators.
  @Test
  public void evaluateBTTwo(){
    String[] s = {"+", "2", "*", null, null, "6", "9"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    assertEquals(56, expressionBT.evaluate());
  }

  // This test case is for the method evaluate in the ExpressionBT class.
  // This test case checks that the method can evaluate a tree with division and subtraction operators.
  // It is important to test with division and subtraction because it makes sure that the order of the operands is correct.
  // the array {"/", "-", "3", "7", "2", null, null} was chosen to create the tree because it has multiple levels to accommodate for the multiple operators.
  // The integers values were chosen randomly as long as they are of type int.
  // This test case passed, so the method is able to evaluate a tree with division and subtraction operators.
  @Test
  public void evaluateBTThree(){
    String[] s = {"/", "-", "3", "7", "2", null, null};
    ExpressionBT expressionBT = new ExpressionBT(s);
    assertEquals(1, expressionBT.evaluate());
  }

  // This test case is for the method evaluate in the ExpressionBT class.
  // This test case checks that the method can evaluate a tree with all five operators.
  // It is important to test with multiple operators because it makes sure that the correct ones are being applied.
  // the array {"-", "*", "+", "7", "/", "+", "^", null, null, "3", "4", "7", "3", "6", "2"} was chosen to create the tree because it has multiple levels to accommodate for the multiple operators.
  // The integers values were chosen randomly as long as they are of type int.
  // This test case passed, so the method is able to evaluate a tree with multiple different operators and levels.
  @Test
  public void evaluateBTFour(){
    String[] s = {"-", "*", "+", "7", "/", "+", "^", null, null, "3", "4", "7", "3", "6", "2"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    assertEquals(-46, expressionBT.evaluate());
  }

  // This test case is for the method evaluate in the ExpressionBT class.
  // This test case checks that the method will produce an error statement if there is a variable present.
  // the array {"+", "3", "+", null, null, "7", "k"} was chosen to create the tree because the variable is in the lowest leaf node on the right.
  // This makes sure that the variable can be detected at any level.
  // The integers values were chosen randomly as long as they are of type int.
  // This test case passed, so the method is able to print an error message and return 0 if a variable is present.
  @Test
  public void evaluateBTFive(){
    String[] s = {"+", "3", "+", null, null, "7", "k"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    assertEquals(0, expressionBT.evaluate());
  }

  // This test case is for the method print in the ExpressionBT class.
  // The array {"+", "2", "1"} is used because it is very simple, and as a first test case, it is important to know that the method can complete this task.
  // The operator was randomly chosen since no evaluating is actually occurring.
  // The integer values were chosen as single digits in order to have the printed expression easier to check.
  // The expected output is (2 + 1)
  // This test passed, so the method is able to print the tree in in-fix notation with the correct parenthesis.
  @Test
  public void printOne(){
    String[] s = {"+", "2", "1"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.print();
  }

  // This test case is for the method print in the ExpressionBT class.
  // This test case contains additional levels, uneven subtrees, and a variable.
  // This makes sure that the appropriate parenthesis are being used and the variable is still printed out.
  // This test case also contains a larger left subtree than the right subtree in order to make sure that the open parenthesis "(" are being printed correctly.
  // The expected output is ((a + 3) - 6)
  // This test case failed at first since the beginning open parenthesis would not print the correct amount of times.
  // In order to fix this, I noticed that the number of parenthesis correlates to the number of levels, or pushes to the stack.
  // By applying this idea, the test case passed so the method can print the correct in-fix notation of a tree with higher left concentration and a variable.
  @Test
  public void printTwo(){
    String[] s = {"-", "+", "6", "a", "3", null, null};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.print();
  }

  // This test case is for the method print in the ExpressionBT class.
  // This test case contains two equal branches in the binary tree.
  // This helps make sure that the two branches are separated by parenthesis with the root node in the middle.
  // The operators of '+' and '-' were chosen arbitrarily and the integers were chosen randomly.
  // The expected output is ((2 - 5) + (5 + 1))
  // This test case passed, which means that the method can print the correct in-fix notation of a tree with balanced subtrees.
  @Test
  public void printThree(){
    String[] s = {"+", "-", "+", "2", "5", "5", "1"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.print();
  }

  // This test case is for the method print in the ExpressionBT class.
  // This test case contains multiple unequal branches.
  // This makes sure that the correct expression will still be printed despite the heavy concentration of nodes on the right of the tree.
  // The expected output is (63 / (8 - (3 - (4 + 6))))
  // This test case failed multiple times.
  // This was because the close parenthesis were not printing in the correct places.
  // In order to fix this error, I noticed a pattern where the closing parenthesis are printed right after a number if the number did not come right after parenthesis.
  // I incorporated this into my algorithm and the test case passed.
  // This means that the method can correctly print the in-fix notation of a tree with a high concentration in its right subtree.
  @Test
  public void printFour(){
    String[] s = {"/", "63", "-", null, null, "8", "-", null, null, null, null, null, null, "3", "+", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "4", "6"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.print();
  }

  // This test case is for the method print in the ExpressionBT class.
  // This test case contains multiple unequal branches.
  // This makes sure that the correct expression will still be printed despite the heavy concentration of nodes on the left of the tree.
  // The expected output is (((4 - 1) + 3) * 7).
  // This test case did not pass multiple times.
  // In many cases, this test case would pass when the test case called printFour() would fail, so it is important to check both of these cases independently.
  // After applying the same logic discussed in the previous test case (printFour()), this test case passed.
  // This means that the method is able to print the in-fix notation of a tree with a more concentrated left subtree.
  @Test
  public void printFive(){
    String[] s = {"*", "+", "7", "-", "3", null, null, "4", "1", null, null, null, null, null, null};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.print();
  }

  // This test case is for the method allVariables in the ExpressionBT class.
  // This test case uses the array {"v"} because it is very simple.
  // The objective is to make sure that it can detect a variable, so this helps make sure it can that in order to build to more complex trees.
  // The expected output is "v ".
  // This test passed and printed out the variable.
  @Test
  public void allVariablesOne(){
    String[] s = {"v"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.allVariables();
  }

  // This test case is for the method allVariables in the ExpressionBT class.
  // This test case uses the array {"+", "+", "+", "3", "4", "5", "+", "3", "v"} to create the tree because it contains only one variable.
  // The variable was paced in the bottom of the tree in order to make sure that the rest of the tree was traversed and nothing else was printed.
  // The operator used is '+' because it is not of interest because the type of operator does not play a role.
  // The expected output is "v ".
  // This test case passed and the method printed the variable.
  @Test
  public void allVariablesTwo(){
    String[] s = {"+", "+", "+", "3", "4", "5", "+", "3", "v"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.allVariables();
  }

  // This test case is for the method allVariables in the ExpressionBT class.
  // This test case uses the array {"+", "a", "+", null, null, "b", "+", null, null, null, null, null, null, "c", "d"} to create the tree.
  // This array was used because it creates multiple levels that require traversing.
  // The variables used are ordered in alphanumerical order according to how they're supposed to be printed out in order to facilitate the evaluation at the end.
  // This test also only uses variables because it is just checking that they will be printed out in the correct order.
  // The operator used is '+' because it is not of interest because the type of operator does not play a role.
  // The expected output is "a b c d "
  // This test case passed and the method printed all the variables in the correct order.
  @Test
  public void allVariablesThree(){
    String[] s = {"+", "a", "+", null, null, "b", "+", null, null, null, null, null, null, "c", "d"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.allVariables();
  }

  // This test case is for the method allVariables in the ExpressionBT class.
  // This test case uses the array {"a", "b", "c", "d", "e", "f", "g"} to create the tree because it is made up of only variables.
  // This makes sure that the tree is being traversed in the correct of level-order.
  // The expected output is "a b c d e f g "
  // This test case passed, so the method is correctly traversing the entire tree in level-order.
  @Test
  public void allVariablesFour(){
    String[] s = {"a", "b", "c", "d", "e", "f", "g"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.allVariables();
  }

  // This test case is for the method allVariables in the ExpressionBT class.
  // This test case uses the array {"+", "+", "+", "7", "3", "4", "+", null, null, null, null, "3", "2"} to create the tree because no variables are included.
  // This makes sure that there is nothing printed out if there are no variables present.
  // The expected output is "No variables in this expression".
  // This test case passed and the method did not print anything out.
  @Test
  public void allVariablesFive(){
    String[] s = {"+", "+", "+", "7", "3", "4", "+", null, null, null, null, "3", "2"};
    ExpressionBT expressionBT = new ExpressionBT(s);
    expressionBT.allVariables();
  }
}
