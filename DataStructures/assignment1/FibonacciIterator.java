package assignment1;

public class FibonacciIterator implements IntegerIterator{
	//x is the "first term" in the Fibonacci sequence and y is the "second".
	int x = 0;
	int y = 1;
	int temporaryVariable = 0;
	
	public FibonacciIterator(){
	}
	
	public boolean hasNext(){
		return true;
		
	}
	//To get the next value, we store y in a temporary variable. We then let y = x+y, so that the it becomes the next term in the sequence.
	//This is because the nth term = (n-1 term) + (n-2 term). y then increments in the sequence. We then set x equal to what y was before so that 
	//it also increments in the sequence. Returning y returns the official next term in the sequence.
	public int getNext(){
		temporaryVariable = y;
		y = x + y;
		x = temporaryVariable;
		return y;
		
	}
	//resetting the iterator is as simple as setting the original variables back to their original values.
	public void reset(){
		x = 0;
		y = 1;
		temporaryVariable = 0;
		
	}

}
