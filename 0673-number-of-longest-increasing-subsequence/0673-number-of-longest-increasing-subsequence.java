class Solution {
    /* void createList(int[] nums , int c , int p , List<List<Integer>> result , List<Integer> inner , int l , boolean include){
        if(inner.size() == l){
            result.add(inner);
        }
        if(c == nums.length){
            return;
        }
        if(p == -1 || (nums[c] > nums[p] & p != -1)){
        inner.add(nums[c]);
        createList(nums , c+1 , c , result , inner , l);
        }
        createList(nums , c+1 , p , result , inner , l);
    }
    int solve(int[] nums , int c , int p , int[][] dp){
        if(c == nums.length){
            return 0;
        }
        if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }
        int include = 0;
        if(p == -1 || (nums[c] > nums[p] && p != -1))
        include = 1+solve(nums, c+1 , c , dp);
        int exclude = solve(nums , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }*/
    public int findNumberOfLIS(int[] nums) {
        /*int[][] dp = new int[nums.length][nums.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int l = solve(nums , 0 , -1 , dp);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        createList(nums , 0 , -1 , result , inner , l);
        return result.size()-1;*/
        int[] dp = new int[nums.length];
        int[] lis = new int[nums.length];
        Arrays.fill(dp , 1);
        Arrays.fill(lis , 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(lis[i] == lis[j]+1)
                        dp[i] += dp[j];
                    else if(lis[i] < lis[j]+1){
                        lis[i] = lis[j]+1;
                        dp[i] = dp[j];
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(lis[i] , max);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(lis[i] == max)
                ans += dp[i];
        }
        return ans;
    }
}