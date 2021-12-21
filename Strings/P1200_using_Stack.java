package com.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class P1200_using_Stack {
	public static void main(String[] args) {
		int[] arr = {1,4,6,10,12,17,19};
		
		List<Integer> inp = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(" inp:"+inp);
		
		List<List<Integer>> result = process(inp);
		System.out.println("res :"+result);

	}

	private static List<List<Integer>> process(List<Integer> inp) {
		Collections.sort(inp);
		System.out.println(" sorted:"+inp);
		
		int min = 1000000;
		
		Stack<List<Integer>> st = new Stack<>();
		List<Integer> tmp = new ArrayList<>();
		
		for(int i=0; i<inp.size(); i++) {
			if(i < inp.size()-1) {
				int diff = inp.get(i+1)-inp.get(i);
				if(diff == min) {
					min = diff;
					// do not pop
					// save inp(i) & inp(i+1)
					tmp.clear();
					tmp.add(Integer.valueOf(inp.get(i)));
					tmp.add(Integer.valueOf(inp.get(i+1)));
					st.push(new ArrayList<>(tmp));
				}
				else if( diff < min) {
					min = diff;
					// pop
					// save inp(i) & inp(i+1)
					st.clear(); // extra
					tmp.clear();
					tmp.add(Integer.valueOf(inp.get(i)));
					tmp.add(Integer.valueOf(inp.get(i+1)));
					st.push(new ArrayList<>(tmp));
				}
				
			}
		}
		
		return st.stream().collect(Collectors.toList());
	}
}
