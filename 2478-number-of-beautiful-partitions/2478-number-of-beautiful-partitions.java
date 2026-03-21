class Solution {
    final int mod = 1000000007;
    int solve(String s , int k , int minLength , int i , List<Integer>[] l , int[][] dp){
        if(i >= s.length()){
            if(k == 0)
            return 1;
            else
            return 0;
        }
        if(dp[k][i] != -1)
        return dp[k][i];
        int ans = 0;
        for(Integer x : l[i]){
            if(k-1 >= 0)
            ans =(ans+solve(s , k-1 , minLength , x , l , dp))%mod;
        }
        dp[k][i] = ans;
        return dp[k][i];
    }
    public int beautifulPartitions(String s, int k, int minLength) {
        List<Integer>[] l = new ArrayList[s.length()];
        for(int i = 0; i < s.length(); i++){
            l[i] = new ArrayList<>();
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '5' || s.charAt(i) == '7'){
            for(int j = minLength+i-1; j < s.length(); j++){
                if((s.charAt(j) != '2' && s.charAt(j) != '3' && s.charAt(j) != '5' && s.charAt(j) != '7') && (j+1 == s.length() || (j+1 < s.length() && (s.charAt(j+1) == '2' || s.charAt(j+1) == '3' || s.charAt(j+1) == '5' || s.charAt(j+1) == '7'))))
                l[i].add(j+1);
            }
            }
        }
        if(l[0].isEmpty())
        return 0;
        int[][] dp = new int[k+1][s.length()];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(s , k , minLength , 0 , l , dp);
    }
}