class Solution {
    int solve(int[] nums , int c , int p , int g , int[][][] dp){
        if(c >= nums.length)
        return 0;
        if(dp[c][p+1][g] != -1)
        return dp[c][p+1][g];
        int include = 0;
        if(g == 1){
            if(p == -1 || (p != -1 && nums[c] > nums[p]))
            include = 1+solve(nums, c+1 , c , 0 , dp);
        }else{
            if(p == -1 || (p != -1 && nums[c] < nums[p]))
            include = 1+solve(nums , c+1 , c , 1 , dp);
        }
        int exclude = solve(nums , c+1 , p , g , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1][g] = ans;
        return dp[c][p+1][g];
    }
    public int wiggleMaxLength(int[] nums) {
        int[] a1 = new int[nums.length+1];
        int[] a2 = new int[nums.length+1];
        a1[0] = -1;
        a2[0] = 1001;
        for(int i = 0; i < nums.length; i++){
            a1[i+1] = nums[i];
            a2[i+1] = nums[i];
        }
        int[][][] dp1 = new int[a1.length][a1.length+1][2];
        int[][][] dp2 = new int[a2.length][a2.length+1][2];
        for(int[][] a : dp1){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        for(int[][] a : dp2){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        int ans = Math.max(solve(a1 , 0 , -1 , 1 , dp1) , solve(a2 , 0 , -1 , 0 , dp2));
        return ans;
    }
}