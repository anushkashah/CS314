import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  Grader name: Grace
 *  Number of slip days I am using: 0
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 * 
 * Time Elapsed for Add Method at 1N: 1.2926540660000005 seconds
 * Time Elapsed for Add Method at 2N: 4.217128806 seconds
 * Time Elapsed for Add Method at 4N: 15.618015100999987 seconds
 * Time Elapsed for Multiply Method at 1N: 1.363411472 seconds
 * Time Elapsed for Multiply Method at 2N: 10.183369366 seconds
 * Time Elapsed for Multiply Method at 4N: 81.784057252 seconds
 * 
 * 1. Based on the results of experiment 1, I expect the add method to take about 64 seconds 
 * if I doubled the dimension size of the MathMatrix objects again.
 * 2. The Big O of the add operation is N^2. The timing data supports this because every time
 * the dimensions of the MathMatrix objects were doubled, the timing increased by a factor of 
 * about 4. My N value was 1.2926540660000005 seconds and 2N was 4.217128806 seconds. This is 
 * approximately an increase by a factor of 4, indicating that the add method is N^2.
 * 3. Based on the results of experiment 2, I expect the multiply method to take about 648
 * seconds if I doubled the dimension size of the MathMatrix objects again.
 * 4. The Big O of the multiply operation is N^3. The timing data supports this because every
 * time the dimensions of the MathMatrix objects were doubled, the timing increased by a
 * factor of 8. My N was 1.363411472 seconds and 2N was 10.183369366 seconds. This is about an
 * increase by a factor of 8, indicating that the multiply method is N^3.
 * 5. I can create a matrix of 30,000x30,000 before my computer crashes. The amount of amount of
 * memory my program is allocated is around 3600 megabytes. The percentage of my computer's
 * RAM my computer used before crashing was 22.5% ((3600 megabytes/16000 megabytes) * 100).
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
    	// MathMatrix maxMat = new MathMatrix(30000, 30000, 5);
    	
        // test 1: getNumRows() 
        int[][] data1 = { {120, 340, 650, 123, 543, 980},
      		  			  {332, 550, 219, 332, 650, 730},
      		  			  {132, 454, 346, 453, 233, 122} };
        MathMatrix mat1 = new MathMatrix(data1);
        int actualVal = mat1.getNumRows();
        int expectedVal = 3;
        if (actualVal == expectedVal) {
        	System.out.println("Test 1: getNumRows() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 1: getNumRows()");
        }
        
        // test 2: getNumRows() 
        int[][] data2 = { {5, 4, 3, 2, 6, 7, 6, 4, 3, 2, 1},
        				  {7, 8, 2, 1, 7, 1, 2, 3, 4, 5, 6},
        				  {6, 7, 3, 2, 1, 7, 8, 3, 4, 6, 7},
        				  {2, 4, 6, 5, 4, 1, 2, 3, 4, 6, 8},
        				  {5, 4, 7, 8, 9, 8, 7, 6, 5, 4, 3}, 
        				  {3, 2, 5, 6, 1, 1, 3, 5, 7, 8, 5} };
        MathMatrix mat2 = new MathMatrix(data2);
        actualVal = mat2.getNumRows();
        expectedVal = 6;
        if (actualVal == expectedVal) {
        	System.out.println("Test 2: getNumRows() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 2: getNumRows()");
        }
        
        // test 3: getNumColumns()
        actualVal = mat1.getNumColumns();
        expectedVal = 6;
        if (actualVal == expectedVal) {
        	System.out.println("Test 3: getNumColumns() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 3: getNumColumns()");
        }
        
        // test 4: getNumColumns()
        actualVal = mat2.getNumColumns();
        expectedVal = 11;
        if (actualVal == expectedVal) {
        	System.out.println("Test 4: getNumColumns() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 4: getNumColumns()");
        }
        
        // test 5: getVal()
        actualVal = mat1.getVal(1, 3);
        expectedVal = 332;
        if (actualVal == expectedVal) {
        	System.out.println("Test 5: getVal() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 4: getVal()");
        }
        
        // test 6: getVal()
        actualVal = mat2.getVal(4, 5);
        expectedVal = 8;
        if (actualVal == expectedVal) {
        	System.out.println("Test 6: getVal() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 6: getVal()");
        }
        
        // test 7: add()
        int[][] data3 = { {20, 22, 45, 32, 65, 32},
                		  {12, 45, 32, 56, 78, 90},
                		  {34, 65, 43, 55, 87, 91} };
        int[][] sum = { {140, 362, 695, 155, 608, 1012},
        				{344, 595, 251, 388, 728, 820},
        				{166, 519, 389, 508, 320, 213} };
        MathMatrix mat3 = new MathMatrix(data3);
        MathMatrix sumMat = mat1.add(mat3);
        if (equals(get2DArray(sumMat), sum) == true) {
        	System.out.println("Test 7: add() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 7: add()");
        }
        
        // test 8: add()
        int[][] data4 = { {5, 4, 3, 2, 6}, 
				  		  {7, 8, 2, 1, 7}, 
				  		  {6, 7, 3, 2, 1}, 
				  		  {2, 4, 6, 5, 4}, 
				  		  {5, 4, 7, 8, 9},  
				  		  {3, 2, 5, 6, 1} };
        int[][] data5 = { {7, 6, 4, 3, 2},
        				  {1, 2, 3, 4, 5},
        				  {7, 8, 3, 4, 6},
        				  {1, 2, 3, 4, 6},
        				  {8, 7, 6, 5, 4},
        				  {1, 3, 5, 7, 8} };
        sum = new int[][] { {12, 10, 7, 5, 8},
        					{8, 10, 5, 5, 12},
        					{13, 15, 6, 6, 7},
        					{3, 6, 9, 9, 10},
        					{13, 11, 13, 13, 13},
        					{4, 5, 10, 13, 9} };
        MathMatrix mat4 = new MathMatrix(data4);
        MathMatrix mat5 = new MathMatrix(data5);
        sumMat = mat4.add(mat5);
        if (equals(get2DArray(sumMat), sum) == true) {
        	System.out.println("Test 8: add() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 8: add()");
        }
        
        // test 9: subtract
        int[][] diff = { {-2, -2, -1, -1, 4},
        				 {6, 6, -1, -3, 2},
        				 {-1, -1, 0, -2, -5},
        				 {1, 2, 3, 1, -2},
        				 {-3, -3, 1, 3, 5},
        				 {2, -1, 0, -1, -7} };
        MathMatrix diffMat = mat4.subtract(mat5);
        if (equals(get2DArray(diffMat), diff) == true) {
        	System.out.println("Test 9: subtract() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 9: subtract()");
        }
        
        // test 10: subtract
        diff = new int[][] { {100, 318, 605, 91, 478, 948},
        					 {320, 505, 187, 276, 572, 640},
        					 {98, 389, 303, 398, 146, 31} };
        diffMat = mat1.subtract(mat3);
        if (equals(get2DArray(diffMat), diff) == true) {
        	System.out.println("Test 10: subtract() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 10: subtract()");
        }
        
        // test 11: multiply
        int[][] data6 = { {5, 0},
        				  {3, 2},
        				  {4, 2} };
        int[][] data7 = { {1, 3, 5},
        				  {4, 6, 0} };
        int[][] product = { {5, 15, 25},
        					{11, 21, 15},
        					{12, 24, 20} };
        MathMatrix mat6 = new MathMatrix(data6);
        MathMatrix mat7 = new MathMatrix(data7);
        MathMatrix productMat = mat6.multiply(mat7);
        if (equals(get2DArray(productMat), product) == true) {
        	System.out.println("Test 11: multiply() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 11: multiply()");
        }
        
        // test 12: multiply
        int[][] data8 = { {4, 6, 7},
        				  {2, 1, 4},
        				  {4, 6, 7},
        				  {1, 0, 2} };
        int[][] data9 = { {5, 6, 3, 2, 1},
				  		  {4, 3, 2, 0, 0},
				  		  {4, 3, 2, 6, 7} };
        product = new int[][] { {72, 63, 38, 50, 53},
        						{30, 27, 16, 28, 30},
        						{72, 63, 38, 50, 53},
        						{13, 12, 7, 14, 15} };
        MathMatrix mat8 = new MathMatrix(data8);
        MathMatrix mat9 = new MathMatrix(data9);						
        productMat = mat8.multiply(mat9);
        if (equals(get2DArray(productMat), product) == true) {
        	System.out.println("Test 12: multiply() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 12: multiply()");
        }
        
        // test 13: getScaledMatrix()
        int scale = 2;
        int[][] scaled = { {8, 12, 14},
        			   	   {4, 2, 8},
        			   	   {8, 12, 14},
        			   	   {2, 0, 4} };
        MathMatrix scaledMat = mat8.getScaledMatrix(scale);
        if (equals(get2DArray(scaledMat), scaled) == true) {
        	System.out.println("Test 13: getScaledMatrix() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 13: getScaledMatrix()");
        }
        
        // test 14: getScaledMatrix()
        scale = 5;
        scaled = new int[][] { {25, 30, 15, 10, 5},
        					   {20, 15, 10, 0, 0},
        					   {20, 15, 10, 30, 35} };
        scaledMat = mat9.getScaledMatrix(scale);
        if (equals(get2DArray(scaledMat), scaled) == true) {
        	System.out.println("Test 14: getScaledMatrix() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 14: getScaledMatrix()");
        }
        
        // test 15: getTransposed()
        int[][] transposed = { {4, 2, 4, 1},
        					   {6, 1, 6, 0},
        					   {7, 4, 7, 2} };
        MathMatrix transposedMat = mat8.getTranspose();
        if (equals(get2DArray(transposedMat), transposed) == true) {
        	System.out.println("Test 15: getTransposed() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 14: getTransposed()");
        }
        
        // test 16: getTransposed()
        transposed = new int[][] { {5, 4, 4},
        						   {6, 3, 3},
        						   {3, 2, 2},
        						   {2, 0, 6},
        						   {1, 0, 7} };
        transposedMat = mat9.getTranspose();
        if (equals(get2DArray(transposedMat), transposed) == true) {
        	System.out.println("Test 16: getTransposed() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 16: getTransposed()");
        }
        
        // test 17: equals()
        int[][] data10 = { {4, 6, 7},
				  		   {2, 1, 4},
				  		   {4, 6, 7},
				  		   {1, 0, 2} };
        MathMatrix mat10 = new MathMatrix(data10);
        if (mat8.equals(mat10) == true) {
        	System.out.println("Test 17: equals() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 17: equals()");
        }
        
        // test 18: equals()
        int[][] data11 = { {4, 6, 7},
		  		   		   {2, 5, 4},
		  		   		   {4, 6, 3},
		  		   		   {1, 0, 2} };
        MathMatrix mat11 = new MathMatrix(data11);
        if (mat10.equals(mat11) == false) {
        	System.out.println("Test 18: equals() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 18: equals()");
        }
        
        // test 19: toString()
        int[][] data12 = { {4000, 60, 7},
		   		   		   {230, 5, 4},
		   		   		   {41, 6, 301} };
        String expected = "| 4000   60    7|\n|  230    5    4|\n|   41    6  301|\n";
        MathMatrix mat12 = new MathMatrix(data12);
        if (mat12.toString().equals(expected)) {
        	System.out.println("Test 19: toString() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 19: toString()");
        }
        
        // test 20: toString()
        int[][] data13 = { {120, 6000, 72, 540},
		   		   		   {2450, 5, 40, 21},
		   		   		   {410, 612, 9, 32} };
        expected = "|  120 6000   72  540|\n| 2450    5   40   21|\n|  410  612    9   32|\n";
        MathMatrix mat13 = new MathMatrix(data13);
        if (mat13.toString().equals(expected)) {
        	System.out.println("Test 20: toString() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 20: toString()");
        }
        
        // test 21: isUpperTriangular()
        int[][] data14 = { {5, 6, 8},
        				   {3, 4, 0},
        				   {1, 0, 0} };
        MathMatrix mat14 = new MathMatrix(data14);
        if (mat14.isUpperTriangular() == true) {
        	System.out.println("Test 21: isUpperTriangular() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 21: isUpperTriangular()");
        }
        
        // test 22: isUpperTriangular()
        int[][] data15 = { {5, 6, 8},
				   		   {0, 4, 1},
				   		   {0, 0, 6} };
        MathMatrix mat15 = new MathMatrix(data15);
        if (mat15.isUpperTriangular() == true) {
        	System.out.println("Test 22: isUpperTriangular() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 22: isUpperTriangular()");
        }

