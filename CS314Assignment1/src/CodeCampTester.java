import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// CodeCamp.java - CS314 Assignment 1 - Tester class

/*
 * Student information for assignment: 
 * Name: Anushka Shah
 * email address: anushkashah654@gmail.com
 * UTEID: aks4562
 * Section 5 digit ID: 52660
 * Grader name: Grace
 * Number of slip days used on this assignment: 0
 */

/*
 * CS314 Students: place results of shared birthdays experiments in this
 * comment.
 * 
 * Average number of pairs of people with shared birthdays = 45.0
 * 
 * I think that it will take 35 people for there to be a 50% chance that 
 * at least 2 of the people have a shared birthday.
 * 
 * 23 people are required to have a 50% chance of there being at least 1 
 * shared birthday, given a 365 day year. This number does slightly surprise
 * me because it is lower than I excepted because I didn't realize how
 * common it can be for a shared birthday to occur.
 * 
Num people: 2, number of experiments with one or more shared birthday: 144, percentage: 0.29
Num people: 3, number of experiments with one or more shared birthday: 404, percentage: 0.81
Num people: 4, number of experiments with one or more shared birthday: 839, percentage: 1.68
Num people: 5, number of experiments with one or more shared birthday: 1349, percentage: 2.70
Num people: 6, number of experiments with one or more shared birthday: 1995, percentage: 3.99
Num people: 7, number of experiments with one or more shared birthday: 2816, percentage: 5.63
Num people: 8, number of experiments with one or more shared birthday: 3746, percentage: 7.49
Num people: 9, number of experiments with one or more shared birthday: 4737, percentage: 9.47
Num people: 10, number of experiments with one or more shared birthday: 5821, percentage: 11.64
Num people: 11, number of experiments with one or more shared birthday: 6993, percentage: 13.99
Num people: 12, number of experiments with one or more shared birthday: 8342, percentage: 16.68
Num people: 13, number of experiments with one or more shared birthday: 9528, percentage: 19.06
Num people: 14, number of experiments with one or more shared birthday: 11212, percentage: 22.42
Num people: 15, number of experiments with one or more shared birthday: 12640, percentage: 25.28
Num people: 16, number of experiments with one or more shared birthday: 14236, percentage: 28.47
Num people: 17, number of experiments with one or more shared birthday: 15727, percentage: 31.45
Num people: 18, number of experiments with one or more shared birthday: 17176, percentage: 34.35
Num people: 19, number of experiments with one or more shared birthday: 18964, percentage: 37.93
Num people: 20, number of experiments with one or more shared birthday: 20558, percentage: 41.12
Num people: 21, number of experiments with one or more shared birthday: 22357, percentage: 44.71
Num people: 22, number of experiments with one or more shared birthday: 23925, percentage: 47.85
Num people: 23, number of experiments with one or more shared birthday: 25448, percentage: 50.90
Num people: 24, number of experiments with one or more shared birthday: 27054, percentage: 54.11
Num people: 25, number of experiments with one or more shared birthday: 28471, percentage: 56.94
Num people: 26, number of experiments with one or more shared birthday: 29796, percentage: 59.59
Num people: 27, number of experiments with one or more shared birthday: 31476, percentage: 62.95
Num people: 28, number of experiments with one or more shared birthday: 32802, percentage: 65.60
Num people: 29, number of experiments with one or more shared birthday: 33946, percentage: 67.89
Num people: 30, number of experiments with one or more shared birthday: 35296, percentage: 70.59
Num people: 31, number of experiments with one or more shared birthday: 36397, percentage: 72.79
Num people: 32, number of experiments with one or more shared birthday: 37698, percentage: 75.40
Num people: 33, number of experiments with one or more shared birthday: 38845, percentage: 77.69
Num people: 34, number of experiments with one or more shared birthday: 39760, percentage: 79.52
Num people: 35, number of experiments with one or more shared birthday: 40824, percentage: 81.65
Num people: 36, number of experiments with one or more shared birthday: 41583, percentage: 83.17
Num people: 37, number of experiments with one or more shared birthday: 42455, percentage: 84.91
Num people: 38, number of experiments with one or more shared birthday: 43153, percentage: 86.31
Num people: 39, number of experiments with one or more shared birthday: 43886, percentage: 87.77
Num people: 40, number of experiments with one or more shared birthday: 44542, percentage: 89.08
Num people: 41, number of experiments with one or more shared birthday: 45105, percentage: 90.21
Num people: 42, number of experiments with one or more shared birthday: 45727, percentage: 91.45
Num people: 43, number of experiments with one or more shared birthday: 46239, percentage: 92.48
Num people: 44, number of experiments with one or more shared birthday: 46677, percentage: 93.35
Num people: 45, number of experiments with one or more shared birthday: 47113, percentage: 94.23
Num people: 46, number of experiments with one or more shared birthday: 47450, percentage: 94.90
Num people: 47, number of experiments with one or more shared birthday: 47749, percentage: 95.50
Num people: 48, number of experiments with one or more shared birthday: 48031, percentage: 96.06
Num people: 49, number of experiments with one or more shared birthday: 48412, percentage: 96.82
Num people: 50, number of experiments with one or more shared birthday: 48488, percentage: 96.98
Num people: 51, number of experiments with one or more shared birthday: 48695, percentage: 97.39
Num people: 52, number of experiments with one or more shared birthday: 48934, percentage: 97.87
Num people: 53, number of experiments with one or more shared birthday: 49060, percentage: 98.12
Num people: 54, number of experiments with one or more shared birthday: 49166, percentage: 98.33
Num people: 55, number of experiments with one or more shared birthday: 49280, percentage: 98.56
Num people: 56, number of experiments with one or more shared birthday: 49433, percentage: 98.87
Num people: 57, number of experiments with one or more shared birthday: 49480, percentage: 98.96
Num people: 58, number of experiments with one or more shared birthday: 49579, percentage: 99.16
Num people: 59, number of experiments with one or more shared birthday: 49690, percentage: 99.38
Num people: 60, number of experiments with one or more shared birthday: 49691, percentage: 99.38
Num people: 61, number of experiments with one or more shared birthday: 49756, percentage: 99.51
Num people: 62, number of experiments with one or more shared birthday: 49809, percentage: 99.62
Num people: 63, number of experiments with one or more shared birthday: 49816, percentage: 99.63
Num people: 64, number of experiments with one or more shared birthday: 49865, percentage: 99.73
Num people: 65, number of experiments with one or more shared birthday: 49889, percentage: 99.78
Num people: 66, number of experiments with one or more shared birthday: 49915, percentage: 99.83
Num people: 67, number of experiments with one or more shared birthday: 49910, percentage: 99.82
Num people: 68, number of experiments with one or more shared birthday: 49941, percentage: 99.88
Num people: 69, number of experiments with one or more shared birthday: 49947, percentage: 99.89
Num people: 70, number of experiments with one or more shared birthday: 49957, percentage: 99.91
Num people: 71, number of experiments with one or more shared birthday: 49966, percentage: 99.93
Num people: 72, number of experiments with one or more shared birthday: 49973, percentage: 99.95
Num people: 73, number of experiments with one or more shared birthday: 49978, percentage: 99.96
Num people: 74, number of experiments with one or more shared birthday: 49973, percentage: 99.95
Num people: 75, number of experiments with one or more shared birthday: 49991, percentage: 99.98
Num people: 76, number of experiments with one or more shared birthday: 49992, percentage: 99.98
Num people: 77, number of experiments with one or more shared birthday: 49993, percentage: 99.99
Num people: 78, number of experiments with one or more shared birthday: 49993, percentage: 99.99
Num people: 79, number of experiments with one or more shared birthday: 49993, percentage: 99.99
Num people: 80, number of experiments with one or more shared birthday: 49993, percentage: 99.99
Num people: 81, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 82, number of experiments with one or more shared birthday: 49996, percentage: 99.99
Num people: 83, number of experiments with one or more shared birthday: 49998, percentage: 100.00
Num people: 84, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 85, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 86, number of experiments with one or more shared birthday: 49997, percentage: 99.99
Num people: 87, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 88, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 89, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 90, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 91, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 92, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 */

