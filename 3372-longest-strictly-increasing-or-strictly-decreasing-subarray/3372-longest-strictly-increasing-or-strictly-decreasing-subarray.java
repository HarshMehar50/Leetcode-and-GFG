class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int c = 1;
            for(int j = i; j < nums.length-1; j++){
                if(nums[j+1] > nums[j])
                c++;
                else
                break;
            }
            ans = Math.max(ans , c);
        }
        for(int i = 0; i < nums.length; i++){
            int c = 1;
            for(int j = i; j < nums.length-1; j++){
                if(nums[j+1] < nums[j])
                c++;
                else
                break;
            }
            ans = Math.max(ans , c);
        }
        return ans;
    }
}