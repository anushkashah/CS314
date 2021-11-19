/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
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

public class AnagramFinderTester {

    /**
     * main method that executes tests.
     * @param args Not used.
     */
    public static void main(String[] args) {
    	cs314StudentTestsForLetterInventory();
    }
    
    private static void cs314StudentTestsForLetterInventory() {
        // constructor tests 1-2
    	LetterInventory let1 = new LetterInventory("Anushka");
    	if (let1.toString().equals("aahknsu") && let1.size() == 7) {
        	System.out.println("Test 1: constructor passed");
        } else {
        	System.out.println("***** FAILED ***** Test 1: constructor");
        }
    	
    	LetterInventory let2 = new LetterInventory("@#!!@@Eight!!teen");
    	if (let2.toString().equals("eeeghintt") && let2.size() == 9) {
        	System.out.println("Test 2: constructor passed");
        } else {
        	System.out.println("***** FAILED ***** Test 2: constructor");
        }
    	
    	// get tests 3-4
    	int get = let1.get('a');
    	if (get == 2) {
        	System.out.println("Test 3: get passed");
        } else {
        	System.out.println("***** FAILED ***** Test 3: get");
        }
    	
    	get = let2.get('e');
    	if (get == 3) {
        	System.out.println("Test 4: get passed");
        } else {
        	System.out.println("***** FAILED ***** Test 4: get");
        }
    	
    	// size tests 5-6
    	int size = let1.size();
    	if (size == 7) {
        	System.out.println("Test 5: size passed");
        } else {
        	System.out.println("***** FAILED ***** Test 5: size");
        }
    	
    	size = let2.size();
    	if (size == 9) {
        	System.out.println("Test 6: size passed");
        } else {
        	System.out.println("***** FAILED ***** Test 6: size");
        }
    	
    	// isEmpty tests 7-8
    	if (!let1.isEmpty()) {
        	System.out.println("Test 7: isEmpty passed");
        } else {
        	System.out.println("***** FAILED ***** Test 7: isEmpty");
        }
    	
    	LetterInventory let3 = new LetterInventory("");
    	if (let3.isEmpty()) {
        	System.out.println("Test 8: isEmpty passed");
        } else {
        	System.out.println("***** FAILED ***** Test 8: isEmpty");
        }
    	
    	// toString tests 9-10
    	if (let1.toString().equals("aahknsu")) {
        	System.out.println("Test 9: toString passed");
        } else {
        	System.out.println("***** FAILED ***** Test 9: toString");
        }
    	
    	if (let2.toString().equals("eeeghintt")) {
        	System.out.println("Test 10: toString passed");
        } else {
        	System.out.println("***** FAILED ***** Test 10: toString");
        }
    	
    	// add tests 11-12
    	LetterInventory expectedAdd = new LetterInventory("aahknsueeeghintt");
    	LetterInventory actualAdd = let1.add(let2);
    	if (expectedAdd.equals(actualAdd)) {
        	System.out.println("Test 11: add passed");
        } else {
        	System.out.println("***** FAILED ***** Test 11: add");
        }
    	
    	LetterInventory expectedAdd2 = new LetterInventory("eeeghintt");
    	LetterInventory actualAdd2 = let2.add(let3);
    	if (expectedAdd2.equals(actualAdd2)) {
        	System.out.println("Test 12: add passed");
        } else {
        	System.out.println("***** FAILED ***** Test 12: add");
        }
    	
    	// subtract tests 13-14
    	LetterInventory let4 = new LetterInventory("abceeeeeghiiinttt");
    	LetterInventory expectedSub = new LetterInventory("abceeiit");
    	LetterInventory actualSub = let4.subtract(let2);
    	if (expectedSub.equals(actualSub)) {
        	System.out.println("Test 13: subtract passed");
        } else {
        	System.out.println("***** FAILED ***** Test 13: subtract");
        }
    	
    	LetterInventory let5 = new LetterInventory("aaabbbhknsuzz");
    	LetterInventory expectedSub2 = new LetterInventory("abbbzz");
    	LetterInventory actualSub2 = let5.subtract(let1);
    	if (expectedSub2.equals(actualSub2)) {
        	System.out.println("Test 14: subtract passed");
        } else {
        	System.out.println("***** FAILED ***** Test 14: subtract");
        }
    	
    	// equals tests 15-16
    	LetterInventory let6 = new LetterInventory("Anushka@@@$$#@");
    	if (let1.equals(let6)) {
        	System.out.println("Test 15: equals passed");
        } else {
        	System.out.println("***** FAILED ***** Test 15: equals");
        }
    	
    	if (!let1.equals(let2)) {
    		System.out.println("Test 16: equals passed");
        } else {
        	System.out.println("***** FAILED ***** Test 16: equals");
        }
    }
}
