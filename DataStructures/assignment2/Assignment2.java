package homework2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Assignment2 {
	
	private static int counter = 0;  //static value used to store the number of subsequences created.
	
	//QUICKSORT
	
	//The method swapElements serves as a swap function for generic objects <E>, swapping their positions in an array.
	private static <E extends Comparable<E>> void swapElements(ArrayList<E> array, int index1, int index2){
		
		E temp = array.get(index1);
		array.set(index1, array.get(index2));
		array.set(index2, temp);
	}
	
	//a quicksort method that takes in an array as well as the "starting" and "ending" index of it to aide in recursion.
	private static <E extends Comparable<E>> void quickSort(ArrayList<E> array, int start, int end){
		if (start < end){						//if the starting point is greater than the ending point, then the partition is already sorted or it is too small to sort (partition of size 1)
			
			Random randomInt = new Random();
			int pivot = start + randomInt.nextInt(end-start+1);      //randomly selects the index of the pivot location.
			swapElements(array,start,pivot);                               //swap the first element and pivot element so that the pivot is the first value.
			int leftPointer =start + 1;											// the left pointer begins an index after the pivot.
			int rightPointer = end;											// the right pointer begins at the end of the partition.
			
			//In this do while loop, the left pointer is incremented until the object at that index is greater than that of the pivot.
			//The right pointer is then decremented until the object at the right pointer index is strictly less than that of the pivot.
			//At this point, if the left and right pointers have not gone past each other, i.e. the left pointer is less than the right,
			//the elements at the index of the left and right are swapped. This continues until the left/right pointers have gone past each other.
			do{
				while (array.get(leftPointer).compareTo(array.get(start)) < 0 && (leftPointer < end))     
					leftPointer++;
				while (array.get(rightPointer).compareTo(array.get(start)) >= 0 && (rightPointer >= start + 1))
					rightPointer--;
				
				if (leftPointer < rightPointer)
					swapElements(array, leftPointer, rightPointer);
				
			} while (leftPointer < rightPointer);
			
			//the elements are swapped back so that the pivot object is no longer in the start index.
			swapElements(array,start, rightPointer);
			
			//The method is then called recursively on partitions from the start, to the location of the current pivot-1.
			//And from the current pivot+1 to the end. We do not need to touch the location of the pivot itself as it is
			//already in its appropriate sorted location.
			quickSort(array, start,rightPointer-1);
			quickSort(array, rightPointer+1, end);
		}
	}
	//This public quicksort takes in an array, gets its start/end indexes, and calls a recursive, private quicksort method.
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> array){
		int start = 0;
		int end = array.size()-1;
		quickSort(array, start, end);
	}
	//REMOVE REPETITIONS
	
	//The method checkExistingValue takes in two arguments, an array of generic objects and a specific object.
	//It then checks to see if any objects in that array are equal to this specific object. If they are, then the object
	//already exists in the array and True is returned.
	private static <E> boolean checkExistingValue(ArrayList<E> array, E object){
		for(E element: array){
			if (element.equals(object))
			return true;
		}
		return false;
	}
	//The method first checks if the array is empty, and if so, it returns the empty array. If not, it appends the first value
	//to newarray which will be a set. From then on, any further values in the original array will be checked to see if they
	//already exist in the set through the "checkExistingValue" method. If they do not exist, they are added to the set.
	//the set is then returned.
	public static <E> ArrayList<E> removeRepetitions(ArrayList<E> array){
		if (array.isEmpty())
			return array;
		
		ArrayList<E> newarray = new ArrayList<E>();
		newarray.add(array.get(0));
		
		for (int i = 0; i <array.size(); i++){
			if (!checkExistingValue(newarray, array.get(i)))
				newarray.add(array.get(i));
		}	
		return newarray;
	}
	
	//INCREASING SUBSEQUENCE
	
	//This private method takes the last number of the sequence, n, the length of the subsequences, the current value, and a stack that's being used.
	//The base case for this recursion is if the length of the subsequence is reached, in which case, the stack will print, counter will be incremented
	// and the recursed method will end.
	//The for loop takes a current value, initially 1 and pushes it to the stack, followed by a recursive call with the length of the subsequence decremented by 1
	//and the currentValue incremented by one. This is repeated until the stack length of the stack is at length k, at this point, the stack is printed, counter is incremented
	//and the k-1 stage of recursion is broken out of. The kth element of the stack is then popped, and incremented by 1 by the for loop, pushed into the stack, and 
	//this is then repeated until the kth element reaches n, at which point both the k-1 and k-2 stages are broken out of and the k-1 element is incremented by one.
	//Recursion then follows under the same form.
	private static void allIncreasingSequences(int n, int k, int currentValue, Stack<Integer> stack){
		
		if (k == 0) {
			System.out.println(stack.toString());
			counter++;
			return;	
			}
		
		for (int i = currentValue; i <= n; i++){
			stack.push(i);
			allIncreasingSequences(n, k-1, i+1, stack);
			stack.pop();
		}
		
	}
	//The method checks to see if the length of subsequences, k, is greater than the length of sequence, n.
	//If so, it throws an illegal argument exception. Otherwise, it creates a stack to call a recursive implementation
	//called allIncreasingSubsequences. 
	public static int printIncreasingSequences (int n, int k){
		
		if (k>n)
			throw new IllegalArgumentException("Length of subsequence cannot be longer than the sequence itself.");
		
		Stack<Integer> stack = new Stack<Integer>();
		allIncreasingSequences(n,k, 1, stack);
		int temporaryValue = counter; //Through allIncreasingSubsequences, counter is incremented. Because it is static, it will remain so.
		counter = 0;                                //Therefore, we store its value as a temporary variable, reset counter back to 0, and return that temporary variable.
		
		return temporaryValue;
	
	}
}
