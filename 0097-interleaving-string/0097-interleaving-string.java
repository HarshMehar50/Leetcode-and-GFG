class Solution {
    boolean solve(String s1 , String s2 , String s3 , int i , int j , HashMap<Pair<Integer , Integer> , Boolean> dp){
        if(i == s1.length() && j == s2.length() && i+j == s3.length())
            return true;
        if(i+j >= s3.length())
            return false;
        if(dp.containsKey(new Pair<>(i , j)))
            return dp.get(new Pair<>(i , j));
        boolean ans = false;
        if(i < s1.length() && i+j < s3.length() && s1.charAt(i) == s3.charAt(i+j))
            ans = ans||solve(s1 , s2 , s3 , i+1 , j , dp);
        if(j < s2.length() && i+j < s3.length() && s2.charAt(j) == s3.charAt(i+j))
            ans = ans||solve(s1 , s2 , s3 , i , j+1 , dp);
        dp.put(new Pair<>(i , j) , ans);
        return dp.get(new Pair<>(i , j));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<Pair<Integer , Integer> , Boolean> dp = new HashMap<>();
        return solve(s1 , s2 , s3 , 0 , 0 , dp);
    }
}