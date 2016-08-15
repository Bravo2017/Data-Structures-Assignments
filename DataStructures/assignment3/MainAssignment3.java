
package assignment3;
import java.util.*;
import java.io.*;
/**
 * @author Ronald Cruz
 */
public class MainAssignment3{
	/**
	 * 
	 * @param path	the expression given from the file path
	 */
	public static void testEvalInfix(String path){
		//Calls evalInfix and catches an Illegal expression it may throw
			try{
				System.out.println(Calculator.evalInfix(path));
			}
			catch (IllegalExpressionException e){	
			}
		}	
	/**
	 * 
	 * @param path	path the expression given from the file path
	 */
	public static void testEvalPrefix(String path) {
		//Calls evalPrefix and catches an Illegal expression it may throw
			try{
				System.out.println(Calculator.evalPrefix(path));
			}
			catch (IllegalExpressionException e){
			}
		}
	/**
	 * 
	 * @param path	path the expression given from the file path
	 */
	public static void testInfixToPostfix(String path){
		//Calls testInfixToPostfix and catches an Illegal expression it may throw
			try{
				System.out.println(Calculator.infixToPostfix(path));
			}
			catch (IllegalExpressionException e){	
			}
		}	

	public static void main(String[] args) {
		
		System.out.println("Evaluate Infix:\n");
		//Reads the file and takes the expressions line by line and calls testEvalinfix.
		try{
			Scanner infixFile = new Scanner(new File(args[0]));	
			while (infixFile.hasNext()){
				String expression = infixFile.nextLine();
				testEvalInfix(expression);
			}}
			catch (FileNotFoundException e){	
			}
		
		System.out.println("\nEvaluate Prefix:\n");
		//Reads the file and takes the expressions line by line and calls testEvalPrefix.
		  try{
			Scanner prefixFile = new Scanner(new File(args[1]));
			while (prefixFile.hasNext()){
				String expression = prefixFile.nextLine();
				testEvalPrefix(expression);
			}}
		catch (FileNotFoundException e){
		}
		  
		System.out.println("\nInfix to Postfix Conversion:\n");
		//Reads the file and takes the expressions line by line and calls InfixToPostfix.
		try{
			Scanner InfixToPostfixFile = new Scanner(new File(args[2]));
			while (InfixToPostfixFile.hasNext()){
				String expression = InfixToPostfixFile.nextLine();
				testInfixToPostfix(expression);
		}}
		  catch (FileNotFoundException e){
		}

	
	}
}
