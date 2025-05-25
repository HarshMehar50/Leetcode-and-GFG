class Solution {
    /* int solve(int[] nums , int index){
        if(index < 1 && nums[index-1] < nums[index]){
            return 1;
        }
        if(index < 1 && nums[index-1] > nums[index]){
            return 0;
        }
        int include = 0;
        int exclude = 0;
        if(nums[index-1] < nums[index])
        include = 1 + solve(nums , index-1);

        exclude = solve(nums , index-1);

        int ans = Math.max(include , exclude);
        return ans;
    }*/
    int solve(int[] nums , int c , int p , int[][] dp){
        if(c == nums.length){
            return 0;
        }
        if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }
        int include = 0;
        if(p == -1 || (nums[c] > nums[p] && p != -1))
            include = 1+solve(nums , c+1 , c , dp);
        int exclude = solve(nums , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    /* int solveTab(int[] nums){
         int[][] dp = new int[nums.length][nums.length+1];
         for(int i = nums.length-2; i >= 0; i--){
             for(int j = nums.length-1; j >= -1; j--){
                 dp[i][j+1] = Math.max(dp[i+1][i+1]+1 , dp[i+1][j+1]);
             }
         }
         return dp[0][0];
     }*/
    int ceil(List<Integer> list , int k){
        int s = 0;
        int e = list.size()-1;
        while(s <= e){
            int m = s + (e-s)/2;
            if(list.get(m) == k){
                return m;
            }
            if(list.get(m) > k){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return s;
    }
    int solveBinary(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > ans.get(ans.size()-1))
                ans.add(nums[i]);
            else{
                int index = ceil(ans , nums[i]);
                ans.remove(index);
                ans.add(index , nums[i]);
            }
        }
        return ans.size();
    }
    public int lengthOfLIS(int[] nums) {
        return solveBinary(nums);
        /*int[][] dp = new int[nums.length][nums.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(nums  , 0  , -1 , dp);*/
        //return solveTab(nums);
    }
}