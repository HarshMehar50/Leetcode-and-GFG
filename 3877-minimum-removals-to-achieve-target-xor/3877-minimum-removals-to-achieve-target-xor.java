class Solution {
    int solve(int[] nums , int target , int i , int xor , HashMap<String , Integer> dp){
        if(i >= nums.length){
            if(xor == target)
            return 0;
            else
            return nums.length+1;
        }
        String key = i+" "+xor;
        if(dp.containsKey(key))
        return dp.get(key);
        int include = solve(nums , target , i+1, xor^nums[i] , dp);
        int exclude = 1+solve(nums , target , i+1 , xor , dp);
        int ans = Math.min(include , exclude);
        dp.put(key , ans);
        return dp.get(key);
    }
    public int minRemovals(int[] nums, int target) {
        HashMap<String , Integer> dp = new HashMap<>();
        int ans = solve(nums , target , 0 , 0 , dp);
        if(ans == nums.length+1)
        return -1;
        return ans;
    }
}