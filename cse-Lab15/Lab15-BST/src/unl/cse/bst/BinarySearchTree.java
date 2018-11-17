package unl.cse.bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T> {

    private TreeNode<T> root;
    private final Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this(Collections.<T> emptyList(), comparator);
    }

    public BinarySearchTree(Collection<T> items, Comparator<T> comparator) {
        this.comparator = comparator;
        List<T> sortedItems = new ArrayList<T>(items);
        java.util.Collections.sort(sortedItems, this.comparator);
        addSortedItems(sortedItems);
    }

    private void addSortedItems(List<T> items) {
        if(items.size() < 1)
            return;
        else if(items.size() == 1)
            addElement(items.get(0));
        else {
            int mid = items.size() / 2;
            addElement(items.get(mid));
            addSortedItems(items.subList(0, mid));
            addSortedItems(items.subList(mid+1, items.size()));
        }

    }

    public boolean containsElement(T item) {
        return (this.findElement(item) != null);
    }

    public T findElement(T item) {
        T result = null;
        if(root == null)
            return null;

        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            if(curr.getValue().equals(item))
                return curr.getValue();

            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }

        return result;
    }
    
    private TreeNode<T> findElementNode(T item) {

        if(root == null)
            return null;

        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            if(curr.getValue().equals(item))
                return curr;

            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return null;
    }

    public int getMaxDepth() {
        if(root == null)
            return 0;
        else if(root.getLeftChild() == null && root.getRightChild() == null)
            return 1;

        TreeNode<T> curr = root;
        TreeNode<T> prev = null;
        int depth = 1;
        int maxDepth = depth;
        while(curr != null) {
            if(curr.getParent() == prev) {
                if(curr.getLeftChild() != null) {
                    prev = curr;
                    curr = curr.getLeftChild();
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                } else if(curr.getRightChild() != null) {
                    prev = curr;
                    curr = curr.getRightChild();
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                } else {
                    prev = curr;
                    curr = curr.getParent();
                    depth--;
                }
            } else if(curr.getLeftChild() == prev) {
                if(curr.getRightChild() != null) {
                    prev = curr;
                    curr = curr.getRightChild();
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                } else {
                    prev = curr;
                    curr = curr.getParent();
                    depth--;
                }
            } else if(curr.getRightChild() == prev) {
                prev = curr;
                curr = curr.getParent();
                depth--;
            } else {
                throw new IllegalStateException("Current/Previous: "+curr.getValue()+", "+prev.getValue());
            }
        }
        return maxDepth;
   }

    private int getDepth(TreeNode<T> node) {
        int depth = 0;
        TreeNode<T> curr = node;
        while(curr != root) {
            curr = curr.getParent();
            depth++;
        }
        return depth;
    }
    
    public int getNumNodes() {
    	
    	int count = 0;

    	if(root == null)
        	return count;

        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            count++;
            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return count;
    }
    
    public void addElement(T item) {
        if(item == null)
            throw new IllegalArgumentException("BinarySearchTree does not allow null elements");
        if(containsElement(item))
            return;
        TreeNode<T> newNode = new TreeNode<T>(item);
        if(root == null) {
            root = newNode;
            return;
        }
        TreeNode<T> curr = root;
        TreeNode<T> prev = null;
        while(curr != null) {
            if(this.comparator.compare(curr.getValue(), item) > 0) {
                prev = curr;
                curr = curr.getLeftChild();
            } else {
                prev = curr;
                curr = curr.getRightChild();
            }
        }
        if(this.comparator.compare(prev.getValue(), item) > 0 ) {
            prev.setLeftChild(newNode);
            newNode.setParent(prev);
        } else {
            prev.setRightChild(newNode);
            newNode.setParent(prev);
        }
    }

    @Override
    public String toString() {
        if(root == null)
            return "[empty]";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        TreeNode<T> curr = root;
        while(curr != null) {
            if(curr.getRightChild() != null)
                s.push(curr.getRightChild());
            if(curr.getLeftChild() != null)
                s.push(curr.getLeftChild());

            for(int i=0; i<getDepth(curr); i++)
                sb.append(" ");
            sb.append("|-"+curr.getValue()+"\n");
            if(s.isEmpty())
                curr = null;
            else
                curr = s.pop();
        }
        return sb.toString();
    }
    
    public int getNumLeaves() {
		//TODO: implement this
    	return this.getLeaveHelper(this.root);
    }
    public int getLeaveHelper(TreeNode<T> root) {
    	//basecase
    	if(root == null) {
    		return 0;
    	}
    	if(root.getLeftChild() == null && root.getRightChild() == null) {
    		return 1;
    	}
		return getLeaveHelper(root.getLeftChild()) + getLeaveHelper(root.getRightChild());
    }

    public void preOrderTraverse() {
		//TODO: implement this
    	//root,left,right
    	System.out.println(preOrderHelper(this.root));
    }
    public String preOrderHelper(TreeNode<T> root) {
    	//basecase
    	if(root == null) {
    		return "";
    	}
    	if(root.getLeftChild() == null && root.getRightChild() == null) {
    		return root.getValue() +",";
    	}
    	return ""+root.getValue()+","+preOrderHelper(root.getLeftChild())+preOrderHelper(root.getRightChild());
    }

    public void inOrderTraverse() {
		//TODO: implement this
    	//left,root,right 
    	System.out.println(inOrderHelper(this.root));
    }
    
    public String inOrderHelper(TreeNode<T> root) {
    	//basecase
    	if(root == null) {
    		return "";
    	}
    	if(root.getLeftChild() == null && root.getRightChild() == null) {
    		return root.getValue() +",";
    	}
    	return ""+inOrderHelper(root.getLeftChild())+root.getValue()+","+inOrderHelper(root.getRightChild());
    }
    
    public void postOrderTraverse() {
		//TODO: implement this
    	//left, right, node
    	System.out.println(postOrderHelper(this.root));
    }

    public String postOrderHelper(TreeNode<T> root) {
    	//basecase
    	if(root == null) {
    		return "";
    	}
    	if(root.getLeftChild() == null && root.getRightChild() == null) {
    		return root.getValue() +",";
    	}
    	return postOrderHelper(root.getLeftChild()) +postOrderHelper(root.getRightChild())+""+root.getValue()+",";
    }
    
    /**
     * Advance activity 
     * breadth first search traversal strategy 
     * @param root
     * print out the element
     */
    public void bfsTraversal() {
    	//init a queue 
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	if(this.root == null) return; 
    	
    	// add root to queue 
    	q.add(this.root);
    	
    	while(!q.isEmpty()) {
    		TreeNode<T> node = (TreeNode<T>) q.remove();
    		System.out.print(" "+node.getValue());
    		
    		if(node.getLeftChild() != null)
    			q.add(node.getLeftChild());
    		if(node.getRightChild()!= null)
    			q.add(node.getRightChild());
    	}// end while 
    }// end bfsTraversal

//    public T findElementWRecursion(TreeNode<T> needle) {
//		
//    	return findElementHelper(this.root,needle);
//    }
//    public T findElementHelper(TreeNode<T> root,TreeNode<T> needle) {
//  
//    	if(root == null) {
//    		System.out.println("no needle in the haystack");
//    		return null;
//    	}
//    	if(comparator.compare(needle,root) <= -1) {
//    		if(root.getRightChild() == null) {
//    			return null; // could't find it
//    		}
//    			findElementHelper(root.getRightChild(),needle);
//    	}else if(comparator.compare(needle,root) >= 1) {
//    		if(root.getLeftChild() == null) {
//    			return null; // could't find it
//    		}
//    		findElementHelper(root.getLeftChild(),needle);
//    	}else {
//    		return root.getValue();
//    	}
//		return null;
//    	
//    }

}// end class 
