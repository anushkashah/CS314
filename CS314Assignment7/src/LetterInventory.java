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
 *  Number of slip days I am using: 1
 */

public class LetterInventory {
	
	// instance variables and constants
	private int[] letterFreq;
	private int size;
	private String name;
	private static final int NUM_LETTERS = 26; 
	private static final int LOWER_ASCII = 97;
	
	/**
	 * Creates a new LetterInventory object using the parameter
	 * @param word the String used to create the LetterInventory
	 */
	public LetterInventory(String word) {
		if (word == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "LetterInventory. The parameter word cannot be null.");
        }
		// initialize instance variables
		name = word;
		letterFreq = new int[NUM_LETTERS];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.toLowerCase().charAt(i); 
			// checks that the char ch is a valid letter
			if ('a' <= ch && ch <= 'z') {
				int val = (int) ch - LOWER_ASCII;
				// increase value in correct position in array
				letterFreq[val] += 1;
				// increase size
				size++;
			}
		}
	}
	
	/**
	 * Gets the frequency of the char in the LetterInventory
	 * @param ch letter to find the frequency of
	 * @return the frequency of the char in the LetterInventory
	 */
	public int get(char ch) {
		// make the char ch lower case
		char lowerCh = Character.toLowerCase(ch);
		if (lowerCh < 'a' || lowerCh > 'z') {
            throw new IllegalArgumentException("Failed precondition: "
                    + "get. The character must be an English letter.");
        }
		// returns frequency at correct position in letterFreq array
		return letterFreq[lowerCh - LOWER_ASCII];
	}
	
	/**
	 * Find the size of the LetterInventory object
	 * @return instance variable size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Checks if the LetterInventory is empty
	 * @return true if LetterInventory is empty, false if otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Find string of all letters in LetterInventory
	 * @return string of all the letters in the LetterInventory object
	 */
	public String toString() {
		// return empty string immediately if LetterInventory is empty
		if (isEmpty()) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < letterFreq.length; i++) {
			int index = 0;
			// find char representation with ascii values
			char ch = (char) (i + LOWER_ASCII);
			// append ch to str the correct number of times
			while (letterFreq[i] > index) {
				str.append(ch);
				index++;
			}
		}
		return str.toString();
	}
	
	/**
	 * Creates a LetterInventory that is the sum of two LetterInventory objects
	 * @param letInv LetterInventory that is being added to this LetterInventory
	 * @return new LetterInventory that is created by adding frequencies of
	 * this LetterInventory and letInv
	 */
	public LetterInventory add(LetterInventory letInv) {
		String newWord = name + letInv.name;
		// create a new LetterInventory using the concatenation of both names
		LetterInventory result = new LetterInventory(newWord);
		return result;
	}
	
	/**
	 * Creates a LetterInventory that is the difference of two LetterInventory objects
	 * @param letInv LetterInventory that is being subtracted from this LetterInventory
	 * @return new LetterInventory that is created by subtracting frequencies of
	 * letInv from this LetterInventory
	 */
	public LetterInventory subtract(LetterInventory letInv) {
		if (letInv == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "subtract. The parameter letInv cannot be null.");
        }
		int[] arr = new int[NUM_LETTERS];
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < letterFreq.length; i++) {
			// add differences at each position into array
			arr[i] = letterFreq[i] - letInv.letterFreq[i];
			// return null if difference is less than 0
			if (arr[i] < 0) {
				return null;
			}
			// find char representation with ascii values
			char ch = (char) (i + LOWER_ASCII);
			int index = 0;
			while (arr[i] > index) {
				// append ch to str the correct number of times
				str.append(ch);
				index++;
			}
		}
		String word = str.toString();
		// create new LetterInventory object with word
		LetterInventory result = new LetterInventory(word);
		return result;
	}
	
	/**
	 * Checks if this LetterInventory is equal to other
	 * @param other Object parameter
	 * @return true if this LetterInventory and other have the same
	 * letter frequencies, false if otherwise
	 */
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other instanceof LetterInventory) {
			// if other is a LetterInventory, check if values at each position are equal
			for (int i = 0; i < letterFreq.length; i++) {
				if (((LetterInventory) other).letterFreq[i] != letterFreq[i]) {
					return false;
				}
			}
			// all values at each position are equal
			return true;
		}
		// other is not an instance of LetterInventory
		return false;
	}
}
