package assignment1;

import java.util.ArrayList;

public class QIterator implements IntegerIterator {
	int n = -1;
	ArrayList<Integer> qValues = new ArrayList<Integer>();
	//An ArrayList qValues is being used in order to store previously received Q-sequence values to "memoize" the recursive function.
	
	//When a QIterator object is instantiated, we add 0 to the array so that it is instantiated with the initial value (n = 0)
	public QIterator(){
		qValues.add(0);
	}
	
	public boolean hasNext(){
		return true;	
	}
	//getNext increments n so that when it begins checking for previously computated values, it begins with 0.
	public int getNext(){
		n++;
		//Since the base case was given to be 0, if n = 0, we return 0.
		if (n ==0 )
			return 0;
		//Otherwise, we add to the Arraylist the new value that was computated by getting the previous values of the list.
		//Afterwards we return it. Through this memoization and because we are returning one value at a time that is one
		//term after the previous one, this method runs in O(1).
		else {
			qValues.add(n-qValues .get(qValues.get(n-1)));
			return qValues.get(n);	
		}
		
	}
	//resetting is simply setting n back to -1 and clearing the ArrayList of all values. We then add 0 to it so that it can have
	//it's initial element.
	public void reset(){
		n = -1;
		qValues.clear();
		qValues.add(0);
	}

}
