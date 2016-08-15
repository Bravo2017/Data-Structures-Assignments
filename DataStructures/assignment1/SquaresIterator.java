package assignment1;
public class SquaresIterator implements IntegerIterator {
	
	int n = 0;
	
	public SquaresIterator(){	
	}
	public boolean hasNext(){
		return true;
		
	}
	//The next term is simply incrementing n and then multiplying it by itself.
	public int getNext(){
		n++;
		return (n*n);
		
	}
	//To reset, we set n back to its original value 0.
	public void reset(){
		n = 0;
	}

}
