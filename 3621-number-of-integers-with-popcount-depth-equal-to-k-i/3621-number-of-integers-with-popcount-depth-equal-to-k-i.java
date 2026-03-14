class Solution {
    long solve(String s , Set<Integer> set , int i , int t , int c , long[][][] dp){
        if(i >= s.length()){
            if(set.contains(c))
            return 1;
            else
            return 0;
        }
        if(dp[i][t][c] != -1)
        return dp[i][t][c];
        int l = 1;
        if(t == 0)
        l = s.charAt(i)-'0';
        long ans = 0;
        for(int j = 0; j <= l; j++){
            int nt = t;
            if(t == 0 && j < l)
            nt = 1;
            ans += solve(s , set , i+1 , nt , c+j , dp);
        }
        dp[i][t][c] = ans;
        return dp[i][t][c];
    }
    public long popcountDepth(long n, int k) {
        if(k == 0)
        return 1;
        int[] pcd = new int[65];
        for(int i = 2; i < 65; i++){
            int x = i;
            while(x != 1){
                x = Integer.bitCount(x);
                pcd[i]++;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < 65; i++){
            if(pcd[i] == k-1)
            set.add(i);
        }
        String s = Long.toBinaryString(n);
        long[][][] dp = new long[s.length()][2][65];
        for(long[][] a : dp){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        long ans = solve(s , set , 0 , 0 , 0 , dp);
        if(k == 1)
        ans--;
        return ans;
    }
}