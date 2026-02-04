class Solution {
    final int mod = 1000000007;
    int solve(int low , int high , int zero , int one , int i){
        if(i > high)
        return 0;
        int ans = 0;
        if(i >= low && i <= high)
        ans = 1;
        ans = (ans+solve(low , high , zero , one , i+zero))%mod;
        ans = (ans+solve(low , high , zero , one , i+one))%mod;
        return ans;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        return solve(low , high , zero , one , 0);
    }
}