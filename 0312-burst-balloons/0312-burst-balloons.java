class Solution {
    int solve(int[] nums , int l , int r){
        if(l > r)
        return 0;
        int ans = Integer.MIN_VALUE;
        for(int i = l; i <= r; i++){
            int s = nums[l-1]*nums[i]*nums[r+1];
            ans = Math.max(ans , s+solve(nums , l , i-1)+solve(nums , i+1 , r));
        }
        return ans;
    }
    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length+2];
        for(int i = 1; i < nums.length+1; i++){
            a[i] = nums[i-1];
        }
        a[0] = 1;
        a[a.length-1] = 1;
        return solve(a , 1 , nums.length);
    }
}