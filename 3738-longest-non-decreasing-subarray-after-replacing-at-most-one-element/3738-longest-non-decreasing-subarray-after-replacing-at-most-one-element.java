class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length <= 3)
        return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= nums[i-1])
            dp[i] += dp[i-1];
        }
        List<Integer> l = new ArrayList<>();
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            ans = Math.max(ans , dp[i]);
            if(dp[i] == 1)
            l.add(i);
        }
        for(int i = 0; i < l.size()-1; i++){
            int s1 = l.get(i);
            int s2 = l.get(i+1);
            if(s1+1 == s2){
                ans = Math.max(ans , 2);
                continue;
            }
            int l1 = s2-s1;
            int l2 = 0;
            if(i+1 == l.size()-1)
            l2 = nums.length-s2;
            else
            l2 = l.get(i+2)-s2;
            int e1 = s1+l1-1;
            int e2 = s2+l2-1;
            
            boolean valid = false;
            if((e1-1 >= 0 && nums[s2] >= nums[e1-1])||(s2+1 < nums.length && nums[s2+1] >= nums[e1]))
            valid = true;
            if(valid)
            ans = Math.max(ans , l1 + l2);

            ans = Math.max(ans , l1+1);
            ans = Math.max(ans , l2+1);
        }
        return ans;
    }
}