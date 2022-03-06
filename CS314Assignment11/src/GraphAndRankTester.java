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
 */

/*
 * Questions.
 *
 * 1. The assignment presents three ways to rank teams using graphs.
 * The results, especially for the last two methods are reasonable.
 * However if all results from all college football teams are included
 * some unexpected results occur. Explain the unexpected results. You may
 * have to do some research on the various college football divisions to
 * make an informed answer.
 * 
 * If all results from all college football teams are included some
 * unexpected results occur because the rankings of various college
 * football teams are very similar. Because the teams are ranked based
 * on the division they are in (Big 10, SEC, etc), multiple teams from
 * different divisions will have the same ranking, which will make
 * it harder to rank these teams and cause the unexpected results.
 * 
 * 2. Suggest another way of method of ranking teams using the results
 * from the graph. Thoroughly explain your method. The method can build
 * on one of the three existing algorithms.
 * 
 * Another way of ranking teams is using the skill of their players and their
 * running yards to determine a weight for each team. Then, we can find the
 * average shortest weighted path of a team using the new weights determined
 * by the players skill level.
 *
 */

public class GraphAndRankTester {

    /**
     * Runs tests on Graph classes and FootballRanker class.
     * Experiments involve results from college football
     * teams. Central nodes in the graph are compared to
     * human rankings of the teams.
     * @param args None expected.
     */
    public static void main(String[] args)  {
        // tests 1-2 dijkstra
    	String [][] g1Edges = {{"A", "B", "3"},
                			   {"A", "C", "2"},
                			   {"A", "H", "7"},
                			   {"B", "D", "5"},
                			   {"B", "E", "6"},
                			   {"B", "F", "3"},
                			   {"B", "G", "2"},
                			   {"C", "G", "1"},
                			   {"C", "H", "3"},
                			   {"G", "I", "3"},
                			   {"H", "I", "6"}};
    	Graph g1 = getGraph(g1Edges, false);
    	g1.dijkstra("A");
    	String actualPath = g1.findPath("G").toString();
        String expected = "[A, C, G]";
        if (actualPath.equals(expected)) {
            System.out.println("Passed Test 1: Dijkstra.");
        } else {
            System.out.println("Failed Test 1: Dijkstra. Expected: " + expected + " actual " + 
            		actualPath);
        }
        
        g1.dijkstra("I");
        actualPath = g1.findPath("A").toString();
        expected = "[I, G, C, A]";
        if (actualPath.equals(expected)) {
            System.out.println("Passed Test 2: Dijkstra.");
        } else {
            System.out.println("Failed Test 2: Dijkstra. Expected: " + expected + " actual " + 
            		actualPath);
        }
        
        // tests 3-4 findAllPaths
        String[] exp = {"Name: B                    cost per path: 1.3750, num paths: 8",
                		"Name: A                    cost per path: 1.6250, num paths: 8",
                		"Name: G                    cost per path: 1.6250, num paths: 8",
                		"Name: C                    cost per path: 2.0000, num paths: 8",
                		"Name: H                    cost per path: 2.0000, num paths: 8",
                		"Name: I                    cost per path: 2.1250, num paths: 8",
                		"Name: D                    cost per path: 2.2500, num paths: 8",
                		"Name: E                    cost per path: 2.2500, num paths: 8",
                		"Name: F                    cost per path: 2.2500, num paths: 8"};
        doAllPathsTests("Graph 1", g1, false, 3, 3.0, exp); 
    	
        String [][] g2Edges = {{"A", "B", "4"},
        					   {"B", "C", "1"},
                			   {"A", "C", "2"},
                			   {"C", "D", "5"},
                			   {"A", "D", "6"},
                			   {"B", "E", "2"},
                			   {"E", "F", "1"},
                			   {"D", "F", "5"}};
        Graph g2 = getGraph(g2Edges, false);
        exp = new String[] {"Name: A                    cost per path: 1.4000, num paths: 5",
				 			"Name: B                    cost per path: 1.4000, num paths: 5",
				 			"Name: C                    cost per path: 1.4000, num paths: 5",
				 			"Name: D                    cost per path: 1.4000, num paths: 5",
				 			"Name: E                    cost per path: 1.6000, num paths: 5",
				 			"Name: F                    cost per path: 1.6000, num paths: 5"};
        doAllPathsTests("Graph 2", g2, false, 2, 2.0, exp);
        
        // 2005  
        // TESTS ON FOOTBALL TEAM GRAPH WITH FootBallRanker CLASS: 
        // UNWEIGHTED ROOT MEAN SQUARE ERROR TEST. actual: 6.8
        // WEIGHTED ROOT MEAN SQUARE ERROR TEST. actual: 5.8
        // WEIGHTED AND WIN PERCENT ROOT MEAN SQUARE ERROR TEST. actual: 3.0
        
        // 2014
        // TESTS ON FOOTBALL TEAM GRAPH WITH FootBallRanker CLASS: 
        // UNWEIGHTED ROOT MEAN SQUARE ERROR TEST. actual: 10.1
        // WEIGHTED ROOT MEAN SQUARE ERROR TEST. actual: 8.5
        // WEIGHTED  AND WIN PERCENT ROOT MEAN SQUARE ERROR TEST. actual: 4.2
    }

