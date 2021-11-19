import java.util.ArrayList;
import java.util.Collections;

public class SetStressTest {
    public static void main(String[] args) {
        //Results storage
        int[] r = {0, 0};
        int temp = 0;

        //Array, and both sets with numbers 1-50
        ArrayList<Integer> num = new ArrayList<>();
        SortedSet<Integer> ref = new SortedSet<>();
        UnsortedSet<Integer> unref = new UnsortedSet<>();
        for (int i = 0; i < 50; i++) {
            num.add(i);
            ref.add(i);
            unref.add(i);
        }

        //Basically all of these test equals.

        System.out.println("Union and intersection Tests");
        //Test union and sorted intersection
        for (int i = 0; i < 50; i++) {
            ISet<Integer> unionRef = new SortedSet<>();
            ISet<Integer> ununionRef = new UnsortedSet<>();
            ISet<Integer> intersectionRef = new SortedSet<>();
            ISet<Integer> setUnion1 = new SortedSet<>();
            ISet<Integer> unsetUnion1 = new SortedSet<>();
            ISet<Integer> setUnion2 = new UnsortedSet<>();
            ISet<Integer> unsetUnion2 = new UnsortedSet<>();
            ISet<Integer> setIntersection1 = new SortedSet<>();
            ISet<Integer> setIntersection2 = new SortedSet<>();

            for (int k = 0; k < i; k++) {
                setUnion1.add(k);
                setUnion2.add(k + 100);
                unsetUnion1.add(k);
                unsetUnion2.add(k + 100);
                setIntersection1.add(k);
                setIntersection2.add(k);
                unionRef.add(k);
                unionRef.add(k + 100);
                ununionRef.add(k);
                ununionRef.add(k + 100);
                intersectionRef.add(k);
            }


            //Union tests
            //Sorted
            test(r, setUnion1.union(setUnion2).equals(unionRef));
            test(r, setUnion1.union(setUnion1).equals(setUnion1));
            test(r, setUnion2.union(setUnion2).equals(setUnion2));
            test(r, setUnion2.union(setUnion1).equals(unionRef));
            //Unsorted
            test(r, unsetUnion1.union(unsetUnion2).equals(ununionRef));
            test(r, unsetUnion1.union(unsetUnion1).equals(unsetUnion1));
            test(r, unsetUnion2.union(unsetUnion2).equals(unsetUnion2));
            test(r, unsetUnion2.union(unsetUnion1).equals(ununionRef));

            //mixed sorted/unsorted
            test(r, setUnion1.union(unsetUnion2).equals(unionRef));
            test(r, setUnion1.union(unsetUnion2).equals(unionRef));
            test(r, unsetUnion1.union(setUnion1).equals(setUnion1));
            test(r, unsetUnion1.union(setUnion1).equals(setUnion1));
            //mixed sorted/unsorted
            test(r, unsetUnion2.union(setUnion2).equals(unsetUnion2));
            test(r, unsetUnion2.union(setUnion2).equals(unsetUnion2));
            test(r, setUnion2.union(unsetUnion1).equals(ununionRef));
            test(r, setUnion2.union(unsetUnion1).equals(ununionRef));

            //(Sorted) Intersection tests
            test(r, setIntersection1.intersection(setIntersection2).equals(intersectionRef));
            test(r, setIntersection1.intersection(setIntersection1).equals(intersectionRef));
            test(r, setIntersection2.intersection(setIntersection2).equals(intersectionRef));
            test(r, setIntersection2.intersection(setIntersection1).equals(intersectionRef));


        }

        System.out.println("More intersection Tests");
        //More intersection tests
        for (int i = 0; i < 100; i++) {
            ISet<Integer> setIntersection1 = new SortedSet<>();
            ISet<Integer> setIntersection2 = new SortedSet<>();
            ISet<Integer> intersectionRef = new SortedSet<>();
            ISet<Integer> unsetIntersection1 = new UnsortedSet<>();
            ISet<Integer> unsetIntersection2 = new UnsortedSet<>();
            ISet<Integer> unintersectionRef = new UnsortedSet<>();

            for (int k = 0; k < i; k++) {
                if (k > (i / 4)) {
                    setIntersection1.add(k);
                    unsetIntersection1.add(k);
                }
                if (k < ((3 * i) / 4)) {
                    setIntersection2.add(k);
                    unsetIntersection2.add(k);
                }
                if (k > (i / 4) && k < ((3 * i) / 4)) {
                    intersectionRef.add(k);
                    unintersectionRef.add(k);
                }
            }

            //Intersection - sorted
            test(r, setIntersection1.intersection(setIntersection2).equals(intersectionRef));
            test(r, setIntersection1.intersection(setIntersection2).equals(intersectionRef));
            test(r, setIntersection1.intersection(setIntersection1).equals(setIntersection1));
            test(r, setIntersection2.intersection(setIntersection2).equals(setIntersection2));

            //Intersection - unsorted
            test(r, unsetIntersection2.intersection(unsetIntersection1).equals(unintersectionRef));
            test(r, unsetIntersection2.intersection(unsetIntersection1).equals(unintersectionRef));
            test(r, unsetIntersection1.intersection(unsetIntersection1).equals(unsetIntersection1));
            test(r, unsetIntersection2.intersection(unsetIntersection2).equals(unsetIntersection2));

            //Intersection - Mixed
            test(r, unsetIntersection1.intersection(setIntersection2).equals(intersectionRef));
            test(r, unsetIntersection1.intersection(setIntersection2).equals(intersectionRef));
            test(r, unsetIntersection2.intersection(setIntersection1).equals(unintersectionRef));
            test(r, unsetIntersection2.intersection(setIntersection1).equals(unintersectionRef));
        }

        System.out.println("Difference Tests");
        //Difference tests
        //i starts at 2 because otherwise reference arrays would be generated incorrectly.
        for (int i = 2; i < 102; i++) {
            ISet<Integer> setDifference1 = new SortedSet<>();
            ISet<Integer> setDifference2 = new SortedSet<>();
            ISet<Integer> differenceRef1 = new SortedSet<>();
            ISet<Integer> differenceRef2 = new SortedSet<>();

            ISet<Integer> unsetDifference1 = new UnsortedSet<>();
            ISet<Integer> unsetDifference2 = new UnsortedSet<>();
            ISet<Integer> undifferenceRef1 = new UnsortedSet<>();
            ISet<Integer> undifferenceRef2 = new UnsortedSet<>();

            for (int k = 0; k < i; k++) {
                if (k > (i / 4)) {
                    setDifference1.add(k);
                    unsetDifference1.add(k);
                }
                if (k < ((3 * i) / 4)) {
                    setDifference2.add(k);
                    unsetDifference2.add(k);
                }

                if (k >= ((3 * i) / 4)) {
                    differenceRef1.add(k);
                    undifferenceRef1.add(k);
                }


                if (k <= (i / 4)) {
                    differenceRef2.add(k);
                    undifferenceRef2.add(k);
                }
            }

            //Sorted
            test(r, setDifference1.difference(setDifference2).equals(differenceRef1));
            test(r, setDifference2.difference(setDifference1).equals(differenceRef2));
            test(r, setDifference1.difference(setDifference1).equals(new SortedSet<>()));
            test(r, setDifference2.difference(setDifference2).equals(new SortedSet<>()));

            //Unsorted
            test(r, unsetDifference1.difference(unsetDifference2).equals(undifferenceRef1));
            test(r, unsetDifference2.difference(unsetDifference1).equals(undifferenceRef2));
            test(r, unsetDifference1.difference(unsetDifference1).equals(new UnsortedSet<>()));
            test(r, unsetDifference2.difference(unsetDifference2).equals(new UnsortedSet<>()));

            //Mixed
            test(r, setDifference1.difference(unsetDifference2).equals(differenceRef1));
            test(r, setDifference1.difference(unsetDifference2).equals(differenceRef1));
            test(r, setDifference1.difference(unsetDifference2).equals(undifferenceRef1));
            test(r, setDifference1.difference(unsetDifference2).equals(undifferenceRef1));

            test(r, unsetDifference2.difference(setDifference1).equals(differenceRef2));
            test(r, setDifference2.difference(unsetDifference1).equals(differenceRef2));
            test(r, unsetDifference2.difference(setDifference1).equals(undifferenceRef2));
            test(r, setDifference2.difference(unsetDifference1).equals(undifferenceRef2));
        }


        System.out.println("AddAll, ContainsAll, Add, Size, Clear");
        //Tests addAll, ContainsAll (for some cases), Add, size, and equals, and clear
        for (int i = 0; i < 50; i++) {
            ISet<Integer> set1 = new SortedSet<>();
            ISet<Integer> unset1 = new UnsortedSet<>();
            ISet<Integer> set2 = new SortedSet<>();
            ISet<Integer> unset2 = new UnsortedSet<>();

            for (int k = 0; k < i; k++) {
                //Test size method
                test(r, set1.size() == k);
                test(r, unset1.size() == k);
                test(r, set2.size() == k);
                test(r, unset2.size() == k);
                set1.add(k);
                unset1.add(k);
                set2.add(k);
                unset2.add(k);
            }

            if (i != 49) {
                //Tests addAll boolean return
                test(r, set1.addAll(ref));
                test(r, unset1.addAll(unref));
                test(r, set2.addAll(unref));
                test(r, unset2.addAll(ref));
            } else {
                //this only runs once.
                //its another test of the boolean return, when it should be false (as nothing
                // should be added)
                set1.add(49);
                unset1.add(49);
                set2.add(49);
                unset2.add(49);
                test(r, !set1.addAll(ref));
                test(r, !unset1.addAll(unref));
                test(r, !set2.addAll(unref));
                test(r, !unset2.addAll(ref));
            }

            //Tests that addAll actually did add all, like it should have
            test(r, set1.equals(ref));
            test(r, set1.equals(unref));
            test(r, unset1.equals(ref));
            test(r, unset1.equals(unref));
            test(r, set2.equals(ref));
            test(r, set2.equals(unref));
            test(r, unset2.equals(ref));
            test(r, unset2.equals(unref));

            //Test containsAll for the case that they are the same size and both contain all
            test(r, set1.containsAll(ref));
            test(r, set1.containsAll(set2));
            test(r, unset1.containsAll(ref));
            test(r, unset1.containsAll(set2));

            test(r, set1.containsAll(unref));
            test(r, set1.containsAll(unset2));
            test(r, unset1.containsAll(unref));
            test(r, unset1.containsAll(unset2));

            //test clear, and equals on an empty set of a different type
            set1.clear();
            test(r, set1.equals(new SortedSet<>()));
            unset1.clear();
            test(r, unset1.equals(new UnsortedSet<>()));
            set2.clear();
            test(r, set2.equals(new UnsortedSet<>()));
            unset2.clear();
            test(r, unset2.equals(new SortedSet<>()));

        }


        System.out.println("ContainsAll");
        //Tests containsAll
        for (int i = 0; i < 50; i++) {
            SortedSet set1 = new SortedSet();
            SortedSet subset1 = new SortedSet();
            UnsortedSet unset1 = new UnsortedSet();
            UnsortedSet unsubset1 = new UnsortedSet();

            for (int k = 0; k < i; k++) {
                set1.add(k);
                unset1.add(k);

                if (k <= (i / 2)) {
                    subset1.add(k);
                    unsubset1.add(k);
                }
            }

            //Test that a set containsAll of its subset.
            test(r, set1.containsAll(subset1));
            test(r, set1.containsAll(unsubset1));

            test(r, unset1.containsAll(unsubset1));
            test(r, unset1.containsAll(subset1));

            //Test that a smaller set can't contain all of a bigger set unless they're equal.
            //----> THIS SHOULD FINISH VERY QUICKLY. EVEN ON LARGE SETS. <----
            if (!subset1.equals(set1) && !subset1.equals(unset1)
                    && !unsubset1.equals(set1) && !unsubset1.equals(unset1)) {
                test(r, !subset1.containsAll(set1));
                test(r, !subset1.containsAll(unset1));
                test(r, !unsubset1.containsAll(set1));
                test(r, !unsubset1.containsAll(unset1));
            }
        }


        System.out.println("Big Stress test- Add, contains, remove");

        //Tests Add, Equals, Contains, Remove
        //This really tests add, a sorted set's ordering, and that there are no duplicates.
        for (int i = 0; i < 500; i++) {
            Collections.shuffle(num);
            SortedSet<Integer> set1 = new SortedSet<>();
            UnsortedSet<Integer> unset = new UnsortedSet<>();
            for (Integer j : num) {
                //Mainly tests sorted order in sorted sets, but also tests if randomly ordered
                //unsorted sets are still equal and contains remove works on them too
                test(r, set1.add(j));
                test(r, unset.add(j));
                //Adding twice tests no repeats
                test(r, !set1.add(j));
                test(r, !unset.add(j));
            }
            test(r, set1.equals(ref));
            test(r, unset.equals(ref));


            test(r, set1.equals(unref));
            test(r, unset.equals(unref));

            for (int k = 0; k < 50; k++) {
                //Test contains, remove, then contains again for a sorted set
                test(r, set1.contains(k));
                test(r, set1.remove(k));
                test(r, !set1.contains(k));
                //Test contains, remove, then contains again for an unsorted set
                test(r, unset.contains(k));
                test(r, unset.remove(k));
                test(r, !unset.contains(k));
            }
        }


        System.out.println("\n\n\nPassed " + ((r[1] * 1.0) / r[0]) * 100 + "% of " + r[0] + " " +
                "tests.");
        System.out.println(r[1] + "/" + r[0]);
    }


    //Test harness, handles output.
    private static void test(int[] results, boolean test) {
        final int PRINT_PER_TESTS = 2_500;
        results[0]++;
        if (!test || results[0] % PRINT_PER_TESTS == 0) {
            if (test) {
                System.out.print("Tests\t" + (results[0] - PRINT_PER_TESTS) + "-" + results[0] + "\t");
            } else {
                System.out.print("Test: " + results[0] + "\t");
            }
        }
        if (test) {
            results[1]++;
            if (results[0] % PRINT_PER_TESTS == 0) {
                System.out.print("\t-\tPassed ");
            }
        } else {
            System.out.print("--------------FAILED------------------- ");
        }
        if (!test || results[0] % PRINT_PER_TESTS == 0) {
            System.out.println("\t-\t" + results[1] + "/" + results[0]);
        }
    }


}
