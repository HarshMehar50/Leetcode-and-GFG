class Solution {
    int solve(String s , int p , int c){
        if(c >= s.length())
        return 0;
        int flip = Integer.MAX_VALUE;
        int noflip = Integer.MAX_VALUE;
        if(p == -1){
            if(s.charAt(c) == '1'){
                flip = 1+solve(s , 0 , c+1);
                noflip = solve(s , 1 , c+1);
            }else{
                flip = 1+solve(s , 1 , c+1);
                noflip = solve(s , 0 , c+1);
            }
        }else{
        if(s.charAt(c) == '0'){
            if(p == 1)
            flip = 1+solve(s , 1 , c+1);
            else{
                flip = 1+solve(s , 1 , c+1);
                noflip = solve(s , 0 , c+1);
            }
        }else{
            if(p == 1)
            noflip = solve(s , 1 , c+1);
            else{
                flip = 1+solve(s , 0 , c+1);
                noflip = solve(s , 1 , c+1);
            }
        }
        }
        int ans = Math.min(flip , noflip);
        return ans;
    }
    public int minFlipsMonoIncr(String s) {
        return solve(s , -1 , 0);
    }
}