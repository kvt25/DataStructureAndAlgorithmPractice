package org.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		//List<Integer> a = new ArrayList<Integer>(Arrays.asList(2,4,5,9,9));
		List<Integer> a = null;
		List<Integer> b = null;
		
		List<Integer> c = mergeArrays(a,b);
		for(int k : c) {
			System.out.println(k);
		}
	}
	
	static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
		List<Integer> c = new ArrayList<Integer>(); 
		if(a == null || a.isEmpty()) {
			return b;
		} else if(b == null || b.isEmpty()) {
			return a;
		}
		int i = 0;
		int j = 0;
		while(i < a.size() && j < b.size()) {
			if(a.get(i) <= b.get(j)) {
				c.add(a.get(i));
				i++;
			} else {
				c.add(b.get(j));
				j++;
			}
		}
		if(i == a.size() - 1) {
			for(; j < b.size(); j++ ) {
				c.add(b.get(j));
			}
		} else {
			for(; i < a.size(); i++ ) {
				c.add(a.get(i));
			}
		}

		return c;
    }

}
