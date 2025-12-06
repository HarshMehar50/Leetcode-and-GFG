class Solution {
    final int mod = 1000000007;
    public int countPartitions(int[] nums, int k) {
        Deque<Integer> dqmax = new LinkedList<>();
        Deque<Integer> dqmin = new LinkedList<>();
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        int l = 0;
        int[] p = new int[nums.length+2];
        p[1] = 1;
        for(int r = 0; r < nums.length; r++){
            while(!dqmax.isEmpty() && nums[dqmax.peekLast()] < nums[r]){
                dqmax.pollLast();
            }
            while(!dqmin.isEmpty() && nums[dqmin.peekLast()] > nums[r]){
                dqmin.pollLast();
            }
            dqmax.offerLast(r);
            dqmin.offerLast(r);
            while(!dqmin.isEmpty() && !dqmax.isEmpty() && nums[dqmax.peekFirst()]-nums[dqmin.peekFirst()] > k){
                if(dqmax.peekFirst() == l)
                dqmax.pollFirst();
                if(dqmin.peekFirst() == l)
                dqmin.pollFirst();
                l++;
            }
            dp[r+1] = (p[r+1]-p[l]+mod)%mod;
            p[r+2] = (p[r+1]+dp[r+1])%mod;
        }
        return dp[dp.length-1];
    }
}