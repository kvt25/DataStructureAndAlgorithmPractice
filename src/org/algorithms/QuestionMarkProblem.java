/*
Using the Java language, have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers, letters, and question marks, and check if there are exactly 3 question marks between every pair of two numbers that add up to 10. If so, then your program should return the string true, otherwise it should return the string false. If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
*/
package org.algorithms;

public class QuestionMarkProblem {

	public static void main(String[] args) {
		String inputStr = "ac4???fr5005???7??3";

		//version1(inputStr);
		version2(inputStr);
	}

	private static void version2(String inputStr) {
		int firstNumber = 0;
		boolean hasQuestionMark = false;
		int i = 0;
		while(i < inputStr.length()) {
			if (Character.isDigit(inputStr.charAt(i))) {
				int value = Character.getNumericValue(inputStr.charAt(i));
				if (hasQuestionMark && firstNumber + value == 10) {
					System.out.println("true");
					return;
				} else {
					firstNumber = value;
					hasQuestionMark = false;
				}
				i++;
			} else if (inputStr.charAt(i) == '?' && i + 1 < inputStr.length() && i + 2 < inputStr.length() && inputStr.charAt(i + 1) == '?' && inputStr.charAt(i + 2) == '?') {
				hasQuestionMark = true;
				i += 2;
			} else {
				i++;
			}
		}
		System.out.println("false");
	}

	private static void version1(String inputStr) {
		int firstIdx = -1;
		int firstNumber = 0;

		for (int i = 0; i < inputStr.length(); i++) {
			if (Character.isDigit(inputStr.charAt(i))) {
				int value = Character.getNumericValue(inputStr.charAt(i));

				if (firstNumber + value == 10) {
					int questionMark = inputStr.indexOf("???", firstIdx);
					if (questionMark > 0 && questionMark <= i) {
						System.out.println("true");
						return;
					}
				} else {
					firstIdx = i;
					firstNumber = value;
				}

			}
		}
		System.out.println("false");
	}

}
