class Solution {
    int solve(int[] nums , int k , int i , int[] dp){
        if(i == nums.length-1)
        return nums[nums.length-1];
        if(dp[i] != Integer.MIN_VALUE)
        return dp[i];
        int ans = Integer.MIN_VALUE;
        int e = i+k;
        for(int j = i+1; j <= Math.min(nums.length-1 , e); j++){
            ans = Math.max(ans , nums[i]+solve(nums , k , j , dp));
        }
        dp[i] = ans;
        return dp[i];
    }
    int solveTab(int[] nums , int k){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        int[] dp = new int[nums.length];
        Arrays.fill(dp , Integer.MIN_VALUE);
        dp[nums.length-1] = nums[nums.length-1];
        pq.offer(new int[]{dp[dp.length-1] , nums.length-1});
        for(int i = nums.length-2; i >= 0; i--){
            if(pq.peek()[1] <= i+k){
                dp[i] = Math.max(dp[i] , pq.peek()[0]+nums[i]);
                pq.offer(new int[]{dp[i] , i});
            }else{
                while(pq.peek()[1] > i+k){
                    pq.poll();
                }
                dp[i] = Math.max(dp[i] , pq.peek()[0]+nums[i]);
                pq.offer(new int[]{dp[i] , i});
            }
        }
        return dp[0];
    }
    public int maxResult(int[] nums, int k) {
        /*int[] dp = new int[nums.length];
        Arrays.fill(dp , Integer.MIN_VALUE);
        return solve(nums , k , 0 , dp);*/
        return solveTab(nums , k);
    }
}