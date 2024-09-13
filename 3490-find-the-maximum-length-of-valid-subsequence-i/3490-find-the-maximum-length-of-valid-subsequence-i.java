class Solution {
    int solveGen(int[] nums){
        /*int[][] dp = new int[2][2];
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 2; j++){
                dp[nums[i]%2][j] = Math.max(dp[nums[i]%2][j] , dp[(j-(nums[i]%2)+2)%2][j]+1);
                ans = Math.max(ans , dp[nums[i]%2][j]);
            }
        }
        return ans;*/
        int e = 0;
        int o = 0;
        int alt = 0;
        int c = nums[0]%2;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0)
            e++;
            else
            o++;
            if(c == nums[i]%2){
                alt++;
                c = 1-c;
            }
        }
        return Math.max(alt , Math.max(e , o));
    }
    int solveOptTab1(int[] nums, int k){
        int[] dp = new int[nums.length+1];
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                int include = 0;
                if(j == -1 || (Math.abs(k-nums[j]%2) == nums[i]%2 && j != -1))
                include = 1+dp[i+1];
                int exclude = dp[j+1];
                dp[j+1] = Math.max(include , exclude);
            }
        }
        return dp[0];
    }
    /*int solveOptTab(int[] nums , int k){
        int[] current = new int[nums.length+1];
        int[] next = new int[nums.length+1];
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                 int include = 0;
                 if(j == -1 || (Math.abs(k-nums[j]%2) == nums[i]%2 && j != -1))
                 include = 1+next[i+1];
                 int exclude = next[j+1];
                 int ans = Math.max(include , exclude);
                 current[j+1] = ans;
            }
            next = current;
        }
        return next[0];
    }*/
    int solveOpt(int[] nums , int k , int c , int p , int[][] dp){
        if(c == nums.length){
            return 0;
        }
        if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }
        int include = 0;
        if(p == -1 || (Math.abs(k-nums[p]%2) == nums[c]%2 && p != -1))
        include = 1+solveOpt(nums , k , c+1 , c , dp);
        int exclude = solveOpt(nums , k , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    int solveTabSpace(int[] nums , int k){
        int[] current = new int[nums.length+1];
        int[] next = new int[nums.length+1];
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                int include = 0;
                if(j == -1 || ((nums[i]+nums[j])%2 == k && j != -1))
                include = 1+next[i+1];
                int exclude = next[j+1];
                current[j+1] = Math.max(include , exclude);
            }
            next = current;
        }
        return next[0];
    }
    int solve(int[] nums , int c , int p , int k , int[][] dp){
        if(c == nums.length){
            return 0;
        }
        if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }
        int include = 0;
        if(p == -1 || ((nums[c]+nums[p])%2 == k && p != -1))
        include = 1+solve(nums , c+1 , c , k , dp);
        int exclude = solve(nums , c+1 , p , k , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    public int maximumLength(int[] nums) {
        int[][] dp0 = new int[nums.length][nums.length+1];
        for(int i = 0; i < dp0.length; i++){
            Arrays.fill(dp0[i] , -1);
        }
        //int solve0 = solve(nums , 0 , -1 , 0 , dp0);
        int[][] dp1 = new int[nums.length][nums.length+1];
        for(int i = 0; i < dp1.length; i++){
            Arrays.fill(dp1[i] , -1);
        }
       // int solve1 = solve(nums , 0 , -1 , 1 , dp1);
        /*return Math.max(solve0 , solve1);*/
        //int s0 = solveTabSpace(nums , 0);
        //int s1 = solveTabSpace(nums , 1);
        //int s0 = solveOpt(nums , 0 , 0 , -1 , dp0);
       // int s1 = solveOpt(nums , 1 , 0 , -1 , dp1);
        //return Math.max(s0 , s1);
       /* int s0 = solveOptTab1(nums , 0);
        int s1 = solveOptTab1(nums , 1);*/
        return solveGen(nums);
    }
}