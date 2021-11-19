
/*
 * Student information for assignment:
 * On my honor, Anushka Shah, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID: aks4562
 * email address: anushkashah@gmail.com
 * TA name: Grace
 * Number of slip days I am using: 0
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements IList<E> {
    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements.
    // No ArrayLists or Java LinkedLists.
	private final DoubleListNode<E> HEADER;
	private int size;
	
    // CS314 students, add constructors here:
	/**
	 * Create a new LinkedList with the instance variable HEADER
	 */
	public LinkedList() {
		// initialize instance variable HEADER
		HEADER = new DoubleListNode<E>();
		HEADER.setNext(HEADER);
		HEADER.setPrev(HEADER);
	}

	/**
	 * BIG O: O(1)
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list,
     * item != null
     */
	public void add(E item) {
		if (item == null) {
			throw new IllegalArgumentException("Violation of precondition: " +
                    "add. Item cannot be null."); 
        }
		
		// create a new DoubleListNode and set it's prev and next pointers
		DoubleListNode<E> newNode = new DoubleListNode<E>(HEADER.getPrev(), item, HEADER);
		// set the last node to point to the new node
		HEADER.getPrev().setNext(newNode);
		// have HEADER point to the new node 
		HEADER.setPrev(newNode);
		size++;
	}
	
	/**
	 * BIG O: O(N)
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a positon >= pos have a
     * position = old position + 1
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list, item != null
    */
	public void insert(int pos, E item) {
		if (pos < 0 || pos > size() || item == null) {
			throw new IllegalArgumentException("Violation of precondition: " +
                    "insert. Pos must be greater or equal to 0 and less than or equal"
                    + "to size(). Item cannot be null."); 
        }
		
		if (pos == 0) {
			// insert at the front of the LinkedList
			addFirst(item);
		} else if (pos == size()) {
			// insert at the end of the LinkedList
			addLast(item);
		} else {
			// insert the new node at pos by changing the pointers
			DoubleListNode<E> oldNodeAtPos = getNode(pos);
			DoubleListNode<E> newNode = new DoubleListNode<E>(oldNodeAtPos.getPrev(),
					item, oldNodeAtPos);
			// change pointers to point to new node
			oldNodeAtPos.getPrev().setNext(newNode);
			oldNodeAtPos.setPrev(newNode);
			size++;
		}
	}
	
	/**
	 * BIG O: O(N)
	 * Get a node based on position
	 * @param pos is the position of the node in the LinkedList
	 * @return DoubleListNode<E> at the position
	 */
	private DoubleListNode<E> getNode(int pos) {
		// special cases if pos is 0 or size() - 1
		if (pos == 0) {
			return HEADER.getNext();
		} else if (pos == size() - 1) {
			return HEADER.getPrev();
		}
		// set temp to find the next node
		DoubleListNode<E> temp = HEADER.getNext();
		int index = 1;
		// get the next node until index == pos
		while (index <= pos) {
			temp = temp.getNext();
			index++;
		}
		
		return temp;
	}
	
	/**
	 * BIG O: O(N)
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     * item != null
     * @return the old data at the specified position
     */
    public E set(int pos, E item) {
    	if (pos < 0 || pos >= size() || item == null) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "set. Pos must be greater or equal to 0 and less than"
                    + "to size(). Item cannot be null."); 
        }
    	
    	// get the node at pos
    	DoubleListNode<E> node = getNode(pos);
    	E oldData = node.getData();
    	// change the data of the node to item
    	node.setData(item);
    	return oldData;
    }
    
    /**
     * BIG O: O(N)
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
    public E get(int pos) {
    	if (pos < 0 || pos >= size()) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "get. Pos must be greater or equal to 0 and less than"
                    + "to size()."); 
        }
    	
    	// get the data from the node at pos
    	return getNode(pos).getData();
    }

    /**
     * BIG O: O(N)
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a position > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
    public E remove(int pos) {
    	if (pos < 0 || pos >= size()) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "remove. Pos must be greater or equal to 0 and less than"
                    + "to size()."); 
        }
    	
    	if (pos == 0) {
    		// remove the first node in the LinkedList
    		return removeFirst();
    	} else if (pos == size() - 1) {
    		// remove the last node in the LinkedList
    		return removeLast();
    	} else {
    		// change the next and prev so the node being removed is never referred to
    		DoubleListNode<E> nodeAtPos = getNode(pos);
        	E data = nodeAtPos.getData();
        	nodeAtPos.getNext().setPrev(nodeAtPos.getPrev());
        	nodeAtPos.getPrev().setNext(nodeAtPos.getNext());
        	size--;
        	return data;
    	}
    }

    /**
     * BIG O: O(N)
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurrence
     * has been removed and size() = old size() - 1.
     * If obj is not present the list is not altered in any way.
     * @param obj The item to remove from this list. obj != null
     * @return Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     */
    public boolean remove(E obj) {
    	if (obj == null) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "remove. Obj cannot be null."); 
        }
    	
    	// find position of obj in list
    	int index = indexOf(obj);
    	if (index != -1) {
    		// remove the element at index
    		remove(index);
    		return true;
    	}
    	
    	return false;
    }

    /**
     * BIG O: O(N^2)
     * Return a sublist of elements in this list
     * from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start
     * and contains the elements at positions start through stop - 1
     * in this list.
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element
     * of the sublist.
     * @return a list with <tt>stop - start</tt> elements,
     * The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     * If start == stop an empty list is returned.
     */
    public IList<E> getSubList(int start, int stop) {
    	if (start < 0 || start > size() || start > stop || stop > size()) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "getSubList. Start must be greater or equal to 0 and less than or"
                    + "equal to size(). Stop must be greater or equal to start and less"
                    + "than or equal to size()."); 
        }
    	
    	// create new IList<E>
    	IList<E> subList = new LinkedList<E>();
    	for (int i = start; i < stop; i++) {
    		// add the data of the node to the subList 
    		subList.add(get(i));
    	}
    	
    	return subList;
    }

    /**
     * BIG O: O(1)
     * Return the size of this list.
     * In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * @return the number of items in this list
     */
    public int size() {
    	return size;
    }

    /**
     * BIG O: O(N)
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     * @param item the element to search for in the list. item != null
     * @return return the index of the first element equal to item
     * or a -1 if item is not present
     */
    public int indexOf(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "indexOf. Item cannot be null."); 
        }
    	
    	// start indexOf at the beginning of list
    	return indexOf(item, 0);
    }

    /**
     * BIG O: O(N)
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     */
    public int indexOf(E item, int pos) {
    	if (pos < 0 || pos >= size() || item == null) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "indexOf. Pos must be greater or equal to 0 and less than"
                    + "to size(). Item cannot be null"); 
        }
    	
    	Iterator<E> it = iterator();
    	int count = -1;
    	while (it.hasNext()) {
    		count++;
    		// checks if the next element equals item and is after the specified position
    		if (it.next().equals(item) && count >= pos) {
    			// if it is, then return the index of the item
    			return count;
    		}
    	}
    	
    	return -1;
    }

    /**
     * BIG O: O(1)
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void makeEmpty() {
    	// set the prev and next pointers to HEADER
    	HEADER.setNext(HEADER);
		HEADER.setPrev(HEADER);
		// reset size to 0
		size = 0;
    }

    /**
    * BIG O: O(1)
    * return an Iterator for this list.
    * <br>pre: none
    * <br>post: return an Iterator object for this List
    */
    public Iterator<E> iterator() {
    	return new LLIterator();
    }
    
    private class LLIterator implements Iterator<E> {
    	
    	// instance variables
    	private DoubleListNode<E> nextNode;
    	private boolean removeOk;
    	private int removeIndex;
    	
    	/**
    	 * Sets the nextNode and removeIndex instance variables
    	 */
    	public LLIterator() {
    		// initialize instance variables
    		nextNode = HEADER.getNext();
    		removeIndex = -1;
    	}
    	
    	/**
    	 * BIG O: O(1)
    	 * returns true if there is at least one more element in this iteration
    	 */
    	public boolean hasNext() {
    		// checks that the nextNode is not the HEADER
    		return nextNode != HEADER;
    	}
    	
    	/**
    	 * BIG O: O(1)
    	 * gets the next element in this iteration
    	 */
    	public E next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException();
    		}
    		
    		removeIndex++;
    		removeOk = true;
    		// get the data of nextNode
    		E data = nextNode.getData();
    		// set nextNode to the next node
    		nextNode = nextNode.getNext();
    		return data;
    	}
    	
    	/**
    	 * BIG O: O(1)
    	 * removes the current element in the iteration
    	 */
    	public void remove() {
    		if (removeOk == false) {
    			throw new IllegalStateException();
    		}
    		
    		// remove the current element by changing the pointers
    		nextNode.getPrev().getPrev().setNext(nextNode);
    		nextNode.setPrev(nextNode.getPrev().getPrev());
    		removeOk = false;
    		// decrease the remove index and size
    		removeIndex--;
    		size--;
    	}
    }

    /**
     * BIG O: O(1)
     * Remove all elements in this list from <tt>start</tt>
     * inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements
     * to be removed
     * @param stop stop - 1 is the position at the end
     * of the range of elements to be removed
     */
    public void removeRange(int start, int stop) {
    	if (start < 0 || start > size() || start > stop || stop > size()) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "removeRange. Start must be greater or equal to 0 and less than"
                    + "or equal to size(). Stop must be greater or equal to start"
                    + "and less than or equal to size()."); 
        }
    	
    	// find the change in the size of list
    	int decreaseSize = stop - start;
    	// connect the pointers of the node before start and the node at stop
    	DoubleListNode<E> nodeAtStart = getNode(start);
    	DoubleListNode<E> nodeAtStop = getNode(stop);
    	nodeAtStart.getPrev().setNext(nodeAtStop);
    	nodeAtStop.setPrev(nodeAtStart.getPrev());
    	size -= decreaseSize;
    }

    /**
     * BIG O: O(N)
     * Return a String version of this list enclosed in
     * square brackets, []. Elements are in
     * are in order based on position in the
     * list with the first element
     * first. Adjacent elements are separated by comma's
     * @return a String representation of this IList
     */
    public String toString() {
    	Iterator<E> it = iterator();
    	StringBuilder result = new StringBuilder();
    	result.append("[");
    	while (it.hasNext()) {
    		// add the value of the node to result
    		result.append(it.next());
    		if (it.hasNext()) {
    			// only add a comma if there is a next value in the iteration
    			result.append(", ");
    		}
    	}
    	result.append("]");
    	return result.toString();
    }

    /**
     * BIG O: O(N)
     * Determine if this IList is equal to other. Two
     * ILists are equal if they contain the same elements
     * in the same order.
     * @return true if this IList is equal to other, false otherwise
     */
    public boolean equals(Object other) {
    	// check that Object other is an instance of IList
    	if (other instanceof IList) {
    		// set the iterators
    		Iterator<E> it = iterator();
    		IList<?> newList = (IList<?>) other;
    		Iterator<?> otherIt = newList.iterator();
    		// iterate through each value of the list
    		while (it.hasNext()) {
    			// return false if next value of it is not equal to next value of otherIt
    			if (!it.next().equals(otherIt.next())) {
    				return false;
    			}
    		}
    		return true;
    	}
    	
    	return false;	
    }
	
    /**
     * BIG O: O(1)
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     *
     * @param item the data to add to the front of this list
     */
    public void addFirst(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "addFirst. Item cannot be null."); 
        }
    	
    	// create new node and set its pointers
    	DoubleListNode<E> newNode = new DoubleListNode<E>(HEADER, item, HEADER.getNext());
    	// change the Header and the old first node to point to the new node
    	HEADER.getNext().setPrev(newNode);
    	HEADER.setNext(newNode);
    	size++;
    }

    /**
     * BIG O: O(1)
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(size() -1) = item
     *
     * @param item the data to add to the end of this list
     */
    public void addLast(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "addLast. Item cannot be null."); 
        }
    	
    	add(item);
    }

    /**
     * BIG O: O(1)
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     *
     * @return the old first element of this list
     */
    public E removeFirst() {
    	if (size() <= 0) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "removeFirst. Size() cannot be less than or equal to 0."); 
        }
    	
    	// get the data from the first node
    	E data = HEADER.getNext().getData();
    	// change prev and next to stop pointing to the first node
    	HEADER.getNext().getNext().setPrev(HEADER);
    	HEADER.setNext(HEADER.getNext().getNext());
    	size--;
    	return data;
    }

    /**
     * BIG O: O(1)
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     *
     * @return the old last element of this list
     */
    public E removeLast() {
    	if (size() <= 0) {
    		throw new IllegalArgumentException("Violation of precondition: " +
                    "removeLast. Size() cannot be less than or equal to 0."); 
        }
    	
    	// get data from the last node
    	E data = HEADER.getPrev().getData();
    	// change prev and next to stop pointed to the last node
    	HEADER.getPrev().getPrev().setNext(HEADER);
    	HEADER.setPrev(HEADER.getPrev().getPrev());
    	size--;
    	return data;
    }
}
