class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(l.isEmpty() || nums[i] != l.get(l.size()-1))
            l.add(nums[i]);
        }
        int[] dp = new int[l.size()];
        Arrays.fill(dp , 1);
        for(int i = 1; i < l.size(); i++){
            if(l.get(i)-l.get(i-1) == 1)
            dp[i] += dp[i-1];
        }
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}