/*
Given array of integers, find the maximal possible sum of some of its k consecutive elements.

Example

For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
arrayMaxConsecutiveSum(inputArray, k) = 8.
All possible sums of 2 consecutive elements are:

2 + 3 = 5;
3 + 5 = 8;
5 + 1 = 6;
1 + 6 = 7.
Thus, the answer is 8.
Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer inputArray

Array of positive integers.

Guaranteed constraints:
3 ≤ inputArray.length ≤ 105,
1 ≤ inputArray[i] ≤ 1000.

[input] integer k

An integer (not greater than the length of inputArray).

Guaranteed constraints:
1 ≤ k ≤ inputArray.length.

[output] integer

The maximal possible sum.

Input:
inputArray: [2, 3, 5, 1, 6]
k: 2
Expected Output:
8

Input:
inputArray: [2, 4, 10, 1]
k: 2
Expected Output:
14

Input:
inputArray: [1, 3, 2, 4]
k: 3
Expected Output:
9

Input:
inputArray: [3, 2, 1, 1]
k: 1
Expected Output:
3
 */
package org.algorithms;

public class ArrayMaxConsecutiveSum {
    public static void main(String[] args) {
        int[] input = {1,3,2,4};
        int k = 3;

        System.out.println(calculateArrayMaxConsecutiveSum(input, k));
    }

    private static int calculateArrayMaxConsecutiveSum(int[] input, int k) {
        int max = 0;
        int sumConsecutive = 0;

        for (int i = 0; i < k; i++) {
            sumConsecutive += input[i];
        }
        max = sumConsecutive;

        for (int i = 1; i <= input.length - k; i++) {
            sumConsecutive = sumConsecutive - input[i-1] + input[i+k-1];
            if(sumConsecutive > max) {
                max = sumConsecutive;
            }
        }

        return max;
    }
}
