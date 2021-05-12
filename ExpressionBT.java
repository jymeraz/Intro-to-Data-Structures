/* ExpressionBT:
 * Complete code below where you read "COMPLETE CODE HERE" 
 * or "MODIFY THIS"
 * You may also want to add methods where it says "ADD METHODS AS NEEDED"
 */

public class ExpressionBT {
	// Attributes:
	private String     type;
	private char       operator;
	private int        value;
	private String     variable;
	private ExpressionBT left;
	private ExpressionBT right;
	
	// Constructors:
	public ExpressionBT() {}
	
	/* String[] e is the array representation of the 
	 * binary tree we want to create 
	 */
	public ExpressionBT(String[] e) {
		if (e.length == 0) return;
		
		int level = 0;
		int counter = 0;
		for (int i=0; i<e.length; i++) {
			counter++;
			if (counter == (int) (Math.pow(2,level+1))) level++;
			if (e[i] != null) this.insert(e[i], i, level);
		}
	}

	/* Insert information e in a BT given an integer n that describes 
	 * its location in the array (hence in the tree)
	 * and level describes the level at which the data will be inserted
	 * Pre-condition: this location is valid
	 */
	public void insert(String e, int n, int level) {
		
		if (n == 0) {
			// variable?
			if ((e.charAt(0) >= 97 && e.charAt(0) <= 122) 
					|| (e.charAt(0) >= 65 && e.charAt(0) <= 90)){
				type = "var";
				variable = e;
				return;
			}
			// value?
			if (e.charAt(0) >= 48 && e.charAt(0) <= 57) {
				type = "value";
				value = Integer.valueOf(e);
				return;
			}
			// operator?
			type = "operator";
			operator = e.charAt(0);
			return;
		}
		
		if (n == 1) {
			left = new ExpressionBT();
			left.insert(e, 0, level-1);
			return;
		}
		if (n == 2) {
			right = new ExpressionBT();
			right.insert(e, 0, level-1);
			return;
		}
		
		if (n + 2 - Math.pow(2,level) <= Math.pow(2,level-1)) {
			left.insert(e, n - (int)(Math.pow(2, level-1)), level - 1); 
		} else {
			right.insert(e, n-(int)(Math.pow(2,level)), level - 1); 
		}
	}
	
	public void printBT() {
		if (type != null) {
			System.out.print("Type: " + type + ": ");
			if (type.compareTo("var")==0)        System.out.println(variable);
			if (type.compareTo("operator")==0)   System.out.println(operator);
			if (type.compareTo("value")==0)      System.out.println(value);
			if (left != null)                    left.printBT();
			if (right != null)                   right.printBT();
		}
	}
	
	// Accessors:
	public String getType() 	                  { return type; }
	public int getValue() 		                  { return value; }
	public String getVariable()                   { return variable; }
	public ExpressionBT getLeft()                 { return left; }
	public ExpressionBT getRight()                { return right; }
	
	// Modifiers:
	public void setType(String t)	              { type = t; }
	public void setValue(int v)		              { value = v; }
	public void setVariable(String var)	          { variable = var; }
	public void setLeft(ExpressionBT b)           { left = b; }
	public void setRight(ExpressionBT b)          { right = b; }


	/* evaluate(): 
	 * traverses the expression using recursion and returns an integer: 
	 * the integer value of the expression. 
	 * Note: only if there are no variables in the expression. 
	 * If there are variables, print out that you cannot evaluate and return 0. 
	 * This method should be RECURSIVE
	 */
	public int evaluate() {
		// Return 0 if there are variable(s) in the expression.
		if(includesVariables()){
			System.out.println("Variable present, cannot evaluate.");
			return 0;
		}

		// Check that there is a left and a right if the type is operator.
		if(type.equals("operator") && (left == null || right == null)){
			System.out.println("Error. Can't evaluate operator without two subtrees");
			return 0;
		}

		// Return the value if it is an integer.
		if(type.equals("value")){
			return value;
		}

		// If the root is an operator, do a recursive call with the left and right subtrees and save their returned result.
		if(type.equals("operator")){
			int leftEvaluate = left.evaluate();
			int rightEvaluate = right.evaluate();

			// Apply the appropriate operation.
			// Return the value after the operation is applied.
			switch(operator){
				case '+':
					return leftEvaluate + rightEvaluate;
				case '-':
					return leftEvaluate - rightEvaluate;
				case '*':
					return leftEvaluate * rightEvaluate;
				case '/':
					return leftEvaluate / rightEvaluate;
				case '^':
					return (int) Math.pow(leftEvaluate, rightEvaluate);
				default:
					System.out.println("Error, invalid character");
					break;
			}
		}
		return 0;
	}
	
