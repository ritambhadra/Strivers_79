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

