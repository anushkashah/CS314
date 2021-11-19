/*  Student information for assignment:
 *
 *  On our honor, Anushka Shah and Jessica Ouyang,
 *  this programming assignment is our own work
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

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Various recursive methods to be implemented.
 * Given shell file for CS314 assignment.
 */
public class Recursive {

	private final static int BINARY = 2;
	private final static int[][] DIRECTIONS = { { -1, 0 },
											    { 1, 0 },
											    { 0, -1 },
											    { 0, 1 } };
	private final static String VALID_CHARS = "SEG$Y*";
	private final static char START = 'S';
	private final static char EXIT = 'E';
	private final static char GREEN = 'G';
	private final static char MONEY = '$';
	private final static char YELLOW = 'Y';
	private final static char IMPASSABLE = '*';
	private final static int SQUARE_DIV = 3;
	private final static int COORDINATE = 2;
	
    /**
     * Problem 1: convert a base 10 int to binary recursively.
     *   <br>pre: n != Integer.MIN_VALUE<br>
     *   <br>post: Returns a String that represents N in binary.
     *   All chars in returned String are '1's or '0's.
     *   Most significant digit is at position 0
     *   @param n the base 10 int to convert to base 2
     *   @return a String that is a binary representation of the parameter n
     */
    public static String getBinary(int n) {
        if (n == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "getBinary. n cannot equal "
                    + "Integer.MIN_VALUE. n: " + n);
        }        
        int quotient = n / BINARY;
        int remainder = n % BINARY;
        // base case: quotient is zero, no more dividing
        if (quotient == 0) {
        	return String.valueOf(remainder);
        }
        // need absolute value for every value except first
        return getBinary(quotient) + String.valueOf(Math.abs(remainder));
    }

    /**
     * Problem 2: reverse a String recursively.<br>
     *   pre: stringToRev != null<br>
     *   post: returns a String that is the reverse of stringToRev
     *   @param stringToRev the String to reverse.
     *   @return a String with the characters in stringToRev
     *   in reverse order.
     */
    public static String revString(String stringToRev) {
        if (stringToRev == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }
        int length = stringToRev.length();
        // if there is only one character in stringToRev, return stringToRev
        if (length == 1) {
        	return stringToRev;
        }
        // letter is the last character in stringToRev
        String letter = stringToRev.substring(length - 1);
        // returns letter and makes recursive call without the last character of stringToRev
        return letter + revString(stringToRev.substring(0, length - 1));
    }

    /**
     * Problem 3: Returns the number of elements in data
     * that are followed directly by value that is
     * double that element.
     * pre: data != null
     * post: return the number of elements in data
     * that are followed immediately by double the value
     * @param data The array to search.
     * @return The number of elements in data that
     * are followed immediately by a value that is double the element.
     */
    public static int nextIsDouble(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }
        // returns method that counts the number of doubles
        return countDoubles(data, 0);
    }

    /**
     * Finds the number of elements in the array that are directly followed
     * by double their element
     * @param arr the array of elements
     * @param idx current position in the array
     * @return the number of elements in arr that are directly followed by double
     * their element
     */
    private static int countDoubles(int[] arr, int idx) {
    	// returns 0 if at the last element of arr
    	if (idx == arr.length - 1) {
    		return 0;
    	}
    	// checks if the value after the current value is double
    	if (arr[idx] * 2 == arr[idx + 1]) {
    		// increases what is returned by 1 and makes recursive call with new index
    		return 1 + countDoubles(arr, idx + 1);
    	}
    	// if not double, just make recursive call
    	return countDoubles(arr, idx + 1);
    }

    /**  Problem 4: Find all combinations of mnemonics
     * for the given number.<br>
     *   pre: number != null, number.length() > 0,
     *   all characters in number are digits<br>
     *   post: see tips section of assignment handout
     *   @param number The number to find mnemonics for
     *   @return An ArrayList<String> with all possible mnemonics
     *   for the given number
     */
    public static ArrayList<String> listMnemonics(String number) {
        if (number == null ||  number.length() == 0 || !allDigits(number)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "listMnemonics");
        }
        ArrayList<String> results = new ArrayList<>(); // to store the mnemonics
        recursiveMnemonics(results, "", number);
        return results;
    }

    /**
     * Helper method for listMnemonics
     * @param mnemonics stores completed mnemonics
     * @param mnemonicSoFar is a partial (possibly complete) mnemonic
     * @param digitsLeft are the digits that have not been used
     * from the original number
     */
    private static void recursiveMnemonics(ArrayList<String> mnemonics,
                    String mnemonicSoFar, String digitsLeft) {
    	// base case - if no digits left to add
    	if (digitsLeft.equals("")) {
    		mnemonics.add(mnemonicSoFar);
    	} else {
        	String digLet = digitLetters(digitsLeft.charAt(0));
        	String digsCopy = digitsLeft;
        	// add each letter associated with the current digit to the mnemonic
        	for (int i = 0; i < digLet.length(); i++) {
        		digitsLeft = digsCopy;
        		mnemonicSoFar = mnemonicSoFar + digLet.charAt(i);
        		digitsLeft = (digitsLeft.length() > 1) ? digitsLeft.substring(1) : "";
        		recursiveMnemonics(mnemonics, mnemonicSoFar, digitsLeft);
        		// reset mnemonicSoFar to original state
        		mnemonicSoFar = mnemonicSoFar.substring(0, mnemonicSoFar.length() - 1);
        	}
    	}
    }

    /* Static code blocks are run once when this class is loaded. 
     * Here we create an unmoddifiable list to use with the phone 
     * mnemonics method.
     */
    private static final List<String> LETTERS_FOR_NUMBER;
    static {
        String[] letters = {"0", "1", "ABC",
                "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        ArrayList<String> lettersAsList = new ArrayList<>();
        for (String s : letters) {
            lettersAsList.add(s);
        }
        LETTERS_FOR_NUMBER = Collections.unmodifiableList(lettersAsList);
    }

    /* helper method for recursiveMnemonics
     * pre: ch is a digit '0' through '9'
     * post: return the characters associated with
     * this digit on a phone keypad
     */
    private static String digitLetters(char ch) {
        if (ch < '0' || ch > '9') {
            throw new IllegalArgumentException("parameter "
                    + "ch must be a digit, 0 to 9. Given value = " + ch);
        }
        int index = ch - '0';
        return LETTERS_FOR_NUMBER.get(index);
    }

    /* helper method for listMnemonics
     * pre: s != null
     * post: return true if every character in s is
     * a digit ('0' through '9')
     */
    private static boolean allDigits(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "allDigits. String s cannot be null.");
        }
        boolean allDigits = true;
        int i = 0;
        while (i < s.length() && allDigits) {
            allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
            i++;
        }
        return allDigits;
    }

    /**
     * Problem 5: Draw a Sierpinski Carpet.
     * @param size the size in pixels of the window
     * @param limit the smallest size of a square in the carpet.
     */
    public static void drawCarpet(int size, int limit) {
        DrawingPanel p = new DrawingPanel(size, size);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.WHITE);
        drawSquares(g, size, limit, 0, 0);
    }

    /** Helper method for drawCarpet
     * Draw the individual squares of the carpet.
     * @param g The Graphics object to use to fill rectangles
     * @param size the size of the current square
     * @param limit the smallest allowable size of squares
     * @param x the x coordinate of the upper left corner of the current square
     * @param y the y coordinate of the upper left corner of the current square
     */
    private static void drawSquares(Graphics g, int size, int limit,
            double x, double y) {
    	if (g == null || size <= 0 || limit <= 0) {
    		throw new IllegalArgumentException("Failed precondition: "
                    + "drawSquares. g cannot be null, size cannot be less than"
                    + "or equal to 0, and limit cannot be less than or equal to 0.");
    	}
    	if (size >= limit) {
    		double newSize = (double) size / SQUARE_DIV;
    		double xPos = x;
    		double yPos = y;
    		// go through each square
    		for (int i = 0; i < SQUARE_DIV; i++) {
    			xPos = x + (newSize * i);
    			for (int j = 0; j < SQUARE_DIV; j++) {
    				yPos = y + (newSize * j);
    				// if in middle square, fill rectangle
    				if (i == 1 && j == 1) {
    					g.fillRect((int) xPos, (int) yPos, (int) newSize, (int) newSize);
    				} else {
    					drawSquares(g, (int) newSize, limit, xPos, yPos);
    				}
    			}
    		}
    	}
    }

    /**
     * Problem 6: Determine if water at a given point
     * on a map can flow off the map.
     * <br>pre: map != null, map.length > 0,
     * map is a rectangular matrix, 0 <= row < map.length,
     * 0 <= col < map[0].length
     * <br>post: return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map,
     * false otherwise.
     * @param map The elevations of a section of a map.
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     * @return return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map, false otherwise.
     */
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        if (map == null || map.length == 0 || !isRectangular(map)
                || !inbounds(row, col, map)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "canFlowOffMap");
        }
        // if the drop of water is at the edge of map, return true
        if (row == 0 || col == 0 || row == map.length - 1 || col == map[0].length - 1) {
        	return true;
        }
        int dirCount = DIRECTIONS.length;
        // check each direction for a valid move
        for (int i = 0; i < dirCount; i++) {
        	int[] direction = DIRECTIONS[i];
        	boolean valid = lowerElevation(map, row, col, direction);
        	if (valid) {
        		// is there a valid path from here - if yes, return right away
            	boolean canFlow = canFlowOffMap(map, row + direction[0], col + direction[1]);
            	if (canFlow) {
            		return true;
            	}
        	}
        }
        return false;
    }
    
    /**
     * Returns true if moving the new position in map is at a lower elevation
     * than the old position, false if otherwise
     * @param map The elevations of a section of a map. 
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     * @param dir The direction the drop of water is moving.
     * @return true of the drop of water can move to the new position
     */
    private static boolean lowerElevation(int[][] map, int row, int col, int[] dir) {
    	int xChange = dir[0];
    	int yChange = dir[1];
    	// returns if the value at new position is smaller than value at the old position
    	if (map[row + xChange][col + yChange] < map[row][col]) {
    		return true;
    	}
    	return false;
    }

    /* helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null,
     */
    private static boolean inbounds(int r, int c, int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null.");
        }
        return r >= 0 && r < mat.length && mat[r] != null
                && c >= 0 && c < mat[r].length;
    }

    /*
     * helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null "
                    + "and must have at least 1 row.");
        }
        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }

    /**
     * Problem 7: Find the minimum difference possible between teams
     * based on ability scores. The number of teams may be greater than 2.
     * The goal is to minimize the difference between the team with the
     * maximum total ability and the team with the minimum total ability.
     * <br> pre: numTeams >= 2, abilities != null, abilities.length >= numTeams
     * <br> post: return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability.
     * @param numTeams the number of teams to form.
     * Every team must have at least one member
     * @param abilities the ability scores of the people to distribute
     * @return return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability. The return value will be greater than or equal to 0.
     */
    public static int minDifference(int numTeams, int[] abilities) {
        if (numTeams < 2 || abilities == null || abilities.length < numTeams) {
        	throw new IllegalArgumentException("Failed precondition: "
                    + "minDifference. numTeams must be greater than or equal to 2, "
                    + "abilities cannot be null, and the length of abilities cannot be"
                    + "less than numTeams.");
        }
    	ArrayList<Integer> abilitiesLeft = new ArrayList<>();
    	// create deep copy of abilities into an ArrayList
    	for (int i = 0; i < abilities.length; i++) {
    		abilitiesLeft.add(abilities[i]);
    	}
    	int[] teamScores = new int[numTeams];
    	boolean[] hasMember = new boolean[numTeams];
    	return findDifference(abilitiesLeft, teamScores, hasMember);
    }
    
    /**
     * Finds the minimum possible difference of teams with the greatest and least abilities
     * @param abilitiesLeft an ArrayList of integers representing the abilities of
     * members who still need to be placed onto a team
     * @param teamScores an array of integers representing the current ability of each team
     * @param hasMember an array of booleans representing whether or not each team 
     * currently has at least one member
     * @return the minimum possible difference in ability between the teams with the greatest
     * and least abilities
     */
    private static int findDifference(ArrayList<Integer> abilitiesLeft, int[] teamScores, 
    		boolean[] hasMember) {
    	// base case - no abilities left to check and every team has a member
    	if (abilitiesLeft.size() == 0) {
    		if (checkMembers(hasMember)) {
        		// find min and max team scores, return difference
        		int maxScore = Integer.MIN_VALUE;
        		int minScore = Integer.MAX_VALUE;
        		for (int i = 0; i < teamScores.length; i++) {
        			maxScore = (teamScores[i] > maxScore) ? teamScores[i] : maxScore;
        			minScore = (teamScores[i] < minScore) ? teamScores[i] : minScore;
        		}
        		return maxScore - minScore;
    		} else {
    			return Integer.MAX_VALUE;
    		}
    	}
    	// set the min difference to the max value possible
    	int minDiff = Integer.MAX_VALUE;
    	// current ability is the last element in abilities left
    	int currentAbility = abilitiesLeft.get(abilitiesLeft.size() - 1);
    	for (int i = 0; i < teamScores.length; i++) {
    		teamScores[i] += currentAbility;
    		boolean oldBoolean = hasMember[i];
    		hasMember[i] = true;
    		abilitiesLeft.remove(abilitiesLeft.size() - 1);
    		int val = findDifference(abilitiesLeft, teamScores, hasMember);
    		minDiff = (val < minDiff) ? val : minDiff;
    		// reset the state of the teams
    		hasMember[i] = oldBoolean;
    		teamScores[i] -= currentAbility;
    		abilitiesLeft.add(currentAbility);
    	}
    	return minDiff;
    }
    /**
     * Checks if any member in the ArrayList is false
     * @param hasMember ArrayList of booleans that represent if each team 
     * has at least one member
     * @return returns true if all values in hasMember is true, false otherwise
     */
    private static boolean checkMembers(boolean[] hasMember) {
    	for (int i = 0; i < hasMember.length; i++) {
    		if (!hasMember[i]) {
    			return false;
    		}
    	}
    	return true;
    }

    /**
     * Problem 8: Maze solver.
     * <br>pre: board != null
     * <br>pre: board is a rectangular matrix
     * <br>pre: board only contains characters 'S', 'E', '$', 'G', 'Y', and '*'
     * <br>pre: there is a single 'S' character present
     * <br>post: rawMaze is not altered as a result of this method.
     * Return 2 if it is possible to escape the maze after
     * collecting all the coins.
     * Return 1 if it is possible to escape the maze
     * but without collecting all the coins.
     * Return 0 if it is not possible
     * to escape the maze. More details in the assignment handout.
     * @param rawMaze represents the maze we want to escape.
     * rawMaze is not altered as a result of this method.
     * @return per the post condition
     */
    public static int canEscapeMaze(char[][] rawMaze) {
        if (rawMaze == null || !isRect(rawMaze) || !correctChars(rawMaze) || 
        		countChar(rawMaze, START) != 1) {
        	throw new IllegalArgumentException("Failed precondition: "
                    + "canEscapeMaze. rawMaze may not be null, must be rectangular, "
                    + "must only contain valid chars and have only one S.");
        }
        // count the number of money characters in rawMaze
    	int moneyCount = countChar(rawMaze, MONEY);
    	// find the starting position in the maze
        int x = findPos(rawMaze, START)[0];
        int y = findPos(rawMaze, START)[1];
        char[][] maze = getCopy(rawMaze);
        // returns the best possible way to escape the maze
        return escapeMaze(maze, x, y, moneyCount);
    }
    
    /**
     * Finds the best possible escape situation from the maze
     * @param maze a 2D array of chars representing the maze to escape
     * @param x the starting x position
     * @param y the starting y position
     * @param moneyCount the amount of money left in the maze to be collected
     * @return 2 if it is possible to escape the maze with all money, 1 if it is possible
     * to escape but not collect all money, or 0 if an escape is not possible
     */
    private static int escapeMaze(char[][] maze, int x, int y, int moneyCount) {
    	int bestEscape = 0;
    	// base case when reaching an exit cell
    	if (maze[x][y] == EXIT) {
    		return (moneyCount == 0) ? 2 : 1;
    	}
    	int dirCount = DIRECTIONS.length;
    	// check every possible direction to move
    	for (int i = 0; i < dirCount; i++) {
    		int[] direction = DIRECTIONS[i];
    		// only continue if the move is in a valid direction
    		if (validDir(maze, x, y, direction)) {
    			// store the state of the maze before making the move
        		int oldX = x;
        		int oldY = y;
        		int oldMoneyCount = moneyCount;
        		char oldChar = maze[x][y];
        		// if we are currently in a cell with money, we have collected it
        		if (maze[x][y] == MONEY) {
        			moneyCount--;
        		}
        		// change board and move x and y before making recursive call
        		makeMove(maze, x, y);
        		x += direction[0];
        		y += direction[1];
        		int val = escapeMaze(maze, x, y, moneyCount);
        		// if the escape from this route is better, update best escape
        		bestEscape = (val > bestEscape) ? val : bestEscape;
        		// revert back to original state of the maze
        		x = oldX;
        		y = oldY;
        		moneyCount = oldMoneyCount;
        		maze[x][y] = oldChar;
    		}
    	}
    	return bestEscape;
    }
    
    /**
     * Creates a deep copy of the given 2D array of chars
     * @param mat the 2D array to make a copy of
     * @return a deep copy of the given 2D array of chars
     */
    private static char[][] getCopy(char[][] mat) {
    	// create a new maze with the dimensions of mat
    	char[][] maze = new char[mat.length][mat[0].length];
    	for (int i = 0; i < mat.length; i++) {
    		for (int j = 0; j < mat[0].length; j++) {
    			// copy each element from mat into maze
    			maze[i][j] = mat[i][j];
    		}
    	}
    	return maze;
    }  
    
    /**
     * Checks if a move in the given direction on the maze is a valid move
     * @param maze the 2D array representing the current maze
     * @param x the current x position 
     * @param y the current y position
     * @param dir an array of ints that represents the direction to check
     * @return true if a move in the direction is valid, false otherwise
     */
    private static boolean validDir(char[][] maze, int x, int y, int[] dir) {
    	// new x and y coordinates based on direction
    	int newX = x + dir[0];
    	int newY = y + dir[1];
    	if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) {
    		return false;
    	} else if (maze[newX][newY] == IMPASSABLE) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * Changes the maze at the given position when a move is made - 
     * green and money squares become yellow,
     * yellow squares become impassable, and start becomes green
     * @param maze the 2D array representing the current maze
     * @param x the x position of the element to change
     * @param y the y position of the element to change
     */
    private static void makeMove(char[][] maze, int x, int y) {
    	char current = maze[x][y];
    	if (current == GREEN) {
    		maze[x][y] = YELLOW;
    	} else if (current == YELLOW) {
    		maze[x][y] = IMPASSABLE;
    	} else if (current == START) {
    		maze[x][y] = GREEN;
    	} else if (current == MONEY) {
    		maze[x][y] = YELLOW;
    	}
    }
    
    /**
     * Checks to make sure that the 2D array is rectangular
     * pre: mat != null, mat.length > 0
     * @param mat the 2D array to check
     * @return true if mat is rectangular, false otherwise
     */
    private static boolean isRect(char[][] mat) {
        if (mat == null || mat.length <= 0) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null "
                    + "and must have at least 1 row.");
        }
        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }
    
    /**
     * Checks to make sure that the 2D array of chars only contains valid chars: S, E, G, Y, $, *
     * @param mat the 2D array to check
     * @return true if the array only contains valid chars, false otherwise
     */
    private static boolean correctChars(char[][] mat) {
    	for (int i = 0; i < mat.length; i++) {
    		for (int j = 0; j < mat[0].length; j++) {
    			// returns false if the value is not a valid char
    			if (!VALID_CHARS.contains(mat[i][j] + "")) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * Counts the number of times a given char appears in the 2D array
     * @param mat the 2D array to check
     * @param var the char to count
     * @return the number of times the char appears in the 2D array
     */
    private static int countChar(char[][] mat, char var) {
    	int count = 0;
    	// iterates through 2d array
    	for (int i = 0; i < mat.length; i++) {
    		for (int j = 0; j < mat[0].length; j++) {
    			// checks if value at a certain position equals the given char
    			if (mat[i][j] == var) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
    
    /**
     * Finds the position of the given char in the 2D array
     * @param mat the 2D array to check
     * @param var the char to find the position of in the 2D array
     * @return an int array of length 2, where the first element is the row
     * and the second element is the column where the char is located.
     */
    private static int[] findPos(char[][] mat, char var) {
    	int[] coordinates = new int[COORDINATE];
    	// iterates through 2d array
    	for (int i = 0; i < mat.length; i++) {
    		for (int j = 0; j < mat[0].length; j++) {
    			if (mat[i][j] == var) {
    				// sets the x and y values of the position of char in the array
    				coordinates[0] = i;
    				coordinates[1] = j;
    			}
    		}
    	}
    	return coordinates;
    }  
}