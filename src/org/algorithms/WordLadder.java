/*
Word Ladder is a fun and interesting word game that involves transforming one word into another, by changing exactly one letter at a time and maintaining a valid word at each step.

example

In this task, you'll be given startWord and goalWord, and your task is to find a word ladder that connects them, using words from the usableWords list.

Normally the goal would be to find the shortest ladder that connects startWord and goalWord, but in this case, we're interested in finding the longest possible word ladder. We're not allowed to re-use words from the list (otherwise the ladder could end up being infinitely long), but some words might appear more than once in usableWords, in which case we can use them as many times as they appear.

If it's not possible to form a word ladder with the given inputs, return []. Otherwise, return the word ladder as an array of strings, beginning with startWord ending with goalWord, and with all the selected words from usableWords in between.

If there are multiple possible answers, return the lexicographically smallest one.

Example

For startWord = "code", goalWord = "dope", and usableWords = ["cone", "bonk", "none", "dole", "tune", "node", "mode", "nope", "mole"], the output should be

longestWordLadder(startWord, goalWord, usableWords) = [
  "code",
  "cone",
  "none",
  "nope",
  "node",
  "mode",
  "mole",
  "dole",
  "dope"
]
Although it's possible to get from startWord to goalWord in just 3 moves ("code" -> "node" -> "nope" -> "dope"), the ladder can be a lot longer than that. Also note that even though we're trying to find the lexicographically smallest option amongst the longest word ladders, this doesn't necessarily mean they'll be in order - for example, "nope" comes before "node", so that it can connect with "mode".

For startWord = "functional", goalWord = "javascript", and usableWords = ["incredible", "programmer"], the output should be longestWordLadder(startWord, goalWord, usableWords) = [].

There's no possible way to form a ladder with these inputs.

Input / Output

[execution time limit] 3 seconds (java)

[input] string startWord

A string representing the starting word.

Guaranteed constraints:
1 ≤ startWord.length ≤ 10
startWord[i] ∈ {"a" - "z"}

[input] string goalWord

A string representing the finishing word.

Guaranteed constraints:
goalWord.length = startWord.length
goalWord[i] ∈ {"a" - "z"}

[input] array.string usableWords

An array of strings we can use to connect startWord to goalWord through a series of single-letter differences.

Guaranteed constraints:
0 ≤ usableWords.length ≤ 1000
usableWords[i].length = startWord.length
usableWords[i][j] ∈ {"a" - "z"}

[output] array.string

An array of strings representing the longest possible word ladder (the lexicographically smallest one if it's a tie).
 */

package org.algorithms;

import java.util.Stack;

public class WordLadder {

    public static void main(String[] args) {
        String startWord = "code";
        String goalWord = "dope";
        String[] usableWords = {"cone","cnde","bonk", "none", "dole", "tune", "node", "mode", "nope", "mole"};

        getLongestWordLadder(usableWords, startWord, goalWord);
    }

    private static boolean getLongestWordLadder(String[] usableWords, String startWord, String goalWord) {
        Stack<Integer> path = new Stack<>();
        for(int i = 0; i < usableWords.length; i++) {
            if(isDifferOneChar(startWord, usableWords[i])) {
                path.push(i);
                if(!doDfsToGoal(usableWords, usableWords[i], path, startWord, goalWord)) {
                    System.out.println(usableWords[i]);
                    path.pop();
                }
            } else {
                path.clear();
            }
        }

        return false;
    }

    private static boolean doDfsToGoal(String[] usableWords, String aWord, Stack<Integer> path, String startWord, String goalWord) {
        for(int i = 0; i < usableWords.length; i++) {
            if(isDifferOneChar(aWord, usableWords[i]) && !path.contains(i)) {
                path.push(i);
                if(doDfsToGoal(usableWords, usableWords[i], path, startWord, goalWord)) {
                    printPath(usableWords, startWord, goalWord, path);
                }
                path.pop();
            }
        }

        if(path.size() > 0 && isDifferOneChar(usableWords[path.peek()], goalWord)) {
            return true;
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

    private static void printPath(String[] usableWords, String startWord, String goalWord, Stack<Integer> path) {
        System.out.print(startWord + " ");
        for(Integer j : path) {
            System.out.print(usableWords[j] + " ");
        }
        System.out.println(goalWord + " ");
    }
}
