class Solution {
    public int sortPermutation(int[] nums) {
        /*int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i])
                ans = Math.min(ans , i&nums[i]);
        }
        if(ans != Integer.MAX_VALUE)
        return ans;
        else
        return 0;*/
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                ans = ans&nums[i];
                if(ans == 0)
                return 0;
            }
        }
        ans = Math.max(ans , 0);
        return ans;
    }
}