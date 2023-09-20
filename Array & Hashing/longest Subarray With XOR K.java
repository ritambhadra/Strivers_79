// Optimal Sol TC - O(N*logN) SC - O(N)

import java.util.*;

public class Solution {
    public static int subarraysWithSumK(int []a, int k) {
        // Write your code here

        int n = a.length;
        int xr = 0;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(xr, 1); //setting the value of 0.

        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];  // prefix XOR till index i 
            int x = xr ^ k;  //By formula: x = xr^k

            // add the occurrence of xr^k to the count:
            if (hm.containsKey(x)) 
                count += hm.get(x);
            
            // Insert the prefix xor till index i into the map:
            if (hm.containsKey(xr)) 
                hm.put(xr, hm.get(xr) + 1);
           
            else hm.put(xr, 1);
        }
        return count;
    }
}


