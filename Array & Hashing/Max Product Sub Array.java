class Solution {
    public int maxProduct(int[] nums) {
        int pre = 1;
        int suf = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;

            pre *= nums[i];
            suf *= nums[nums.length - i - 1];

            max = Math.max(max, Math.max(pre, suf));
        }
        return max;
    }
}

/*
Algorithm: 
We will first declare 2 variables i.e. ‘pre’(stores the product of the prefix subarray) and ‘suff’(stores the product of the suffix subarray). They both will be initialized with 1(as we want to store the product).

Now, we will use a loop(say i) that will run from 0 to n-1.

We have to check 2 cases to handle the presence of 0:
	If pre = 0: This means the previous element was 0. So, we will consider the current element as a part of the new subarray. So, we will set ‘pre’ to 1.
	If suff = 0: This means the previous element was 0 in the suffix. So, we will consider the current element as a part of the new suffix subarray. So, we will set ‘suff’ to 1.
	
Next, we will multiply the elements from the starting index with ‘pre’ and the elements from the end with ‘suff’. To incorporate both cases inside a single loop, we will do the following:
	We will multiply arr[i] with ‘pre’ i.e. pre *= arr[i].
	We will multiply arr[n-i-1] with ‘suff’ i.e. suff *= arr[n-i-1].

After each iteration, we will consider the maximum among the previous answer, ‘pre’ and ‘suff’ i.e. max(previous_answer, pre, suff).

Finally, we will return the maximum product.
*/
