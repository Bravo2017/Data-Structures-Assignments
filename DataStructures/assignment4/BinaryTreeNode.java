package assignment4;
/**
 * 
 * @author Ronald Cruz
 *
 * 
 */
public class BinaryTreeNode<E> {
	
	private E data;
	private BinaryTreeNode<E> leftChild;
	private BinaryTreeNode<E> rightChild;
/**
 * 
 * @param data: A constructor which takes in data of type E and sets it as the data field "data".
 */
public BinaryTreeNode(E data){
	this.data = data;
}
/**
 * 
 * @param data: takes in data of type E and sets data as that data field.
 */
public void setData(E data){
	this.data = data;
}
/**
 * 
 * @return data, which is a data field.
 */
public E getData(){
	return data;	
}
/**
 * 
 * @return the leftChild data field.
 */
public BinaryTreeNode<E> getLeftChild() {
	return leftChild;
}
/**
 * 
 * @param leftChild: takes in a node and sets the left child as that node.
 */
public void setLeftChild(BinaryTreeNode<E> leftChild) {
	this.leftChild = leftChild;
}
/**
 * 
 * @return the rightChild data field.
 */
public BinaryTreeNode<E> getRightChild() {
	return rightChild;
}
/**
 * 
 * @param rightChild: takes in a node and sets the right child as that node.
 */
public void setRightChild(BinaryTreeNode<E> rightChild) {
	this.rightChild = rightChild;
}

}
