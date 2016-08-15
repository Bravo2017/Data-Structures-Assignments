package assignment1;
import java.io.*;
public class Assignment1 {

	//printSequence takes an object of type integer iterator and through a for loop, runs "n" iterations 
	//checking first to see if it has a next value, followed by printing it's value through getNext().
	//If it doesn't, then break out of the loop.
	public static void printSequence(IntegerIterator it, int n){
		for (int i = 0; i < n; i++){
			if (it.hasNext())
				System.out.print(it.getNext() +" ");
			else
				break;
		}
	}
	// Recursive implementation of Q-Sequence. Implementation was described in the assignment.
	public static int getQsequence(int n){
		if (n == 0)
		return 0;
		else{
			return n - getQsequence(getQsequence(n-1));
		}
	}
	public static void main(String[] args) {
		
		FileIterator numbers = new FileIterator(new File(args[0])); //Saving the file of numbers as "numbers" since it is the first argument given.
		
		System.out.print("SquaresIterator: ");
			printSequence(new SquaresIterator(), 10);
		
		System.out.print("\n\nFibonacciIterator: ");
			printSequence(new FibonacciIterator(), 10);
		
		System.out.print("\n\nFileIterator: ");
			printSequence(numbers, 10);
		
		System.out.print("\n\nQ-sequence comparison between Iterative and Recursive:");
		System.out.print("\n\nIterative: ");
		
		printSequence(new QIterator(), 10);
		
		System.out.print("\nRecursively: ");
		
		//Looping from 0 to 10 of the recursive method of Q-sequence described above. 
		for (int i = 0; i < 10; i++){
			System.out.print(getQsequence(i)+ " ");
		}
		
	}

}
