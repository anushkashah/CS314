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
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {

	// instance variable
    private ArrayList<E> myCon;
    
    /**
     * Creates a new UnsortedSet using an ArrayList as an internal storage container
     */
    // O(1)
    public UnsortedSet() {
    	myCon = new ArrayList<E>();
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
                    "Add. Item cannot be null."); 
        }
    	boolean changed = false;
    	if (!myCon.contains(item)) {
    		// only add item if myCon doesn't already have it
    		myCon.add(item);
    		changed = true;
    	}
    	return changed;
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
    // O(N^2)
    public ISet<E> difference(ISet<E> otherSet) {
    	if (otherSet == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "difference. otherSet cannot be null."); 
        }
    	// create new UnsortedSet
    	UnsortedSet<E> temp = new UnsortedSet<>();
    	for (E val : this) {
    		// only add val from this set if otherSet does not contain it
    		if (!otherSet.contains(val)) {
    			temp.add(val);
    		}
    	}
    	return temp;
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
    // O(N^2)
    public ISet<E> intersection(ISet<E> otherSet) {
    	if (otherSet == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "intersection. otherSet cannot be null."); 
        }
    	UnsortedSet<E> temp = new UnsortedSet<>();
    	// determine smaller and larger sets
    	AbstractSet<E> smaller = (this.size() > otherSet.size()) ? 
    			(AbstractSet<E>) otherSet : this;
    	AbstractSet<E> larger = (smaller.equals(this)) ? (AbstractSet<E>) otherSet : this;
    	// iterate through smaller set
    	for (E val : smaller) {
    		// check if larger set contains each val from smaller, then add
    		if (larger.contains(val)) {
    			temp.add(val);
    		}
    	}
    	return temp;
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
    // O(N^2)
    public ISet<E> union(ISet<E> otherSet) {
    	if (otherSet == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "union. otherSet cannot be null."); 
        }
    	UnsortedSet<E> temp = new UnsortedSet<>();
    	// add all elements of both sets without repeats
    	temp.addAll(this);
    	temp.addAll(otherSet);
    	return temp;
    }
}
