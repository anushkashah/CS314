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


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AnagramSolver {
	
	// instance variable
	private TreeMap<String, LetterInventory> anagrams;
	
    /*
     * pre: list != null
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
    	if (dictionary == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "AnagramSolver. The parameter dictionary cannot be null.");
        }
    	// initialize instance variable
    	anagrams = new TreeMap<>();
    	for (String str : dictionary) {
    		// create a new LetterInventory for each str in dictionary
    		LetterInventory letInv = new LetterInventory(str);
    		anagrams.put(str, letInv);
    	}
    }

    /*
     * pre: maxWords >= 0, s != null, s contains at least one 
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
    	if (maxWords < 0 || s == null || !containsLetter(s)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "AnagramSolver. The parameter dictionary cannot be null.");
        }
    	// create a letter inventory with the given string s parameter
    	LetterInventory currentWord = new LetterInventory(s);
    	List<String> smallDictionary = getSmallDictionary(currentWord);
    	List<List<String>> allAnagrams = new ArrayList<List<String>>();
    	List<String> anagramsSoFar = new ArrayList<String>();
    	// change maxWords to the size of the LetterInventory if maxWords is 0
    	maxWords = (maxWords == 0) ? currentWord.size() : maxWords;
    	int index = 0;
    	// call helper method that does the recursion
    	anagramHelper(currentWord, maxWords, smallDictionary, allAnagrams, anagramsSoFar,
    			index);
    	// sort the order of anagrams in the lists
    	allAnagrams.sort(new AnagramComparator());
        return allAnagrams;
    }
    
    /**
     * Find all the anagrams that can be formed from currentWord with
     * no more than maxWords 
     * @param currentWord LetterInventory object for word that we find anagrams for
     * @param maxWords max number of words in an anagram
     * @param smallDictionary dictionary of only possible, valid words
     * @param allAnagrams all possible anagrams for currentWord
     * @param anagramsSoFar list of words that make up the anagram so far
     * @param index marks spot in the smallDictionary
     */
    private void anagramHelper(LetterInventory currentWord, int maxWords, 
    		List<String> smallDictionary, List<List<String>> allAnagrams, 
    		List<String> anagramsSoFar, int index) {
    	// base case
    	if (currentWord.isEmpty() && maxWords >= 0) {
    		// create a copy of anagramsSoFar
    		List<String> newList = new ArrayList<>(anagramsSoFar); 
    		allAnagrams.add(newList);
    		// clear anagramsSoFar
    		anagramsSoFar.clear();
    	} else {
    		// checks that we still have words left
    		if (maxWords > 0) {
    			// create a copy of anagramsSoFar
    			ArrayList<String> anagramCopy = new ArrayList<String>(anagramsSoFar);
    			for (int i = index; i < smallDictionary.size(); i++) {
        			// checks if word from small dictionary can be part of a valid anagram
    				if (currentWord.subtract(anagrams.get(smallDictionary.get(i))) != null) {
        				// add the word to anagramSoFar
    					anagramsSoFar.add(smallDictionary.get(i));
        				LetterInventory newLet = currentWord.subtract
        						(anagrams.get(smallDictionary.get(i)));
        				// decrement maxWords 
        				maxWords--;
        				// make recursive call
        				anagramHelper(newLet, maxWords, smallDictionary, allAnagrams, 
        						anagramsSoFar, i);
        				// return maxWords and anagramSoFar to original state
        				maxWords++;
        				anagramsSoFar.remove(smallDictionary.get(i));
        			}
    				anagramsSoFar = new ArrayList<String>(anagramCopy);
    			}
    		}
    	}
    }
    
    private static class AnagramComparator implements Comparator<List<String>> {
        
    	/**
    	 * Compare two Lists of Strings with each other
    	 * @param a1 List of strings
    	 * @param a2 List of strings
    	 */
    	public int compare(List<String> a1, List<String> a2) {
            // find the difference between the two lists
    		int diff = a1.size() - a2.size();
            if (diff == 0) {
            	for (int i = 0; i < a1.size(); i++) {
            		// compare string at certain position in both lists
            		int compare = a1.get(i).compareTo(a2.get(i));
            		if (compare != 0) {
            			return compare;
            		}
            	}
            }
            return diff;
        }
    }
    
    /**
     * Find a smaller dictionary with only valid words that can be part
     * of making an anagram 
     * @param currentWord LetterInventory object with the word that anagrams
     * will be found for
     * @return List of strings with valid words
     */
    private List<String> getSmallDictionary(LetterInventory currentWord) {
    	List<String> smallDictionary = new ArrayList<String>();
    	// find all the words in the larger dictionary
    	Set<String> dictionary = anagrams.keySet();
    	for (String word : dictionary) {
    		if (currentWord.subtract(anagrams.get(word)) != null) {
    			// add word to smaller dictionary if it is valid
    			smallDictionary.add(word);
    		}
    	}
    	return smallDictionary;
    }
    
    /**
     * Checks if a string contains at least one English letter
     * @param s word that is checked for letter
     * @return true if string s contains at least one English letter
     */
    private boolean containsLetter(String s) {
    	// make string lowercase
    	String str = s.toLowerCase();
    	for (int i = 0; i < str.length(); i++) {
    		// checks if char at position is English letter
    		if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
    			return true;
    		}
    	}
    	return false;
    }
}
