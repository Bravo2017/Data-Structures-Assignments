package assignment4;

import java.util.*;
/**
 * 
 * @author Ronald Cruz
 * 
 */
public class BinaryTree<E> implements Iterable<E>{
	protected BinaryTreeNode<E> root;
	/**
	 * 
	 * @return  A function call to height's helper method which recursively calculates height.
	 * @see height(BinaryTreeNode<E> root) helper method.
	 */
	public int height(){
		return height(root);
	}
	/**
	 * 
	 * @param root: It is a pointer to a Binary Tree node.
	 * @return The method returns the base case, -1 if the root is null, meaning that there is no tree. Otherwise
	 * 		   The method returns two function calls, to the left and right child of the node + 1.
	 * 		   The max value of all these recursive calls is then returned to give the greatest depth of the tree.
	 */
	private int height(BinaryTreeNode<E> root){
		if (root == null)
			return -1;
		else
			return (Math.max(height(root.getLeftChild()), height(root.getRightChild())) +1 ) ;
	}
	/**
	 *@see reverseTree(BinaryTreeNode<E> root
	 */
	public void reverseTree(){
		reverseTree(root);
	}
	/**
	 * This function takes the left and right child of a Node and swaps them.
	 * @param root: root is a pointer to a Binary Tree Node.
	 */
	private void swap(BinaryTreeNode<E> root){
		BinaryTreeNode<E >temp = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);
	}
	/**
	 * 
	 * @param root: A pointer to a Binary Tree Node.
	 * 
	 * @see swap(BinaryTreeNode<E> root)
	 * 
	 * This helper method serves to reverse the two children of a Binary Tree recursively.
	 * If the root is null, then there is no tree to reverse and so the method ends. Otherwise,
	 * It recursively calls the left and right child and swaps them, until the tree runs out of children.
	 */
	private void reverseTree(BinaryTreeNode<E> root){
		if (root == null){
			System.out.print("The tree is empty, it cannot be reversed.");
			return;
			}
		if (root.getLeftChild() != null)
			reverseTree(root.getLeftChild());
		if (root.getRightChild() != null)	
			reverseTree(root.getRightChild());
		swap(root);
	}
	/**
	 * The method returns the children of the tree on a layer by layer basis. It first checks to see
	 * if the root is null. If it is, there is no tree and therefore no BFS can be produced. Otherwise
	 * We add the root and "EOL" to a queue and add the children of the current nodes of the tree until
	 * EOL is reached. Then if the tree is not empty, EOL is added back in and we continue with the previously
	 * explained algorithm until the tree is empty.
	 */
	public void BFSLayers(){
		int layers = 0;
		int counter = 0;
		BinaryTreeNode<E> element = null;
		Object temp;
		Queue queue = new LinkedList();
		if (root == null){
			System.out.println("The tree is empty. There is no BFS.");
			return;
				}
		queue.add(root);
		queue.add("EOL");
		while (!queue.isEmpty()){
			if (layers == counter){
				System.out.print("Layer " + layers + ": ");
				counter++;
			}
			temp = queue.remove();
			if(temp == "EOL"){
				if (queue.isEmpty())
					return;
				queue.add("EOL");
				layers++;
				System.out.println("\n");
			}
			else{
				element = (BinaryTreeNode) temp;
			System.out.print(element.getData() + " ");
			if (element.getLeftChild() != null)
				queue.add(element.getLeftChild());
			if (element.getRightChild() != null)
				queue.add(element.getRightChild());
			}
			
		}
	}
	/**
	 * 
	 * @return a call to InOrderIterator
	 * @see class InOrderIterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new InOrderIterator();
	}

	private class InOrderIterator implements Iterator<E>{
		
		private Stack<BinaryTreeNode<E>> stack;
		private BinaryTreeNode<E> node;
		private BinaryTreeNode<E> returnnode; //the node that will be returned for the .next method.
		private BinaryTreeNode<E> temproot = root; //temproot serves as a pointer to root, so root itselfr remains unaffected
		
		/**
		 * If the root isn't null. Pushes the root and pushes all elements to the far left in until there are none left.
		 */
		public InOrderIterator(){
			stack = new Stack<BinaryTreeNode<E>>();
			if (root != null){
				stack.push(temproot);
				while (temproot.getLeftChild() != null){
					temproot = temproot.getLeftChild();
					stack.push(temproot);
				}
			}
		}
		/**
		 * @return returns whether the stack is empty or not. If it is empty, then hasNext is false.
		 */
		@Override
		public boolean hasNext() {
			return (!stack.isEmpty());
		}

		/**
		 * @return returnnode.getData() = which is the data of the node to be returned in regards to InOrder Traversal.
		 * 
		 * The method pops from the stack to get the node that will be returned. It then checks to see if that node has
		 * any Right Children, since it is the leftmost (Might be the parent of a right child). If there is a right child,
		 * it adds it to the stack and continues as far left as it can. It then returns the node's data.
		 */
		@Override
		public E next() {
			if (!hasNext()){
				throw new NoSuchElementException("There are no more elements.");
				}
			returnnode = stack.pop();
			node = returnnode;
			if (node.getRightChild() != null){
				node = node.getRightChild();
				stack.push(node);
				while (node.getLeftChild() != null){
					node = node.getLeftChild();
					stack.push(node);
				}
			}
			return returnnode.getData();
		}

		@Override 
		/**
		 * The method was not required for the assignment
		 */
		public void remove() {
		}
		
	}
	
}
