class Solution {
    boolean solve(String s1 , String s2 , String s3 , int i , int j){
        if(i == s1.length() && j == s2.length() && i+j == s3.length())
        return true;
        if(i+j >= s3.length())
        return false;
        boolean ans = false;
        if(i < s1.length() && i+j < s3.length() && s1.charAt(i) == s3.charAt(i+j))
        ans = ans||solve(s1 , s2 , s3 , i+1 , j);
        if(j < s2.length() && i+j < s3.length() && s2.charAt(j) == s3.charAt(i+j))
        ans = ans||solve(s1 , s2 , s3 , i , j+1);
        return ans;
    }
    public boolean isInterLeave(String s1, String s2, String s3) {
        // code here
        int[][] dp = new int[s1.le]
        return solve(s1 , s2 , s3 , 0 , 0);
    }
}