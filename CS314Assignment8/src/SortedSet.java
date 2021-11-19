/*  Student information for assignment:
 *
 *  On our honor, Anushka Shah and Jessica Ouyang, 
 *  this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose Canvas account is being used): Anushka Shah
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  TA name: Grace
 *  
 *  Student 2: Jessica Ouyang
 *  UTEID: jjo889
 *  email address: jouyang99@gmail.com  
 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * 
 * The data type for E must be a type that implements Comparable.
 * 
 * Implement methods that were not implemented in AbstractSet 
 * and override methods that can be done more efficiently. An ArrayList must 
 * be used as the internal storage container. For methods involving two set, 
 * if that method can be done more efficiently if the other set is also a 
 * SortedSet, then do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {
	
	// instance variable
    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    // O(1)
    public SortedSet() {
    	myCon = new ArrayList<E>();
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null
     */
    // O(NlogN)
    public SortedSet(ISet<E> other) {
       	if (other == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "SortedSet. other cannot be null."); 
       	}
    	myCon = new ArrayList<E>();
    	// add all elements to myCon
    	for (E temp : other) {
    		myCon.add(temp);
    	}
    	// mergesort
    	sort(myCon, 0, myCon.size() - 1);
    }
    
    /**
     * Adapted from Mike's slides on MergeSort
     * @param data the ArrayList of data to sort
     * @param low the starting index of the array to sort
     * @param high the ending index of the array to sort
     */
    private void sort(ArrayList<E> data, int low, int high) {
    	if (low < high) {
    		int center = (low + high ) / 2;
    		sort(data, low, center);
    		sort(data, center + 1, high);
    		merge(data, low, center + 1, high);
    	}
    }
    
    /**
     * Adapted from Mike's slides on MergeSort
     * @param data the ArrayList of data to sort
     * @param left the start index of the left half of the list
     * @param right the start index of the right half of the list
     * @param rightEnd the end of the list
     */
    // O(NlogN)
    private void merge(ArrayList<E> data, int left, int right, int rightEnd) {
    	ArrayList<E> temp = new ArrayList<>();
    	int leftIdx = left;
    	int rightIdx = right;
    	// main loop
    	while (leftIdx < right && rightIdx <= rightEnd) {
    		if (data.get(leftIdx).compareTo(data.get(rightIdx)) <= 0) {
    			temp.add(data.get(leftIdx));
    			leftIdx++;
    		} else {
    			temp.add(data.get(rightIdx));
    			rightIdx++;
    		}
    	}
    	// copy rest of left half
    	while (leftIdx < right) {
    		temp.add(data.get(leftIdx));
    		leftIdx++;
    	}
    	// copy rest of right half
    	while (rightIdx <= rightEnd) {
    		temp.add(data.get(rightIdx));
    		rightIdx++;
    	}
    	// copy temp back into data
    	int idx = 0;
    	int tempPos = left;
    	while (idx < temp.size()) {
    		data.set(tempPos, temp.get(idx));
    		idx++;
    		tempPos++;
    	}
    }

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    // O(1)
    public E min() {
       	if (this.size() == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "min. size must be greater than 0."); 
       	}
    	return myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    // O(1)
    public E max() {
       	if (this.size() == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "max. size must be greater than 0."); 
       	}
    	return myCon.get(myCon.size() - 1);
    }
    
    /**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, 
     * false otherwise.
     */
    // O(N)
    public boolean add(E item) {
	   	if (item == null) {
	           throw new IllegalArgumentException("Violation of precondition: " +
	                   "add. otherSet cannot be null."); 
	    }
	   	// only add if set does not contain item
	   	if (!this.contains(item)) {
	   		// find index to insert item
		   	int index = 0;
		   	boolean check = false;
		   	int i = 0;
		   	while (i < myCon.size() && !check) {
		   		E temp = myCon.get(i);
		   		int comp = item.compareTo(temp);
		   		if (comp < 0) {
		   			index = i;
		   			check = true;
		   		}
		   		i++;
		   	}
		   	// add item at index and return true
		   	index = (!check) ? myCon.size() : index;
		   	myCon.add(index, item);
		   	return true;
		}
	   	return false;
    }
    
    /**
     * A union operation. Add all items of otherSet that 
     * are not already present in this set to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, 
     * false otherwise.
     */
    // O(N) if otherSet is a SortedSet, otherwise O(NlogN)
   public boolean addAll(ISet<E> otherSet) {
	   	if (otherSet == null) {
	           throw new IllegalArgumentException("Violation of precondition: " +
	                   "addAll. otherSet cannot be null."); 
	    }
	   	SortedSet<E> other = (otherSet instanceof SortedSet) ? (SortedSet<E>) otherSet : 
	   		new SortedSet<>(otherSet);
	   	SortedSet<E> result = new SortedSet<E>();
	   	return combine(result, other, 0, 0);
   }
   
   /**
    * Combines other SortedSet and this SortedSet
    * @param result SortedSet that is other SortedSet added to this SortedSet
    * @param other the other SortedSet that is added to this SortedSet
    * @param thisIdx index of this SortedSet
    * @param othIdx index of other SortedSet
    * @return true if this set changed as a result of this operation, false otherwise
    */
   // O(N)
   private boolean combine(SortedSet<E> result, SortedSet<E> other, int thisIdx, int othIdx) {
	   boolean changed = false;
	   // go through both sets
	   while (thisIdx < myCon.size() && othIdx < other.myCon.size()) {
	   		E thisTemp = myCon.get(thisIdx);
	   		E othTemp = other.myCon.get(othIdx);
	   		int comp = thisTemp.compareTo(othTemp);
	   		// add whichever element is smaller, and increase the index
	   		if (comp < 0) {
	   			result.myCon.add(thisTemp);
	   			thisIdx++;
	   		} else if (comp > 0) {
	   			result.myCon.add(othTemp);
	   			othIdx++;
	   			changed = true;
	   		} else { // if both are the same only add one, increase index of both
	   			result.myCon.add(thisTemp);
	   			thisIdx++;
	   			othIdx++;
	   		}
	   	}
	   	// add the remaining elements of the larger set
	   	SortedSet<E> temp = (thisIdx == myCon.size()) ? other : this;
	   	int index = (thisIdx == myCon.size()) ? othIdx : thisIdx;
	   	while (index < temp.size()) {
	   		E val = temp.myCon.get(index);
	   		result.myCon.add(val);
	   		index++;
	   	}
	   	this.myCon = result.myCon;
	   	return changed;
   }

    /**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. 
     * Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
   	// O(logN)
    public boolean contains(E item) {
    	// binary search
    	return bsearch(myCon, item) != -1;
    }
    
    /**
     * Adapted from Mike's slides on binary search
     * @param data ArrayList of data we are searching through
     * @param target value we are finding in ArrayList
     * @return the index of target, -1 if not found
     */
    // O(logN)
    private int bsearch(ArrayList<E> data, E target) {
    	int indexOfTarget = -1;
    	int low = 0;
    	int high = data.size() - 1;
    	while (indexOfTarget == -1 && low <= high) {
    		int mid = low + ((high - low) / 2);
    		if (data.get(mid).equals(target)) {
    			indexOfTarget = mid;
    		} else if (data.get(mid).compareTo(target) < 0) {
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	return indexOfTarget;
    }
    
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    // O(N)
    public boolean containsAll(ISet<E> otherSet) {
	   	if (otherSet == null) {
	           throw new IllegalArgumentException("Violation of precondition: " +
	                   "containsAll. otherSet cannot be null."); 
	    }
    	if (otherSet instanceof SortedSet) {
    		SortedSet<E> o = (SortedSet<E>) otherSet;
    		// if current set is smaller, cannot contain all of otherSet
    		if (this.size() < o.size()) {
    			return false;
    		// if same size, sets must be equal to contain all
    		} else if (this.size() == o.size()) {
    			return this.equals(o);
    		}
    		// otherwise intersection must be same as otherSet
    		SortedSet<E> intersection = (SortedSet<E>) this.intersection(otherSet);
    		return intersection.equals(otherSet);
    	}
    	return super.containsAll(otherSet);
    }
    
    /**
     * Create a new set that is the difference of this set and otherSet. 
     * Return an ISet of elements that are in this Set but not in otherSet. 
     * Also called the relative complement. 
     * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z] 
     * then A.difference(B) would return an ISet with elements [X, Y] while
     * B.difference(A) would return an ISet with elements [W]. 
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the difference of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    // O(N) if otherSet is a SortedSet, otherwise O(NlogN)
    public ISet<E> difference(ISet<E> otherSet) {
	   	if (otherSet == null) {
	           throw new IllegalArgumentException("Violation of precondition: " +
	                   "difference. otherSet cannot be null."); 
	    } 
	   	SortedSet<E> other = (otherSet instanceof SortedSet) ? (SortedSet<E>) otherSet : 
	   		new SortedSet<>(otherSet);
	   	SortedSet<E> result = new SortedSet<E>();
	   	int thisIdx = 0;
	   	int othIdx = 0;
	   	// make sure there are elements left in otherSet and this set
	   	while (othIdx < other.size() && thisIdx < this.size()) {
	   		// get the current E vals at their respective indexes
	   		E temp = myCon.get(thisIdx);
	   		E othTemp = other.myCon.get(othIdx);
	   		int comp = temp.compareTo(othTemp);
	   		// add val from this set if smaller than val from otherSet
	   		if (comp < 0) {
	   			result.myCon.add(temp);
	   			thisIdx++;
	   		// if vals are the same, increase index for both
	   		} else if (comp == 0) {
	   			thisIdx++;
	   			othIdx++;
	   		} else {
	   			othIdx++;
	   		}
	   	}
	   	// add remaining elements from this set if any are left
	   	while (thisIdx < this.size()) {
	   		result.myCon.add(myCon.get(thisIdx));
	   		thisIdx++;
	   	}
	   	return result;
    }
    
    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    // O(N) if other is a SortedSet, O(N^2) otherwise
    public boolean equals(Object other) {
    	if (other instanceof SortedSet<?>) {
    		SortedSet<?> o = (SortedSet<?>) other;
    		// can only be equal if sets have the same number of elements
    		if (this.size() != o.size()) {
    			return false;
    		}
    		Iterator<E> it = this.iterator();
    		Iterator<?> oit = o.iterator();
    		// elements are in order, so each must be equal
    		while (it.hasNext() && oit.hasNext()) {
    			if (!it.next().equals(oit.next())) {
    				return false;
    			}
    		}
    		return true;
    	}
    	// if not a SortedSet, call AbstractSet method
    	return super.equals(other);
    }
    
    /**
     * create a new set that is the intersection of this set and otherSet.
     * <br>pre: otherSet != null<br>
     * <br>post: returns a set that is the intersection of this set 
     * and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the intersection of this set and otherSet
     */
    // O(N) if otherSet is a SortedSet, otherwise O(NlogN)
    public ISet<E> intersection(ISet<E> otherSet) {
	   	if (otherSet == null) {
	           throw new IllegalArgumentException("Violation of precondition: " +
	                   "intersection. otherSet cannot be null."); 
	    }
	   	// GRACE WE LOVE YOU <333 (please don't take off points this is a necessary comment)
	   	SortedSet<E> other = (otherSet instanceof SortedSet) ? (SortedSet<E>) otherSet : 
	   		new SortedSet<>(otherSet);
	   	SortedSet<E> result = new SortedSet<E>();
	   	int thisIdx = 0;
	   	int othIdx = 0;
	   	// loop while still iterating through both sets
	   	while (thisIdx < this.size() && othIdx < other.size()) {
	   		E temp = myCon.get(thisIdx);
	   		E othTemp = other.myCon.get(othIdx);
	   		int comp = temp.compareTo(othTemp);
	   		// increase the index of the set for which the temp val is smaller
	   		if (comp < 0) {
	   			thisIdx++;
	   		} else if (comp > 0) {
	   			othIdx++;
	   		} else {
	   			// if temp vals are equal, add to result and increase index in both
	   			result.myCon.add(temp);
	   			thisIdx++;
	   			othIdx++;
	   		}
	   	}
	   	return result;
    }
    
    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    // O(1)
    public int size() {
    	return myCon.size();
    }
    
    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    // O(1)
    public Iterator<E> iterator() {
    	return myCon.iterator();
    }
    
    /**
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     */
    // O(N)
    public ISet<E> union(ISet<E> otherSet) {
	   	if (otherSet == null) {
	           throw new IllegalArgumentException("Violation of precondition: " +
	                   "union. otherSet cannot be null."); 
	    }
	   	SortedSet<E> result = new SortedSet<>();
	   	// add all elements of this set and otherSet without repeats
	   	result.addAll(this);
	   	result.addAll(otherSet);
	   	return result;
    }
}
