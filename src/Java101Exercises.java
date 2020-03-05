import java.util.ArrayList;
import java.util.List;

/**
 * This file has a set of Java exercises to use for improve your skill level in Java and preparing you for coding
 * interview questions. There are five levels of problems. As you improve you can move up levels.
 *
 * LEVELS:
 *          BASIC               Exercise 001 - 010
 *          EASY                Exercise 011 - 040
 *          INTERMEDIATE        Exercise 041 - 070
 *          DIFFICULT           Exercise 071 - 090
 *          ADVANCED            Exercise 091 - 101
 *
 */

public class Java101Exercises {

    /**
     * Write a method to add to integers (int) and return the sum.
     *
     * LEVEL: BASIC
     *
     * @param a     First number to add
     * @param b     Second number to add
     * @return      The sum
     */
    public static int exercise001(int a, int b) {
        // add operands
        return a + b;
    }

    /**
     * Exercise 002 - Find Two Addends
     * Given a primitive array of integers a number n, return whether any two numbers from the array add up to equal n.
     * For example, given [7, 15, 3, 6, 8] and n equal to 13, return true since 7 + 6 is 13.
     *
     * LEVEL: BASIC
     *
     * @param nums
     * @param n
     * @return
     */
    public static boolean exercise002(int[] nums, int n) {

        // Check input
        if (nums == null || nums.length < 2) return false;

        // loop to find sums
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == n) return true;
            }
        }

        return false;
    }

    /**
     * Write a method with 3 parameters; a String and 2 doubles. The string will be an operation that the operation
     * needs to process on the two operands. Return the result if the operation. Return 0.0 if the operation is not
     * one of the four specified. The operation should be case sensitive.
     *
     * LEVEL: EASY
     *
     * @param operation     ADD, SUB, MUL, DIV
     * @param op1           First operand
     * @param op2           Second operand
     * @return              Result
     */
    public static double exercise011(String operation, double op1, double op2) {

        switch (operation) {
            case ("ADD"):
                return op1 + op2;
            case ("SUB"):
                return op1 - op2;
            case ("MUL"):
                return op1 * op2;
            case ("DIV"):
                return op1 / op2;
            default:
                // do nothing;
        }
        return 0;
    }

    /**
     * Exercise 012 - Find Factors
     * Find all of the factors for a given positive integer (int). The result needs to be sorted in ascending order.
     *
     * LEVEL: EASY
     *
     * @param num       The number to be factored
     * @return          An Integer ArrayList of factors of num.
     */
    public static ArrayList<Integer> exercise012(int num) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= num; i++){
            if (num % i == 0){
                numbers.add(i);
            }
        }
        return numbers;
    }

    /**
     * Given an array of integers, return a new array such that each element at index i of the new array is the product
     * of all the numbers in the original array except the one at i.
     *
     * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input
     * was [3, 2, 1], the expected output would be [2, 3, 6].
     *
     * LEVEL:   INTERMEDIATE
     *
     * @param iList         An array of integers
     * @return              An array of products of integers
     * @throws Exception    Invalid input should throw an exception
     */
    public static List<Integer> exercise041(List<Integer> iList) throws Exception {

        // validate input
        if (iList == null || iList.isEmpty()) throw new Exception("NULL or empty Integer list.");

        // loop to calculate the product of the entire list
        int product = iList.get(0);
        for (int i = 1; i < iList.size(); i++) {
            product *= iList.get(i).intValue();
        }

        // loop to calculate product with this element
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < iList.size(); i++) {
            results.add(product / iList.get(i));
        }
        return results;
    }

    /**
     * Exercise 071 - Find Factors Efficiently
     * Find all of the factors for a given integer (int). The integer could be negative. The result needs to be sorted
     * in ascending order.
     *
     * The solution must be able to find the factors for 2080046 in less than 200000 nano-seconds. (ms/1000000).
     *
     * LEVEL: DIFFICULT
     *
     * @param num       The number to be factored
     * @return          An Integer ArrayList of factors of num.
     */
    public static ArrayList<Integer> exercise071(int num) {
        ArrayList<Integer> factors = new ArrayList<>();

        // setup
        boolean isNeg = false;
        if (num < 0) {
            num *= -1;
            isNeg = true;
        }

        // initialize the limit
        int limit = num/2;

        int i = 2;
        int pos = 0;
        factors.add(pos, 1); // 1 is always a factor
        pos++;
        while (i <= limit) {
            if (num%i == 0) {
                factors.add(pos, i);
                pos++;
                if (i != num/i) {
                    factors.add(pos, num/i);
                }
            }
            limit = num/i;
            i++;
        }
        if (num != 1) factors.add(num); // the target number is always a factor, but it could be 1

        // add negatives
        if (isNeg) {
            int length = factors.size() * 2;
            for (int j = 0; j < length; j += 2) {
                factors.add(0, -1*factors.get(j));
            }
        }

        return factors;
    }
}
