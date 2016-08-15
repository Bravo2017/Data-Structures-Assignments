package assignment4;
/**
 * 
 * @author Ronald Cruz
 *
 */
public class BinarySearchTree <E extends Comparable<E>> extends BinaryTree<E> {
	/**
	 * 
	 * @param e: E is the data that is going to be added.
	 * 
	 * The method adds an element in the following ways: First, it checks to see if the root is null
	 * If it is, then the tree is non-existant and so a root node is created with the data given.
	 * Otherwise, It checks to see whether the data is greater or less than the root node and continues until it reaches
	 * a null child, in which point the null child will be replaced by a node containing the data E.
	 */
	public void addElement(E e){
		BinaryTreeNode<E> node = null;
		if (root == null)
			root = new BinaryTreeNode<E>(e);
		else{
			node = root;
			while (node.getData() != null){
				if (e.compareTo(node.getData()) > 0){
					if (node.getRightChild() == null){
						node.setRightChild(new BinaryTreeNode<E>(e));
					return;
					}
					else{
						node = node.getRightChild();
					}
				}
				else{
					if (node.getLeftChild() == null){
						node.setLeftChild(new BinaryTreeNode<E>(e));
						return;
						}
					else{
						node = node.getLeftChild();
						}
				}
			}
		}

	}
	
}
