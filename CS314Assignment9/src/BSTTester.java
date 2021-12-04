/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, Anushka Shah, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  TA name: Grace
 *  Number of slip days I am using: 2
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Experiment Results:
 * 
 * RANDOM ORDER:
 * Binary Search Tree:
 * n = 1000, average time = 3.8747369999999996E-4, average height = 21.4, average size = 1000.0
 * n = 2000, average time = 3.3671E-4, average height = 24.3, average size = 2000.0
 * n = 4000, average time = 6.116803E-4, average height = 26.2, average size = 4000.0
 * n = 8000, average time = 0.0013873103, average height = 28.8, average size = 8000.0
 * n = 16000, average time = 0.0032679818, average height = 32.8, average size = 16000.0
 * n = 32000, average time = 0.0070755207, average height = 35.0, average size = 31999.8
 * n = 64000, average time = 0.013846849600000002, average height = 37.9, average size = 63999.8
 * n = 128000, average time = 0.0322971918, average height = 40.1, average size = 127998.1
 * n = 256000, average time = 0.0919015163, average height = 43.4, average size = 255991.2
 * n = 512000, average time = 0.2699706481, average height = 47.0, average size = 511971.2
 * n = 1024000, average time = 0.7454731573, average height = 48.9, average size = 1023878.7
 * Minimum Possible Tree Height:
 * n = 1000, minimum height = 10
 * n = 2000, minimum height = 11
 * n = 4000, minimum height = 12
 * n = 8000, minimum height = 13
 * n = 16000, minimum height = 14
 * n = 32000, minimum height = 15
 * n = 64000, minimum height = 16
 * n = 128000, minimum height = 17
 * n = 256000, minimum height = 18
 * n = 512000, minimum height = 19
 * n = 1024000, minimum height = 20
 * 
 * TreeSet:
 * n = 1000, average time = 5.8305E-4, average size = 1000.0
 * n = 2000, average time = 7.774862000000002E-4, average size = 2000.0
 * n = 4000, average time = 7.514071E-4, average size = 4000.0
 * n = 8000, average time = 0.0013631264, average size = 8000.0
 * n = 16000, average time = 0.0028757393, average size = 16000.0
 * n = 32000, average time = 0.006328458299999999, average size = 31999.9
 * n = 64000, average time = 0.015346210400000001, average size = 63999.7
 * n = 128000, average time = 0.0354795159, average size = 127998.1
 * n = 256000, average time = 0.10688109429999999, average size = 255992.1
 * n = 512000, average time = 0.31152649420000006, average size = 511967.8
 * n = 1024000, average time = 0.7891818376, average size = 1023881.3
 * 
 * The times of inserting random elements into a TreeSet and a Binary Search Tree
 * are about the same.
 * 
 * SORTED ORDER:
 * Binary Search Tree:
 * n = 1000, average time = 0.0020588178000000004, average height = 999, average size = 1000
 * n = 2000, average time = 0.0038304172999999997, average height = 1999, average size = 2000
 * n = 4000, average time = 0.015190542899999998, average height = 3999, average size = 4000
 * n = 8000, average time = 0.06424140019999999, average height = 7999, average size = 8000
 * n = 16000, average time = 0.25742670920000005, average height = 15999, average size = 16000
 * n = 32000, average time = 1.0524142953, average height = 31999, average size = 32000
 * n = 64000, average time = 4.084300186599999, average height = 63999, average size = 64000
 * Predicted Values:
 * n = 128000, average time = 16, average height = 127999, average size = 128000
 * n = 256000, average time = 64, average height = 255999, average size = 256000
 * n = 512000, average time = 256, average height = 511999, average size = 512000
 * 
 * TreeSet:
 * n = 1000, average time = 6.442583999999999E-4, average size = 1000
 * n = 2000, average time = 2.448228E-4, average size = 2000
 * n = 4000, average time = 4.5256489999999995E-4, average size = 4000
 * n = 8000, average time = 9.844035E-4, average size = 8000
 * n = 16000, average time = 0.0022084848999999996, average size = 16000
 * n = 32000, average time = 0.0038436283, average size = 32000
 * n = 64000, average time = 0.009611221399999998, average size = 64000
 * n = 128000, average time = 0.016011852899999998, average size = 128000
 * n = 256000, average time = 0.0347019665, average size = 256000
 * n = 512000, average time = 0.0783484331, average size = 512000
 * 
 * The times of TreeSet when inserting in a sorted order are a lot faster than the times of
 * inserting in a Binary Search Tree in sorted order. I think that the cause of these 
 * differences are because 
 * 
 * 
 * Some test cases for CS314 Binary Search Tree assignment.
 *
 */
