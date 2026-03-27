class Solution {
    boolean solve(int[] nums , int i , HashMap<Integer , Boolean> dp){
        if(i >= nums.length)
        return true;
        if(dp.containsKey(i))
        return dp.get(i);
        boolean ans = false;
        if(i+1 < nums.length && nums[i+1] == nums[i])
        ans |= solve(nums , i+2 , dp);
        if(i+2 < nums.length && nums[i+1] == nums[i] && nums[i] == nums[i+2])
        ans |= solve(nums , i+3 , dp);
        if(i+2 < nums.length && nums[i]+1 == nums[i+1] && nums[i+1]+1 == nums[i+2])
        ans |= solve(nums , i+3 , dp);
        dp.put(i , ans);
        return dp.get(i);
    }
    public boolean validPartition(int[] nums) {
        HashMap<Integer , Boolean> dp = new HashMap<>();
        return solve(nums , 0 , dp); 
    }
}