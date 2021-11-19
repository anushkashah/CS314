//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 * 
 *  replace <NAME> with your name.
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

import java.lang.reflect.Array;
import java.util.Random;

public class CodeCamp {

    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aData</tt> or
     * <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null, aData.length == aData.length
     * @param bData != null
     * @return the Hamming Distance between the two arrays of ints.
     */    
    public static int hammingDistance(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null || aData.length != bData.length) { 
            throw new IllegalArgumentException("Violation of precondition: " +
                    "hammingDistance. neither parameter may equal null, arrays" +
                    " must be equal length.");
        }
        
        int hammingDis = 0;
        for (int i = 0; i < aData.length; i++) {
        	if (aData[i] != bData[i]) {
        		hammingDis++;
        	}
        }
        
        return hammingDis;
    }
    
    /* 
     * creates a copy of an array
     * pre: copyArr != null, original != null
     * post: returns copyArr
     */
    private static int[] copyArray(int[] originalArr, int[] copyArr) {
    	for (int i = 0; i < originalArr.length; i++) {
    		copyArr[i] = originalArr[i];
    	}
    	
    	return copyArr;
    }
    
    /* 
     * selection sorts an array
     * pre: array != null
     * post: returns sorted array
     */
    private static int[] sortArray(int[] array) {
    	for (int i = 0; i < array.length - 1; i++) {
        	int min = i;
        	for (int j = i + 1; j < array.length; j++) {
        		if (array[j] < array[min]) {
        			min = j;
        		}	
        	}
        	int tempVal = array[min];
        	array[min] = array[i];
        	array[i] = tempVal;	
        }
    	
    	return array;	
    }
    

    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>aData</tt> or 
     * the parameter <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null
     * @param bData != null
     * @return <tt>true</tt> if aData is a permutation of bData, 
     * <tt>false</tt> otherwise
     * 
     */
    public static boolean isPermutation(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isPermutation. neither parameter may equal null.");
        }

        if (aData.length != bData.length) {
        	return false;
        }
        
        int[] aDataCopy = new int[aData.length];
        int[] bDataCopy = new int[bData.length];
        
        copyArray(aData, aDataCopy);
        copyArray(bData, bDataCopy);
        
        sortArray(aDataCopy);
        sortArray(bDataCopy);
        
        for (int i = 0; i < aData.length; i++) {
        	if (aDataCopy[i] != bDataCopy[i]) {
        		return false;
        	}
        }
        
        return true;
    }

    /**
     * Determine the index of the String that 
     * has the largest number of vowels. 
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
     * 'U', and 'u'</tt>.
     * The parameter <tt>arrayOfStrings</tt> is not altered as a result of this method.
     * <p>pre: <tt>arrayOfStrings != null</tt>, <tt>arrayOfStrings.length > 0</tt>, 
     * there is an least 1 non null element in arrayOfStrings.
     * <p>post: return the index of the non-null element in arrayOfStrings that has the 
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero. 
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param arrayOfStrings the array to check
     * @return the index of the non-null element in arrayOfStrings that has 
     * the largest number of vowels.
     */
    public static int mostVowels(String[] arrayOfStrings) {
        // check preconditions
        if (arrayOfStrings == null || arrayOfStrings.length == 0 || 
        		!atLeastOneNonNull(arrayOfStrings)) { 
            throw new IllegalArgumentException("Violation of precondition: " +
                    "mostVowels. parameter may not equal null and must contain " +
                    "at least one none null value.");
        }
        
        int count = 0;
        int[] numberOfVowels = new int[arrayOfStrings.length];
        String vowels = "AaEeIiOoUu";
        
        for (int i = 0; i < arrayOfStrings.length; i++) {
        	if (arrayOfStrings[i] == null) {
        		numberOfVowels[i] = -1;
        	} else {
        		for (int j = 0; j < arrayOfStrings[i].length(); j++) {
        			if (vowels.contains(arrayOfStrings[i].charAt(j) + "") == true) {
        				count++;
        			}
        		}
        		numberOfVowels[i] = count;
        		count = 0;
        	}
        }
        
        int indexOfMaxVowels = 0;
        for (int i = 0; i < numberOfVowels.length; i++) {
        	if (numberOfVowels[i] > numberOfVowels[indexOfMaxVowels]) {
        		indexOfMaxVowels = i;
        	}
        }
        
        return indexOfMaxVowels;
    }

    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people. 
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday 
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople + 
                    ", numDaysInYear: " + numDaysInYear);
        }

        int[] arrayOfBirthdays = new int[numPeople];
        for (int i = 0; i < numPeople; i++) {
        	arrayOfBirthdays[i] = (int) (Math.random() * numDaysInYear);	
        }
        
        int count = 0;
        int[] numberOfSharedBirthdays = new int[numPeople];
        for (int i = 0; i < arrayOfBirthdays.length; i++) {
        	for (int j = i + 1; j < arrayOfBirthdays.length; j++) {
        		if (arrayOfBirthdays[i] == arrayOfBirthdays[j]) {
        			count++;
        		}
        	}
        	numberOfSharedBirthdays[i] = count;
        	count = 0;
        }
        
        int sum = 0;
        for (int i = 0; i < numberOfSharedBirthdays.length; i++) {
        	sum += numberOfSharedBirthdays[i];
        }
        
        return sum;
    }
    
    /* given a row and column in the board, find if there are any other queens on the diagonal
     * pre: row and col are within the bounds of board
     * post: returns if there is no other queen on diagonal
     */
    private static boolean diagonalsAreSafe(char[][] board, int row, int col) {
    	// checking bottom diagonals is redundant because queen will already be found
    	for (int i = 1; (i <= row) && (i <= col); i++) {
    		if (board[row - i][col - i] == 'q') {
				return false;
			}
    	}
    	
    	for (int i = 1; (i <= row) && (i < board.length - col); i++) {
    		if (board[row - i][col + i] == 'q') {
				return false;
			}
    	}
    	
    	return true;
    }
    
    /* 
     * given a row and column in the board, checks that there are no
     * other queens on the row
     * pre: row and col are within the bounds of board 
     * post: returns if there is no other queen in the row
     */
    private static boolean rowAreSafe(char[][] board, int row, int col) {
    	// checking rows below are redundant because queen will already be found 
    	for (int i = 0; i < board.length; i++) {
    		if (i < row) {
    			if (board[i][col] == 'q') {
    				return false;
    			}
    		}
    	}

    	return true;
    }
    
    /* 
     * given a row and column in the board, checks that there are no
     * other queens in the column
     * pre: row and col are within the bounds of board 
     * post: returns if there is no other queen in the column  
     */
    private static boolean colAreSafe(char[][] board, int row, int col) {
    	// checking columns to the right is redundant because queen will already be found
    	for (int i = 0; i < board.length; i++) {
    		if (i < col) {
    			if (board[row][i] == 'q') {
    				return false;
    			}
    		}
    	}

    	return true;
    }

    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of 
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board) 
                || !onlyContains(board, validChars)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "queensAreSafe. The board may not be null, must be square, " +
                    "and may only contain 'q's and '.'s");        
        }
        
        // iterates through board to make sure each queen is safe
        for (int row = 0; row < board.length; row++) {
        	for (int col = 0; col < board.length; col++) {
        		if (board[row][col] == 'q') {
        			if (diagonalsAreSafe(board, row, col) != true || 
        				rowAreSafe(board, row, col) != true || 
        				colAreSafe(board, row, col) != true) {
        				return false;
        			}
        		}
        	}
        }

        return true; 
    }
    
    /* 
     * finds the sum of a specific plot given the coordinates of the 
     * upper left corner and lower right corner
     * pre: leftRow, leftCol, rightRow, rightCol are within the bounds of city 
     * post: returns the sum of plot
     */
    private static int getSum(int[][] city, int leftRow, int leftCol, 
    						  int rightRow, int rightCol) {
    	int sum = 0;
    	for (int i = leftRow; i <= rightRow; i++) {
    		for (int j = leftCol; j <= rightCol; j++) {
    			sum += city[i][j];
    		}
    	}
    	
    	return sum;
    }
    
    /* 
     * finds all the possible lower right corners for a specific upper left corner
     * and determines the maximum plot value with that upper left corner
     * pre: leftRow and leftCol are within bounds of city
     * post: returns maxSoFar 
     */
    private static int getLowerRightCornerMax(int[][] city, int leftRow, int leftCol) {
    	int maxSoFar = city[leftRow][leftCol];
    	for (int i = leftRow; i < city.length; i++) {
    		for (int j = leftCol; j < city[0].length; j++) {
    			if (getSum(city, leftRow, leftCol, i, j) > maxSoFar) {
    				maxSoFar = getSum(city, leftRow, leftCol, i, j);
    			}
    		}
    	}
    	
    	return maxSoFar;
    }

    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1. 
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0 
                || !isRectangular(city) ) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getValueOfMostValuablePlot. The parameter may not be null," +
                    " must value at least one row and at least" +
                    " one column, and must be rectangular."); 
        }
        
        int max = city[0][0];
        for (int i = 0; i < city.length; i++) {
        	for (int j = 0; j < city[0].length; j++) {
        		if (getLowerRightCornerMax(city, i, j) > max) {
        			max = getLowerRightCornerMax(city, i, j);
        		}
        	}
        }
        
        return max; 
    }

    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiment code here:
    
    /* 
     * prints the average number of pairs of people with shared birthdays given the
     * number of experiments, number of days, and number of people
     * pre: none
     * post: prints average number of pairs of people with shared birthdays 
     */
    public static void sharedBirthdayExperimentAverage(int experiments, int days, int people) {
    	int count = 0;
    	for (int i = 0; i < experiments; i++) {
    		count += sharedBirthdays(people, days);
    	}
    	
    	double average = count / experiments;
    	System.out.println("Average number of pairs of people with shared birthdays: " 
    					   + average);
    }
    
    /* 
     * prints the percent chance for there to be at least one shared birthday for 
     * 2 to 100 people given the number of experiments and days
     * pre: none
     * post: prints percent chance of at least one shared birthday
     */
    public static void sharedBirthdayExperimentPercent(int experiments, int days) {
    	for (int i = 2; i <= 100; i++) {
    		int count = 0;
    		for (int j = 0; j < experiments; j++) {
    			if (sharedBirthdays(i, days) >= 1) {
    				count++;
    			}
    		}
    		double percentage = ((double) count / experiments) * 100;
    		
    		System.out.print("Num people: " + i + ", number of experiments with one or more"
    							+ " shared birthday: " + count);
    		System.out.printf(", percentage: %.2f\n", percentage);
    		count = 0;
    	}	
    }
    

    /* 
     * pre: arrayOfStrings != null
     * post: return true if at least one element in arrayOfStrings is 
     * not null, otherwise return false. 
     */
    private static boolean atLeastOneNonNull(String[] arrayOfStrings) {
        // check precondition
        if (arrayOfStrings == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "atLeastOneNonNull. parameter may not equal null.");
        }
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < arrayOfStrings.length ) {
            foundNonNull = arrayOfStrings[i] != null;
            i++;
        }
        return foundNonNull;
    }


    /* 
     * pre: mat != null
     * post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isSquare. Parameter may not be null.");
        }
        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while (isSquare && row < numRows) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }


    /* 
     * pre: mat != null, valid != null
     * post: return true if all elements in mat are one of the 
     * characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if (mat == null || valid == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "onlyContains. Parameters may not be null.");
        }
        String validChars = new String(valid);
        int row = 0;
        boolean onlyContainsValidChars = true;
        while (onlyContainsValidChars && row < mat.length) {
            int col = 0;
            while(onlyContainsValidChars && col < mat[row].length) {
                int indexOfChar = validChars.indexOf(mat[row][col]);
                onlyContainsValidChars = indexOfChar != -1;
                col++;
            }
            row++;
        }
        return onlyContainsValidChars;
    }


    /*
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isRectangular. Parameter may not be null and must contain" +
                    " at least one row.");
        }
        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null) 
                    && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }

    // make constructor private so no instances of CodeCamp can not be created
    private CodeCamp() {

    }
}