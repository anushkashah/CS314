import java.util.ArrayList;

public class NameRecord implements Comparable<NameRecord> {
	
	// instance variables
	private String name;
	private int baseDecade;
	private ArrayList<Integer> rank;
	
	/* 
	 * Creates a NameRecord with a name, baseDecade, and an ArrayList of ranks
     * pre: namesOfRecord != null
     * post: none
     */
	public NameRecord(String nameOfRecord, int baseDec, ArrayList<Integer> ranksOfRecord) {
		if (nameOfRecord == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "NameRecord. The parameter may not be null."); 
        }
		
		name = nameOfRecord;
		baseDecade = baseDec;
		rank = new ArrayList<Integer>();
		// adding in the values from the parameter ArrayList to instance variable rank
		// setting 0 to 1001 in rank
		for (int i = 0; i < ranksOfRecord.size(); i++) {
			if (ranksOfRecord.get(i) == 0) {
				rank.add(1001);
			} else {
				rank.add(rank.get(i));
			}
		}
	}
	
	/* 
	 * Get the name of the NameRecord
     * pre: none
     * post: returns name
     */
	public String getName() {
		return name;
	}
	
	/* 
	 * Get the base decade of the NameRecord
     * pre: none
     * post: returns baseDecade
     */
	public int getBaseDecade() {
		return baseDecade;
	}
	
	/* 
	 * Get a specific decades's rank from the ArrayList ranks
     * pre: none
     * post: returns a specific decade's rank
     */
	public int getRank(int decade) {
		if (decade < 0 || decade > rank.size() - 1) {
			throw new IllegalArgumentException("Violation of precondition: " +
                    "getRank. The parameter may not be less that 0" +
                    " and must not be greater than numOfDecades - 1.");
		}
		
		// 0's are saved as 1001 in rank so need to return 0
		if (rank.get(decade) == 1001) {
			return 0;
		} else {
			return rank.get(decade);
		}
	}
	
	/* 
	 * Get the decade with the best rank
     * pre: none
     * post: returns the best decade
     */
	public int bestDecade() {
		int max = 1001;
		int index = 0;
		// finds the index of the best decade
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) <= max) {
				max = rank.get(i);
				index = i;
			}
		}
		
		// uses index of best decade to find actual decade
		int decade = baseDecade;
		for (int i = 0; i < index; i++) {
			decade += 10;
		}
		
		return decade;
	}
	
	/* 
	 * Get the number of decades a NameRecord is in the top 1000
     * pre: none
     * post: returns number of decades that a Name Record is in top 1000
     */
	public int decadesInTop1000s() {
		int decades = 0;
		// iterates through rank to find decades in top 1000
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) != 1001) {
				decades++;
			}
		}
		
		return decades;
	}
	
	/* 
	 * Checks if all decades' ranks are in top 1000
     * pre: none
     * post: returns if each decade's rank is in the top 1000
     */
	public boolean allInTop1000s() {
		for (int i = 0; i < rank.size(); i++) {
			// returns false if one decade is not in top 1000
			if (rank.get(i) == 1001) {
				return false;
			}
		}
		
		return true;
	}
	
	/* 
	 * Checks if NameRecord has only one decade with a rank in the top 1000
     * pre: none
     * post: returns if there is only one decade in top 1000
     */
	public boolean onceInTop1000s() {
		int decades = 0;
		for (int i = 0; i < rank.size(); i++) {
			// counts number of decades in top 1000
			if (rank.get(i) < 1001) {
				decades++;
			}
		}
		
		// returns if there is only 1 decade in top 1000
		if (decades == 1) {
			return true;
		}
		
		return false;
	}
	
	/* 
	 * Checks if ranks get more popular
     * pre: none
     * post: returns if the decades's ranks get more popular
     */
	public boolean morePopular() {
		int max = 1002;
		// iterates through ranks to check if they are getting more popular
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) < max) {
				max = rank.get(i);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	/* 
	 * Checks if ranks get less popular
     * pre: none
     * post: returns if the decades's ranks get less popular
     */
	public boolean lessPopular() {
		int max = 0;
		// iterates through ranks to check if they are getting less popular
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) > max) {
				max = rank.get(i);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	/* 
     * pre: none
     * post: returns String for a Name Record
     */
	public String toString() {
		StringBuilder str = new StringBuilder(1);
		str.append(name + "\n");
		// add each value from rank into str
		for (int i = 0; i < rank.size(); i++) {
			// change back 1001 to 0 before adding to str
			if (rank.get(i) == 1001) {
				rank.set(i, 0);
			}
			str.append((baseDecade + i * 10) + ": " + rank.get(i) + "\n");
		}
		
		return str.toString();
	}
	
	/* 
	 * Compares one Name Record to other Name Record
     * pre: none
     * post: returns a value based on the difference between the characters
     */
	public int compareTo(NameRecord other) {
		return name.compareTo(other.name);
	}
	
	/* 
	 * Checks if a Name Record's ranks are alternating increasing and decreasing
     * pre: none
     * post: returns if the decades's ranks are alternating increasing/decreasing
     */
	public boolean alternatingRanks() {
		// set altBool based on if first rank is greater or less than second rank
		boolean altBool = true;
		if (rank.get(0) < rank.get(1)) {
			altBool = false;
		}
		
		for (int i = 1; i < rank.size(); i++) {
			// checks if ranks are alternating, returns false if not
			if (altBool && rank.get(i - 1) > rank.get(i)) {
				altBool = false;
			} else if (!altBool && rank.get(i - 1) < rank.get(i)) {
				altBool = true;
			} else {
				return false;
			}
		}
		
		return true;	
	}	
}
