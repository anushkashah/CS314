/*  Student information for assignment:
 *
 *  On my honor, Anushka Shah, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Anushka Shah
 *  email address: anushkashah654@gmail.com
 *  UTEID: aks4562
 *  Section 5 digit ID: 52660
 *  Grader name: Grace
 *  Number of slip days used on this assignment: 0
 */

// add imports as necessary

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Manages the details of EvilHangman. This class keeps
 * tracks of the possible words from a dictionary during
 * rounds of hangman, based on guesses so far.
 *
 */
public class HangmanManager {

    // instance variables
	Set<String> data;
	boolean debug;
	int wordLength;
	int numOfWrongGuesses;
	HangmanDifficulty difficulty;
	Set<String> current;
	String pattern;
	TreeSet<Character> guesses;
	// constants
	private final static int MEDIUM = 4;
	private final static int EASY = 2;
	private final static char DASH = '-';
	private static int COUNTER = 0;
	
    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * pre: words != null, words.size() > 0
     * @param words A set with the words for this instance of Hangman.
     * @param debugOn true if we should print out debugging to System.out.
     */
    public HangmanManager(Set<String> words, boolean debugOn) {
    	if (words == null || words.size() <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "HangmanManager. The parameter may not be null and the size cannot"
                    + "be less than or equal to 0."); 
        }
    	// set instance variables to respective parameters
    	data = words;
    	debug = debugOn;
    }

    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * Debugging is off.
     * pre: words != null, words.size() > 0
     * @param words A set with the words for this instance of Hangman.
     */
    public HangmanManager(Set<String> words) {
    	this(words, false);
    }

    /**
     * Get the number of words in this HangmanManager of the given length.
     * pre: none
     * @param length The given length to check.
     * @return the number of words in the original Dictionary
     * with the given length
     */
    public int numWords(int length) {
        int count = 0;
        // if the length of a word in data is equal to the 
        // given length, increase count
    	for (String s : data) {
    		if (s.length() == length) {
    			count++;
    		}
    	}
    	
    	return count;
    }

    /**
     * Get for a new round of Hangman. Think of a round as a
     * complete game of Hangman.
     * @param wordLen the length of the word to pick this time.
     * numWords(wordLen) > 0
     * @param numGuesses the number of wrong guesses before the
     * player loses the round. numGuesses >= 1
     * @param diff The difficulty for this round.
     */
    public void prepForRound(int wordLen, int numGuesses, HangmanDifficulty diff) {
    	if (numWords(wordLen) <= 0 || numGuesses < 1) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "HangmanManager. There must be more than 0 words with wordLen and "
                    + "the number of guesses must be greater or equal to 1."); 
        }
    	
    	// initialize instance variables with parameters
    	wordLength = wordLen;
    	numOfWrongGuesses = numGuesses;
    	difficulty = diff;
    	// current has words only with the specified word length from data
    	current = currLength(wordLength);
    	// create the empty pattern of dashes based on the word length
    	StringBuilder pat = new StringBuilder();
    	for (int i = 0; i < wordLength; i++) {
    		pat.append(DASH);
    	}
    	pattern = pat.toString();
    	// create new empty tree set
    	guesses = new TreeSet<Character>();
    	COUNTER = 0;
    }
    
    /**
     * Adds all words from data that are a specified word length to a set of Strings
     * @param wordLen the length of the word to pick
     * @return Set of Strings with words with length wordLen
     */
    private Set<String> currLength(int wordLen) {
    	Set<String> result = new HashSet<String>();
    	// if the length of a word in data is equal to the 
        // parameter wordLen, add to the set result
    	for (String s : data) {
    		if (s.length() == wordLen) {
    			result.add(s);
    		}
    	}
    	
    	return result;
    }
    
    /**
     * The number of words still possible (live) based on the guesses so far.
     *  Guesses will eliminate possible words.
     * @return the number of words that are still possibilities based on the
     * original dictionary and the guesses so far.
     */
    public int numWordsCurrent() {
        return current.size();
    }

    /**
     * Get the number of wrong guesses the user has left in
     * this round (game) of Hangman.
     * @return the number of wrong guesses the user has left
     * in this round (game) of Hangman.
     */
    public int getGuessesLeft() {
        return numOfWrongGuesses;
    }

    /**
     * Return a String that contains the letters the user has guessed
     * so far during this round.
     * The characters in the String are in alphabetical order.
     * The String is in the form [let1, let2, let3, ... letN].
     * For example [a, c, e, s, t, z]
     * @return a String that contains the letters the user
     * has guessed so far during this round.
     */
    public String getGuessesMade() {
    	return guesses.toString();
    }

    /**
     * Check the status of a character.
     * @param guess The characater to check.
     * @return true if guess has been used or guessed this round of Hangman,
     * false otherwise.
     */
    public boolean alreadyGuessed(char guess) {
        // returns true if the TreeSet of guesses has the parameter guess
    	return guesses.contains(guess);
    }


    /**
     * Get the current pattern. The pattern contains '-''s for
     * unrevealed (or guessed) characters and the actual character 
     * for "correctly guessed" characters.
     * @return the current pattern.
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Update the game status (pattern, wrong guesses, word list),
     * based on the give guess.
     * @param guess pre: !alreadyGuessed(ch), the current guessed character
     * @return return a tree map with the resulting patterns and the number of
     * words in each of the new patterns.
     * The return value is for testing and debugging purposes.
     */
    public TreeMap<String, Integer> makeGuess(char guess) {
        if (alreadyGuessed(guess)) {
        	throw new IllegalStateException("Character is already guessed");
        }
        
        guesses.add(guess);
        // treemap where the pattern is the key, and the arraylist are the words
        // with that pattern
        TreeMap<String, ArrayList<String>> allPatterns = new TreeMap<String, 
        		ArrayList<String>>();
        allPatterns = findOptions(guess);
        // create an arraylist of CorrectPattern objects
        ArrayList<CorrectPattern> arrOfPat = new ArrayList<CorrectPattern>();
    	ArrayList<String> keys = new ArrayList<>(allPatterns.keySet());
    	for (int i = 0; i < allPatterns.size(); i++) {
    		// size is the number of words per pattern
    		int size = allPatterns.get(keys.get(i)).size();
    		String currPattern = keys.get(i);
    		// create a new CorrectPattern object and add to array list
    		CorrectPattern cp = new CorrectPattern(size, currPattern, guess);
    		arrOfPat.add(cp);
    	}
    	// sort the arraylist but then reverse it
    	Collections.sort(arrOfPat, Collections.reverseOrder());
    	// set the new pattern based on the check difficulty method
    	pattern = checkDifficulty(arrOfPat);
    	// update the current words
    	updateCurrWords(allPatterns);
    	// decrease the number of wrong guesses available if the guess is incorrect
    	if (!pattern.contains(guess + "")) {
    		numOfWrongGuesses--;
    	}
    	// create treemap and add patterns as key and number of words per key as the value
        TreeMap<String, Integer> branches = new TreeMap<String, Integer>();
        for (int i = 0; i < allPatterns.size(); i++) {
        	branches.put(keys.get(i), allPatterns.get(keys.get(i)).size());
        }
        
        return branches;
    }
    
    /**
     * Finds the pattern of a given string based on the guess
     * @param guess the character that has been guessed
     * @param word the pattern of this String needs to be found
     * @return the pattern of word
     */
    private String findPattern(char guess, String word) {
    	StringBuilder wordPattern = new StringBuilder();
    	// go through each letter of word
    	for (int i = 0; i < wordLength; i++) {
    		// makes sure that the instance variable pattern is equal to a dash
    		// and not something from a previous guess
    		if (pattern.charAt(i) == DASH) {
    			// append guess if the letter of word equals guess
    			if(word.charAt(i) == guess) {
    				wordPattern.append(guess);
    			} else {
    				wordPattern.append(DASH);
    			}
    		} else {
    			wordPattern.append(pattern.charAt(i));
    		}
    	}
    	
    	return wordPattern.toString();
    }
    
    /**
     * Creates a TreeMap containing patterns and ArrayLists of all words with those patterns
     * @param guess the letter being guessed
     * @return a TreeMap containing patterns and ArrayLists of all words with those patterns
     */
    private TreeMap<String, ArrayList<String>> findOptions(char guess) {
    	TreeMap<String, ArrayList<String>> options = new TreeMap<String, ArrayList<String>>();
    	for (String word : current) {
    		// finds the pattern of the word in current
    		String currentPattern = findPattern(guess, word);
    		ArrayList<String> newSet = new ArrayList<String>();
    		// if the pattern already exists in options
    		if (options.containsKey(currentPattern)) {
    			// set the arraylist to the words in options with the current pattern
    			newSet = options.get(currentPattern);
    			// add the new word and replace the old value of current pattern
    			// with the new arraylist
    			newSet.add(word);
    			options.replace(currentPattern, newSet);
    		} else {
    			// if pattern does not exist, add it to options
    			newSet.add(word);
    			options.put(currentPattern, newSet);
    		}
    	}
    	
    	return options;
    }
    
    class CorrectPattern implements Comparable<CorrectPattern> {
    	
    	// instance variables
    	int frequency;
    	String currPattern;
    	char guess;
    	
    	/**
    	 * Create a new CorrectPattern
    	 * @param freq the number of words a specific pattern has 
    	 * @param newPattern one of the possible patterns
    	 * @param guessedLetter the letter guessed in HangmanManager
    	 */
    	public CorrectPattern(int freq, String newPattern, char guessedLetter) {
    		frequency = freq;
    		currPattern = newPattern;
    		guess = guessedLetter;
    	}
    	
    	/**
    	 * Get the pattern of the CorrectPattern class
    	 * @return currPattern
    	 */
    	public String getPat() {
    		return currPattern;
    	}
    	
    	/**
    	 * CompareTo method to compare CorrectPattern objects
    	 */
    	public int compareTo(CorrectPattern o) {
			// first compare based on frequency (which pattern has more words)
    		int freqDiff = frequency - o.frequency;
			if (freqDiff == 0) {
				// if both frequency are equal, check which one reveals less letters
				int lessRev = lessRevealed(o.currPattern);
				if (lessRev == 0) {
					// if both reveal the same number of letters, use string compare to
					return o.currPattern.compareTo(currPattern);
				}
				// returns if lessRev != 0
				return lessRev;
			}
			
			return freqDiff;
		}
		
    	/**
    	 * Determines which pattern has less of the guess revealed for compareTo method
    	 * @param otherPattern is another pattern
    	 * @return the difference of otherCount minus patCount
    	 */
		private int lessRevealed(String otherPattern) {
			int patCount = 0;
			int otherCount = 0;
			for (int i = 0; i < currPattern.length(); i++) {
				// iterates through each value of currPattern and otherPattern and checks
				// if the character is equal to guess in order to increase patCount 
				// or otherCount
				if (currPattern.charAt(i) == guess) {
					patCount++;
				}
				if (otherPattern.charAt(i) == guess) {
					otherCount++;
				}
			}
			
			return otherCount - patCount;
		}	
    }
    
    /**
     * Based on the difficulty, determine which pattern to return
     * @param arrOfPat is the arraylist of sorted CorrectPattern objects where
     * each object has a specified pattern
     * @return a String which is the pattern
     */
    private String checkDifficulty(ArrayList<CorrectPattern> arrOfPat) {
    	COUNTER++;
    	if (arrOfPat.size() == 1) {
    		// get first CorrectPattern pattern when arraylist is of size 1
    		return arrOfPat.get(0).getPat();
    	}
    	if (difficulty == HangmanDifficulty.HARD) {
    		// always get the hardest difficulty pattern
    		return arrOfPat.get(0).getPat();
    	} else if (difficulty == HangmanDifficulty.MEDIUM) {
    		if (COUNTER % MEDIUM == 0) {
    			// every fourth time, get the second hardest difficulty pattern
    			return arrOfPat.get(1).getPat();
    		} else {
    			return arrOfPat.get(0).getPat();
    		}
    	} else {
    		if (COUNTER % EASY == 0) {
    			// every other time, get the second hardest difficulty pattern
    			return arrOfPat.get(1).getPat();
    		} else {
    			return arrOfPat.get(0).getPat();
    		}
    	}
    }
    
    /**
     * Updates the current/active words instance variable
     * @param allPatterns is the treemap with pattern as key and list of words as the value
     */
    private void updateCurrWords(TreeMap<String, ArrayList<String>> allPatterns) {
    	ArrayList<String> corrWords = new ArrayList<String>();
    	// set the arraylist to the words that have the correct new pattern
    	corrWords = allPatterns.get(pattern);
    	Set<String> currSet = new TreeSet<String>();
    	for (int i = 0; i < corrWords.size(); i++) {
    		// add each of the words to the new active set of words
    		currSet.add(corrWords.get(i));
    	}
    	// update current to the new active words
    	current = currSet;
    }

    /**
     * Return the secret word this HangmanManager finally ended up
     * picking for this round.
     * If there are multiple possible words left one is selected at random.
     * <br> pre: numWordsCurrent() > 0
     * @return return the secret word the manager picked.
     */
    public String getSecretWord() {
    	if (numWordsCurrent() <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getSecretWord. There must be more than 0 active words."); 
        }
    	
    	// find a random number within the number of current words
    	int ran = (int) Math.random() * numWordsCurrent();
    	int count = 0;
    	for (String s : current) {
    		count++;
    		// if there is only one active word or count equals the random number
    		// return the String s from the set
    		if (numWordsCurrent() == 1 || count == ran) {
    			return s;
    		}
    	}
    	
    	return "";
    }
}
