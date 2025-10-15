class Solution {
    boolean predicate(List<Integer> nums , int[] dp , int m){
        for(int i = 0; i < dp.length; i++){
            if(dp[i] >= m && i+m < dp.length && dp[i+m] >= m)
            return true;
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp , 1);
        for(int i = 0; i < nums.size()-1; i++){
            if(nums.get(i) < nums.get(i+1))
            dp[i+1] += dp[i];
        }
        int s = 1;
        int e = nums.size();
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(nums , dp , m)){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        return ans;
    }
}