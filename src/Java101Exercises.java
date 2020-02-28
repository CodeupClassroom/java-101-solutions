import java.util.ArrayList;
import java.util.List;

/**
 * This file has a set of Java exercises to use for improve your skill level in Java and preparing you for coding
 * interview questions. There are five levels of problems. As you improve you can move up levels.
 *
 * LEVELS:
 *          BASIC
 *          EASY
 *          INTERMEDIATE
 *          DIFFICULT
 *          ADVANCED
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
}
