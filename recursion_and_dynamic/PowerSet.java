
import java.util.*;
import java.lang.*;

public class PowerSet {

    // return all subsets of a set
    public static List<List<Integer>> getPowerSet(List<Integer> set) {
        
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();

        // base case
        if (set.size() == 1) {
            powerSet.add(set);
            return powerSet;
        }

        // recursive case
        else {
            // get the first element of set
            int first = set.get(0);
            set.remove(0);

            powerSet.addAll(addElementToSet(first, getPowerSet(set)));
        }
        return powerSet;
    }

    public static List<List<Integer>> addElementToSet (int element, List<List<Integer>> set) {
        for (int i = 0; i < set.size(); i++) {
            List<Integer> curr = set.get(i);
            curr.add(element);
        }
        return set;
    }

    public static void main(String[] args) {
        List<Integer> testSet = new ArrayList<Integer>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);

        System.out.print("Before: ");
        System.out.println(testSet);
        System.out.print("After: ");
        System.out.println(getPowerSet(testSet));
    }
}



