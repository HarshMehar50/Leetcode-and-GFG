class Solution {
    public int longestSubsequence(int[] nums) {
        /*int xor = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if((xor^nums[i]) == 0)
                continue;
            xor = xor^nums[i];
            ans++;
        }
        return ans;*/
        int c0 = 0;
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor = xor^nums[i];
            if(nums[i] == 0)
            c0++;
        } 
        if(c0 == nums.length)
        return 0;
        if(xor == 0)
        return nums.length-1;
        return nums.length;
    }
}