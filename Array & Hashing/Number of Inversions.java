/*
import java.util.ArrayList;

public class Solution {
    public static void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> ls= new ArrayList<>();

        while(left <= mid && right <= high)
            if(arr[left] <= arr[right]) ls.add(arr[left++]);
            else ls.add(arr[right++]);
        
        while(left <= mid)
            ls.add(arr[left++]);
        
        while(right <= high)
            ls.add(arr[right++]);

        for (int i = low; i <= high; i++)
            arr[i] = ls.get(i - low);
    }
    public static void mergeSort(int[] arr, int l, int r){
        // Write your code here
        if(l >= r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
}
*/

// modified mersort for solving this qstn

import java.util.*;

public class Solution {
    static int merge(int[] a, int low, int mid, int high){
        int left = low;
        int right = mid +1;
        int count = 0;       //Modification: count variable to count the pairs:
        ArrayList<Integer> ls = new ArrayList<>();
        
        while(left <= mid && right <= high){
            if(a[left] <= a[right])
                ls.add(a[left++]);
            else{
                count += (mid - left + 1);  //Modification
                ls.add(a[right++]);
            }
        }
        while(left <= mid)
            ls.add(a[left++]);
            
        while(right <= high)
            ls.add(a[right++]);

        for(int i = low ; i <= high; i++)
            a[i] = ls.get(i - low);

        return count;     // Modification
    }
    static int mergesort(int[] a, int low, int high){
        int count = 0;
        if(low >= high) return count;
        int mid = (low + high)/2;
        count += mergesort(a, low, mid);
        count += mergesort(a, mid+1, high);
        count += merge(a, low, mid, high);
        return count;
    }
    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        return mergesort(a, 0, n-1);
    }
}
