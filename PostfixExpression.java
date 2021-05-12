/* PostfixExpression:
 * Complete code below where you read "COMPLETE CODE HERE"
 */

public class PostfixExpression {

	// Attributes: 
	private String expression;
	
	// Constructors:
	public PostfixExpression() {}
	
	public PostfixExpression(String e) {expression = e;}
	
	// Accessor:
	public String getExpression() {return expression;}
	
	// Modifier:
	public void setExpression(String e) {expression = e;}
	
	// Print out the expression: 
	public void print() {
		System.out.println(expression);
	}
	
	// Evaluate expression:
	public int evaluate() {
		IntStack S = new IntStack();
		int result = 0;

		// Iterate through the string.
		// Push the character if it is an integer.
		// Evaluate the expression if the character is an operator.
		// Push the result of the evaluation to the stack.
		for(int i = 0; i < expression.length(); i++){
			if(Character.isDigit(expression.charAt(i))){
				S.push(Character.getNumericValue(expression.charAt(i)));
			} else {
				int num1 = S.pop();
				int num2 = S.pop();
				switch(expression.charAt(i)){
					case '+':
						result = num2 + num1;
						break;
					case '-':
						result = num2 - num1;
						break;
					case '*':
						result = num2 * num1;
						break;
					case '/':
						result = num2 / num1;
						break;
					case '^':
						result = (int) Math.pow(num2, num1);
						break;
					default:
						System.out.println("Error, invalid character at index " + i);
						break;
				}
				S.push(result);
			}
		}
		// Pop the final result.
		return S.pop();
	}
}
