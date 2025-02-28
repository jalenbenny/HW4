/*
 * *** BEN FLOWERS / COMP 272/400C 002 ***
 *
 * This HashingProblems object contains three methods / problems that you must
 * complete utilize the HashMap object within the Java's Collection Framework Library.
 *
 * The three methods / problems you need to solve are:
 *  - getAverage
 *  - odd
 *  - twoSums
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class HashingProblems {

    /*
     * Method getAverage()
     *
     * This method accepts two parameters. The first is a HashMap object, while the second
     * is an array of integers. This method must compute the average of the values for each
     * 'key' that is found in BOTH the HashMap and the array.
     *
     * For example, if only the keys 1 and 2 from the array are present in the HashMap, and
     * lets say their values were 10 and 20, respectively, then the average is calculated
     * as (10+20)/2 = 15. Lets also say the keys ‘7’ and ‘8’ are in the array, but those keys
     * are not present in the HashMap. That means their corresponding values in the HashMap
     * are not included in the average calculation.
     */

    public double getAverage(HashMap<Integer, Integer> map, int[] array) {
        double sum = 0.0;
        int count = 0;

        // iterate through the array
        for (int key : array) {
            // if the key exists in the HashMap
            if (map.containsKey(key)) {
                // add the value to the sum
                sum += map.get(key);
                // increment count of values found
                count++;
            }
        }

        // if no values found in common, return NaN as specified
        if (count == 0) {
            return 0.0 / 0.0; // Returns NaN
        }

        // calculate and return the average
        return sum / count;
    }


        /*
     * Method odd()
     *
     * This method accepts a HashMap object, and returns an ArrayList object with the
     * values of the corresponding keys that are odd.
     */

    public ArrayList<String> odd(HashMap<Integer, String> map) {

        ArrayList<String> result = new ArrayList<>();

        // iterate through all keys in the HashMap
        for (Integer key : map.keySet()) {
            // check if the key is odd
            if (key % 2 != 0) {
                // add corresponding value to the result
                result.add(map.get(key));
            }
        }

        return result;
    }

    /*
     * Method twoSums()
     *
     * You ARE to solve this problem in time complexity O(n). The submittals will be spot checked.
     *
     * Problem statement:
     * Suppose you are given an integer array containing the values [1,4,5,7,8,9] along with the
     * value k=4, where k is the difference between two array elements. How many times does k appear
     * in that list?
     *
     * With the above numbers, it will be three times:
     *    k = 4
     *    (5 - 1) = k
     *    (8 - 4) = k
     *    (9 - 5) = k
     *    k appears 3 times.
     *
     * All combinations must be considered. But, any other combination of the numbers in the array
     * results in a difference value that is not equal to k (k=4 in this case).
     *
     * This can be solved using nested for-loops, checking all combinations of the values in the array.
     * But the time complexity would be O(n^2).
     *
     * In order to solve this problem in O(n) complexity, utilize a HashMap (or a HashSet).
     *
     * You are two solve this using a HashMap (or you can use a HashSet, which is implemented
     * using HashMap). To solve this, you should populate the HashMap (or HashSet) based on
     * the array (this will be complexity time on the order of 'n'). After populating the HashMap,
     * consider a for-loop that does a lookup (probe) of the HashMap (or HashSet) on each iteration
     * of the loop. This will also have a complexity on the order of 'n', as the hashing probes are a
     * constant time complexity (after removing any constant based on collisions).
     *
     * This will result in a time complexity of O(n) for the overall method.
     *
     * NOTE: Solving using a HashMap or HashSet is fine (either is okay). HashSet may be easier to code?
     */

    public int twoSums(int[] numbers, int k) {

        // hashset for O(1) lookups
        HashSet<Integer> numSet = new HashSet<>();
        int count = 0;

        // all numbers from array in hash set
        for (int num : numbers) {
            numSet.add(num);
        }

        // check for pairs with difference k
        for (int num : numbers) {
            // check if (num + k) exists in the set
            if (numSet.contains(num + k)) {
                count++;
            }
        }

        return count;
    }

} /* end class HashingProblems */
