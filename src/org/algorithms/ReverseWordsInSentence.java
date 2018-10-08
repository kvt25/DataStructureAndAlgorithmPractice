package org.algorithms;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		/*
		char[] input = {'t','o','d','a','y',' ','i','s',' ','a',' ','g','o','o','d',' ','d','a','y'};
		input = new char[] {'p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','s','e'};
		int wordLeftIndex = 0;
		int wordRightIndex = 0;
		for(int i=0; i<input.length; i++) {
			if(input[i] == ' ') {
				wordRightIndex = i - 1;
			} else if(i==input.length - 1) {
				wordRightIndex = i;
			}
			if(wordRightIndex - wordLeftIndex > 0) {
				swapWord(input, wordLeftIndex, wordRightIndex);
				wordLeftIndex = wordRightIndex + 2;
			}
		}
		swapWord(input, 0, input.length-1);
		printResult(input);
		*/
		String a = "aaa";
		String b = new String("aaa");
		if(a.equals(b)) {
			System.out.println("a==b");
		}
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
