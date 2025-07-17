class Solution {
    /*int solve(String s , String r , int k , int i , int j){
        if(i >= s.length() || j >= r.length())
        return 0;
        if(s.charAt(i) == r.charAt(j))
        return 1+solve(s , r , k , i+1 , j+1);
        else{
            int includeop = 0;
            if(k >= Math.min(Math.abs((int)(s.charAt(i)-r.charAt(j))) , 26-Math.abs((int)(s.charAt(i)-r.charAt(j))))){
                includeop =  2+solve(s , r , k-Math.min(Math.abs((int)(s.charAt(i)-r.charAt(j))) , 26-Math.abs((int)(s.charAt(i)-r.charAt(j)))) , i+1 , j+1);
            }
            int m1 = solve(s , r , k , i+1 , j);
            int m2 = solve(s , r , k , i , j+1);
            int ans = Math.max(includeop , Math.max(m1 , m2));
            return ans;
        }
    }*/
    int solve(String s , int k , int i , int j){
        if(i > j)
        return 0;
        if(i == j)
        return 1;
        if(s.charAt(i) == s.charAt(j))
        return 2+solve(s , k , i+1 , j-1);
        else{
            int d = Math.min(Math.abs((int)(s.charAt(i)-s.charAt(j))) , 26-Math.abs((int)(s.charAt(i)-s.charAt(j))));
            int includeop = 0;
            if(k-d >= 0)
            includeop = 2+solve(s , k-d , i+1 , j-1);
            int m1 = solve(s , k , i+1 , j);
            int m2 = solve(s , k , i , j-1);
            int ans = Math.max(includeop , Math.max(m1 , m2)); 
            return ans;
        }
    }
    public int longestPalindromicSubsequence(String s, int k) {
        //String r = new StringBuilder(s).reverse().toString();
        //return solve(s , r , k , 0 , 0);
        
        return solve(s , k , 0 , s.length()-1); 
    }
}