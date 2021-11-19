/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, Anushka Shah, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  TA name: Grace
 *  Number of slip days I am using: 0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Shell for a binary search tree class.
 * @author scottm
 * @param <E> The data type of the elements of this BinarySearchTree.
 * Must implement Comparable or inherit from a class that implements
 * Comparable.
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    // instance variables
	private BSTNode<E> root;
    private int size;

    /**
     * Create an empty BinarySearchTree
     */
    public BinarySearchTree() {
    	root = null;
    	size = 0;
    }

    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    public boolean add(E value) {
    	if (value == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "add. value cannot be null."); 
       	}
    	int oldSize = size;
    	root = addVal(root, value);
    	return size != oldSize;
    }
    
    /**
     * 
     * @param node
     * @param value
     * @return
     */
    private BSTNode<E> addVal(BSTNode<E> node, E value) {
    	if (node == null) {
    		size++;
    		return new BSTNode<E>(value);
    	}
    	int temp = value.compareTo(node.getData());
    	if (temp < 0) {
    		node.setLeft(addVal(node.getLeft(), value));
    	} else if (temp > 0) {
    		node.setRight(addVal(node.getRight(), value));
    	}
    	return node;
    }

    /**
     *  Remove a specified item from this Binary Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    public boolean remove(E value) {
    	if (value == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "remove. value cannot be null."); 
       	}
    	int oldSize = size;
    	root = removeVal(root, value);
    	return size != oldSize;
    }
    
    /**
     * 
     * @param node
     * @param value
     * @return
     */
    private BSTNode<E> removeVal(BSTNode<E> node, E value) {
    	if (node == null) {
    		return null;
    	}
    	int temp = value.compareTo(node.getData());
    	if (temp < 0) {
    		node.setLeft(removeVal(node.getLeft(), value));
    	} else if (temp > 0) {
    		node.setRight(removeVal(node.getRight(), value));
    	} else {
    		size--;
    		if (node.getLeft() == null && node.getRight() == null) {
    			node = null;
    		} else if (node.getRight() == null) {
    			node = node.getLeft();
    		} else if (node.getLeft() == null) {
    			node = node.getRight();
    		} else {
    			E maxLeft = max(node.getLeft());
    			node.setData(maxLeft);
    			node.setLeft(removeVal(node.getLeft(), maxLeft));
    			size++;
    		}
    	}
    	return node;
    }
    
    /**
     * 
     * @param node
     * @return
     */
    private E max(BSTNode<E> node) {
    	while (node.getRight() != null) {
    		node = node.getRight();
    	}
    	return node.getData();
    }

    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @return true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
    	if (value == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isPresent. value cannot be null."); 
       	}
    	return hasVal(root, value);
    }
    
    /**
     * 
     * @param node
     * @param value
     * @return
     */
    private boolean hasVal(BSTNode<E> node, E value) {
    	if (node == null) {
    		return false;
    	} else if (value.compareTo(node.getData()) == 0) {
    		return true;
    	} else if (value.compareTo(node.getData()) > 0) {
    		return hasVal(node.getRight(), value);
    	} 
    	return hasVal(node.getLeft(), value);
    }

    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @return the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @return the height of this tree or -1 if the tree is empty
     */
    public int height() {
        return getHeight(root);
    }
    
    /**
     * 
     * @param node
     * @return
     */
    private int getHeight(BSTNode<E> node) {
    	if (node == null) {
    		return -1;
    	}
    	return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order.
     *  If the tree is empty return an empty List
     *  @return a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
        List<E> tree = new ArrayList<E>();
    	getTree(root, tree);
    	return tree;
    }
    
    /**
     * 
     * @param node
     * @param tree
     */
    private void getTree(BSTNode<E> node, List<E> tree) {
		if (node != null) {
			getTree(node.getLeft(), tree);
			tree.add(node.getData());
			getTree(node.getRight(), tree);
		}
	}

    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
    	if (size() < 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "max. size() cannot be less than 0."); 
       	}
        return getMax(root);
    }
    
    /**
     * 
     * @param node
     * @return
     */
    private E getMax(BSTNode<E> node) {
    	if (node.getRight() == null) {
    		return node.getData();
    	}
    	return getMax(node.getRight());
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
    	if (size() < 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "min. size() cannot be less than 0."); 
       	}
        return getMin(root);
    }
    
    /**
     * 
     * @param node
     * @return
     */
    private E getMin(BSTNode<E> node) {
    	if (node.getLeft() == null) {
    		return node.getData();
    	}
    	return getMin(node.getLeft());
    }

    /**
     * An add method that implements the add algorithm iteratively 
     * instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, 
     * otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add, 
     * false otherwise.
     */
    public boolean iterativeAdd(E data) {
    	if (data == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "iterativeAdd. data cannot be null."); 
       	}
		BSTNode<E> prev = null;
    	BSTNode<E> curr = root;
    	BSTNode<E> node = new BSTNode<E>(data);
		while (curr != null) {
			prev = curr;
			if (data.compareTo(curr.getData()) == 0) {
				return false;
			} else if (data.compareTo(curr.getData()) < 0) {
				curr = curr.getLeft();
			} else {
				curr = curr.getRight();
			}
		}
		if (prev == null) {
			root = node;
		} else if (data.compareTo(prev.getData()) < 0) {
			prev.setLeft(node);
		} else {
			prev.setRight(node);
		}
		size++;
		return true;
    }

    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the
     * smallest value (minimum) is returned.
     * If kth = 1 the second smallest value is returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Binary Search Tree
     */
    public E get(int kth) {
    	if (0 > kth || kth >= size()) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "get. kth must be greater or equal to 0 and kth must be less "
                    + "than size()."); 
       	}
    	return getHelp(root, kth, new int[1]);
    }
    
    /**
     * 
     * @param node
     * @param kth
     * @param count
     * @return
     */
    private E getHelp(BSTNode<E> node, int kth, int[] count) {
    	if (node != null) {
    		E left = getHelp(node.getLeft(), kth, count);
    		if (left != null) {
    			return left;
    		}
    		if (kth == count[0]) {
    			return node.getData();
    		}
    		count[0]++;
    		E right = getHelp(node.getRight(), kth, count);
    		if (right != null) {
    			return right;
    		}
    	}
    	return null;
    }

    /**
     * Return a List with all values in this Binary Search Tree 
     * that are less than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than 
     * the parameter value. If there are no values in this tree less 
     * than value return an empty list. The elements of the list are 
     * in ascending order.
     */
    public List<E> getAllLessThan(E value) {
    	if (value == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getAllLessThan. value cannot be null."); 
       	}
    	return lessThanHelp(value, new ArrayList<E>(), root);
    }
    
    /**
     * 
     * @param value
     * @param res
     * @param node
     * @return
     */
    private List<E> lessThanHelp(E value, ArrayList<E> res, BSTNode<E> node) {
    	if (node != null) {
    		lessThanHelp(value, res, node.getLeft());
    		if (value.compareTo(node.getData()) > 0) {
    			res.add(node.getData());
    			lessThanHelp(value, res, node.getRight());
    		}
    	}
    	return res;
    }

    /**
     * Return a List with all values in this Binary Search Tree 
     * that are greater than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater
     *  than the parameter value. If there are no values in this tree
     * greater than value return an empty list. 
     * The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
    	if (value == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getAllGreaterThan. value cannot be null."); 
       	}
    	return greaterThanHelp(value, new LinkedList<E>(), root);
    }
    
    /**
     * 
     * @param value
     * @param res
     * @param node
     * @return
     */
    private List<E> greaterThanHelp(E value, LinkedList<E> res, BSTNode<E> node) {
    	if (node != null) {
    		greaterThanHelp(value, res, node.getRight());
    		if (value.compareTo(node.getData()) < 0) {
    			res.addFirst(node.getData());
    			greaterThanHelp(value, res, node.getLeft());
    		}
    	}
    	return res;
    }

    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
        return findNodes(d, 0, root);
    }
    
    /**
     * 
     * @param d
     * @param count
     * @param node
     * @return
     */
    private int findNodes(int d, int count, BSTNode<E> node) {
    	if (d == 0) {
    		return count + 1;
    	} else if (node == null) {
    		return 0;
    	}
    	return findNodes(d - 1, count, node.getLeft()) + 
    			findNodes(d - 1, count, node.getRight());
    }

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children will not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * <br>pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null);
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,
                BSTNode<E> initRight) {
            data = initValue;
            left = initLeft;
            right = initRight;
        }

        public E getData() {
            return data;
        }

        public BSTNode<E> getLeft() {
            return left;
        }

        public BSTNode<E> getRight() {
            return right;
        }

        public void setData(E theNewValue) {
            data = theNewValue;
        }

        public void setLeft(BSTNode<E> theNewLeft) {
            left = theNewLeft;
        }

        public void setRight(BSTNode<E> theNewRight) {
            right = theNewRight;
        }
    }
}
