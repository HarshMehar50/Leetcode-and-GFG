class Solution {
    int solve(List<List<Integer>> piles, int k , List<int[]> ps , int i , int[][] dp){
        if(i >= ps.size() || k == 0)
        return 0;
        if(dp[k][i] != -1)
        return dp[k][i];
        int exclude = solve(piles , k , ps , i+1 , dp);
        int include = 0;
        for(int j = 0; j < Math.min(k , ps.get(i).length); j++){
            include = Math.max(include , ps.get(i)[j]+solve(piles , k-(j+1) , ps , i+1 , dp));
        }
        int ans = Math.max(include , exclude);
        dp[k][i] = ans;
        return dp[k][i];
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<int[]> ps = new ArrayList<>();
        for(List<Integer> l : piles){
            int[] a = new int[l.size()];
            a[0] = l.get(0);
            for(int i = 1; i < a.length; i++){
                a[i] = a[i-1]+l.get(i);
            }
            ps.add(a);
        }
        int[][] dp = new int[k+1][ps.size()];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(piles , k , ps , 0 , dp);
    }
}