public class CodeCampTester {

    public static void main(String[] args) {
        final String newline = System.getProperty("line.separator");

        // DELETE THE ABOVE TESTS IN THE VERSION OF THE FILE YOU TURN IN

        // CS314 Students: add tests here.
         
         // test 1, hamming distance
         int[] h1 = { 6, 5, 3, 2, 1, 3, 9 };
         int[] h2 = { 7, 5, 3, 1, 2, 3, -9 };
         int expected = 4;
         int actual = CodeCamp.hammingDistance(h1, h2);
         System.out.println("Test 1 hamming distance: expected value: " + expected
                 + ", actual value: " + actual);
         if (expected == actual) {
             System.out.println(" passed test 1, hamming distance");
         } else {
             System.out.println(" ***** FAILED ***** test 1, hamming distance");
         }
         
         // test 2, hamming distance
         h1 = new int[10];
         h2 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
         expected = 0;
         actual = CodeCamp.hammingDistance(h1, h2);
         System.out.println(newline + "Test 2 hamming distance: expected value: " + expected
                 + ", actual value: " + actual);
         if (expected == actual) {
             System.out.println(" passed test 2, hamming distance");
         } else {
             System.out.println(" ***** FAILED ***** test 2, hamming distance");
         }
         
         // test 3, isPermutation
         int[] a = { 5, 7, 9, 1, 1000000, 3, 4, 5, 2000, 1, 0, 5 };
         int[] b = { 5, 5, 9, 1, 7, 10000, 4, 3, 2000, 1, 0, 5};
         boolean expectedBool = false;
         boolean actualBool = CodeCamp.isPermutation(a, b);
         System.out.println(newline + "Test 3 isPermutation: expected value: " + expectedBool
                 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
             System.out.println(" passed test 3, isPermutation");
         } else {
             System.out.println(" ***** FAILED ***** test 3, isPermutation");
         }
         
         // test 4, isPermuatation
         a = new int[100];
         b = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        	 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        	 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        	 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        	 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         expectedBool = true;
         actualBool = CodeCamp.isPermutation(a, b);
         System.out.println(newline + "Test 4 isPermutation: expected value: " + expectedBool
                 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
             System.out.println(" passed test 4, isPermutation");
         } else {
             System.out.println(" ***** FAILED ***** test 4, isPermutation");
         }
         
         // test 5, mostVowels
         String[] arrayOfStrings = { "a034eI", "", null, null, "strawberry ice cream", "ee" };
         int expectedResult = 4;
         int actualResult = CodeCamp.mostVowels(arrayOfStrings);
         System.out.println(newline + "Test 5 mostVowels: expected result: " + expectedResult
                 + ", actual result: " + actualResult);
         if (actualResult == expectedResult) {
             System.out.println("passed test 5, mostVowels");
         } else {
             System.out.println("***** FAILED ***** test 5, mostVowels");
         }
         
         // test 6, mostVowels
         arrayOfStrings = new String[] { "ALLIGATOR", "fly", null, "" };
         expectedResult = 0;
         actualResult = CodeCamp.mostVowels(arrayOfStrings);
         System.out.println(newline + "Test 6 mostVowels: expected result: " + expectedResult
                 + ", actual result: " + actualResult);
         if (actualResult == expectedResult) {
             System.out.println("passed test 6, mostVowels");
         } else {
             System.out.println("***** FAILED ***** test 6, mostVowels");
         }
         
         // test 7, sharedBirthdays
         int pairs = CodeCamp.sharedBirthdays(10000, 500);
         System.out.println(
                 newline + "Test 7 shared birthdays - stress test. (Is solution slow?) : expected: > 0"
                         + ", actual: " + pairs);
         if (pairs > 0) {
             System.out.println("passed test 7, shared birthdays");
         } else {
             System.out.println("***** FAILED ***** test 7, shared birthdays. "
                     + "Expected at least 1 pair. Value returned: " + pairs);
         }
         
         // test 8, sharedBirthdays
         pairs = CodeCamp.sharedBirthdays(65000, 365);
         System.out.println(
                 newline + "Test 8 shared birthdays - stress test. (Is solution slow?) : expected: > 0"
                         + ", actual: " + pairs);
         if (pairs > 0) {
             System.out.println("passed test 8, shared birthdays");
         } else {
             System.out.println("***** FAILED ***** test 8, shared birthdays. "
                     + "Expected at least 1 pair. Value returned: " + pairs);
         }
         
         // test 9, queensAreSafe
         char[][] board = { { 'q', '.', '.', '.', '.', '.', '.' },
                 			{ '.', '.', '.', '.', 'q', '.', '.' }, 
                 			{ '.', '.', '.', '.', '.', '.', '.' },
                 			{ '.', '.', '.', '.', '.', 'q', '.' }, 
                 			{ '.', '.', 'q', '.', '.', '.', '.' },
                 			{ '.', '.', '.', '.', '.', '.', '.' }, 
                 			{ '.', '.', '.', 'q', '.', '.', 'q' } };
         expectedBool = false;
         actualBool = CodeCamp.queensAreSafe(board);
         System.out.println(newline + "Test 9 queensAreSafe: expected value: " + expectedBool
        		 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
        	 System.out.println(" passed test 9, queensAreSafe");
         } else {
        	 System.out.println(" ***** FAILED ***** test 9, queensAreSafe");
         }
         
         // test 10, queensAreSafe
         board = new char[][] { 
             { 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
             { '.', '.', '.', '.', '.', '.', '.', '.', '.', 'q' },
             { '.', '.', '.', '.', '.', '.', 'q', '.', '.', '.' },
             { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
             { '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.' },
             { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
             { '.', '.', '.', 'q', '.', '.', '.', '.', '.', '.' },
             { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
             { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
             { '.', '.', '.', '.', '.', 'q', '.', '.', '.', '.' }, };
         expectedBool = true;
         actualBool = CodeCamp.queensAreSafe(board);
         System.out.println(newline + "Test 10 queensAreSafe: expected value: " + expectedBool 
        		 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
        	 System.out.println(" passed test 10, queensAreSafe");
         } else {
        	 System.out.println(" ***** FAILED ***** test 10, queensAreSafe");
         }
         
         // test 11, getValueOfMostValuablePlot
         int[][] city = { { 5, 13, 10, 65, -100 }, 
                 		  { 90, -20, -6, 1, 3 }, 
                 		  { 4, 10, -4, 1, 0 },
                 		  { 30, -8, 5, -6, 1 }, 
                 		  { 10, -1, 4, 5, 6 }, 
                 		  { 15, 1, 3, 9, 9 } };
         expected = 236;
         actual = CodeCamp.getValueOfMostValuablePlot(city);
         System.out.println(newline + "Test 11 getValueOfMostValuablePlot: expected value: "
        		 + expected + ", actual value: " + actual);
         if (expected == actual) {
        	 System.out.println(" passed test 11, getValueOfMostValuablePlot");
         } else {
        	 System.out.println(" ***** FAILED ***** test 11, getValueOfMostValuablePlot");
         }
         
         // test 12, getValueOfMostValuablePlot
         city = new int[][] { { 5, 6, 7, 8, 9, 5, 6, 7, 8, 9 }, 
        	 				  { 4, 30, 7, 6, 50, -30, 6, 7, -8, 9 }, 
        	 				  { 9, 6, 50, 20, -9, -5, 6, -100, 18, 9 },
        	 				  { -10, 6, 27, 80, 30, 5, -20, 7, 82, 9 },
        	 				  { -20, 6, 73, -8, 90, 5, 6, 7, 8, 9 } };
         expected = 559;
         actual = CodeCamp.getValueOfMostValuablePlot(city);
         System.out.println(newline + "Test 12 getValueOfMostValuablePlot: expected value: "
        		 + expected + ", actual value: " + actual);
         if (expected == actual) {
        	 System.out.println(" passed test 12, getValueOfMostValuablePlot");
         } else {
        	 System.out.println(" ***** FAILED ***** test 12, getValueOfMostValuablePlot");
         }

    } // end of main method

    // pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list parameter may not be null.");
        }
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for (int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
}
