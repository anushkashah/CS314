/*  Student information for assignment:
 *
 *  On our honor, Anushka Shah and Jessica Ouyang, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose turnin account is being used): Anushka Shah
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  Grader name: Grace
 *
 *  Student 2: Jessica Ouyang
 *  UTEID: jjo889
 *  email address: jouyang99@gmail.com
 *
 */

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue<E extends Comparable<? super E>> {
	
	// instance variables
	private LinkedList<E> q;
	
	/**
	 * Constructs a new PriorityQueue.
	 */
	public PriorityQueue() {
		 q = new LinkedList<>();
	}
	
	/**
	 * Adds the given data into the priority queue, breaking ties fairly.
	 * @param data The data to add to the queue
	 * @return true once data is added
	 */
	public boolean enqueue(E data) {
		if (data == null) {
			throw new IllegalArgumentException("Violation of precondition: " +
                    "enqueue. data cannot be null.");
		}
		// if priority queue is empty, just add data
		if (size() == 0) {
			q.add(data);
			return true;
		}
		int count = 0;
		Iterator<E> it = q.iterator();
		boolean found = false;
		// determine index to add element at
		while (it.hasNext() && !found) {
			E temp = it.next();
			int comp = data.compareTo(temp);
			// iterate through existing list until a larger element is found
			if (comp >= 0) {
				count++;
			} else {
				found = true;
			}
		}
		// add data at the determined index
		q.add(count, data);
		return true;
	}
	
	/**
	 * Removes the first element from the priority queue, if size > 0
	 * @return true if priority queue is changed by this call, false otherwise
	 */
	public boolean dequeue() {
		if (size() != 0) {
			// remove the first element from the queue if one exists
			q.removeFirst();
			return true;
		}
		return false;
	}
	
	/**
	 * Removes all elements from the priority queue.
	 */
	public void clear() {
		q.clear();
	}
	
	/**
	 * Gets the number of elements in the priority queue.
	 * @return the number of elements in the priority queue
	 */
	public int size() {
		return q.size();
	}
	
	/**
	 * Gets the first element in the priority queue.
	 * @return the first element in the priority queue
	 */
	public E front() {
		if (size() != 0) {
			return q.getFirst();
		}
		return null;
	}
	
	/**
	 * Checks whether the priority queue contains any elements.
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Checks whether or not the given Object is in the priority queue.
	 * @param o The object being searched for
	 * @return true if the object is in the queue, false otherwise
	 */
	public boolean contains(Object o) {
		return q.contains(o);
	}	
	
	/**
	 * Creates a String representation of the priority queue.
	 * @return the String representation of the priority queue.
	 */
	public String toString() {
		return q.toString();
	}
}
