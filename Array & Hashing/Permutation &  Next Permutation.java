// Next Permutation

import java.util.*;
public class Solution {
    public static List< Integer > nextGreaterPermutation(List< Integer > a) {
        int n = a.size();
        int ind = -1; // break point
        
        // FInding the break point
        for(int i = n -2 ; i >=0 ; i--){
            if(a.get(i) < a.get(i+1)){
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            reverse(a, 0, n-1);
            return a;
        } else { 
            // If break point exists
            // Step 2: Find the next greater element and swap it with arr[ind]:
            for(int i = n -1; i >= ind; i--){
                if(a.get(i) > a.get(ind)){
                    swap(a, i, ind);
                    break;
                }
            }
        }
        
        // Step 3: reverse the right half:
        reverse(a, ind +1, n-1);
        return a;
    }
    public static void swap(List<Integer> a, int i, int ind){
        int temp = a.get(i);
        a.set(i, a.get(ind));
        a.set(ind, temp);
    }
    public static void reverse(List<Integer> a, int i , int j){
        while(i <= j)
            swap(a, i++, j--);
    }
}


// Finding All the permutation using extra space 
class Solution {
  public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> ds = new ArrayList<>();
      boolean[] freq = new boolean[nums.length];
      recursion(nums, ds, ans, freq);
      return ans;
  }

  public void recursion(int[]nums, List<Integer>ds, List<List<Integer>>ans, boolean[]freq){
    if(nums.length == ds.size()){
        ans.add(new ArrayList(ds));
        return;
      }

      for(int i = 0 ; i < nums.length; i++){
        if(!freq[i]){
          freq[i] = true;
          ds.add(nums[i]);
          recursion(nums, ds, ans, freq);
          ds.remove(ds.size() - 1);
          freq[i] = false;
        }
      }
  }
}

// Finding All the permutation without using extra space || Most Optimal
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      recursion(0, nums, ans);
      return ans;
    }

    public void recursion(int index, int[] nums, List<List<Integer>>ans){
      if(nums.length == index){
        List<Integer> ls = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++)
          ls.add(nums[i]); 

        ans.add(new ArrayList(ls));
        return;     
      }

      for(int i = index ; i < nums.length ; i++){
        swap(i, index, nums);
        recursion(index+1, nums, ans);
        swap(i, index, nums);
      }
    }

    public void swap(int i , int j , int[] arr){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
}
