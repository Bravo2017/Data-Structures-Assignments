package assignment4;
import java.util.*;
/**
 * 
 * @author Ronald Cruz
 *
 */
public class MainAssignment4 {
	/**
	 * 
	 * @param n : The number of elements to be added to a random BST
	 * @param k : The range from which the elements can be in terms of Integers. 1 to k.
	 * @return Tree : The tree returned is the tree produced from adding n elements of possible size k.
	 * @see BinarySearchTree.addElement()
	 */
	public static BinarySearchTree createRandomBSTree(int n, int k){
		BinarySearchTree Tree = new BinarySearchTree();
		Random integer = new Random();
		for (int i = 0; i < n; i++)
			Tree.addElement(integer.nextInt(k) + 1);
		return Tree;
	}
	/**
	 * @see MainAssignment4.createRandomBSTree(int n, int k)
	 * @see BinaryTree.BFSLayers()
	 * @see BinaryTree.height()
	 * @see BinaryTree.reverseTree()
	 */
	public static void testBinaryTree(){
		System.out.println("Testing Binary Tree:\n");
		BinaryTree Tree = createRandomBSTree(20, 200);
		int height1;
		int height2;
		Tree.BFSLayers();
		height1 = Tree.height();
		System.out.println("\n\nHeight of the tree: "+ height1 + "\n");
		Tree.reverseTree();
		Tree.BFSLayers();
		height2 = Tree.height();
		System.out.println("\n\nHeight of Reverse Tree: " + height2);
		System.out.println("The height of the tree and the reverse tree are " + ((height1 == height2) ? "the same." : "different."));
	}
	/**
	 * @see BinaryTree.iterator()
	 * @see MainAssignment4.createRandomBSTree(int n, int k)
	 * @see BinaryTree.InOrderIterator.next()
	 * @see BinaryTree.InOrderIterator.hasNext()
	 */
	public static void testIterator(){
		System.out.println("\nTesting Iterator: \n");
		BinarySearchTree Tree = createRandomBSTree(20, 200);
		Random integer = new Random();
		Iterator iterator = Tree.iterator();
		System.out.print("The first 5 elements: ");
		for (int i = 0; i < 5; i++)
			System.out.print(iterator.next() +" ");
		System.out.print("\nThe next 35 elements: ");
		for (int i = 0; i < 20; i++)
			Tree.addElement((integer.nextInt(200) + 201));
		while(iterator.hasNext())
			System.out.print(iterator.next() + " ");
		System.out.println();
	}
	/**
	 * @see MainAssignment4.createRandomBSTree( int n, int k)
	 * @see BinaryTree.height()
	 */
	public static void testHeightofRandomBSTree(){
		System.out.println("\nTesting height of Random BST:\n");
		BinarySearchTree Tree = createRandomBSTree(100, 10000);
		System.out.print("Height of random tree: " + Tree.height());
	}
public static void main(String[] args ){
	testBinaryTree();
	testIterator();
	testHeightofRandomBSTree();
}
}