/*
        // Experiment Code
        final int ADD_N_VALUE = 500;
        final int MAX = 100;
        int[] arr = new int[] {1, 2, 4};
        Random r = new Random();
        MathMatrix addMatrixOne;
        MathMatrix addMatrixTwo;
            
        // finds the time it takes for N, 2N, and 4N matrices to be added together
        for (int i = 0; i < 3; i++) {
            addMatrixOne = createMat(r, ADD_N_VALUE * arr[i], ADD_N_VALUE * arr[i], MAX);
            addMatrixTwo = createMat(r, ADD_N_VALUE * arr[i], ADD_N_VALUE * arr[i], MAX);
            // finds total time it takes to add matrix 1000 times
            double totalAddTime = 0;
            Stopwatch s = new Stopwatch();
            s.start();
            for (int j = 0; j < 1000; j++) {
                addMatrixOne.add(addMatrixTwo);
            }
            s.stop();
            totalAddTime = s.time();
            System.out.println("Time Elapsed for Add Method at " + arr[i] + 
            		"N: " + totalAddTime + " seconds");
            totalAddTime = 0;
            }
        
        int MULTIPLY_N_VALUE = 200; 
        MathMatrix multiplyMatrixOne;
        MathMatrix multiplyMatrixTwo;
            
        // finds the time it takes for N, 2N, and 4N matrices to be multiplied together
        for (int i = 0; i < 3; i++) {
        	multiplyMatrixOne = createMat(r, MULTIPLY_N_VALUE * arr[i], 
        			MULTIPLY_N_VALUE * arr[i], MAX);
        	multiplyMatrixTwo = createMat(r, MULTIPLY_N_VALUE * arr[i], 
        			MULTIPLY_N_VALUE * arr[i], MAX);
            // finds total time it takes to multiply matrix 100 times
        	double totalMultiplyTime = 0;
            Stopwatch s = new Stopwatch();
            s.start();
            for (int l = 0; l < 100; l++) {
            	multiplyMatrixOne.multiply(multiplyMatrixTwo);
            }
            s.stop();
            totalMultiplyTime = s.time();
            System.out.println("Time Elapsed for Multiply Method at " + arr[i] + 
            		"N: " + totalMultiplyTime + " seconds");
            totalMultiplyTime = 0;
            }
*/
    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        } 
        int result = 0;
        final int ROWS =  mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
        System.out.print("Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with 
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0) 
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0) 
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}

