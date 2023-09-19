// Majority element is the element that appears more than ⌊n / 2⌋ times
import java.util.*;
public class Solution {
    public static int majorityElement(int []v) {
        // Write your code here
        int element = 0;
        int count = 0;

        for(int i : v){
            if(count == 0) element = i;
            count += (i == element) ? 1 : -1; 
        }
        
        return element;
    }
}


// Majority element is the element that appears more than ⌊n / 3⌋ times

import java.util.*;
public class Solution {
    public static List< Integer > majorityElement(int []v) {
        int n = v.length;
        List <Integer> ans = new ArrayList<>();
        
        //Better Solution using extra space
        
        // HashMap<Integer, Integer> hm = new HashMap<>();

        // int count = (int) (n/3) +1;

        // for(int i = 0 ; i < n ; i++){
        //     int value = hm.getOrDefault(v[i], 0);
        //     hm.put(v[i], value+1);

        //     if(hm.get(v[i]) == count) ans.add(v[i]);
        //     if(ans.size() == 2) break;
        // }
        // return ans;

	//Optimal Solution without using extra space
        int eli1 = Integer.MIN_VALUE;
        int eli2 = Integer.MIN_VALUE;
        int count1 = 0; int count2 = 0;

        for(int i : v){
            if(count1 == 0 && i != eli2){
                count1 = 1;
                eli1 = i;
            } else if ( count2 == 0 && i != eli1 ){
                count2 = 1;
                eli2 = i;
            } 
            else if ( i == eli1 ) count1 ++;
            else if (i == eli2) count2++;
            else {
                count1--; count2--;
            }
        }
        count1 = 0; count2 = 0;

        for(int i : v){
            count1 += (i == eli1) ? 1 : 0;
            count2 += (i == eli2) ? 1 : 0;
        }

        int min = n/3 + 1;
        if(count1 >= min) ans.add(eli1);
        if(count2 >= min) ans.add(eli2);

        return ans;
    }
}

