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
    public static int addInts001(int a, int b) {
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
    public static double preformIndicatedOperation011(String operation, double op1, double op2) {

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
    public static ArrayList<Integer> findFactors012(int num) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= num; i++){
            if (num % i == 0){
                numbers.add(i);
            }
        }
        return numbers;
    }

    /**
     * Exercise 013 - Real Integer sum Addends
     * Given a two double parameters, return the nearest integer sum. If a number is half-way between to integers,
     * round up for positive sums and down for negative sums.
     *
     * LEVEL: EASY
     *
     * @param p1    First real number
     * @param p2    Second real number
     * @return      Integer sum
     */
    public static int getNearestIntegerToRealSum013(double p1, double p2 ) {
        double dSum = p1 + p2;
        double offset = 0.5;
        if (dSum < 0.0) {
            dSum -= offset;
        } else {
            dSum += offset;
        }
        int sum = (int) dSum;
        return sum;
    }

    /**
     * Exercise 014 - Is it a number
     * Given a string s, write a method (function) that will return true if its a valid single integer or floating
     * point number or false if its not.
     *
     * LEVEL: EASY
     *
     * Valid examples, should return true:
     * isDigit("3")
     * isDigit("  3  ")
     * isDigit("-3.23")
     *
     * should return false:
     * isDigit("3-4")
     * isDigit("  3   5")
     * isDigit("3 5")
     * isDigit("zero")
     *
     * @param stringToTest
     * @return              True if number, false if not.
     */
    public static boolean isNumber014(String stringToTest) {
        stringToTest.trim();
        try {
            Double.parseDouble(stringToTest);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Exercise 015 - Find Two Addends
     * Given a primitive array of integers a number n, return whether any two numbers from the array add up to equal n.
     * For example, given [7, 15, 3, 6, 8] and n equal to 13, return true since 7 + 6 is 13.
     *
     * LEVEL: EASY
     *
     * @param nums
     * @param n
     * @return
     */
    public static boolean findTwoAddends015(int[] nums, int n) {

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
    public static List<Integer> multiplyElementsOfList041(List<Integer> iList) throws Exception {

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
    public static ArrayList<Integer> findFactorsEfficiently071(int num) {
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

    /**
     * Exercise 072 - Roman numeral conversion
     * Given a roman numeral in a string, convert it to an integer (int). Do not worry about any roman digits past
     * M (1000).
     *
     * I = 1
     * V = 5
     * X = 10
     * L = 50
     * C = 100
     * D = 500
     * M = 1000
     *
     * LEVEL: DIFFICULT
     *
     * @param romanNumeral      The roman numeral to convert
     * @return                  The equivalent integer
     */
    public static int convertRomanNumeral072(String romanNumeral) {

        int total = 0;
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;

        char thePreviousChar = ' ';
        for (int i = 0; i < romanNumeral.length(); i++) {
            if (romanNumeral.charAt(i) == 'M'){
                total += M;
            } else if (romanNumeral.charAt(i) == 'D') {
                total += D;
            } else if (romanNumeral.charAt(i) == 'C') {
                if (thePreviousChar == 'C') total += C;
                else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i+1) == 'M'){
                    total += M - C;
                    i++;
                } else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i+1) == 'D'){
                    total += D - C;
                    i++;
                } else total += C;
            } else if (romanNumeral.charAt(i) == 'L') {
                total += L;
            } else if (romanNumeral.charAt(i) == 'X') {
                if (thePreviousChar == 'X') total += X;
                else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i+1) == 'C'){
                    total += C - X;
                    i++;
                } else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i+1) == 'L'){
                    total += L - X;
                    i++;
                } else total += X;
            } else if (romanNumeral.charAt(i) == 'V') {
                total += V;
            } else if (romanNumeral.charAt(i) == 'I') {
                if (thePreviousChar == 'I') total += I;
                else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i+1) == 'X') {
                    total += X - I;
                    i++;
                } else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i+1) == 'V') {
                    total += V - I;
                    i++;
                } else total += I;
            }
            thePreviousChar = romanNumeral.charAt(i);
        }
        return total;
    }
}
