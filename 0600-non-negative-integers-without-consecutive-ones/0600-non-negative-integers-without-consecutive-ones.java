class Solution {
    int solve(int n , String s , int i , int p , int ct1){
        if(i >= s.length())
        return 1;
        int ans = 0;
        /*if(p == 1)
        ans += solve(n , s , i+1 , 0 , 1);
        else{
            if(s.charAt(i) == '0'){
                ans += solve(n , s , i+1 , 0 , ct1);
                if(ct1 == 1)
                ans += solve(n , s , i+1 , 1 , 1);
            }else{
                ans += solve(n , s , i+1 , 0 , 1)+solve(n , s , i+1 , 1 , ct1);
            }
        }*/
        int limit = 1;
        if(ct1 == 1)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            if(p == 1 && j == 1) continue;
            int nct1 = 0;
            if(ct1 == 1 && j == limit)
            nct1 = 1;
            ans += solve(n , s , i+1 , j , nct1);
        }
        return ans;
    }
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        return solve(n , s , 0 , 0 , 1);
    }
}