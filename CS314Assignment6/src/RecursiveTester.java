/*  Student information for assignment:
 *
 *  On our honor, Anushka Shah and Jessica Ouyang, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used: 0
 *
 *  Student 1 (Student whose Canvas account is being used): Anushka Shah
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  Grader name: Grace
 *  Section number: 52660
 *
 *  Student 2: Jessica Ouyang
 *  UTEID: jjo889
 *  email address: jouyang99@gmail.com
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Tester class for the methods in Recursive.java
 * @author scottm
 *
 */
public class RecursiveTester {

    // run the tests
    public static void main(String[] args) {
        studentTests();
    }
    
    // pre: r != null
    // post: run student test
    private static void studentTests() {
        // CS314 students put your tests here
    	
    	// getBinary tests
    	String bin = Recursive.getBinary(284);
        if (bin.equals("100011100")) {
        	System.out.println("Test 1: getBinary passed");
        } else {
        	System.out.println("***** FAILED ***** Test 1: getBinary");
        }
        
        bin = Recursive.getBinary(89);
        if (bin.equals("1011001")) {
        	System.out.println("Test 2: getBinary passed");
        } else {
        	System.out.println("***** FAILED ***** Test 2: getBinary");
        }
        
        // revString tests
        String rev = Recursive.revString("AnushkaJessica");
        if (rev.equals("acisseJakhsunA")) {
        	System.out.println("Test 3: revString passed");
        } else {
        	System.out.println("***** FAILED ***** Test 3: revString");
        }
        
        rev = Recursive.revString("He llo Wor ld!");
        if (rev.equals("!dl roW oll eH")) {
        	System.out.println("Test 4: revString passed");
        } else {
        	System.out.println("***** FAILED ***** Test 4: revString");
        }
        
        // nextIsDouble tests
        int[] arr = {2, 4, 7, 14, 28, 29, 58, 100};
        int val = Recursive.nextIsDouble(arr);
        if (val == 4) {
        	System.out.println("Test 5: nextIsDouble passed");
        } else {
        	System.out.println("***** FAILED ***** Test 5: nextIsDouble");
        }
        
        arr = new int[] {1};
        val = Recursive.nextIsDouble(arr);
        if (val == 0) {
        	System.out.println("Test 6: nextIsDouble passed");
        } else {
        	System.out.println("***** FAILED ***** Test 6: nextIsDouble");
        }
        
        arr = new int[] {1, 3, 4, 9, 10, 32, 50, 75, 93};
        val = Recursive.nextIsDouble(arr);
        if (val == 0) {
        	System.out.println("Test 7: nextIsDouble passed");
        } else {
        	System.out.println("***** FAILED ***** Test 7: nextIsDouble");
        }
        
        // listMnemonics tests
        ArrayList<String> result = new ArrayList<String>();
        result = Recursive.listMnemonics("89");
        ArrayList<String> expectedResult = new ArrayList<String>(Arrays.asList("TW", "TX",
        		"TY", "TZ", "UW", "UX", "UY", "UZ", "VW", "VX", "VY", "VZ"));
        Collections.sort(result);
        Collections.sort(expectedResult);
        if (result.equals(expectedResult)) {
        	System.out.println("Test 8: listMnemonics passed");
        } else {
        	System.out.println("***** FAILED ***** Test 8: listMnemonics");
        }
        
        result = Recursive.listMnemonics("12");
        expectedResult = new ArrayList<String>(Arrays.asList("1A", "1B", "1C"));
        Collections.sort(result);
        Collections.sort(expectedResult);
        if (result.equals(expectedResult)) {
        	System.out.println("Test 9: listMnemonics passed");
        } else {
        	System.out.println("***** FAILED ***** Test 9: listMnemonics");
        }
    	
    	// canFlowOffMap tests
        int[][] map = {{5,5,5},
                       {5,5,5},
                       {5,5,5},
                       {5,4,5},
                       {5,3,5},
                       {5,2,5}}; 

        boolean flow = Recursive.canFlowOffMap(map, 3, 1);
        if (flow) {
        	System.out.println("Test 10: canFlowOffMap passed");
        } else {
        	System.out.println("***** FAILED ***** Test 10: canFlowOffMap");
        }
        flow = Recursive.canFlowOffMap(map, 1, 1);
        if (!flow) {
        	System.out.println("Test 11: canFlowOffMap passed");
        } else {
        	System.out.println("***** FAILED ***** Test 11: canFlowOffMap");
        }
        
        // minDifference tests
        int[] abs = {6, 3, 7, 4, -1, 0, 9};
        int numTeams = 2;
        int minDiff = Recursive.minDifference(numTeams, abs);
        if (minDiff == 0) {
        	System.out.println("Test 12: minDifference passed");
        } else {
        	System.out.println("***** FAILED ***** Test 12: minDifference");
        }
        numTeams = 4;
        minDiff = Recursive.minDifference(numTeams, abs);
        if (minDiff == 2) {
        	System.out.println("Test 13: minDifference passed");
        } else {
        	System.out.println("***** FAILED ***** Test 13: minDifference");
        }
        
        // canEscapeMaze tests
        char[][] maze = { {'S', 'E', '$'},
        				  {'E', 'G', 'G'} };
        int esc = Recursive.canEscapeMaze(maze);
        if (esc == 1) {
        	System.out.println("Test 14: canEscapeMaze passed");
        } else {
        	System.out.println("***** FAILED ***** Test 14: canEscapeMaze");
        }
        maze = new char[][] { {'S', 'G', '$'},
        					  {'E', 'G', 'G'} };
        esc = Recursive.canEscapeMaze(maze);
        if (esc == 2) {
        	System.out.println("Test 15: canEscapeMaze passed");
        } else {
        	System.out.println("***** FAILED ***** Test 15: canEscapeMaze");
        }
    }
}
