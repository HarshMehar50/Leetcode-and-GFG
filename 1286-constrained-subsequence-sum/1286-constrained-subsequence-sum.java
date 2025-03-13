class Solution {
    /*int solve(int[] nums , int k , int c , int p){
        if(c == nums.length){
            return 0;
        }
        int include = 0;
        if(p == -1 || (c-p <= k && p != -1))
        include = nums[c]+solve(nums , k , c+1 , c);
        int exclude = solve(nums , k , c+1 , p);
        int ans = Math.max(include , exclude);
        return ans;
    }*/
    public int constrainedSubsetSum(int[] nums, int k) {
        //return solve(nums , k , 0 , -1);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        pq.offer(new int[]{dp[0] , 0});
        for(int i = 1; i < dp.length; i++){
            if(i-pq.peek()[1] <= k)
            dp[i] = nums[i]+Math.max(0 , pq.peek()[0]);
            else{
                while(i-pq.peek()[1] > k){
                    pq.poll();
                }
                dp[i] = nums[i]+Math.max(0 , pq.peek()[0]);
            }
            pq.offer(new int[]{dp[i] , i});
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}