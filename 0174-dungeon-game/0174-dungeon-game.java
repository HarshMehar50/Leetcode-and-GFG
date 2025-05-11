class Solution {
    /*boolean solve(int[][] dungeon , int r , int c , int h , HashMap<Pair<Integer , Pair<Integer , Integer>> , Boolean> dp){
        if(r >= dungeon.length || c >= dungeon[0].length)
        return false;
        h += dungeon[r][c];
        if(h <= 0)
        return false;
        if(r == dungeon.length-1 && c == dungeon[0].length-1){
            if(h > 0)
            return true;
            else
            return false;
        }
        if(dp.containsKey(new Pair<>(h , new Pair<>(r , c))))
        return dp.get(new Pair<>(h , new Pair<>(r , c)));
        boolean right = solve(dungeon , r , c+1 , h , dp);
        boolean down = solve(dungeon , r+1 , c , h , dp);
        boolean ans = right||down;
        dp.put(new Pair<>(h , new Pair<>(r , c)) , ans);
        return dp.get(new Pair<>(h , new Pair<>(r , c))); 
    }*/
    int solve(int[][] dungeon , int r , int c , int[][] dp){
        if(r >= dungeon.length || c >= dungeon[0].length)
        return Integer.MAX_VALUE;
        if(r == dungeon.length-1 && c == dungeon[0].length-1){
            if(dungeon[r][c] > 0)
            return 1;
            else
            return Math.abs(dungeon[r][c])+1;
        }
        if(dp[r][c] != -1)
        return dp[r][c];
        int right = solve(dungeon , r , c+1 , dp);
        int down = solve(dungeon , r+1 , c , dp);
        int ans = Math.min(right , down)-dungeon[r][c];
        if(ans > 0)
        ans = ans;
        else
        ans = 1;
        dp[r][c] = ans;
        return dp[r][c];
    }
    public int calculateMinimumHP(int[][] dungeon) {
        /*int s = 1; 
        int e = 4*((int)1e7);
        int ans = e;
        HashMap<Pair<Integer , Pair<Integer , Integer>> , Boolean> dp = new HashMap<>();
        while(s <= e){
            int m = s+(e-s)/2;
            dp.clear();
            if(solve(dungeon , 0 , 0 , m , dp)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;*/
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(dungeon , 0 , 0 , dp);
    }
}