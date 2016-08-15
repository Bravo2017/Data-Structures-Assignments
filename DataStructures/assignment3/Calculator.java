
package assignment3;
import java.util.*;

/** The class has four methods, the first enumerate, is a helper method which turns arithmetic from its "String"
 *  form into something that can be evaluated and returns that value. The next three methods are evalInfix, which
 *  evaluates an expression in infix form, evalPrefix, which evaluates expression in prefix form, and infixToPostfix
 *  which converts an infix expression into a postfix expression.
 *  
 * @author Ronald Cruz
 */
public class Calculator {
	/** Takes two operands and an operator and simplifies the expression to its value.
	 * 
	 * @param operator	takes in the operator, which in this case is "+,-,/,*"
	 * @param operand1	operand1 is the first value in order of the string given being operated on
	 * @param operand2	operand 2 is the second value in order being operated on
	 * @return value	the value after the arithmetic is simplified.
	 */
	private static double enumerate(String operator, String operand1, String operand2){
		double value = 0.0;
		switch (operator){
		case "+": value = Double.parseDouble(operand1) + Double.parseDouble(operand2);
				  break;
		case "-": value = Double.parseDouble(operand1) - Double.parseDouble(operand2);
				  break;
		case "*": value = Double.parseDouble(operand1) * Double.parseDouble(operand2);
				  break;
		case "/": value = Double.parseDouble(operand1) / Double.parseDouble(operand2);
				  break;
		default: //Throw exception here.
		}
		return value;
	}
	/**
	 * 
	 * @param exp	expression given by string
	 * @return value 	double which returns the value after the expression is simplified.
	 * @throws IllegalExpressionException	Exception for when an argument is illegal.
	 */
	public static double evalInfix(String exp) throws IllegalExpressionException{
		//Two stacks, one stack takes in integers, the other takes in operators and parenthesis.
		Stack<String> integers = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		double value = 0.0; 
		//initiating values for operators and operands.	
		String operator;
		String operand1;
		String operand2;
		//Split the expression token by token into an array
		String[] tokens = exp.trim().split("\\s+");
		try{
		for (int i = 0 ; i  < tokens.length ; i++){
			//If the token is a number, push it to integers
			if (tokens[i].matches("[0-9]+")){
					integers.push(tokens[i]);
					value = Double.parseDouble(tokens[i]); //For the edge case in that the expression is only an integer.
			}
			//If the tokens is a ")", then the expression is closed. Therefore, we pop the operator, and take the operands
			//and enumerate them. You pop the operators once more to get rid of the open parenthesis. Then you push the
			//integer back into the stack.
			else if (tokens[i].equals(")")){
				operator = operators.pop();
				operand2 = integers.pop();
				operand1 = integers.pop();
				operators.pop();
				value = enumerate(operator, operand1, operand2);
				integers.push(Double.toString(value));
			}
			else
				operators.push(tokens[i]);
		}}
		//If the stack is empty, then there is an insufficient amount of operators or integers to operate on and thus the 
		//expression is illegal.
		catch (EmptyStackException e){
			throw new IllegalExpressionException("Invalid Expression");
		}
		//If there are no operators left, then the expression is also illegal because there either was an excess of operators
		//or a lack of integers.
		if (!operators.isEmpty())
			throw new IllegalExpressionException("Invalid Expression");
		return value;
	}
	/**
	 * 
	 * @param exp	expression given by file.
	 * @return value	a double which returns the value after the expression is simplified.
	 * @throws IllegalExpressionException	Exception for when an argument is illegal.
	 */
	public static double evalPrefix(String exp) throws IllegalExpressionException{
		//Uses a stack that takes in integers.
		Stack<String> integers = new Stack<String>();
		double value = 0.0;
		//placeholder is a temporary value.
		double placeholder = 0.0;
		//Split the expression token by token into an array
		String[] tokens = exp.trim().split("\\s+");
		try{
		for (int i = tokens.length-1; i>=0 ; i--){
		//if the token is an integer, then push it into the stack.
			if (tokens[i].matches("[0-9]+"))
				integers.push(tokens[i]);
			else{
				//else, the token is an operator, in which one would enumerate on the operators and the top two integers for the stack.
				placeholder = enumerate(tokens[i], (String)integers.pop(), (String)integers.pop());
				//push the result back into the integers stack.
				integers.push(Double.toString(placeholder));
			}
		}}
		//If the stack is empty, then there are a lack of integers to operate on or an excess amount of operators
		//therefore, it is an invalid expression.
		catch (EmptyStackException e){
			throw new IllegalExpressionException("Invalid Expression");
		}
		//value is the final value that is in the Integers stack.
		value = Double.parseDouble(integers.pop());
		return value;
	}
	/**
	 * 
	 * @param exp	expression given by the file.
	 * @return expression 	a String that returns the expression in Postfix notation
	 * @throws IllegalExpressionException	Exception for when an argument is illegal.
	 */
	public static String infixToPostfix(String exp) throws IllegalExpressionException{
		//If the infix expression cannot be operated then it is an invalid expression.
		evalInfix(exp);	
		Stack<String> operators = new Stack<String>();
		//Stack that takes in operators and a string that keeps track of the final expression.
		String expression = "";
		//Split the expression token by token into an array
		String[] tokens = exp.trim().split("\\s+");
		try{
		for (int i = 0 ; i  < tokens.length ; i++){
			//If the token is an number, then add it to the expression.
			if (tokens[i].matches("[0-9]+")){
				expression += tokens[i] + " ";
			}
			//If the token is a ")", then we pop the operators and add it to the expression.
			else if (tokens[i].equals(")")){
				expression += operators.pop() + " ";
				operators.pop();
			}//everything else is an operator and is added to the stack.
			else
				operators.push(tokens[i]);
		}}//If the stack is empty, then there are a lack of of integers and therefore the expression is illegal.
		catch (EmptyStackException e){
			throw new IllegalExpressionException("Invalid Expression");
		}
		//return the final expression
		return expression;
	}

	
	}

