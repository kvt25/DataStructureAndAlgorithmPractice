/*
Given an input string, reverse the string word by word in-place (without using additional array)

Example:  

Input: "today is a good day",
Output: "day good a is today".
 */

package org.algorithms;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		String inputStr = "today is a good day";
		char[] inputArray = inputStr.toCharArray();
		int wordLeftIndex = 0;
		int wordRightIndex = 0;
		for(int i=0; i < inputArray.length; i++) {
			if(inputArray[i] == ' ') {
				wordRightIndex = i - 1;
			} else if(i == inputArray.length - 1) {
				wordRightIndex = i;
			}
			if(wordRightIndex - wordLeftIndex > 0 || (wordLeftIndex > 0 && wordRightIndex > 0 && wordLeftIndex == wordRightIndex)) {
				swapWord(inputArray, wordLeftIndex, wordRightIndex);
				wordLeftIndex = wordRightIndex + 2;
			}
		}
		swapWord(inputArray, 0, inputArray.length-1);
		printResult(inputArray);
	}

	private static void printResult(char[] input) {
		for(char c : input) {
			System.out.print(c);
		}
	}

	private static void swapWord(char[] input, int wordLeftIndex, int wordRightIndex) {
		int i = 0;
		while(i<=(wordRightIndex - wordLeftIndex)/2) {
			char temp = input[wordLeftIndex + i];
			input[wordLeftIndex + i] = input[wordRightIndex - i];
			input[wordRightIndex - i] = temp;
			i++;
		}
	}
}
