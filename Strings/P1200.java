package com.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P_1200_Min_Abs_Diff {
	public static void main(String[] args) {
		//List<Integer> inp = Arrays.asList(3,8,-10,23,19,-4,-14,27);
		
		//System.out.println("Inp:"+inp);
		
		//min_abs_diff(inp);
		
		//int[] arr = {1,3,6,10,15};
		int[] arr = {3,8,-10,23,19,-4,-14,27};
		List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
		res = minimumAbsDifference(arr);
		System.out.println("res:"+res);
	}

	private static List<List<Integer>> minimumAbsDifference(int[] arr) {
		int min = 10000000;
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		List<List<Integer>> tmp = new ArrayList<>(new ArrayList<>());
		List<Integer> tmp1 = new ArrayList<>();
		
		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(l);
		System.out.println("inp:"+l);
		
		for(int i=0; i<l.size(); i++) {
			if(i < l.size()-1) {
				int diff = l.get(i+1)-l.get(i);
				if(diff <= min) {
					min = diff;
					System.out.println("min:"+min);
					if(map.containsKey(min)) {
						System.out.println("contains key :"+min);
						tmp.clear();
						tmp1.clear();
						
						tmp1.add(l.get(i+1));
						tmp1.add(l.get(i));
						
						List<List<Integer>> e = new ArrayList<>();
						e =map.entrySet().stream().map(x ->x.getValue()).flatMap(List::stream).collect(Collectors.toList());
						System.out.println("e:"+e);
						
						
						tmp.addAll(e);      // extra
						tmp.add(new ArrayList<>(tmp1));
						map.put(Integer.valueOf(min), new ArrayList<>(new ArrayList<>(tmp)));
					}
					else {
						map.clear();
						tmp.clear();
						tmp1.clear();
						
						tmp1.add(l.get(i+1));
						tmp1.add(l.get(i));
						tmp.add(new ArrayList<>(tmp1));
						map.put(Integer.valueOf(min), new ArrayList<>(new ArrayList<>(tmp)));
					}
				}
			}
		}
		List<List<Integer>> mapValues = map.entrySet().stream().map(x->x.getValue()).flatMap(List::stream).collect(Collectors.toList());
		System.out.println("mapValues:"+mapValues);
		return mapValues;
	}

	}