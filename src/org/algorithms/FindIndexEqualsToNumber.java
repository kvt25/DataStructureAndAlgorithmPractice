package org.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindIndexEqualsToNumber {

	public static void main(String[] args) {
		int[] input = {2, 11, 5, 1, 4, 7};
		int sum = 5;
		Map<Integer, Integer> map = new HashMap<>();
		int idx1=0;
		int idx2=0;
		for(int i=0; i<input.length; i++) {
			if(map.get(sum - input[i]) != null) {
				idx1 = i;
				idx2 = map.get(sum - input[i]);
				break;
			} else {
				map.put(input[i], i);
			}
		}
		
		System.out.println("idx1=" + idx1 + " - value=" + input[idx1]);
		System.out.println("idx2=" + idx2 + " - value=" + input[idx2]);
		
		checkTwoElementsEqualsToRestOfArray(input);
	}

	static void checkTwoElementsEqualsToRestOfArray(int[] input) {
		int sum = 0;
		for(int i : input) {
			sum+=i;
		}
		sum /= 2;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<input.length; i++) {
			int temp = sum - input[i];
			if(set.contains(temp)) {
				System.out.println("num1=" + temp + " - val2=" + input[i]);
				break;
			}
			set.add(input[i]);
		}
	}
}
