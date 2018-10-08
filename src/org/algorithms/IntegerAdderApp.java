/* 
Integer Adder

Given two numbers that are represented as arrays of their digits, write a function that returns the sum of the two numbers.
Each number is represented by an array of integers from 0 to 9, with the first element being the most significant digit of a number and the last element being the least significant digit.
Note: Try to solve this task using only addition between digits.
Example
* For a = [1, 0] and b = [5], the output should be integerAdder(a, b) = [1, 5];
* For a = [2, 6] and b = [3, 4], the output should be integerAdder(a, b) = [6, 0].

Input/Output
* [execution time limit] 4 seconds
* [input] array.integer a 
  Guaranteed constraints: 1 ≤ a.length ≤ 50, 0 ≤ a[i] ≤ 9.
* [input] array.integer b 
  Guaranteed constraints: 1 ≤ b.length ≤ 50, 0 ≤ b[i] ≤ 9.
* [output] array.integer
    * The result of adding a and b together
 */

package org.algorithms;

public class IntegerAdderApp {

	public static void main(String[] args) {
		int[] a = new int[] { 5 };
		int[] b = new int[] { 9, 9, 9 };
		int[] result = integerAdder(a, b);
		for (int i : result) {
			System.out.println(i);
		}
	}

	static int[] integerAdder(int[] a, int[] b) {
		int resultIndex = a.length > b.length ? a.length + 1 : b.length + 1;
		int[] result = new int[resultIndex];
		int i = a.length - 1;
		int j = b.length - 1;
		int remaining = 0;
		while (i >= 0 || j >= 0) {
			int a1 = 0;
			int a2 = 0;
			if (i >= 0) {
				a1 = a[i];
			}
			if (j >= 0) {
				a2 = b[j];
			}

			int sum = a1 + a2 + remaining;
			if (sum >= 10) {
				sum = sum - 10;
				remaining = 1;
			} else {
				remaining = 0;
			}
			result[resultIndex - 1] = sum;
			resultIndex--;
			i--;
			j--;
		}
		if (remaining == 1) {
			result[0] = 1;
		}
		if (remaining == 0) {
			int[] result2 = new int[result.length - 1];
			for (int k = 0; k < result2.length; k++) {
				result2[k] = result[k + 1];
			}
			return result2;
		}

		return result;
	}

}

