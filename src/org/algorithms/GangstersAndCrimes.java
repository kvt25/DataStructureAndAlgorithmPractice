package org.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GangstersAndCrimes {

	public static void main(String[] args) {

		//List<String> gangstersAndCrimes = new ArrayList<String>(Arrays.asList("A,B,C","A","D,E","E,F"));
		
		List<String> gangstersAndCrimes = new ArrayList<String>(Arrays.asList("5,4,3,2,1","1","2","3","4","5"));
		
		
		String res = isOneGang(gangstersAndCrimes);
		
		System.out.println(res);
	}
	
	static String isOneGang(List<String> gangstersAndCrimes) {
		if(gangstersAndCrimes == null || gangstersAndCrimes.isEmpty()) {
			return "FALSE";
		}
		
		StringBuilder allCrimes = new StringBuilder();
		List<String> reviewList = new ArrayList<>();
		allCrimes.append(gangstersAndCrimes.get(0));
        for(int i = 1; i < gangstersAndCrimes.size(); i++) {
        	boolean isHasCrime = false;
        	String allCrimesStr = allCrimes.toString();
        	String s = gangstersAndCrimes.get(i);
        	String[] crimes = s.split(",");
        	for(int j = 0; j < crimes.length; j++) {
        		String c = crimes[j];
        		if(allCrimesStr.contains(c)) {
        			allCrimes.append("," + s);
        			isHasCrime = true;
        			break;
        		}
        	}
        	if(!isHasCrime) {
        		reviewList.add(s);
        	}
        }
        
        if(reviewList.isEmpty()) {
        	return "TRUE";
        } else {
        	String allCrimesStr = allCrimes.toString();
        	for(int k = 0; k < reviewList.size(); k++) {
            	String s = reviewList.get(k);
            	String[] crimes = s.split(",");
            	boolean isHasCrime = false;
            	for(int j = 0; j < crimes.length; j++) {
            		String c = crimes[j];
            		if(allCrimesStr.contains(c)) {
            			isHasCrime = true;
            		}
            	}
            	if(!isHasCrime) {
            		return "FALSE";
            	}
            }
        }
        
        return "TRUE";
    }

}
