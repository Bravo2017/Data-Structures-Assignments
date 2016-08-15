package assignment3;

/** The following class is an exception class that should be thrown when the expression that is being operated on is
 *  illegal. In this case, illegal is defined as there aren't spaces between all tokens of an expression, the expression
 *  being evaluated on is nonsensical (too many operators for the operands and vice versa), or it contains no integer/double.
 * @author Ronald Cruz
 */

public class IllegalExpressionException extends Exception {
	/**
	 * A default constructor for the exception.
	 */
	public IllegalExpressionException(){
	}
	/**
	 * 
	 * @param message The message the user wishes to print out during the instantiation of this exception.
	 */
	public IllegalExpressionException(String message){
		System.out.println(message);
	}
	

}
