class Solution {
    /*boolean solve(int[] nums , boolean[] visited , int p1 , int p2 , int index , boolean turn){
        int c = 0;
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == true)
            c++;
        }
        if(c == visited.length){
            if(p1 > p2)
            return true;
            else
            return false;
        }
        boolean includeStart = 

    }*/
    int solve(int[] nums , int l , int r){
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i];
        }
        for(int sal = 2; sal <= nums.length; sal++){
            for(int i = 0; i <= nums.length-sal; i++){
                int j = i+sal-1;
                dp[i][j] = Math.max(nums[i]-dp[i+1][j] , nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1];
    }
    public boolean predictTheWinner(int[] nums) {
       /* boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited , false);
        return solve(nums , visited , 0 , 0 , 0 , true);*/
        int ans = solve(nums , 0 , nums.length-1);
        System.out.println(ans);
        if(ans >= 0)
        return true;
        else
        return false;
    }
}