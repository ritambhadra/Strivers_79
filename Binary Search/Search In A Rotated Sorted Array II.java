public class Solution {
    public static boolean searchInARotatedSortedArrayII(int []a, int k) {
        // Write your code here
        int low =0 ;
        int high = a.length -1;

        while(low <= high){
            int mid = (low + high)/2;
            if(a[mid] == k) return true;
            if(a[low] == a[mid] && a[mid] == a[high]){
                low += 1;
                high -= 1;
                continue;
            }

            if(a[low] <= a[mid]){
                if(a[low] <= k && k <= a[mid])
                    high = mid -1;
                else
                    low = mid +1;
            } else {
                if(a[mid] <= k && k <= a[high])
                    low = mid +1;
                else 
                    high = mid -1;
            }
        }
        return false;
    }
}
