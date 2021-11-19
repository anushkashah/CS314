
/*
 * Student information for assignment:
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose Canvas account is being used): Anushka Shah
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  TA name: Grace
 *  
 *  Student 2: Jessica Ouyang
 *  UTEID: jjo889
 *  email address: jouyang99@gmail.com
 */

import java.util.Iterator;

/*
 * CS 314 Students, put your results to the experiments and answers to questions
 * here: CS314 Students, why is it unwise to implement all three of the
 * intersection, union, and difference methods in the AbstractSet class:
 * It is unwise to implement all three of the methods in the AbstractSet class 
 * because in order to implement one, it calls the other two methods since we
 * cannot create a new AbstractSet in the AbstractSet class. If we implemented
 * all three, it would result in the methods calling each other infinitely.
 * 
 * YELLOW WALLPAPER
 * File size: 53KB
 * Number of words: 9153
 * Number of distinct words: 2350
 * Sorted Time: 0.047281659 seconds
 * Unsorted Time: 0.066603824
 * Hash Time: 0.010833172
 * Tree Time: 0.014841766
 * 
 * HAMLET (in terms of Yellow Wallpaper)
 * File size: 3.98x
 * Number of words: 3.73x
 * Number of distinct words: 3.29x
 * Sorted Time: 3.24x
 * Unsorted Time: 8.56x
 * Hash Time: 2.67x
 * Tree Time: 2.63x
 * 
 * THE PICTURE OF DORIAN GRAY (in terms of Yellow Wallpaper)
 * File size: 6.13x
 * Number of words: 6.30x
 * Number of distinct words: 3.91x
 * Sorted Time: 4.91x
 * Unsorted Time: 11.77x
 * Hash Time: 4.32x
 * Tree Time: 3.20x
 * 
 * WUTHERING HEIGHTS (in terms of Yellow Wallpaper)
 * File size: 13.09x
 * Number of words: 12.99x
 * Number of distinct words: 7.48x
 * Sorted Time: 14.86x
 * Unsorted Time: 28.59x
 * Hash Time: 7.05x
 * Tree Time: 6.09x
 * 
 * The processText method for SortedSet is approximately O(N), and it appears as if
 * the processText method for UnsortedSet is O(N*M).
 * 
 * The add methods for SortedSet and UnSorted set are both O(N). The add method for
 * HashSet may be O(1), and for TreeSet it may be O(logN).
 * 
 * TreeSet's contents are printed in ASCII order, while HashSet's contents are printed
 * in no particular order.
 */

public class SetTester {

