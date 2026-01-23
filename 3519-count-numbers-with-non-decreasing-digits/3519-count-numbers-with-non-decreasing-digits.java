import java.math.BigInteger;
class Solution {
    final int mod = 1000000007;
    int solve(String s , int b , int i , int t , int p , int[][][] dp){
        if(i == s.length())
        return 1;
        if(dp[i][t][p] != -1)
        return dp[i][t][p];
        int ans = 0;
        if(t == 1){
            for(int j = p; j < b; j++){
                ans = (ans+solve(s , b , i+1 , t , j , dp))%mod;
            }
        }else{
            for(int j = p; j <= s.charAt(i)-'0'; j++){
                if(j == s.charAt(i)-'0')
                ans = (ans+solve(s , b , i+1 , t , j , dp))%mod;
                else
                ans = (ans+solve(s , b , i+1 , 1 , j , dp))%mod;
            }
        }
        dp[i][t][p] = ans%mod;
        return dp[i][t][p];
    }
    public int countNumbers(String l, String r, int b) {
        BigInteger nl = new BigInteger(l);
        String sl = nl.toString(b);
        BigInteger nr = new BigInteger(r);
        String sr = nr.toString(b);
        int e = 1;
        for(int i = 0; i < sl.length()-1; i++){
            if(sl.charAt(i) > sl.charAt(i+1)){
                e = 0;
                break;
            }
        }
        int[][][] dpl = new int[sl.length()][2][b];
        for(int[][] a : dpl){
            for(int[] x : a){
                Arrays.fill(x , -1);
            }
        }
        int[][][] dpr = new int[sr.length()][2][b];
        for(int[][] a : dpr){
            for(int[] x : a){
                Arrays.fill(x , -1);
            }
        }
        int ans = (solve(sr , b , 0 , 0 , 0 , dpr)-solve(sl , b , 0 , 0 , 0 , dpl)+mod)%mod;
        ans = (ans+e)%mod;
        return ans;
    }
}