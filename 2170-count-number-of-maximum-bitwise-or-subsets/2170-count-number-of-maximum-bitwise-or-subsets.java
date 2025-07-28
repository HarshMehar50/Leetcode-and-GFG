class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxor = 0;
        for(int i = 0; i < nums.length; i++){
            maxor = maxor|nums[i];
        }
        int ans = 0;
        for(int mask = 1; mask < (1<<nums.length); mask++){
            int ssor = 0;
            for(int i = 0; i < nums.length; i++){
                if((mask&(1<<i)) != 0)
                ssor = ssor|nums[i];
            }
            if(ssor == maxor)
            ans++;
        }
        return ans;
    }
}