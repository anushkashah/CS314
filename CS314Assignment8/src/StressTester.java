//Made by Aryan Agarwal

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class StressTester {
    final static private int OPERATIONS = 1000;

    public static void main(String[] args) {
        final int base = 100;
        //Increase this to get bigger tests
        Map<String, Integer> methods = new TreeMap<>();
        Map<String, Double> results = new TreeMap<>();
        //Adjusted for each method
        // N adds to size N -> N^2
        methods.put("add", 10);
        // N^2 for unsorted, N for sorted
        methods.put("addAll", 8);
        // Technically O(N) but can be done O(1) trivially
        methods.put("clear", 10);
        // Fixed Operations -> O(Log(N)) sorted, O(N) unsorted
        methods.put("contains", 9);
        // N^2 for unsorted, N for sorted
        methods.put("containsAll", 4);
        // N^2 for unsorted, N for sorted
        methods.put("difference", 6);
        // N^2 for unsorted, N for sorted
        methods.put("equals", 10);
        // N^2 for unsorted, N for sorted
        methods.put("intersection", 6);
        // Fixed Operations -> N for unsorted, N for sorted
        methods.put("remove", 9);
        // N^2 for unsorted, N for sorted
        methods.put("union", 4);
        for (String method : methods.keySet()) {
            results.put(method, runTest(base, methods.get(method), method));
        }
        // function to adjust number of trials
        //getNumberTries(results);
    }

    private static void getNumberTries(Map<String, Double> results) {
        double target = 1;
        System.out.format("Method:%15s%15s%20s\n", "method", "total time taken", "adjustment " +
            "factor");
        for (String method : results.keySet()) {
            double result = Math.log(target / results.get(method)) / Math.log(2);
            System.out.format("Method:%15s%15f%20f\n", method, results.get(method), result);

        }
    }

    static double runTest(int n, int tests, String method) {
        System.out.println(method);
        System.out.format("%10s%15s%15s\n", "n",
            "unsorted set", "sorted set");
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        for (int i = 0; i < tests; i++) {
            StressTest(n, method);
            n = n * 2;
        }
        stopwatch.stop();

        return stopwatch.time();
    }

    private static void StressTest(int n, String method) {
        final int factor = 10000;
        ISet<Integer> unsortedSet = new UnsortedSet<>();
        ISet<Integer> sortedSet = new SortedSet<>();
        double unsortedTime = StressTestHelper(n, unsortedSet, method);
        double sortedTime = StressTestHelper(n, sortedSet, method);
        System.out.format("%10d%15f%15f\n", n, unsortedTime,
            sortedTime);
    }

    private static double StressTestHelper(int n, ISet<Integer> list, String method) {
        if (method.equals("add")) {
            return StressTestAdd(n, list);
        }
        if (method.equals("addAll")) {
            return addAll(n, list);
        }
        if (method.equals("contains")) {
            return contains(n, list);
        }
        if (method.equals("containsAll")) {
            return containsAll(n, list);
        }
        if (method.equals("difference")) {
            return difference(n, list);
        }
        if (method.equals("clear")) {
            return clear(n, list);
        }
        if (method.equals("equals")) {
            return equals(n, list);
        }
        if (method.equals("intersection")) {
            return intersection(n, list);
        }
        if (method.equals("remove")) {
            return remove(n, list);
        }
        if (method.equals("union")) {
            return union(n, list);
        }
        throw new UnsupportedOperationException();
    }

    private static double StressTestAdd(int n, ISet<Integer> list) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        fillList(n, list);
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double addAll(int n, ISet<Integer> list) {
        Random rng = new Random();
        Stopwatch stopwatch = new Stopwatch();
        ISet<Integer> source = new SortedSet<>();
        for (int i = 0; i < n; i++) {
            source.add(rng.nextInt());
            list.add(rng.nextInt());
        }
        stopwatch.start();
        list.addAll(source);
        stopwatch.stop();
        return stopwatch.time();

    }

    private static double template(int n, ISet<Integer> list) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double clear(int n, ISet<Integer> list) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        list.clear();
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double contains(int n, ISet<Integer> list) {
        Random rng = new Random();
        fillList(n, list);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.contains(rng.nextInt());
        }
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double containsAll(int n, ISet<Integer> list) {
        ISet<Integer> list2 = new SortedSet<>();
        fillList(n, list, list2);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.containsAll(list2);
        }
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double difference(int n, ISet<Integer> list) {
        fillList(n, list);
        ISet<Integer> otherList = new SortedSet<>();
        fillList(n, otherList);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.difference(otherList);
        }
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double equals(int n, ISet<Integer> list) {
        ISet<Integer> otherList = new SortedSet<>();
        Stopwatch stopwatch = new Stopwatch();
        fillList(n, list);
        fillList(n, otherList);
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.equals(otherList);
        }
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double union(int n, ISet<Integer> list) {
        ISet<Integer> otherList = new SortedSet<>();
        Stopwatch stopwatch = new Stopwatch();
        fillList(n, list);
        fillList(n, otherList);
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.union(otherList);
        }
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double remove(int n, ISet<Integer> list) {
        Stopwatch stopwatch = new Stopwatch();
        Random rng = new Random();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.remove(rng.nextInt(n));
        }
        stopwatch.stop();
        return stopwatch.time();
    }

    private static double intersection(int n, ISet<Integer> list) {
        ISet<Integer> otherList = new SortedSet<>();
        Stopwatch stopwatch = new Stopwatch();
        fillList(n, list);
        fillList(n, otherList);
        stopwatch.start();
        for (int i = 0; i < OPERATIONS; i++) {
            list.intersection(otherList);
        }
        stopwatch.stop();
        return stopwatch.time();
    }


    private static void fillList(int n, ISet<Integer> list) {
        Random rng = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rng.nextInt());
        }
    }

    private static void fillList(int n, ISet<Integer> list, ISet<Integer> list2) {
        Random rng = new Random();
        for (int i = 0; i < n; i++) {
            int toAdd = rng.nextInt();
            list.add(toAdd);
            list2.add(toAdd);
        }
    }
}
