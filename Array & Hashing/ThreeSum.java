// Better using extra space 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> hs = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            Set<Integer> lt = new HashSet<>();
            for(int j = i+1; j <nums.length; j++){
                int third = -(nums[i] + nums[j]);
                if(lt.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    hs.add(temp);
                }
                lt.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(hs);
        return ans;
    }
}

// Best |  without using extra space
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(); 

        for(int i = 0; i < nums.length ; i++){
            if( i > 0 && nums[i] == nums[i-1]) continue; // if there is duplicate then we'll skip that one.

            int j = i+1;
            int k = nums.length -1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) j++;
                else if(sum > 0) k--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++; // if there is duplicate then we'll skip that one.
                    while(j < k && nums[k] == nums[k+1]) k--; // if there is duplicate then we'll skip that one.
                } 
            }
        }
        return ans;
    }
}
