class Solution {
    final int mod = 1000000007;
    int solveMax(List<String> board , int r , int c , int[][] dp){
        if(r == 0 && c == 0)
        return 0;
        if(dp[r][c] != -1)
        return dp[r][c];
        int left = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        if(r-1 >= 0 && board.get(r-1).charAt(c) != 'X')
        up = solveMax(board , r-1 , c , dp);
        if(c-1 >= 0 && board.get(r).charAt(c-1) != 'X')
        left = solveMax(board , r , c-1 , dp);
        int daigonal = Integer.MIN_VALUE;
        if(r-1 >= 0 && c-1 >= 0 && board.get(r-1).charAt(c-1) != 'X')
        daigonal = solveMax(board , r-1 , c-1 , dp);
        int cost = 0;
        if(board.get(r).charAt(c) >= '0' && board.get(r).charAt(c) <= '9')
        cost = board.get(r).charAt(c)-'0';
        int ans = cost+Math.max(daigonal , Math.max(up , left));
        dp[r][c] = ans;
        return dp[r][c];
    }
    int solve(List<String> board , int r , int c , int max , int[][][] dp){
        if(max < 0)
        return 0;
        if(r == 0 && c == 0){
            if(max == 0)
            return 1;
            else
            return 0;
        }
        if(dp[r][c][max] != -1)
        return dp[r][c][max];
        int ans = 0;
        int cost = 0;
        if(board.get(r).charAt(c) >= '0' && board.get(r).charAt(c) <= '9')
        cost = board.get(r).charAt(c)-'0';
        if(c-1 >= 0 && board.get(r).charAt(c-1) != 'X')
        ans = (ans+solve(board , r , c-1 , max-cost , dp))%mod;
        if(r-1 >= 0 && board.get(r-1).charAt(c) != 'X')
        ans = (ans+solve(board , r-1 , c , max-cost , dp))%mod;
        if(c-1 >= 0 && r-1 >= 0 && board.get(r-1).charAt(c-1) != 'X')
        ans = (ans+solve(board , r-1 , c-1 , max-cost , dp))%mod;
        dp[r][c][max] = ans;
        return dp[r][c][max];
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int[][] dpmax = new int[board.size()][board.get(0).length()];
        for(int[] a : dpmax){
            Arrays.fill(a , -1);
        }
        int max = solveMax(board , board.size()-1 , board.get(0).length()-1 , dpmax);
        max = Math.max(max , 0);
        //if(max == 0)
        //return new int[]{0 , 0};
        int[][][] dp = new int[board.size()][board.get(0).length()][max+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        int paths = solve(board , board.size()-1 , board.get(0).length()-1 , max , dp);
        return new int[]{max , paths};
    }
}