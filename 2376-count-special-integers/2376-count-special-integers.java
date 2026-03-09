class Solution {
    int solve(String s , int i , int t , int mask , int start){
        if(i >= s.length())
        return 1;
        int ans = 0;
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            if((mask&(1<<j)) == 0) continue;
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            if(start == 0 && j == 0)
            ans += solve(s , i+1 , nt , mask , 0);
            else
            ans += solve(s , i+1 , nt , mask^(1<<j) , 1);
        }
        return ans;
    }
    public int countSpecialNumbers(int n) {
        String s = Integer.toString(n);
        return solve(s , 0 , 0 , (1<<10)-1 , 0)-1;
    }
}