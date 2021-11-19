/*  Student information for assignment:
*
*  On my honor, Anushka Shah, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: aks4562
*  email address: anushkashah654@gmail.com
*  Number of slip days I am using: 0
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
* A collection of NameRecords. 
* Stores NameRecord objects and provides methods to select
* NameRecords based on various criteria.
*/
public class Names {
    
	private ArrayList<NameRecord> arrOfNameRecords = new ArrayList<NameRecord>();
	
    /**
     * Construct a new Names object based on the data source the Scanner 
     * sc is connected to. Assume the first two lines in the 
     * data source are the base year and number of decades to use.
     * Any lines without the correct number of decades are discarded 
     * and are not part of the resulting Names object. 
     * Any names with ranks of all 0 are discarded and not
     * part of the resulting Names object.
     * @param sc Is connected to a data file with baby names 
     * and positioned at the start of the data source.
     */
    public Names(Scanner sc) {
    	String line;
    	// set first line to be the base decade and convert to int
    	String baseDecadeStr = sc.nextLine();
    	int baseDecade = Integer.parseInt(baseDecadeStr);
    	// set second line to be the number of decades and convert to int
    	String numOfDecadeStr = sc.nextLine();
    	int numOfDecade = Integer.parseInt(numOfDecadeStr);
    	while(sc.hasNextLine() ){
    	    line = sc.nextLine();
    	    // split the name from the ranks and set to variables
    	    String[] parsedData = line.split("\\s+");
    	    String name = parsedData[0];
    	    String[] parsedDataCopy = new String[parsedData.length - 1];
    	    System.arraycopy(parsedData, 1, parsedDataCopy, 0, parsedData.length - 1);
    	    // check if the ArrayList of ranks is equal to the number of decades
    	    if (parsedDataCopy.length == numOfDecade) {
    	    	ArrayList<Integer> realData = new ArrayList<Integer>();
        	    for (int i = 0; i < parsedDataCopy.length; i++) {
        	    	realData.add(Integer.parseInt(parsedDataCopy[i]));
        	    }
        	    // initialize new Name Record using constructor
        	    NameRecord newNR = new NameRecord(name, baseDecade, realData);
        	    arrOfNameRecords.add(newNR);
    	    }
    	}
    	// sort arrOfNameRecords alphabetically
    	Collections.sort(arrOfNameRecords);
    }

   /**
    * Returns an ArrayList of NameRecord objects that contain a 
    * given substring, ignoring case.  The names must be in sorted order based 
    * on name.
    * @param partialName != null, partialName.length() > 0
    * @return an ArrayList of NameRecords whose names contains
    * partialName. If there are no NameRecords that meet this
    * criteria returns an empty list. 
    */
   public ArrayList<NameRecord> getMatches(String partialName) {
	   if (partialName == null || partialName.length() <= 0) {
			throw new IllegalArgumentException("Violation of precondition: " +
                   "getMatches. The parameter may not be null and may" +
                   " not have a length less than or equal to 0");
		}
	   
	   ArrayList<NameRecord> sameNames = new ArrayList<NameRecord>();
	   // iterates through arrOfNameRecords to check if the partialName is in the 
	   // NameRecord name
	   for (int i = 0; i < arrOfNameRecords.size(); i++) {
		   if (arrOfNameRecords.get(i).getName().toLowerCase().contains
				   (partialName.toLowerCase())) {
			   sameNames.add(arrOfNameRecords.get(i));
		   }
	   }
	   
	   return sameNames;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the
    * top 1000 or better for every decade. The Strings  must be in sorted 
    * order based on name. 
    * @return A list of the names that have been ranked in the top
    * 1000 or better in every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedEveryDecade() {
	   ArrayList<String> rankedDecade = new ArrayList<String>();
	   // iterates through arrOfNameRecords to find Name Records ranked every decade
	   for (int i = 0; i < arrOfNameRecords.size(); i++) {
		   if (arrOfNameRecords.get(i).allInTop1000s()) {
			   rankedDecade.add(arrOfNameRecords.get(i).getName());
		   }
	   }
	   
	   return rankedDecade;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the 
    * top 1000 or better in exactly one decade. The Strings must be in sorted 
    * order based on name. 
    * @return A list of the names that have been ranked in the top
    * 1000 or better in exactly one decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedOnlyOneDecade() {
	   ArrayList<String> rankedOneDecade = new ArrayList<String>();
	   for (int i = 0; i < arrOfNameRecords.size(); i++) {
		   // if a Name Record from arrOfNameRecords is in top 1000 once,
		   // add to ArrayList of strings
		   if (arrOfNameRecords.get(i).onceInTop1000s()) {
			   rankedOneDecade.add(arrOfNameRecords.get(i).getName());
		   }
	   }
	   
	   return rankedOneDecade;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting more
    * popular every decade. The Strings  must be in sorted order based on name.
    * @return A list of the names that have been getting more popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list. 
    */
   public ArrayList<String> alwaysMorePopular() {
	   ArrayList<String> morePopular = new ArrayList<String>();
       // checks if Name Record in arrOfNameRecords is more popular
	   for (int i = 0; i < arrOfNameRecords.size(); i++) {
    	   if (arrOfNameRecords.get(i).morePopular()) {
    		   morePopular.add(arrOfNameRecords.get(i).getName());
    	   }
       }
       
       return morePopular;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting less
    * popular every decade. The Strings  must be in sorted order based on name.
    * @return A list of the names that have been getting less popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list. 
    */
   public ArrayList<String> alwaysLessPopular() {
	   ArrayList<String> lessPopular = new ArrayList<String>();
       for (int i = 0; i < arrOfNameRecords.size(); i++) {
    	   // add Name Record to ArrayList of strings if it is less popular
    	   if (arrOfNameRecords.get(i).lessPopular()) {
    		   lessPopular.add(arrOfNameRecords.get(i).getName());
    	   }
       }
       
       return lessPopular;
   }
   
   /**
    * Return the NameRecord in this Names object that matches the given String.
    * <br>
    * <tt>pre: name != null</tt>
    * @param name The name to search for.
    * @return The name record with the given name or null if no NameRecord in this Names
    * object contains the given name.
    */
   public NameRecord getName(String name) {
       if(name == null) {
    	   throw new IllegalArgumentException("The parameter name cannot be null");
       }
       
       int val = 0;
       for (int i = 0; i < arrOfNameRecords.size(); i++) {
    	   // checks if name is equal to Name Record's name
		   if (arrOfNameRecords.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
			   val = i;
			   return arrOfNameRecords.get(val);
		   }
	   }
       
       return null;
   }
   
   /* 
	* Checks if the Name Records in arrOfNAmeRecords have alternating ranks
    * pre: none
    * post: returns altRanks, an ArrayList of strings with the names of 
    * Name Records with alternating ranks
    */
   public ArrayList<String> getAlternatingRanks() {
	   ArrayList<String> altRanks = new ArrayList<String>();
	   for (int i = 0; i < arrOfNameRecords.size(); i++) {
		   if (arrOfNameRecords.get(i).alternatingRanks()) {
			   altRanks.add(arrOfNameRecords.get(i).getName());
		   }
	   }
	   
	   return altRanks;
   }
}
