class Solution {
    int ceil(List<Integer> list , int k){
        int s = 0;
        int e = list.size();
        while(s <= e){
            int m = s + (e-s)/2;
            if(list.get(m) == k){
                return -1;
            }
            if(list.get(m) < k){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        return s;
    }
    int solve(int[][] pairs , int c , int p , int[][] dp){
        if(c == pairs.length){
            return 0;
        }
        if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }
        int include = 0;
        if(p == -1 || (pairs[c][0] > pairs[p][1] && p != -1))
        include = 1+solve(pairs , c+1 , c , dp);
        int exclude = solve(pairs , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs , (a , b)->Integer.compare(a[0] , b[0]));
        int[][] dp = new int[pairs.length][pairs.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(pairs , 0 , -1 , dp);
    }
}