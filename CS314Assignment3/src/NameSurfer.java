
/*
 * Student information for assignment: Replace <NAME> in the following with your
 * name. You are stating, on your honor you did not copy any other code on this
 * assignment and have not provided your code to anyone. 
 * 
 * On my honor, Anushka Shah, this programming assignment is my own work 
 * and I have not provided this code
 * to any other student. 
 * 
 * UTEID: aks4562
 * email address: anushkashah654@gmail.com
 * Number of slip days I am using: 0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class NameSurfer {

	final static String NAME_FILE = "names2.txt";
	// CS314 students, explain your menu option 7 here: My menu option 7 searches
	// for Name Records with alternating increasing/decreasing ranks. If the rank is
	// increasing from the first rank to the second, then it must decrease from the
	// second rank to the third, and continue alternating like that for the rest of
	// the ranks.

	// CS314 students, Explain your interesting search / trend here: My interesting search is
	// that I noticed that during a time of a celebrity's peak in fame, their name rises in 
	// popularity. For example, the name Shakira went from never being in the top 1000 to 
	// suddenly being the 594 place in the 1990s, around when Shakira was at her most famous.
	// Another example is the name Marilyn went from 539 in 1910 to 29 and 56 in 1940 and 1950.
	// This is around the time that Marilyn Monroe was at her most famous.

	// CS314 students, add test code for NameRecord class here:
	public static void tester() {
		int baseDecade = 1900;
		ArrayList<Integer> anushkaRank = new ArrayList<Integer>(
				Arrays.asList(0, 987, 239, 0, 293, 567, 0, 0, 0, 300, 232));
		ArrayList<Integer> jessicaRank = new ArrayList<Integer>(
				Arrays.asList(0, 987, 878, 565, 432, 431, 321, 212, 123, 107, 4));
		ArrayList<Integer> jakeRank = new ArrayList<Integer>(
				Arrays.asList(2, 5, 6, 40, 120, 129, 567, 588, 608, 743, 821));
		ArrayList<Integer> janaRank = new ArrayList<Integer>(
				Arrays.asList(0, 0, 0, 0, 0, 0, 0, 943, 0, 0, 0));
		NameRecord anushkaRecord = new NameRecord("Anushka", baseDecade, anushkaRank);
		NameRecord jessicaRecord = new NameRecord("Jessica", baseDecade, jessicaRank);
		NameRecord jakeRecord = new NameRecord("Jake", baseDecade, jakeRank);
		NameRecord janaRecord = new NameRecord("Jana", baseDecade, janaRank);

		// getName tests
		String actualVal = anushkaRecord.getName();
		String expectedVal = "Anushka";
		if (actualVal.equals(expectedVal)) {
			System.out.println("Test 1: getName() passed");
		} else {
			System.out.println("***** FAILED ***** Test 1: getName()");
		}

		actualVal = jessicaRecord.getName();
		expectedVal = "Jessica";
		if (actualVal.equals(expectedVal)) {
			System.out.println("Test 2: getName() passed");
		} else {
			System.out.println("***** FAILED ***** Test 2: getName()");
		}

		// getBaseDecade tests
		int intActualVal = anushkaRecord.getBaseDecade();
		int intExpectedVal = 1900;
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 3: getBaseDecade() passed");
		} else {
			System.out.println("***** FAILED ***** Test 3: getBaseDecade()");
		}

		intActualVal = jessicaRecord.getBaseDecade();
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 4: getBaseDecade() passed");
		} else {
			System.out.println("***** FAILED ***** Test 4: getBaseDecade()");
		}

		// getRank tests
		intActualVal = anushkaRecord.getRank(3);
		intExpectedVal = 0;
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 5: getRank() passed");
		} else {
			System.out.println("***** FAILED ***** Test 5: getRank()");
		}

		intActualVal = jessicaRecord.getRank(6);
		intExpectedVal = 321;
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 6: getRank() passed");
		} else {
			System.out.println("***** FAILED ***** Test 6: getRank()");
		}

		// bestDecade tests
		intActualVal = anushkaRecord.bestDecade();
		intExpectedVal = 2000;
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 7: bestDecade() passed");
		} else {
			System.out.println("***** FAILED ***** Test 6: bestDecade()");
		}

		intActualVal = jessicaRecord.bestDecade();
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 8: bestDecade() passed");
		} else {
			System.out.println("***** FAILED ***** Test 8: bestDecade()");
		}

		// decadesInTop1000s tests
		intActualVal = anushkaRecord.decadesInTop1000s();
		intExpectedVal = 6;
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 9: decadesInTop1000s() passed");
		} else {
			System.out.println("***** FAILED ***** Test 9: decadesInTop1000s()");
		}

		intActualVal = jessicaRecord.decadesInTop1000s();
		intExpectedVal = 10;
		if (intActualVal == intExpectedVal) {
			System.out.println("Test 10: decadesInTop1000s() passed");
		} else {
			System.out.println("***** FAILED ***** Test 10: decadesInTop1000s()");
		}

		// allInTop1000s tests
		boolean actualBool = anushkaRecord.allInTop1000s();
		boolean expectedBool = false;
		if (actualBool == expectedBool) {
			System.out.println("Test 11: allInTop1000s() passed");
		} else {
			System.out.println("***** FAILED ***** Test 11: allInTop1000s()");
		}

		actualBool = jakeRecord.allInTop1000s();
		expectedBool = true;
		if (actualBool == expectedBool) {
			System.out.println("Test 12: allInTop1000s() passed");
		} else {
			System.out.println("***** FAILED ***** Test 12: allInTop1000s()");
		}

		// onceInTop1000s tests
		actualBool = anushkaRecord.onceInTop1000s();
		expectedBool = false;
		if (actualBool == expectedBool) {
			System.out.println("Test 13: onceInTop1000s() passed");
		} else {
			System.out.println("***** FAILED ***** Test 13: onceInTop1000s()");
		}

		actualBool = janaRecord.onceInTop1000s();
		expectedBool = true;
		if (actualBool == expectedBool) {
			System.out.println("Test 14: onceInTop1000s() passed");
		} else {
			System.out.println("***** FAILED ***** Test 14: onceInTop1000s()");
		}

		// morePopular tests
		actualBool = janaRecord.morePopular();
		expectedBool = false;
		if (actualBool == expectedBool) {
			System.out.println("Test 15: morePopular() passed");
		} else {
			System.out.println("***** FAILED ***** Test 15: morePopular()");
		}

		actualBool = jessicaRecord.morePopular();
		expectedBool = true;
		if (actualBool == expectedBool) {
			System.out.println("Test 16: morePopular() passed");
		} else {
			System.out.println("***** FAILED ***** Test 16: morePopular()");
		}

		// lessPopular tests
		actualBool = anushkaRecord.lessPopular();
		expectedBool = false;
		if (actualBool == expectedBool) {
			System.out.println("Test 17: lessPopular() passed");
		} else {
			System.out.println("***** FAILED ***** Test 17: lessPopular()");
		}

		actualBool = jakeRecord.lessPopular();
		expectedBool = true;
		if (actualBool == expectedBool) {
			System.out.println("Test 18: lessPopular() passed");
		} else {
			System.out.println("***** FAILED ***** Test 18: lessPopular()");
		}

		// toString tests
		actualVal = anushkaRecord.toString();
		expectedVal = "Anushka\n1900: 0\n1910: 987\n1920: 239\n1930: 0\n1940: "
				+ "293\n1950: 567\n1960: 0\n1970: 0\n1980: 0\n1990: " + "300\n2000: 232\n";
		if (actualVal.equals(expectedVal)) {
			System.out.println("Test 19: toString() passed");
		} else {
			System.out.println("***** FAILED ***** Test 19: toString()");
		}

		actualVal = jessicaRecord.toString();
		expectedVal = "Jessica\n1900: 0\n1910: 987\n1920: 878\n1930: 565\n1940: "
				+ "432\n1950: 431\n1960: 321\n1970: 212\n1980: 123\n1990: " + "107\n2000: 4\n";
		if (actualVal.equals(expectedVal)) {
			System.out.println("Test 20: toString() passed");
		} else {
			System.out.println("***** FAILED ***** Test 20: toString()");
		}

		// compareTo tests
		intActualVal = anushkaRecord.compareTo(jessicaRecord);
		if (intActualVal < 0) {
			System.out.println("Test 20: compareTo() passed");
		} else {
			System.out.println("***** FAILED ***** Test 19: compareTo()");
		}

		intActualVal = jakeRecord.compareTo(janaRecord);
		if (intActualVal < 0) {
			System.out.println("Test 20: compareTo() passed");
		} else {
			System.out.println("***** FAILED ***** Test 19: compareTo()");
		}

		// alternatingRanks test
		actualBool = anushkaRecord.alternatingRanks();
		expectedBool = false;
		if (actualBool == expectedBool) {
			System.out.println("Test 21: alternatingRanks() passed");
		} else {
			System.out.println("***** FAILED ***** Test 21: alternatingRanks()");
		}

		ArrayList<Integer> jessRank = new ArrayList<Integer>(
				Arrays.asList(0, 987, 999, 800, 970, 431, 654, 212, 500, 300, 400));
		NameRecord jessRecord = new NameRecord("Jess", baseDecade, jessRank);
		actualBool = jessRecord.alternatingRanks();
		expectedBool = true;
		if (actualBool == expectedBool) {
			System.out.println("Test 22: alternatingRanks() passed");
		} else {
			System.out.println("***** FAILED ***** Test 22: alternatingRanks()");
		}
	}

	// A few simple tests for the Names and NameRecord class.
	public static void simpleTest() {
		// raw data for Jake. Alter as necessary for your NameRecord
		String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
		int baseDecade = 1900;
		ArrayList<Integer> jakeRank = new ArrayList<Integer>(Arrays.asList(262, 312, 323, 479,
				484, 630, 751, 453, 225, 117, 97));
		NameRecord jakeRecord = new NameRecord("Jake", baseDecade, jakeRank);
		String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: "
				+ "484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: " + "117\n2000: 97\n";
		String actual = jakeRecord.toString();
		System.out.println("expected string:\n" + expected);
		System.out.println("actual string:\n" + actual);
		if (expected.equals(actual)) {
			System.out.println("passed Jake toString test.");
		} else {
			System.out.println("FAILED Jake toString test.");
		}

		// Some getName Tests
		Names names = new Names(getFileScannerForNames(NAME_FILE));
		String[] testNames = { "Isabelle", "isabelle", "sel", "X1178", "ZZ", "via", "kelly" };
		boolean[] expectNull = { false, false, true, true, true, true, false };
		for (int i = 0; i < testNames.length; i++) {
			performGetNameTest(names, testNames[i], expectNull[i]);
		}
	}

	// Checks if given name is present in Names.
	private static void performGetNameTest(Names names, String name, boolean expectNull) {
		System.out.println("Performing test for this name: " + name);
		if (expectNull) {
			System.out.println("Expected return value is null");
		} else {
			System.out.println("Expected return value is not null");
		}
		NameRecord result = names.getName(name);
		if ((expectNull && result == null) || (!expectNull && result != null)) {
			System.out.println("PASSED TEST.");
		} else {
			System.out.println("Failed test");
		}
	}

	// main method. Driver for the whole program
	public static void main(String[] args) {
		// Alter name of file to try different data sources.
		final String NAME_FILE = "names2.txt";
		Scanner fileScanner = getFileScannerForNames(NAME_FILE);
		Names namesDatabase = new Names(fileScanner);
		fileScanner.close();
		runOptions(namesDatabase);
	}

	/*
	 * pre: namesDatabase != null Ask user for options to perform on the given Names
	 * object. Creates a Scanner connected to System.in.
	 */
	private static void runOptions(Names namesDatabase) {
		Scanner keyboard = new Scanner(System.in);
		MenuChoices[] menuChoices = MenuChoices.values();
		MenuChoices menuChoice;
		do {
			showMenu();
			int userChoice = getChoice(keyboard) - 1;
			menuChoice = menuChoices[userChoice];
			if (menuChoice == MenuChoices.SEARCH) {
				search(namesDatabase, keyboard);
			} else if (menuChoice == MenuChoices.ONE_NAME) {
				oneName(namesDatabase, keyboard);
			} else if (menuChoice == MenuChoices.APPEAR_ONCE) {
				appearOnce(namesDatabase);
			} else if (menuChoice == MenuChoices.APPEAR_ALWAYS) {
				appearAlways(namesDatabase);
			} else if (menuChoice == MenuChoices.ALWAYS_MORE) {
				alwaysMore(namesDatabase);
			} else if (menuChoice == MenuChoices.ALWAYS_LESS) {
				alwaysLess(namesDatabase);
			} else if (menuChoice == MenuChoices.STUDENT_SEARCH) {
				alternatingRanksSearch(namesDatabase);
			}
		} while (menuChoice != MenuChoices.QUIT);
		keyboard.close();
	}

	/*
	 * Create a Scanner and return connected to a File with the given name. 
	 * pre: fileName != null 
	 * post: Return a Scanner connected to the file or null if the
	 * File does not exist in the current directory.
	 */
	private static Scanner getFileScannerForNames(String fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("\n***** ERROR IN READING FILE ***** ");
			System.out.println("Can't find this file " + fileName + " in the current directory.");
			System.out.println("Error: " + e);
			String currentDir = System.getProperty("user.dir");
			System.out.println("Be sure " + fileName + " is in this directory: ");
			System.out.println(currentDir);
			System.out.println("\nReturning null from method.");
			sc = null;
		}
		return sc;
	}

	/*
	 * Display the names that have appeared in ever decade. 
	 * pre: n != null 
	 * post: print out names that have appeared in ever decade
	 */
	private static void appearAlways(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
		}

		System.out.println(namesDatabase.rankedEveryDecade().size() + " names appear in every"
				+ " decade. The names are:");
		// print all names that appear in every decade
		for (int i = 0; i < namesDatabase.rankedEveryDecade().size(); i++) {
			System.out.println(namesDatabase.rankedEveryDecade().get(i));
		}
	}

	/*
	 * Display the names that have appeared in only one decade. 
	 * pre: n != null 
	 * post: print out names that have appeared in only one decade
	 */
	private static void appearOnce(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot"
					+ " be null");
		}

		System.out.println(namesDatabase.rankedOnlyOneDecade().size() + " names appear in "
				+ "exactly one decade. The names are:");
		// prints all names that are ranked in only one decade
		for (int i = 0; i < namesDatabase.rankedOnlyOneDecade().size(); i++) {
			System.out.println(namesDatabase.rankedOnlyOneDecade().get(i));
		}
	}

	/*
	 * Display the names that have gotten more popular in each successive decade.
	 * pre: n != null post: print out names that have gotten more popular in each
	 * decade
	 */
	private static void alwaysMore(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot be null");
		}

		System.out.println(namesDatabase.alwaysMorePopular().size() + " names are more popular"
				+ " in every decade.");
		// prints out the names that get more popular
		for (int i = 0; i < namesDatabase.alwaysMorePopular().size(); i++) {
			System.out.println(namesDatabase.alwaysMorePopular().get(i));
		}
	}

	/*
	 * Display the names that have gotten less popular in each successive decade.
	 * pre: n != null post: print out names that have gotten less popular in each
	 * decade
	 */
	private static void alwaysLess(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot"
					+ " be null");
		}

		System.out.println(namesDatabase.alwaysLessPopular().size() + " names are less"
				+ " popular in every decade.");
		// prints out the names that get less popular
		for (int i = 0; i < namesDatabase.alwaysLessPopular().size(); i++) {
			System.out.println(namesDatabase.alwaysLessPopular().get(i));
		}
	}

	/*
	 * Display the data for one name or state that name has never been ranked. pre:
	 * n != null, keyboard != null and is connected to System.in post: print out the
	 * data for n or a message that n has never been in the top 1000 for any decade
	 */
	private static void oneName(Names namesDatabase, Scanner keyboard) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (namesDatabase == null || keyboard == null) {
			throw new IllegalArgumentException("The parameters cannot be null");
		}

		System.out.print("Enter a name: ");
		String name = keyboard.nextLine();
		System.out.println(namesDatabase.getName(name).toString());
	}

	/*
	 * Display all names that contain a substring from the user and the decade they
	 * were most popular. pre: n != null, keyboard != null and is connected to
	 * System.in post: display the data for each name.
	 */
	private static void search(Names namesDatabase, Scanner keyboard) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (namesDatabase == null || keyboard == null) {
			throw new IllegalArgumentException("The parameters cannot be null");
		}
		
		System.out.print("Enter a partial name: ");
		String name = keyboard.nextLine();
		System.out.println("There are " + namesDatabase.getMatches(name).size() +
				" matches for " + name);
		System.out.println("The matches with their highest ranking decade are:");
		// prints out the names with the partial name and their highest decade
		for (int i = 0; i < namesDatabase.getMatches(name).size(); i++) {
			System.out.println(namesDatabase.getMatches(name).get(i).getName() + " "
					+ namesDatabase.getMatches(name).get(i).bestDecade());
		}
	}

	/*
	 * Return the names for all NameRecords that have alternating increasing/
	 * decreasing ranks pre: namesDatabase != null post: prints out a list of names
	 * for NameRecords that have alternating ranks
	 */
	private static void alternatingRanksSearch(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + 
					" namesDatabase cannot be null");
		}
		
		System.out.println(namesDatabase.getAlternatingRanks().size() + 
				" NameRecords have alternating ranks. The names are: ");
		// prints out each of the names that have alternating ranks
		for (int i = 0; i < namesDatabase.getAlternatingRanks().size(); i++) {
			System.out.println(namesDatabase.getAlternatingRanks().get(i));
		}
	}

	/*
	 * Get choice from the user keyboard != null and is connected to System.in
	 * return an int that is >= MenuChoices.SEARCH.ordinal() and <=
	 * MenuChoices.QUIT.ordinal().
	 */
	private static int getChoice(Scanner keyboard) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (keyboard == null) {
			throw new IllegalArgumentException("The parameter keyboard cannot be null");
		}
		
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		// Add one due to zero based indexing of enums, but 1 based indexing of menu.
		final int MAX_CHOICE = MenuChoices.QUIT.ordinal() + 1;
		while (choice < 1 || choice > MAX_CHOICE) {
			System.out.println();
			System.out.println(choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		
		return choice;
	}

	/*
	 * Ensure an int is entered from the keyboard. pre: s != null and is connected
	 * to System.in post: return the int typed in by the user.
	 */
	private static int getInt(Scanner s, String prompt) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (s == null) {
			throw new IllegalArgumentException("The parameter s cannot be null");
		}
		
		System.out.print(prompt);
		while (!s.hasNextInt()) {
			s.next();
			System.out.println("That was not an int.");
			System.out.print(prompt);
		}

		return s.nextInt();
	}

	// Show the user the menu.
	private static void showMenu() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("Enter 1 to search for names.");
		System.out.println("Enter 2 to display data for one name.");
		System.out.println("Enter 3 to display all names that appear in only " + "one decade.");
		System.out.println("Enter 4 to display all names that appear in all " + "decades.");
		System.out.println(
				"Enter 5 to display all names that are more popular " + "in every decade.");
		System.out.println(
				"Enter 6 to display all names that are less popular " + "in every decade.");
		System.out.println("Enter 7 to display all names that have the same average "
				+ "rank as a specific name.");
		System.out.println("Enter 8 to quit.");
		System.out.println();
	}

	/**
	 * An enumerated type to hold the menu choices for the NameSurfer program.
	 */
	private static enum MenuChoices {
		SEARCH, ONE_NAME, APPEAR_ONCE, APPEAR_ALWAYS, ALWAYS_MORE, ALWAYS_LESS, STUDENT_SEARCH,
		QUIT;
	}
}
