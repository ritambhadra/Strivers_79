// BruteForce sol--- tc - O(n^3)
import java.util.*;

public class tUf {
    public static int getLongestSubarray(int []a, int k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            for (int j = i; j < n; j++) { // ending index
                // add all the elements of
                // subarray = a[i...j]:
                int s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }


// Better sol--- tc - O(n^2)

import java.util.*;

public class Solution {
    public static int getLongestSubarray(int []a, int k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            int s = 0;
            for (int j = i; j < n; j++) { // ending index
                // add the current element to
                // the subarray a[i...j-1]:
                s += a[j];

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
}



// Optimal sol--- tc - O(N*logN) SC. O(N)
// This Solution is optimal for Longest Subarray with sum K [Positives and Negatives] 
// but better for  Longest Subarray with sum K  [ONLY Postives]

import java.util.* ;
import java.io.*; 
import java.lang.Math.*;
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		int sum = 0; int maxLength = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0 ; i < nums.length; i++){ 
			sum += nums[i];
			int remaining = sum - k;

			if(sum == k) maxLength = Math.max(maxLength, i+1);

			if (hm.containsKey(remaining)) {
				int length = i - hm.get(remaining);
				maxLength = Math.max(maxLength, length);
			}

			if (!hm.containsKey(sum)) 
                	hm.put(sum, i);
		}
		return maxLength;
	}
}
        


// Optimal sol for  Longest SubArray with sum K  [ONLY Positives] with TC of O(2N)
// Because only outer while loop will run n times

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int start = 0 ; 
        int end = 0;
        int maxLen = 0;
        long sum = a[0];
        int n = a.length;
        
        while(end < n){
            while(start <= end && sum > k)
                sum -= a[start++];
            
            int len = (end - start) + 1;
            if(sum == k) maxLen = Math.max(maxLen, len);

            end++;
            if(end < n) sum += a[end];
        }
        
        return maxLen;
    }
}
