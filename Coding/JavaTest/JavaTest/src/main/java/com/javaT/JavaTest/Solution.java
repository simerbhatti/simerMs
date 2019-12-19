package com.javaT.JavaTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
	/**
	 *
	 * @param A is Lower range
	 * @param B is Higher Range
	 * @param K is Divisor
	 * @return
	 */
	public static int intcount_divisible(int A, int B, int K) {
		   int leftBoundryOffset = 0;
		   if ( A % K == 0) { ++leftBoundryOffset; }
		   return  (B/K) - (A /K) + leftBoundryOffset;
		}

	public static void main(String[] args) {
		countPairs(new Long[]{10000000000L, 3L, 20000000000L, 2L, 25L}, 30000000000L);
	}



	public static int countPairs(Long[] arrayOfNumbers, Long sum) {
		int res=0;
		 List<Integer> list = new LinkedList<>();
		    list.add(0);
		    while (true) {
		    	Integer i = list.get(list.size()-1);
		        if (i == arrayOfNumbers.length - 1) {
		            list.remove(list.size()-1);
		            if (list.isEmpty()) {
		                break;
		            }
		            Integer last = list.remove(list.size()-1);
		            list.add(last + 1);
		        } else {
		            list.add(i + 1);
		        }
		        if (list.stream().map(j -> arrayOfNumbers[j]).mapToLong(Long::longValue).sum() == sum) {
		            res++;
		        }
		    }
		    System.out.println(res);
		    return res;

	}
}