    // return a Graph based on the given edges
    private static Graph getGraph(String[][] edges, boolean directed) {
        Graph result = new Graph();
        for (String[] edge : edges) {
            result.addEdge(edge[0], edge[1], Double.parseDouble(edge[2]));
            // If edges are for an undirected graph add edge in other direction too.
            if (!directed) {
                result.addEdge(edge[1], edge[0], Double.parseDouble(edge[2]));
            }
        }
        return result;
    }

    // Tests the all paths method. Run each set of tests twice to ensure the Graph
    // is correctly reseting each time
    private static void doAllPathsTests(String graphNumber, Graph g, boolean weighted,
                    int expectedDiameter, double expectedCostOfLongestShortestPath,
                    String[] expectedPaths) {

        System.out.println("\nTESTING ALL PATHS INFO ON " + graphNumber + ". ");
        for (int i = 0; i < 2; i++) {
            System.out.println("Test run = " + (i + 1));
            System.out.println("Find all paths weighted = " + weighted);
            g.findAllPaths(weighted);
            int actualDiameter = g.getDiameter();
            double actualCostOfLongestShortesPath = g.costOfLongestShortestPath();
            if (actualDiameter == expectedDiameter) {
                System.out.println("Passed diameter test.");
            } else {
                System.out.println("FAILED diameter test. "
                                + "Expected = "  + expectedDiameter +
                                " Actual = " + actualDiameter);
            }
            if (actualCostOfLongestShortesPath == expectedCostOfLongestShortestPath) {
                System.out.println("Passed cost of longest shortest path. test.");
            } else {
                System.out.println("FAILED cost of longest shortest path. "
                                + "Expected = "  + expectedCostOfLongestShortestPath +
                                " Actual = " + actualCostOfLongestShortesPath);
            }
            testAllPathsInfo(g, expectedPaths);
            System.out.println();
        }

    }

    // Compare results of all paths info on Graph to expected results.
    private static void testAllPathsInfo(Graph g, String[] expectedPaths) {
        int index = 0;

        for (AllPathsInfo api : g.getAllPaths()) {
            if (expectedPaths[index].equals(api.toString())) {
                System.out.println(expectedPaths[index] + " is correct!!");
            } else {
                System.out.println("ERROR IN ALL PATHS INFO: ");
                System.out.println("index: " + index);
                System.out.println("EXPECTED: " + expectedPaths[index]);
                System.out.println("ACTUAL: " + api.toString());
                System.out.println();
            }
            index++;
        }
        System.out.println();
    }
}
