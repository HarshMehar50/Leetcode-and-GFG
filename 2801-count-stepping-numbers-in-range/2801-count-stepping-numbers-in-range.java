class Solution {
    final int mod = 1000000007;
    int solve(String s , int i , int t , int p , int start){
        if(i == s.length())
        return 1;
        int ans = 0;
        /*if(start == 0){
            int limit = 9;
            if(t == 0)
            limit = s.charAt(i)-'0';
            for(int j = 0; j <= limit; j++){
                int nt = 0;
                if(j < limit || t == 1)
                nt = 1;
                int ns = -1;
                if(j == 0)
                ns = 0;
                else
                ns = 1;
                ans = (ans+solve(s , i+1 , nt , p , ns))%mod;
            }
        }else{
            int limit = 9;
            if(t == 0)
            limit = s.charAt(i)-'0';
            if(p+1 <= limit){
                int nt = 0;
                if(p+1 < limit || t == 1)
                nt = 1;
                ans = (ans+solve(s , i+1 , nt , p+1 , 1))%mod;
            }
            if(p-1 >= 0 && p+1 <= limit){
                int nt = 0;
                if(p-1 < limit || t == 1)
                nt = 1;
                ans = (ans+solve(s , i+1 , nt , p-1 , 1))%mod;
            }
        }*/
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            int nt = 0;
            if(t == 1 || j < limit)
            nt = 1;
            if(start == 0){
                if(j == 0)
                ans = (ans+solve(s , i+1 , nt , 0 , 0))%mod;
                else
                ans = (ans+solve(s , i+1 , nt , j , 1))%mod;
            }else{
                if(Math.abs(p-j) == 1)
                ans = (ans+solve(s , i+1 , nt , j , 1))%mod;
            }
        }
        return ans;
    }
    public int countSteppingNumbers(String low, String high) {
        int e = 1;
        for(int i = 0; i < low.length()-1; i++){
            if(Math.abs(low.charAt(i)-low.charAt(i+1)) != 1){
                e = 0;
                break;
            }
        }
        return solve(high , 0 , 0 , 0 , 0)-solve(low , 0 , 0 , 0 , 0)+e;
    }
}