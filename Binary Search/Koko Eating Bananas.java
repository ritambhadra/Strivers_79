class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = maxEliment(piles);
        //binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = totalTimeNeeded(piles, mid);
            if (totalH <= h) 
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return low;
    }
    
    private int maxEliment(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i: arr)
            maxi = Math.max(maxi, i);

        return maxi;
    }
    
    private int totalTimeNeeded(int[] arr, int h){  //find total hours:
        int totalH = 0;
        for (int i: arr)
            totalH += Math.ceil((double) i / (double) h);
        
        return totalH;
    }

}
