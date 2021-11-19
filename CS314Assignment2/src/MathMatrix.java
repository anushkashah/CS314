import java.util.Arrays;
//MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:

*
*  On my honor, Anushka Shah, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: aks4562
*  email address: anushkashah654@gmail.com
*  Unique section number: 52660
*  Number of slip days I am using: 0
*/

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {
    
    // instance variable
	private int[][] data;
	
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
    	if (mat == null || mat.length <= 0 || mat[0].length <= 0 || 
    			rectangularMatrix(mat) == false) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "MathMatrix. The parameter may not be null," +
                    " must have at least one row and at least" +
                    " one column, and be a rectangular matrix."); 
        }
    	
    	// initializing instance variable to mat
    	data = new int[mat.length][mat[0].length];
    	for (int i = 0; i < mat.length; i++) {
    		for (int j = 0; j < mat[0].length; j++) {
    			data[i][j] = mat[i][j];
    		}
    	}
    }

    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
    	if (numRows <= 0 || numCols <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "MathMatrix. The parameters numRows and numCols must have a"
                    + "value greater than 0."); 
        }
    	
    	// initializing instance variable with numRows and numCols 
    	data = new int[numRows][numCols];
    	// setting each value in data to initialVal
    	for (int i = 0; i < numRows; i++) {
    		for (int j = 0; j < numCols; j++) {
    			data[i][j] = initialVal;
    		}
    	}
    }

    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        int numRows = 0;
    	for (int i = 0; i < data.length; i++) {
    		numRows++;
    	}
    	
    	return numRows;
    }

    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns(){
        int numCols = 0;
        for (int i = 0; i < data[0].length; i++) {
    		numCols++;
    	}
    	
    	return numCols;
    }

    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
    	if (row < 0 || row >= getNumRows() || col < 0 || col >= getNumColumns()) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getVal. The parameter row must be greater than 0 but less than"
                    + "getNumRows() and the parameter col must be greater than 0 but"
                    + "less than getNumColumns."); 
        }

    	return data[row][col];
    }

    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide){
    	if (rightHandSide.getNumRows() != getNumRows() || 
    			rightHandSide.getNumColumns() != getNumColumns()) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "Add. The parameter must have the same number of rows and"
                    + "columns to this MathMatrix."); 
        }
    	
    	int[][] newData = new int[getNumRows()][getNumColumns()];
    	MathMatrix newMatrix = new MathMatrix(newData);
    	// set the values of newMatrix to the sum of this MathMatrix and rightHandSide
    	for (int i = 0; i < getNumRows(); i++) {
    		for (int j = 0; j < getNumColumns(); j++) {
    			newMatrix.data[i][j] = getVal(i, j) + rightHandSide.getVal(i, j);
    		}
    	}
    	
    	return newMatrix;
    }

    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide){
    	if (rightHandSide.getNumRows() != getNumRows() || 
    			rightHandSide.getNumColumns() != getNumColumns()) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "Subtract. The parameter must have the same number of rows and"
                    + "columns to this MathMatrix."); 
        }
    	
    	int[][] newData = new int[getNumRows()][getNumColumns()];
    	MathMatrix newMatrix = new MathMatrix(newData);
    	// set the values of newMatrix to the difference of this MathMatrix and rightHandSide
    	for (int i = 0; i < getNumRows(); i++) {
    		for (int j = 0; j < getNumColumns(); j++) {
    			newMatrix.data[i][j] = getVal(i, j) - rightHandSide.getVal(i, j);
    		}
    	}
    	
    	return newMatrix;
    }

    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide){
    	if (rightHandSide.getNumRows() != getNumColumns()) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "Multiply. The parameter must have the same number of rows"
                    + "as the columns of this MathMatrix."); 
        }
    	
    	// create new MathMatrix using the number of rows from this MathMatrix for rows
    	// and number of columns from rightHandSide for the columns
    	int[][] newData = new int[getNumRows()][rightHandSide.getNumColumns()];
    	MathMatrix newMatrix = new MathMatrix(newData);
    	for (int i = 0; i < getNumRows(); i++) {
    		for (int j = 0; j < rightHandSide.getNumColumns(); j++) {
    			// multiplies corresponding cells in the row of this MathMatrix and 
    			// column of rightHandSide; sums values in order to calculate the value
    			// at a specific cell of newMatrix
    			for (int k = 0; k < getNumColumns(); k++) {
    				newMatrix.data[i][j] += getVal(i, k) * rightHandSide.getVal(k, j);
    			}
    		}
    	}
    	
    	return newMatrix;
    } 

    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix 
     * multiplied by factor. 
     * In other words after this method has been called 
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
    	int[][] newData = new int[getNumRows()][getNumColumns()];
    	MathMatrix newMatrix = new MathMatrix(newData);
    	// multiplies each cell of the matrix by factor
    	for (int i = 0; i < getNumRows(); i++) {
    		for (int j = 0; j < getNumColumns(); j++) {
    			newMatrix.data[i][j] = getVal(i, j) * factor;
    		}
    	}
    	
    	return newMatrix;
    }

    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
    	int[][] newData = new int[getNumColumns()][getNumRows()];
    	MathMatrix newMatrix = new MathMatrix(newData);
    	// goes through entire MathMatrix to switch the row and columns of each value
    	for (int i = 0; i < getNumRows(); i++) {
    		for (int j = 0; j < getNumColumns(); j++) {
    			newMatrix.data[j][i] = getVal(i, j);
    		}
    	}
    	
    	return newMatrix;
    }

    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
        boolean result = true;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix) rightHandSide;
            
            if (otherMatrix.getNumRows() != getNumRows() || 
            		otherMatrix.getNumColumns() != getNumColumns()) {
            	result = false;
            } else {
            	// checks each value in otherMatrix with this Matrix to make sure 
            	// they are equal
            	for (int i = 0; i < getNumRows(); i++) {
                	for (int j = 0; j < getNumColumns(); j++) {
                		if (otherMatrix.getVal(i, j) != getVal(i, j)) {
                			result = false;
                			// return false;
                		}
                	}
                }
            } 
        }
        
        return result;
    }

    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {
    	int max = 0;
    	// find the number with the most digits
    	for (int i = 0; i < getNumRows(); i++) {
        	for (int j = 0; j < getNumColumns(); j++) {
        		if (("" + getVal(i, j)).length() > max) {
        			max = ("" + getVal(i, j)).length();
        		}
        	}
        }
    	// increase max by one to take account of the extra space for the number
    	// with the most digits
    	max++;
    	int tracker = 0;
    	StringBuilder str = new StringBuilder(1);
    	for (int i = 0; i < getNumRows(); i++) {
    		str.append("|");
    		for (int j = 0; j < getNumColumns(); j++) {
    			tracker = ("" + getVal(i, j)).length();
    			// find the specific number of spaces needed based on the number of digits
    			int spaces = max - tracker;
    			while (spaces > 0) {
    				str.append(" ");
    				spaces--;
    			}
    			str.append(getVal(i, j));
    		}
    		str.append("|\n");
    	}
    	String stringOfElements = str.toString();
    	return stringOfElements;
    }
    
    /*
     * pre: getNumRows() == getNumColumns()
     * post: returns if all values below the down diagonal are 0
     */
    private boolean downDiagonal() {
    	for (int i = getNumRows() - 1; i >= 0; i--) {
    		for (int j = i; j > 0; j--) {
    			// checks if any of the values under the diagonal are not 0
    			if(getVal(i, j - 1) != 0) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    /*
     * pre: getNumRows() == getNumColumns()
     * post: returns if all values below the up diagonal are 0
     */
    private boolean upDiagonal() {
    	for (int i = 1; i < getNumRows(); i++) {
    		for (int j = i; j < getNumColumns(); j++) {
    			// checks if any of the values under the diagonal are not 0
    			if (getVal(getNumRows() - 1, j) != 0) {
    				return false;
    			}
    		}
    	}

    	return true;
    }

    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular(){
        if (getNumRows() != getNumColumns()) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isUpperTriangular. The parameter must have the same number of rows"
                    + "and columns."); 
        }
    	
    	if (downDiagonal() == true || upDiagonal() == true) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // method to ensure mat is rectangular. It is public so that
    // tester classes can use it. 
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}
