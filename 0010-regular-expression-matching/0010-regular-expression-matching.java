class Solution {
    boolean solve(String s , String p , int i , int j){
        if(i < 0 && j < 0){
            return true;
        }
        if(i >= 0 && j < 0){
            return false;
        }
        if(i < 0 && j >= 0){
            if(p.charAt(j) == '*'){
                return solve(s , p , i , j-2);
            }
            else{
                return false;
            }
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            return solve(s , p , i-1 , j-1);
        }
        else if(p.charAt(j) == '*'){
            if(j > 0 && solve(s , p , i , j-2)){
                return true;
            }
            if(j > 0 && (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.')){
                return solve(s , p , i-1 , j);
            }
        }
        else {
            return false;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        return solve(s , p , s.length()-1 , p.length()-1);
    }
}