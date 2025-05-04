class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1)
            return 0;
        Arrays.sort(nums);
        /*if(k == 2){
            int min = nums[1]-nums[0];
            for(int i = 1; i <= nums.length-2; i++){
                min = Math.min(min , nums[i+1]-nums[i]);
            }
            return min;
        }*/
        int ans = nums[k-1]-nums[0];
        for(int i = 1; i <= nums.length-k; i++){
            ans = Math.min(ans , nums[i+k-1]-nums[i]);
        }
        return ans;
    }
}