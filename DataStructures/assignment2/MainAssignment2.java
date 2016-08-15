package homework2;
import java.util.*;
import java.util.ArrayList;

public class MainAssignment2 extends Assignment2 {

	//Method to test quicksort method.
	public static void testQuickSort(){
		System.out.println("QUICKSORT:");
		
		Random randomInt = new Random();
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		System.out.print("Here is the unsorted array: ");
		//array of 20 random integers created.
		for (int i = 0; i < 20; i++){
			array.add(randomInt.nextInt(101));
			System.out.print(array.get(i) + " ");
		}
			quickSort(array);         //a call to sort the array.
			System.out.println();
			//Comparing the objects to see if it sorted properly. If not, it returns an error message saying sorting failed.
		for (int j = 0; j < 19; j++){
			if (array.get(j).compareTo(array.get(j+1)) == 1){
				System.out.println("The list is not in order. Sorting failed");
				return;
			}
		}
		//prints the sorted array.
		System.out.print("Here is the sorted array: ");
		for (int k = 0; k < 20; k++)
			System.out.print(array.get(k) + " ");
	}
	public static void testRemoveRepetitions(){
		System.out.println("\n\nREMOVE REPETITIONS:");
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		Random randomInt = new Random();
		
		System.out.print("Here is an array of 40 integers:");
		
		//creates an array of 40 random integers.
		for (int i =0; i < 40; i++){
			array.add(randomInt.nextInt(11));
			System.out.print(array.get(i) + " ");
		}
		//A call to remove repetition, and stores it as newarray as the method returns the new, altered array with no repetitions.
		ArrayList<Integer> newarray = removeRepetitions(array);
		System.out.println();
		System.out.print("The new array, free of repetitions: ");
		
		//printing all elements of the new array.
		for (int j = 0; j < newarray.size(); j++)
			System.out.print(newarray.get(j) + " ");
		
		System.out.println();	
	}
	public static void testIncreasingSequences(){
		System.out.println("\nINCREASING SEQUENCES:");
		
		//creates random variables for both n in range of [0,20] and k in range [2,4]
		Random randomInt = new Random();
		int n = randomInt.nextInt(21);
		int k =2 + randomInt.nextInt(3);
		
		//calls printIncreasingSequence and stores the int it returns as the numberOfSequences.
		int numberOfSequences =printIncreasingSequences(n,k);
		
		System.out.println("\nNumber of sequences: " + numberOfSequences);
		
	}
	public static void main(String[] args) {
		
		testQuickSort();
		testRemoveRepetitions();
		testIncreasingSequences();

	}
}


