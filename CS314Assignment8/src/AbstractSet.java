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

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> {
    
    /**
     * Return a String version of this set. 
     * Format is (e1, e2, ... en)
     * @return A String version of this set.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0) {
            result.setLength(result.length() - seperator.length());
        }
        result.append(")");
        return result.toString();
    }
    
    /**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, 
     * false otherwise.
     */
    public abstract boolean add(E item);
    
    /**
      * A union operation. Add all items of otherSet that 
      * are not already present in this set to this set.
      * @param otherSet != null
      * @return true if this set changed as a result of this operation, 
      * false otherwise.
      */
    // O(N^2)
    public boolean addAll(ISet<E> otherSet) {
    	if (otherSet == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "addAll. otherSet cannot be null."); 
        }
    	boolean changed = false;
    	Iterator<E> it = otherSet.iterator();
    	while (it.hasNext()) {
    		E temp = it.next();
    		// only add item if not already in current set
    		if (!this.contains(temp)) {
    			this.add(temp);
    			// set has been altered
    			changed = true;
    		}
    	}
    	return changed;
    } 

    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    // O(N)
    public void clear() {
    	Iterator<E> it = this.iterator();
    	// remove each item in set
    	while (it.hasNext()) {
    		it.next();
    		it.remove();
    	}
    }

    /**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. 
     * Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    // O(N)
    public boolean contains(E item) {
    	if (item == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "Contains. Item cannot be null."); 
        }
    	for (E temp : this) {
    		// check each element in current set against item
    		if (temp.equals(item)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    // O(N^2)
    public boolean containsAll(ISet<E> otherSet) {
    	if (otherSet == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "containsAll. otherSet cannot be null."); 
        }
    	for (E item : otherSet) {
    		// if current set does not contain an item in other set, does not contain all
    		if (!this.contains(item)) {
    			return false;
    		}
    	}
    	return true;
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
    public abstract ISet<E> difference(ISet<E> otherSet);

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    // O(N^2)
    public boolean equals(Object other) {
    	// make sure other is an AbstractSet
    	if (other instanceof AbstractSet<?>) {
    		AbstractSet<?> o = (AbstractSet<?>) other;
    		// if sizes are different, not equal
    		if (o.size() != this.size()) {
    			return false;
    		}
    		Iterator<E> it = this.iterator();
    		while (it.hasNext()) {
    			// check each element in this set against other
    			boolean equal = false;
    			E temp = it.next();
    			Iterator<?> oit = o.iterator();
    			while (oit.hasNext() && !equal) {
    				if (temp.equals(oit.next())) {
    					equal = true;
    				}
    			}
    			// if this element is not in the other set, cannot be equal
    			if (!equal) {
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
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
    public abstract ISet<E> intersection(ISet<E> otherSet); 
    
    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    public abstract Iterator<E> iterator();  
    
    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, 
     * false otherwise
     */
    // O(N)
    public boolean remove(E item) {
    	if (item == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "Remove. Item cannot be null."); 
        }
    	// make sure item is present in current set
    	if (this.contains(item)) {
    		Iterator<E> it = this.iterator();
    		while (it.hasNext()) {
    			// remove element if equal to current
    			if (it.next().equals(item)) {
    				it.remove();
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    // O(N)
    public int size() {
    	Iterator<E> it = this.iterator();
    	int count = 0;
    	// count the number of iterations
    	while (it.hasNext()) {
    		count++;
    	}
    	return count;
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
    	// union is equal to intersection plus both differences
    	ISet<E> thisDiff = this.difference(otherSet);
    	thisDiff.addAll(otherSet.difference(this));
    	thisDiff.addAll(this.intersection(otherSet));
    	return thisDiff;
    }
}