    public static void main(String[] args) {
    	
    	// test 1 unsorted set constructor
        UnsortedSet<String> u1 = new UnsortedSet<>();
        if (u1.size() == 0) {
        	System.out.println("Passed Test 1: UnsortedSet constructor");
        } else {
        	System.out.println("Failed Test 1: UnsortedSet constructor");
        }
        
        // test 2 sorted set default constructor
        SortedSet<String> s1 = new SortedSet<>();
        if (s1.size() == 0) {
        	System.out.println("Passed Test 2: SortedSet default constructor");
        } else {
        	System.out.println("Failed Test 2: SortedSet default constructor");
        }
        
        // test 3 sorted set loaded constructor
        u1.add("jessica");
        u1.add("is");
        u1.add("so");
        u1.add("cool");
        SortedSet<String> s2 = new SortedSet<>(u1);
        if (s2.size() == 4) {
        	System.out.println("Passed Test 3: SortedSet ISet constructor");
        } else {
        	System.out.println("Failed Test 3: SortedSet ISet constructor");
        }
        
    	// test 4 min
        String actual = s2.min();
        String expected = "cool";
        if (actual.equals(expected)) {
        	System.out.println("Passed Test 4: SortedSet min");
        } else {
        	System.out.println("Failed Test 4: SortedSet min");
        }
        
    	// test 5 max
        actual = s2.max();
        expected = "so";
        if (actual.equals(expected)) {
        	System.out.println("Passed Test 5: SortedSet max");
        } else {
        	System.out.println("Failed Test 5: SortedSet max");
        }
        
        // test 6 add sorted
        s2.add("anushka");
        if (s2.min().equals("anushka")) {
        	System.out.println("Passed Test 6: SortedSet add");
        } else {
        	System.out.println("Failed Test 6: SortedSet add");
        }
        
        // test 7 add unsorted
        u1.add("anushka");
        if (u1.contains("anushka")) {
        	System.out.println("Passed Test 7: UnsortedSet add");
        } else {
        	System.out.println("Failed Test 7: UnsortedSet add");
        }
    	
    	// test 8 abstract addAll
        AbstractSet<String> u2 = new UnsortedSet<>();
        u2.addAll(s2);
        if (u2.equals(s2)) {
        	System.out.println("Passed Test 8: AbstractSet addAll");
        } else {
        	System.out.println("Passed Test 8: AbstractSet addAll");
        }
        
        // test 9 sorted addAll
        SortedSet<String> s3 = new SortedSet<>();
    	s3.addAll(u2);
    	expected = "(anushka, cool, is, jessica, so)";
    	actual = s3.toString();
    	if (expected.equals(actual)) {
    		System.out.println("Passed Test 9: SortedSet addAll");
        } else {
        	System.out.println("Passed Test 9: SortedSet addAll");
    	}
    	
    	// test 10 sorted clear
    	s3.clear();
    	if (s3.size() == 0) {
    		System.out.println("Passed Test 10: SortedSet clear");
        } else {
        	System.out.println("Passed Test 10: SortedSet clear");
    	}
    	
    	// test 11 sorted contains
    	s3.add("anushka");
    	s3.add("and");
    	s3.add("jessica");
    	s3.add("and");
    	s3.add("morgan");
    	if (s3.contains("anushka")) {
    		System.out.println("Passed Test 11: SortedSet contains");
        } else {
        	System.out.println("Passed Test 11: SortedSet contains");
    	}
    	
    	// test 12 abstract contains
    	if (u2.contains("jessica")) {
    		System.out.println("Passed Test 12: AbstractSet contains");
        } else {
        	System.out.println("Passed Test 12: AbstractSet contains");
    	}
    	
    	// test 13 sorted containsAll
    	s3.add("cool");
    	s3.add("so");
    	s3.add("so");
    	if (s3.containsAll(s2)) {
    		System.out.println("Passed Test 13: SortedSet containsAll");
        } else {
        	System.out.println("Passed Test 13: SortedSet containsAll");
    	}
    	
    	// test 14 abstract equals
    	if (u1.equals(u2)) {
    		System.out.println("Passed Test 14: AbstractSet equals");
        } else {
        	System.out.println("Passed Test 14: AbstractSet equals");
    	}
    	
    	// test 15 abstract containsAll
    	u1.clear();
    	if (u2.containsAll(u1)) {
    		System.out.println("Passed Test 15: AbstractSet containsAll");
        } else {
        	System.out.println("Passed Test 15: AbstractSet containsAll");
    	}
    	
    	// test 16 sorted equals
    	s2.add("and");
    	s2.add("morgan");
    	if (s2.equals(s3)) {
    		System.out.println("Passed Test 16: SortedSet equals");
        } else {
        	System.out.println("Passed Test 16: SortedSet equals");
    	}
    	
    	// test 17 abstract remove
    	s2.remove("morgan");
    	if (!s2.contains("morgan")) {
    		System.out.println("Passed Test 17: AbstractSet remove");
        } else {
        	System.out.println("Passed Test 17: AbstractSet remove");
    	}
    	
    	// test 18 sorted set size
    	int actualSize = s2.size();
    	int expectedSize = 6;
    	if (actualSize == expectedSize) {
    		System.out.println("Passed Test 18: SortedSet size");
        } else {
        	System.out.println("Passed Test 18: SortedSet size");
    	}
    	
    	// test 19 unsorted set size
    	actualSize = u2.size();
    	expectedSize = 5;
    	if (actualSize == expectedSize) {
    		System.out.println("Passed Test 19: UnsortedSet size");
        } else {
        	System.out.println("Passed Test 19: UnsortedSet size");
    	}
    	
    	// test 20 sorted set iterator
    	Iterator<String> it = s2.iterator();
    	String val = it.next();
    	if (val.equals("and")) {
    		System.out.println("Passed Test 20: SortedSet iterator");
        } else {
        	System.out.println("Passed Test 20: SortedSet iterator");
    	}
    	
    	// test 21 unsorted set iterator
    	it = u2.iterator();
    	val = it.next();
    	if (val.equals("anushka")) {
    		System.out.println("Passed Test 21: UnsortedSet iterator");
        } else {
        	System.out.println("Passed Test 21: UnsortedSet iterator");
    	}
    	
    	// test 22 sorted difference
    	SortedSet<Integer> s4 = new SortedSet<>();
    	s4.add(1);
    	s4.add(2);
    	s4.add(3);
    	s4.add(4);
    	s4.add(5);
    	SortedSet<Integer> s5 = new SortedSet<>();
    	s4.add(1);
    	s4.add(3);
    	s4.add(5);
    	s4.add(7);
    	s4.add(9);
    	ISet<Integer> actualDiff = s4.difference(s5);
    	UnsortedSet<Integer> expectedDiff = new UnsortedSet<>();
    	expectedDiff.add(2);
    	expectedDiff.add(4);
    	if (actualDiff.equals(expectedDiff)) {
    		System.out.println("Passed Test 22: SortedSet difference");
        } else {
        	System.out.println("Passed Test 22: SortedSet difference");
    	}
    	
    	// test 23 unsorted difference
    	UnsortedSet<Integer> u4 = new UnsortedSet<>();
    	u4.add(1);
    	u4.add(2);
    	u4.add(3);
    	u4.add(4);
    	u4.add(5);
    	UnsortedSet<Integer> u5 = new UnsortedSet<>();
    	u4.add(1);
    	u4.add(3);
    	u4.add(5);
    	u4.add(7);
    	u4.add(9);
    	actualDiff = u4.difference(u5);
    	if (actualDiff.equals(expectedDiff)) {
    		System.out.println("Passed Test 23: UnsortedSet difference");
        } else {
        	System.out.println("Passed Test 23: UnsortedSet difference");
    	}
    	
    	// test 24 sorted intersection
    	UnsortedSet<Integer> expectedInt = new UnsortedSet<>();
    	expectedInt.add(1);
    	expectedInt.add(3);
    	expectedInt.add(5);
    	ISet<Integer> actualInt = s4.intersection(s5);
    	if (actualInt.equals(expectedInt)) {
    		System.out.println("Passed Test 24: SortedSet intersection");
        } else {
        	System.out.println("Passed Test 24: SortedSet intersection");
    	}
    	
    	// test 25 unsorted intersection
    	actualInt = u4.intersection(u5);
    	if (actualInt.equals(expectedInt)) {
    		System.out.println("Passed Test 25: UnsortedSet intersection");
        } else {
        	System.out.println("Passed Test 25: UnsortedSet intersection");
    	}
    	
    	// test 26 sorted union
    	UnsortedSet<Integer> expectedUnion = new UnsortedSet<>();
    	expectedUnion.add(1);
    	expectedUnion.add(2);
    	expectedUnion.add(3);
    	expectedUnion.add(4);
    	expectedUnion.add(5);
    	expectedUnion.add(7);
    	expectedUnion.add(9);
    	ISet<Integer> actualUnion = s4.union(s5);
    	if (actualUnion.equals(expectedUnion)) {
    		System.out.println("Passed Test 26: SortedSet union");
        } else {
        	System.out.println("Passed Test 26: SortedSet union");
    	}
    	
    	// test 27 unsorted union
    	actualUnion = u4.union(u5);
    	if (actualUnion.equals(expectedUnion)) {
    		System.out.println("Passed Test 27: UnsortedSet union");
        } else {
        	System.out.println("Passed Test 27: UnsortedSet union");
    	}
    }
}