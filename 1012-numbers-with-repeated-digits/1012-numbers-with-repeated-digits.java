class Solution {
    int solve(String s , int i , int t , int start , int mask){
        if(i == s.length())
        return 1;
        int ans = 0;
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            int ns = 0;
            if(start == 1 || (start == 0 && j != 0))
            ns = 1;
            if(ns == 1){
                if((mask&(1<<j)) == 0)
                ans += solve(s , i+1 , nt , ns , (mask|(1<<j)));
            }else
            ans += solve(s , i+1 , nt , ns , mask);
        }
        return ans;
    }
    public int numDupDigitsAtMostN(int n) {
        return n-solve(Integer.toString(n) , 0 , 0 , 0 , 0)+1;
    }
}