public class BSTTester {

    /**
     * The main method runs the tests.
     * @param args Not used
     */
    public static void main(String[] args) {
    	// tests 1-2 constructor
    	BinarySearchTree<String> b1 = new BinarySearchTree<>();
    	if (b1.size() == 0) {
    		System.out.println("Passed Test 1: BinarySearchTree constructor");
    	} else {
    		System.out.println("Failed Test 1: BinarySearchTree constructor");
    	}
    	
    	BinarySearchTree<String> b2 = new BinarySearchTree<>();
    	b2.add("anushka");
    	b2.add("exciting");
    	b2.add("jubilant");
    	if (b2.size() == 3) {
    		System.out.println("Passed Test 2: BinarySearchTree constructor");
    	} else {
    		System.out.println("Failed Test 2: BinarySearchTree constructor");
    	}
    	
    	// tests 3-4 add
    	boolean check = b1.add("funny");
    	if (b1.size() == 1 && b1.isPresent("funny") && check) {
    		System.out.println("Passed Test 3: BinarySearchTree add");
    	} else {
    		System.out.println("Failed Test 3: BinarySearchTree add");
    	}
    	
    	check = b1.add("funny");
    	if (b1.size() == 1 && !check) {
    		System.out.println("Passed Test 4: BinarySearchTree add");
    	} else {
    		System.out.println("Failed Test 4: BinarySearchTree add");
    	}
    	
    	// tests 5-6 remove
    	check = b1.remove("nice");
    	if (b1.size() == 1 && !check) {
    		System.out.println("Passed Test 5: BinarySearchTree remove");
    	} else {
    		System.out.println("Failed Test 5: BinarySearchTree remove");
    	}
    	
    	check = b1.remove("funny");
    	if (b1.size() == 0 && check) {
    		System.out.println("Passed Test 6: BinarySearchTree remove");
    	} else {
    		System.out.println("Failed Test 6: BinarySearchTree remove");
    	}
    	
    	// tests 7-8 isPresent
    	check = b2.isPresent("anushka");
    	if (check) {
    		System.out.println("Passed Test 7: BinarySearchTree isPresent");
    	} else {
    		System.out.println("Failed Test 7: BinarySearchTree isPresent");
    	}
    	
    	check = b2.isPresent("jessica");
    	if (!check) {
    		System.out.println("Passed Test 8: BinarySearchTree isPresent");
    	} else {
    		System.out.println("Failed Test 8: BinarySearchTree isPresent");
    	}
    	
    	// tests 9-10 size
    	if (b1.size() == 0) {
    		System.out.println("Passed Test 9: BinarySearchTree size");
    	} else {
    		System.out.println("Failed Test 9: BinarySearchTree size");
    	}
    	
    	if (b2.size() == 3) {
    		System.out.println("Passed Test 10: BinarySearchTree size");
    	} else {
    		System.out.println("Failed Test 10: BinarySearchTree size");
    	}
    	
    	// tests 11-12
    	b2.add("jessica");
    	b2.add("morgan");
    	b2.add("nitisha");
    	b2.add("keya");
    	if (b2.height() == 4) {
    		System.out.println("Passed Test 11: BinarySearchTree height");
    	} else {
    		System.out.println("Failed Test 11: BinarySearchTree height");
    	}
    	
    	b1.add("leo");
    	b1.add("virgo");
    	b1.add("scorpio");
    	b1.add("capricorn");
    	b1.add("cancer");
    	b1.add("taurus");
    	b1.add("libra");
    	if (b1.height() == 3) {
    		System.out.println("Passed Test 12: BinarySearchTree height");
    	} else {
    		System.out.println("Failed Test 12: BinarySearchTree height");
    	}
    	
    	// tests 13-14 getAll
    	List<String> list = b1.getAll();
    	List<String> expList = new ArrayList<>(Arrays.asList("cancer", "capricorn", "leo", 
    			"libra", "scorpio", "taurus", "virgo"));
    	if (list.toString().equals(expList.toString())) {
    		System.out.println("Passed Test 13: BinarySearchTree getAll");
    	} else {
    		System.out.println("Failed Test 13: BinarySearchTree getAll");
    	}
    	
    	list = b2.getAll();
    	expList = new ArrayList<>(Arrays.asList("anushka", "exciting", "jessica",
    			"jubilant", "keya", "morgan", "nitisha"));
    	if (list.toString().equals(expList.toString())) {
    		System.out.println("Passed Test 14: BinarySearchTree getAll");
    	} else {
    		System.out.println("Failed Test 14: BinarySearchTree getAll");
    	}
    	
    	// tests 15-16 max
    	if (b1.max().equals("virgo")) {
    		System.out.println("Passed Test 15: BinarySearchTree max");
    	} else {
    		System.out.println("Failed Test 15: BinarySearchTree max");
    	}
    	
    	if (b2.max().equals("nitisha")) {
    		System.out.println("Passed Test 16: BinarySearchTree max");
    	} else {
    		System.out.println("Failed Test 16: BinarySearchTree max");
    	}
    	
    	// tests 17-18 min
    	if (b1.min().equals("cancer")) {
    		System.out.println("Passed Test 17: BinarySearchTree min");
    	} else {
    		System.out.println("Failed Test 17: BinarySearchTree min");
    	}
    	
    	if (b2.min().equals("anushka")) {
    		System.out.println("Passed Test 18: BinarySearchTree min");
    	} else {
    		System.out.println("Failed Test 18: BinarySearchTree min");
    	}
    	
    	// tests 19-20 iterativeAdd
    	BinarySearchTree<String> b3 = new BinarySearchTree<>();
    	b3.iterativeAdd("hello");
    	check = b3.iterativeAdd("world");
    	if (b3.size() == 2 && check) {
    		System.out.println("Passed Test 19: BinarySearchTree iterativeAdd");
    	} else {
    		System.out.println("Failed Test 19: BinarySearchTree iterativeAdd");
    	}
    	
    	b3.iterativeAdd("hi");
    	check = b3.iterativeAdd("hello");
    	if (b3.size() == 3 && !check) {
    		System.out.println("Passed Test 20: BinarySearchTree iterativeAdd");
    	} else {
    		System.out.println("Failed Test 20: BinarySearchTree iterativeAdd");
    	}
    	
    	// tests 21-22 get
    	String k = b1.get(4);
    	if (k.equals("scorpio")) {
    		System.out.println("Passed Test 21: BinarySearchTree get");
    	} else {
    		System.out.println("Failed Test 21: BinarySearchTree get");
    	}
    	
    	k = b2.get(5);
    	if (k.equals("morgan")) {
    		System.out.println("Passed Test 22: BinarySearchTree get");
    	} else {
    		System.out.println("Failed Test 22: BinarySearchTree get");
    	}
    	
    	// tests 23-24 getAllLessThan
    	list = b1.getAllLessThan("scorpio");
    	expList = new ArrayList<>(Arrays.asList("cancer", "capricorn", "leo", "libra"));
    	if (list.toString().equals(expList.toString())) {
    		System.out.println("Passed Test 23: BinarySearchTree getAllLessThan");
    	} else {
    		System.out.println("Failed Test 23: BinarySearchTree getAllLessThan");
    	}
    	
    	list = b2.getAllLessThan("morgan");
    	expList = new ArrayList<>(Arrays.asList("anushka", "exciting", "jessica", "jubilant",
    			"keya"));
    	if (list.toString().equals(expList.toString())) {
    		System.out.println("Passed Test 24: BinarySearchTree getAllLessThan");
    	} else {
    		System.out.println("Failed Test 24: BinarySearchTree getAllLessThan");
    	}
    	
    	// tests 25-26 getAllGreaterThan
    	list = b1.getAllGreaterThan("scorpio");
    	expList = new ArrayList<>(Arrays.asList("taurus", "virgo"));
    	if (list.toString().equals(expList.toString())) {
    		System.out.println("Passed Test 25: BinarySearchTree getAllGreaterThan");
    	} else {
    		System.out.println("Failed Test 25: BinarySearchTree getAllGreaterThan");
    	}
    	
    	list = b2.getAllGreaterThan("morgan");
    	expList = new ArrayList<>(Arrays.asList("nitisha"));
    	if (list.toString().equals(expList.toString())) {
    		System.out.println("Passed Test 26: BinarySearchTree getAllGreaterThan");
    	} else {
    		System.out.println("Failed Test 26: BinarySearchTree getAllGreaterThan");
    	}
    	
    	// tests 27-28 numNodesAtDepth
    	if (b1.numNodesAtDepth(1) == 2) {
    		System.out.println("Passed Test 27: BinarySearchTree numNodesAtDepth");
    	} else {
    		System.out.println("Failed Test 27: BinarySearchTree numNodesAtDepth");
    	}
    	
    	if (b2.numNodesAtDepth(3) == 2) {
    		System.out.println("Passed Test 28: BinarySearchTree numNodesAtDepth");
    	} else {
    		System.out.println("Failed Test 28: BinarySearchTree numNodesAtDepth");
    	}
    	
/*    	
		// experiment code
    	System.out.println("RANDOM ORDER:");
    	System.out.println("Binary Search Tree:");
    	for (int n = 1000; n <= 1024000; n *= 2) {
    		double time = 0;
    		double height = 0;
    		double size = 0;
    		for (int j = 0; j <  10; j++) {
    			Random ra = new Random();
            	BinarySearchTree<Integer> b = new BinarySearchTree<>();
            	Stopwatch s = new Stopwatch();
            	s.start();
            	for(int i = 0; i < n; i++) {
            	    b.add(new Integer(ra.nextInt()));
            	}
            	s.stop();
            	time += s.time();
            	height += b.height();
            	size += b.size();
    		}
    		double avgTime = time / 10;
    		double avgHeight = height / 10;
    		double avgSize = size / 10;
        	System.out.println("n = " + n + ", average time = " + avgTime + 
        			", average height = " + avgHeight + ", average size = " + avgSize);
    	}
    	
    	System.out.println("TreeSet:");
    	for (int n = 1000; n <= 1024000; n *= 2) {
    		double time = 0;
    		double size = 0;
    		for (int j = 0; j <  10; j++) {
    			Random ra = new Random();
            	TreeSet<Integer> b = new TreeSet<>();
            	Stopwatch s = new Stopwatch();
            	s.start();
            	for(int i = 0; i < n; i++) {
            	    b.add(new Integer(ra.nextInt()));
            	}
            	s.stop();
            	time += s.time();
            	size += b.size();
    		}
    		double avgTime = time / 10;
    		double avgSize = size / 10;
        	System.out.println("n = " + n + ", average time = " + avgTime +
        			", average size = " + avgSize);
    	}
    	
    	System.out.println("SORTED ORDER:");
    	System.out.println("Binary Search Tree:");
    	for (int n = 1000; n <= 64000; n *= 2) {
    		ArrayList<Integer> arr = new ArrayList<>();
        	for (int i = 1; i <= n; i++) {
        		arr.add(i);
        	}
    		double time = 0;
    		for (int j = 0; j <  10; j++) {
            	BinarySearchTree<Integer> b = new BinarySearchTree<>();
            	Stopwatch s = new Stopwatch();
            	s.start();
            	for(int i = 0; i < arr.size(); i++) {
            	    b.iterativeAdd(arr.get(i));
            	}
            	s.stop();
            	time += s.time();
    		}
    		double avgTime = time / 10;
        	System.out.println("n = " + n + ", average time = " + avgTime);
    	}
    	
    	System.out.println("TreeSet:");
    	for (int n = 1000; n <= 512000; n *= 2) {
    		ArrayList<Integer> arr = new ArrayList<>();
        	for (int i = 1; i <= n; i++) {
        		arr.add(i);
        	}
    		double time = 0;
    		for (int j = 0; j <  10; j++) {
            	TreeSet<Integer> b = new TreeSet<>();
            	Stopwatch s = new Stopwatch();
            	s.start();
            	for(int i = 0; i < arr.size(); i++) {
            	    b.add(arr.get(i));
            	}
            	s.stop();
            	time += s.time();
    		}
    		double avgTime = time / 10;
        	System.out.println("n = " + n + ", average time = " + avgTime);
    	}
*/    	
    }
}
