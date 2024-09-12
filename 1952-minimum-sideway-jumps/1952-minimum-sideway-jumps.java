class Solution {
    int solve(int[] obstacles , int cl , int cp){
        if(cp == obstacles.length-1){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if(obstacles[cp+1] != cl){
            return solve(obstacles , cl , cp+1);
        }else{
            for(int i = 1; i <= 3; i++){
                if(cl != i && obstacles[cp] != i)
                ans = Math.min(ans , 1+solve(obstacles , i , cp));
            }
        }
        return ans;
    }
    public int minSideJumps(int[] obstacles) {
        return solve(obstacles, 2 , 0);
    }
}