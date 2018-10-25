/*
Given an array of equal-length strings, check if it is possible to rearrange the strings in such a way that after the rearrangement the strings at consecutive positions would differ by exactly one character.

Example:
For inputArray = ["aba", "bbb", "bab"], the output should be
stringsRearrangement(inputArray) = false.
All rearrangements don't satisfy the description condition.

For inputArray = ["ab", "bb", "aa"], the output should be
stringsRearrangement(inputArray) = true.
Strings can be rearranged in the following way: "aa", "ab", "bb".

Input/Output

[execution time limit] 3 seconds (java)

[input] array.string inputArray

A non-empty array of strings of lowercase letters.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i].length ≤ 15.

Test case 1:
Input:
inputArray: ["aba",
 "bbb",
 "bab"]
Expected Output:
false

Test case 2:
Input:
inputArray: ["ab",
 "bb",
 "aa"]
Expected Output:
true

Test case 3:
Input:
inputArray: ["q",
 "q"]
Expected Output:
false

Test case 4:
Input:
inputArray: ["zzzzab",
 "zzzzbb",
 "zzzzaa"]
Expected Output:
true

Test case 5:
Input:
inputArray: ["ab",
 "ad",
 "ef",
 "eg"]
Expected Output:
false

Test case 6:
Input:
inputArray: ["abc",
 "bef",
 "bcc",
 "bec",
 "bbc",
 "bdc"]
Expected Output:
true

Test case 7:
Input:
inputArray: ["abc",
 "abx",
 "axx",
 "abc"]
Expected Output:
false

Test case 8:
Input:
inputArray: ["abc",
 "abx",
 "axx",
 "abx",
 "abc"]
Expected Output:
true
 */

package org.algorithms;

import java.util.Stack;

public class RearrangingStrings {

    public static void main(String[] args) {
        //{"aba", "bbb", "bab"}: FALSE
        // {"q", "q", "q"}: FALSE
        // {"zzzzab", "zzzzbb", "zzzzaa"}: TRUE
        // {"ab", "ad", "ef", "eg"}: FALSE
        // {"abc", "bef", "bcc", "bec", "bbc", "bdc"}: TRUE
        // {"abc", "abx", "axx", "abc"}: FALSE
        // {"abc", "abx", "axx", "abx", "abc"}: TRUE
        String[][] inputs = {{"aba", "bbb", "bab"},{"q", "q", "q"},{"zzzzab", "zzzzbb", "zzzzaa"},
                {"ab", "ad", "ef", "eg"}, {"abc", "bef", "bcc", "bec", "bbc", "bdc"}, {"abc", "abx", "axx", "abc"},
                {"abc", "abx", "axx", "abx", "abc"}};

        for(String[] input : inputs) {
            if(checkRearrangeStrings(input)) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }
    }

    private static boolean checkRearrangeStrings(String[] input) {
        Stack<Integer> path = new Stack<>();
        for(int i = 0; i < input.length; i++) {
            if(doDfs(input, input[i], path)) {
                // This is to print out one of the ways to sort the array
                for(Integer j : path) {
                    System.out.print(input[j] + " ");
                }
                return true;
            }
        }

        return false;
    }

    private static boolean doDfs(String[] input, String str, Stack<Integer> path) {
        if(path.size() == input.length) {
            return true;
        }

        for(int i = 0; i < input.length; i++) {
            if(isDifferOneChar(str, input[i]) && !path.contains(i)) {
                path.push(i);
                if(doDfs(input, input[i], path)) {
                    return true;
                }
                path.pop();
            }
        }

        return false;
    }

    private static boolean isDifferOneChar(String str1, String str2) {
        int countDiffer = 0;

        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                countDiffer++;
            }
        }
        if(countDiffer != 1) {
            return false;
        }

        return true;
    }
}
