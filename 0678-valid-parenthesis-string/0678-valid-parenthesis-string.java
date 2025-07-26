class Solution {
    boolean solve(String s , int i , int s1 , HashMap<Pair<Integer , Integer> , Boolean> dp){
        if(s1 < 0)
        return false;
        if(i >= s.length()){
            if(s1 == 0)
            return true;
            else
            return false;
        }
        if(dp.containsKey(new Pair<>(i , s1)))
        return dp.get(new Pair<>(i , s1));
        if(s.charAt(i) == '(')
        return solve(s , i+1 , s1+1 , dp);
        else if(s.charAt(i) == ')')
        return solve(s , i+1 , s1-1 , dp);
        else{
            boolean ans = false;
            ans = ans||solve(s , i+1 , s1+1 , dp)||solve(s , i+1 , s1 , dp)||solve(s , i+1 , s1-1 , dp);
            dp.put(new Pair<>(i , s1) , ans);
            return dp.get(new Pair<>(i , s1));
        }
    }
    public boolean checkValidString(String s) {
        HashMap<Pair<Integer , Integer> , Boolean> dp = new HashMap<>();
        return solve(s , 0 , 0 , dp);
    }
}