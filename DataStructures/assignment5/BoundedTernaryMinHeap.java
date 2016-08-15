package assignment5;
import java.util.*;
/**
 * 
 * @author Ronald Cruz
 *
 */
public class BoundedTernaryMinHeap {
	/**
	 * 
	 */
	final static int MAX_SIZE = 1000;         //Max Size the heap can be
	private int[] heap = new int[MAX_SIZE];   // instantiating a heap to this size
	private int heapSize = 0;				  //private variable to keep track of the heap size.
	
	/**
	 * 
	 * @param heap - takes in an array and constructs a heap with the array taken in linear time.
	 */
	public BoundedTernaryMinHeap(int[] heap){
		for (int i = heap.length - 1; i >= 0; i--){
			this.heap[i] = heap[i];
			heapSize++;
			siftDown(this.heap, i);
		}
	}
	/**
	 * 
	 * @return the length of the heap or the size of the heap that's being tracked. If it is zero, then it is empty.
	 * Otherwise, the heap has elements.
	 */
	public boolean isEmpty(){
		return ((heap.length == 0) || (heapSize == 0));
	}
	/**
	 * 
	 * @param i  - value that is being added. 
	 * @see siftUp(int[] heap, int index)
	 * If the size of the heap is less than 999, then there is space to add an element. SiftUp is then called to
	 * Make sure the element is in the proper position. Otherwise, the heap is full and element can't be added.
	 */
	public void addElement(int i){
		if (heapSize < 999){
			heap[heapSize] = i;
			heapSize++;
			siftUp(heap, heapSize-1);
		}
		else
			System.out.print("Heap is full, element could not be added.");
	}
	/**
	 * 
	 * @return heap[0] - which is the root of the minHeap. The root is usually the smallest value.
	 * If the size of the heap is empty, then throw an exception as there is no element.
	 */
	public int getMin(){
		if (this.isEmpty())
			throw new NoSuchElementException("There is no minimum value. The heap is empty.");
		return heap[0];
	}
	/**
	 * @see siftDown(int[] heap, int index)
	 * Makes the last element of the heap the root and then sifts down the root to ensure the new min is
	 * in its proper position.
	 */
	public void removeMin(){
		heap[0] = heap[heapSize-1];
		heapSize--;
		siftDown(heap, 0);
	}
	/**
	 * 
	 * @param k - the number in which all elements returned must be smaller by.
	 * @return array - returns the array which contains all elements smaller than the value K.
	 * @see smallerThan(int k, int position, ArrayList storage)
	 * 
	 */
	public int[] getSmallerThanK(int k){
		ArrayList<Integer> storage = new ArrayList<Integer>();
		smallerThan(k, 0, storage);
		int[] array = new int[storage.size()];
		for (int i = 0; i < storage.size(); i++){
			array[i] = storage.get(i);
		}
	return array;
	}
	/**
	 * 
	 * @param k - the number in which all elements must be smaller than.
	 * @param position - the current position of which the element being checked is in.
	 * @param storage - storage is where the values that are smaller than K are stored.
	 * 
	 * This method recursively finds the smallest elements and adds them to an arraylist until the parent
	 * is larger, in which case all childrens are larger.
	 */
	private void smallerThan(int k, int position, ArrayList storage){
		int leftChild = 3 * position + 1;
		int midChild = 3  * position + 2;
		int rightChild = 3 * position + 3;
		if (position > heapSize || heap[position] >= k)
			return;
		storage.add(heap[position]);
		smallerThan(k, leftChild , storage);
		smallerThan(k, midChild , storage);
		smallerThan(k, rightChild, storage);
		
	}
	/**
	 * 
	 * @param heap - takes in the current heap.
	 * @param index1 - the index of the first element being swapped. 
	 * @param index2 - the index of the second element being swapped.
	 */
	private void swap(int[] heap, int index1, int index2){
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	/**
	 * 
	 * @param heap - takes in the current heap.
	 * @param index - takes in the index of the heap that is being sifted.
	 * 
	 * If the current index is smaller than its parent, then the elements are swapped and the parent becomes
	 * the child. The method then continues recursively until the root is reached or the element is larger than
	 * the parent.
	 */
	private void siftUp(int[] heap, int index){
		if ((heap[index] < heap[(index - 1) /3]) && (index - 1) /3 >= 0){
			swap(heap, index, (index-1)/3);
			siftUp(heap, (index-1)/3);
		}
	}
	/**
	 * 
	 * @param heap - takes in the current heap.
	 * @param index - The element being sifted.
	 * 
	 * All children are checked to see which is the smallest and that index is stored as minIndex.
	 * Afterwards, it is checked to see if that children is within the heapSize. If it is and it is smaller
	 * than it's parents, then the child and the parent are swapped and the method is called recursively until
	 * the end of the heap is reached or the parent is no longer larger.
	 */
	private void siftDown(int[] heap, int index){
		int minIndex = index;
		if (heap[3 * index + 1] <= heap[3 * index + 2] && (heap[3 * index + 1] <= heap[3 * index + 3]) && (3 * index + 1) < heapSize)
			minIndex = 3 * index + 1;
		else if (heap[3 * index + 2] <= heap[3 * index + 3] && (heap[3 * index + 2] <= heap[3 * index + 1]) && (3 * index + 2) < heapSize)
			minIndex = 3 * index + 2;
		else if (heap[3 * index + 3] <= heap[3 * index + 1] && (heap[3*index + 3] < heap[3*index + 2]) && 3 * index + 3 < heapSize)
			minIndex = 3 * index + 3; 
		
		if (heap[index] > heap[minIndex] && (minIndex <= heapSize-1)){
			swap(heap, index, minIndex);
			siftDown(heap, minIndex);
		}
	}
}
