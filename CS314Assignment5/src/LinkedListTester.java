/*  Student information for assignment:
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

/* Experiment results. CS314 students, place your experiment
 *  results here:
 *  
 *  Adding at the front and removing from the front were faster for LinkedList.
 *  Getting random, getting all using iterator, and getting all using get 
 *  method were faster for ArrayList.
 *  Adding at the end was about the same for both LinkedList and ArrayList.
 *  
 *  Based on the timing data, the Big O for the operations are:
 *  Adding at the end is O(N) for both LinkedList and ArrayList because the timing doubles
 *  when the N doubles.
 *  Adding at the front is O(N^2) for ArrayList but is O(N) for LinkedList. This is because the
 *  timing increases by a factor of 4 when N doubles for ArrayList but the timing doubles when N
 *  doubles for LinkedList.
 *  Removing from front is O(N^2) for ArrayList but is O(N) for LinkedList. This is because 
 *  the timing for removing from front increases by a factor of 4 when N doubles for ArrayList
 *  but the timing only doubles when N doubles for LinkedList.
 *  Getting random is O(N) for ArrayList but is O(N^2) for LinkedList. This is because the 
 *  timing data shows that when getting random for ArrayList the timing doubles when N doubles. 
 *  However, for Linked List the timing increases by a factor of 4 when N doubles, meaning it is 
 *  O(N^2). 
 *  Getting all using iterator is O(N) for both ArrayList and LinkedList. This 
 *  is because the timing doubles when N doubles for both ArrayList and LinkedList.
 *  Getting all using get method is O(N) for ArrayList but O(N^2) for LinkedList. This is
 *  shown in the timing data because the timing doubles when N doubles for ArrayList but
 *  increases by a factor of 4 when N doubles for LinkedList.
 *  
 */

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedListTester {

    public static void main(String[] args) {
    	
        //CS314 students. Add your tests here:
        // add() tests 1-3
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("A");
        if (list1.toString().equals("[A]")) {
        	System.out.println("Test 1: add() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 1: add()");
        }
        
        list1.add("B");
        if (list1.toString().equals("[A, B]")) {
        	System.out.println("Test 2: add() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 2: add()");
        }
        
        list1.add("G");
        if (list1.toString().equals("[A, B, G]")) {
        	System.out.println("Test 3: add() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 3: add()");
        }
        
        // insert() tests 4-6
        list1.insert(2, "C");
        if (list1.toString().equals("[A, B, C, G]")) {
        	System.out.println("Test 4: insert() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 4: insert()");
        }
        
        list1.insert(0, "D");
        if (list1.toString().equals("[D, A, B, C, G]")) {
        	System.out.println("Test 5: insert() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 5: insert()");
        }
        
        list1.insert(3, "H");
        if (list1.toString().equals("[D, A, B, H, C, G]")) {
        	System.out.println("Test 6: insert() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 6: insert()");
        }
        
        // set() tests 7-9
        list1.set(3, "L");
        if (list1.toString().equals("[D, A, B, L, C, G]")) {
        	System.out.println("Test 7: set() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 7: set()");
        }
        
        list1.set(5, "K");
        if (list1.toString().equals("[D, A, B, L, C, K]")) {
        	System.out.println("Test 8: set() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 8: set()");
        }
        
        list1.set(1, "R");
        if (list1.toString().equals("[D, R, B, L, C, K]")) {
        	System.out.println("Test 9: set() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 9: set()");
        }
        
        // get() tests 10-12
        if (list1.get(3).equals("L")) {
        	System.out.println("Test 10: get() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 10: get()");
        }
        
        if (list1.get(4).equals("C")) {
        	System.out.println("Test 11: get() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 11: get()");
        }
        
        if (list1.get(0).equals("D")) {
        	System.out.println("Test 12: get() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 12: get()");
        }
        
        // remove(int pos) tests 13-15
        list1.remove(3);
        if (list1.toString().equals("[D, R, B, C, K]")) {
        	System.out.println("Test 13: remove() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 13: remove()");
        }
        
        list1.remove(3);
        if (list1.toString().equals("[D, R, B, K]")) {
        	System.out.println("Test 14: remove() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 14: remove()");
        }
        
        list1.remove(1);
        if (list1.toString().equals("[D, B, K]")) {
        	System.out.println("Test 15: remove() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 15: remove()");
        }
        
        // remove(E obj) tests 16-18
        boolean val = list1.remove("D");
        if (val && list1.toString().equals("[B, K]")) {
        	System.out.println("Test 16: remove(E obj) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 16: remove(E obj)");
        }
        
        val = list1.remove("A");
        if (!val && list1.toString().equals("[B, K]")) {
        	System.out.println("Test 17: remove(E obj) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 17: remove(E obj)");
        }
        
        val = list1.remove("K");
        if (val && list1.toString().equals("[B]")) {
        	System.out.println("Test 18: remove(E obj) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 18: remove(E obj)");
        }
        
        // getSubList tests 19-21
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("C");
        list2.add("A");
        list2.add("B");
        list2.add("D");
        list2.add("E"); // [C, A, B, D, E]
        IList<String> subList = new LinkedList<>();
        subList = list2.getSubList(1, 4); // [A, B, D]
        if (subList.toString().equals("[A, B, D]")) {
        	System.out.println("Test 19: getSubList passed");
        } else {
        	System.out.println("***** FAILED ***** Test 19: getSubList");
        }
        
        subList = list2.getSubList(0, 1);
        if (subList.toString().equals("[C]")) {
        	System.out.println("Test 20: getSubList passed");
        } else {
        	System.out.println("***** FAILED ***** Test 20: getSubList");
        }
        
        subList = list2.getSubList(2, 4);
        if (subList.toString().equals("[B, D]")) {
        	System.out.println("Test 21: getSubList passed");
        } else {
        	System.out.println("***** FAILED ***** Test 21: getSubList");
        }
        
        // size() tests 22-24
        int sizeVal = list1.size();
        if (sizeVal == 1) {
        	System.out.println("Test 22: size passed");
        } else {
        	System.out.println("***** FAILED ***** Test 22: size");
        }
        
        sizeVal = list2.size();
        if (sizeVal == 5) {
        	System.out.println("Test 23: size passed");
        } else {
        	System.out.println("***** FAILED ***** Test 23: size");
        }
        
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("K");
        list3.add("C");
        list3.add("W");
        list3.add("E");
        list3.add("F");
        list3.add("J"); // [K, C, W, E, F, J]
        sizeVal = list3.size();
        if (sizeVal == 6) {
        	System.out.println("Test 24: size passed");
        } else {
        	System.out.println("***** FAILED ***** Test 24: size");
        }
        
        // indexOf(E item) tests 25-27
        int index = list2.indexOf("B");
        if (index == 2) {
        	System.out.println("Test 25: indexOf(E item) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 25: indexOf(E item)");
        }
        
        index = list3.indexOf("J");
        if (index == 5) {
        	System.out.println("Test 26: indexOf(E item) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 26: indexOf(E item)");
        }
        
        index = list3.indexOf("A");
        if (index == -1) {
        	System.out.println("Test 27: indexOf(E item) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 27: indexOf(E item)");
        }
        
        // indexOf(E item, int pos) tests 28-30
        index = list3.indexOf("W", 3);
        if (index == -1) {
        	System.out.println("Test 28: indexOf(E item, int pos) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 28: indexOf(E item, int pos)");
        }
        
        index = list3.indexOf("E", 2);
        if (index == 3) {
        	System.out.println("Test 29: indexOf(E item, int pos) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 29: indexOf(E item, int pos)");
        }
        
        index = list3.indexOf("C", 1);
        if (index == 1) {
        	System.out.println("Test 30: indexOf(E item, int pos) passed");
        } else {
        	System.out.println("***** FAILED ***** Test 30: indexOf(E item, int pos)");
        }
        
        // makeEmpty tests 31-33
        list1.makeEmpty();
        if (list1.toString().equals("[]")) {
        	System.out.println("Test 31: makeEmpty() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 31: makeEmpty()");
        }
        
        list2.makeEmpty();
        if (list2.toString().equals("[]")) {
        	System.out.println("Test 32: makeEmpty() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 32: makeEmpty()");
        }
        
        list3.makeEmpty();
        if (list3.toString().equals("[]")) {
        	System.out.println("Test 33: makeEmpty() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 33: makeEmpty()");
        }
        
        // iterator() tests 34-36
        list1.add("A");
        list1.add("B");
        list1.add("C");  // [A, B, C]
        Iterator<String> it = list1.iterator();
        
        // test 34
        if (it.hasNext()) {
        	System.out.println("Test 34: hasNext() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 34: hasNext()");
        }
        
        if (it.next().equals("A")) {
        	System.out.println("Test 34: next() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 34: next()");
        }
        
        it.remove();
        if (list1.toString().equals("[B, C]")) {
        	System.out.println("Test 34: remove() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 34: remove()");
        }
        
        // test 35
        if (it.hasNext()) {
        	System.out.println("Test 35: hasNext() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 35: hasNext()");
        }
        
        if (it.next().equals("B")) {
        	System.out.println("Test 35: next() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 35: next()");
        }
        
        it.remove();
        if (list1.toString().equals("[C]")) {
        	System.out.println("Test 35: remove() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 35: remove()");
        }
        
        // test 36
        if (it.hasNext()) {
        	System.out.println("Test 36: hasNext() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 36: hasNext()");
        }
        
        if (it.next().equals("C")) {
        	System.out.println("Test 36: next() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 36: next()");
        }
        
        it.remove();
        if (list1.toString().equals("[]")) {
        	System.out.println("Test 36: remove() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 36: remove()");
        }
        
        // removeRange tests 37-39
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");
        list1.removeRange(1, 3);
        if (list1.toString().equals("[A, D, E]")) {
        	System.out.println("Test 37: removeRange() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 37: removeRange()");
        }
        
        list2.add("W");
        list2.add("X");
        list2.add("Y");
        list2.add("Z");
        list2.removeRange(1, 1);
        if (list2.toString().equals("[W, X, Y, Z]")) {
        	System.out.println("Test 38: removeRange() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 38: removeRange()");
        }
        
        list2.removeRange(0, 3);
        if (list2.toString().equals("[Z]")) {
        	System.out.println("Test 39: removeRange() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 39: removeRange()");
        }
        
        // toString tests 40-42
        if (list1.toString().equals("[A, D, E]")) {
        	System.out.println("Test 40: toString passed");
        } else {
        	System.out.println("***** FAILED ***** Test 40: toString()");
        }
        
        if (list2.toString().equals("[Z]")) {
        	System.out.println("Test 41: toString() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 41: toString()");
        }
        
        if (list3.toString().equals("[]")) {
        	System.out.println("Test 42: toString() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 42: toString()");
        }
        
        // equals tests 43-45
        list3.add("A");
        list3.add("D");
        list3.add("E");
        if (list1.equals(list3)) {
        	System.out.println("Test 43: equals() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 43: equals()");
        }
        
        if (!list1.equals(list2)) {
        	System.out.println("Test 44: equals() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 44: equals()");
        }
        
        LinkedList<String> list4 = new LinkedList<>();
        list4.add("D");
        list4.add("A");
        list4.add("E");
        if (!list3.equals(list4)) {
        	System.out.println("Test 45: equals() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 45: equals()");
        }
        
        // addFirst tests 46-48
        list1.addFirst("W");
        if (list1.toString().equals("[W, A, D, E]")) {
        	System.out.println("Test 46: addFirst() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 46: addFirst()");
        }
        
        list1.addFirst("G");
        if (list1.toString().equals("[G, W, A, D, E]")) {
        	System.out.println("Test 47: addFirst() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 47: addFirst()");
        }
        
        list2.addFirst("H");
        if (list2.toString().equals("[H, Z]")) {
        	System.out.println("Test 48: addFirst() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 48: addFirst()");
        }
        
        // addLast tests 49-51
        list1.addLast("L");
        if (list1.toString().equals("[G, W, A, D, E, L]")) {
        	System.out.println("Test 49: addLast() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 49: addLast()");
        }
        
        list2.addLast("M");
        if (list2.toString().equals("[H, Z, M]")) {
        	System.out.println("Test 50: addLast() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 50: addLast()");
        }
        
        list2.addLast("Y");
        if (list2.toString().equals("[H, Z, M, Y]")) {
        	System.out.println("Test 51: addLast() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 51: addLast()");
        }
        
        // removeFirst tests 52-54
        String data = list1.removeFirst();
        if (data.equals("G") && list1.toString().equals("[W, A, D, E, L]")) {
        	System.out.println("Test 52: removeFirst() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 52: removeFirst()");
        }
        
        data = list1.removeFirst();
        if (data.equals("W") && list1.toString().equals("[A, D, E, L]")) {
        	System.out.println("Test 53: removeFirst() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 53: removeFirst()");
        }
        
        data = list2.removeFirst();
        if (data.equals("H") && list2.toString().equals("[Z, M, Y]")) {
        	System.out.println("Test 54: removeFirst() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 54: removeFirst()");
        }
        
        // removeLast tests 55-57
        data = list1.removeLast();
        if (data.equals("L") && list1.toString().equals("[A, D, E]")) {
        	System.out.println("Test 55: removeLast() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 55: removeLast()");
        }
        
        data = list1.removeLast();
        if (data.equals("E") && list1.toString().equals("[A, D]")) {
        	System.out.println("Test 56: removeLast() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 56: removeLast()");
        }
        
        data = list2.removeLast();
        if (data.equals("Y") && list2.toString().equals("[Z, M]")) {
        	System.out.println("Test 56: removeLast() passed");
        } else {
        	System.out.println("***** FAILED ***** Test 56: removeLast()");
        }
    }
}
