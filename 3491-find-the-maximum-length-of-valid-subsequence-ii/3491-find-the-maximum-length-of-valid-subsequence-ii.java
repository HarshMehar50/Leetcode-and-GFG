class Solution {
    int solveBinary(int[] nums , int k , int r){
        if(nums.length == 0){
            return 0;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int cr = ans.get(ans.size()-1)%k;
            int rr = r-cr;
            if(nums[i]%k == rr)
                ans.add(nums[i]);
        }
        return ans.size();
    }
    int solveTab(int[] nums , int k){
        int[][] dp = new int[k][k];
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < k; j++){
                dp[nums[i]%k][j] = Math.max(dp[nums[i]%k][j] , dp[(j-(nums[i]%k)+k)%k][j]+1);
                ans = Math.max(ans , dp[nums[i]%k][j]);
            }
        }
        return ans;
    }
    int solve(int[] nums , int k , int r , int c , int p){
        if(c == nums.length){
            return 0;
        }
        int include = 0;
        if(p == -1 || (Math.abs(r-nums[p]%k) == nums[c]%k && p != -1))
            include = 1+solve(nums , k , r , c+1 , c);
        int exclude = solve(nums , k , r , c+1 , p);
        int ans = Math.max(include , exclude);
        return ans;
    }
    int solveTabSpace(int[] nums , int k , int r){
        int[] current = new int[nums.length+1];
        int[] next = new int[nums.length+1];
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                int include = 0;
                if(j == -1 || ((nums[i]+nums[j])%k == r && j != -1))
                    include = 1+next[i+1];
                int exclude = next[j+1];
                current[j+1] = Math.max(include , exclude);
            }
            next = current;
        }
        return next[0];
    }
    public int maximumLength(int[] nums, int k) {
        /*if(nums.length < 3){
            return nums.length;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            ans = Math.max(solveBinary(nums , k , i) , ans);
        }
        return ans;*/
        return solveTab(nums , k);
    }
}