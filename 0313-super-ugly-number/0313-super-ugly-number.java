class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pi = new int[primes.length];
        Arrays.fill(pi , 1);
        long[] dp = new long[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (long)(1e16);
            for(int j = 0; j < primes.length; j++){
                dp[i] = Math.min(dp[i] , dp[pi[j]]*(long)primes[j]);
            }
            for(int j = 0; j < primes.length; j++){
                if(dp[i] == dp[pi[j]]*(long)primes[j])
                pi[j]++;
            }
        }
        return (int)dp[n];
    }
}