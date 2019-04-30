package dynamic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  
	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {
		int sum = 0;
		int[] sumArr = new int[arr.length];
		for (int i = 0; i < arr.length - 2; i++) {
			sum = findCombination(i, arr.length, arr, sum , sumArr);
		}
		return sum;
	}

	private static int findCombination(int start, int end, int[] arr, int sum , int[] sumArr) {
		int i = 0;
		while (i<2) {
		
			sumArr[i] = findMaximumSum(i, arr , sumArr);
			i++;
		}
		return  findTheLargestVal(sumArr , arr );
		 
	}

	private static int findTheLargestVal(int[] sumArr , int[] arr) {
		int max = 0 ;
		for(int i = 0 ; i < arr.length ; i++){
			    for(int j = i + 2 ; j < arr.length ; j++){
			    	if(arr[i] + arr[j] > sumArr[i]){
			    		sumArr[i] = arr[i] + arr[j];
			    	
			    }
			    		
		 }
		}
		
		int result = 0;
		for(int  i = 0 ; i < sumArr.length ; i++){
			if(sumArr[i] > result){
				result = sumArr[i];
			}
		}
		return result;
		
	}

	private static int findMaximumSum(int adjacent, int[] arr , int[] sumArr) {
		if (adjacent > arr.length - 1) {
				return 0;
		}
	
		return  sumArr[adjacent] = arr[adjacent] +  findMaximumSum(adjacent + 2, arr , sumArr);
		
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[] arr = {3,7,4,6,5};

		int res = maxSubsetSum(arr);
		System.out.println(res);

	}
}
