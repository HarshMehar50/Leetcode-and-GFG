class Solution {
    int solve(String s , int i , int t , int s1 , int p , int start){
        if(i >= s.length()){
            if(s1 != 0 && p%s1 == 0)
            return 1;
            else
            return 0;
        }
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        int ans = 0;
        for(int j = 0; j <= limit; j++){
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            if(start == 0 && j == 0)
            ans += solve(s , i+1 , nt , s1 , p , 0);
            else
            ans += solve(s , i+1 , nt , s1+j , p*j , 1);
        }
        return ans;
    }
    public int beautifulNumbers(int l, int r) {
        String sr = Integer.toString(r);
        String sl = Integer.toString(l-1);
        return solve(sr , 0 , 0 , 0 , 1 , 0)-solve(sl , 0 , 0 , 0 , 1 , 0);
    }
}