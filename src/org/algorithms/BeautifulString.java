/*
A string is said to be beautiful if b occurs in it no more times than a; c occurs in it no more times than b; etc.

Given a string, check whether it is beautiful.

Example

For inputString = "bbbaacdafe", the output should be
isBeautifulString(inputString) = true;
For inputString = "aabbb", the output should be
isBeautifulString(inputString) = false;
For inputString = "bbc", the output should be
isBeautifulString(inputString) = false.
Input/Output

[execution time limit] 4 seconds (js)

[input] string inputString

A string of lowercase letters.

Guaranteed constraints:
3 ≤ inputString.length ≤ 50.

[output] boolean

Test case 1:
Input:
inputString: "bbbaacdafe"
Expected Output:
true

Test case 2:
Input:
inputString: "aabbb"
Expected Output:
false

Test case 3:
Input:
inputString: "bbc"
Expected Output:
false

Test case 4:
Input:
inputString: "bbbaa"
Expected Output:
false

Test case 5:
Input:
inputString: "abcdefghijklmnopqrstuvwxyzz"
Expected Output:
false

Test case 6:
Input:
inputString: "abcdefghijklmnopqrstuvwxyz"
Expected Output:
true
 */

package org.algorithms;

public class BeautifulString {
    public static void main(String[] args) {
        // ASCII table for a to z is 97 to 122
        String[] inputs = {"bbbaacdafe", "aabbb", "bbc", "bbbaa", "abcdefghijklmnopqrstuvwxyzz", "abcdefghijklmnopqrstuvwxyz"};
        for (String s : inputs) {
            int[] allLowercaseLetters = new int[26];
            char[] inputChars = s.toCharArray();
            for (int i = 0; i < inputChars.length; i++) {
                int c = inputChars[i] - 97;
                allLowercaseLetters[c]++;
            }

            boolean isBeautiful = true;
            for (int k = 0; k < allLowercaseLetters.length - 1; k++) {
                if (allLowercaseLetters[k + 1] > allLowercaseLetters[k]) {
                    isBeautiful = false;
                    break;
                }
            }

            if (isBeautiful) {
                System.out.println("input: " + s + " - true");
            } else {
                System.out.println("input: " + s + " - false");
            }
        }
    }
}
