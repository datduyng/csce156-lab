package unl.cse.bst;

public class TreeNode<T>{

    private final T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private TreeNode<T> parent;

    public TreeNode(T value) {
        this(value, null);
    }

    public TreeNode(T value, TreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
        this.rightChild = null;
        this.leftChild = null;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getParent() {
        return this.parent;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public T getValue() {
        return this.value;
    }
    
    public String toString() {
    	return  ""+this.value;
    }


//	public int compareTo(TreeNode<T> a) {
//		// TODO Auto-generated method stub
//		return this.getValue().compareTo(a.getValue());
//	}


}