	/* print(): 
	 * prints out the expression in infix notation with parentheses, using a BTStack
	 */
	public void print() {
		// Create a new stack and save the current node.
		// Initialize a counter for the open parenthesis "(" and the close parenthesis ")".
		// Initialize a boolean variable to check whether the open parenthesis appears directly before the current value.
		BTStack stack = new BTStack();
		ExpressionBT temp = this;

		int openParenthesis = -1;
		int closeParenthesis = 0;
		boolean parenthesisPresent = false;

		// Traverse the binary tree through a stack.
		// Push the left node until the bottom of the left side is reached.
		// Pop and print the value at the top of the stack, which is the left-most node of the tree.
		// Pop and print the next value, which is the root of the tree.
		// Pop and print the next value, which is the right side of the previous root.
		while(!stack.isEmpty() || temp != null){
			while(temp != null){
				stack.push(temp);
				temp = temp.left;
				openParenthesis++;
			}
			temp = stack.pop();

			// Use a switch statement to determine what type is the current node.
			// The operators are printed alone and the values/variables are printed within parenthesis.
			// Update closeParenthesis whenever an operator is used because there is one close parenthesis "(" for each operator.
			// openParenthesis keeps track of how many levels on the left side there are, which should be printed before the left node of the current operator.
			// parenthesisPresent keeps track if an open parenthesis was used before the current value was printed, in which case a close parenthesis should not be printed.
			switch(temp.type){
				case "operator":
					System.out.print(" " + temp.operator + " ");
					closeParenthesis++;
					break;
				case "value":
					while (openParenthesis > 0) {
						System.out.print("(");
						openParenthesis--;
						parenthesisPresent = true;
					}

					System.out.print(temp.value);

					while (closeParenthesis > 0 && !parenthesisPresent) {
						System.out.print(")");
						closeParenthesis--;
					}
					break;
				case "var":
					while (openParenthesis > 0) {
						System.out.print("(");
						openParenthesis--;
						parenthesisPresent = true;
					}

					System.out.print(temp.variable);

					while (closeParenthesis > 0 && !parenthesisPresent) {
						System.out.print(")");
						closeParenthesis--;
					}
					break;
				default:
					System.out.println("Error, invalid character.");
					break;
			}
			// Update the variables being used.
			temp = temp.right;
			openParenthesis = -1;
			parenthesisPresent = false;
		}
	}
	
	/* allVariables(): 
	 * void method. 
	 * It prints out all variables in the tree, if any. 
	 * If there is no variable, it prints out “no variable in this expression”. 
	 * This method should use a BTQueue.
	 */
	public void allVariables() {
		// Check if the expression has variables.
		if(!includesVariables()){
			System.out.println("No variables in this expression");
		}

		BTQueue queue = new BTQueue();

		// Print out the contents if the current type is a variable.
		// Enqueue the left and right nodes to the queue.
		if (type.equals("var")) {
			System.out.print(variable + " ");
		}
    if (left != null){
			queue.enqueue(left);
		}
    if(right != null) {
      queue.enqueue(right);
		}

    // Use a while loop to iterate through the rest of the tree.
		// Dequeue and save the front of the queue. Print out the contents if the type is a variable.
		// Enqueue the left and right nodes to the queue.
    while (!queue.isEmpty()){
    	ExpressionBT front = queue.dequeue();
      if (front.type.equals("var")){
        System.out.print(front.variable + " ");
			}
			if (front.left != null){
				queue.enqueue(front.left);
			}
			if(front.right != null){
				queue.enqueue(front.right);
			}
		}
	}
	
	/* includesVariables(): 
	 * returns true if the expression contains at least one variable, false otherwise
	 */
	public boolean includesVariables() {
		// Return true if the type is variable.
		if(type.equals("var")){
			return true;
		}

		// Recursively search the left and right subtrees.
		// Return false if no variable was found.
		if(left != null && right != null){
			return left.includesVariables() || right.includesVariables();
		}
		return false;
	}
}
