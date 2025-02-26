class Solution {
    int ceil(int[][] events , int t){
        int s = 0;
        int e = events.length;
        while(s < e){
            int m = s+(e-s)/2;
            if(events[m][0] <= t)
            s = m+1;
            else
            e = m;
        }
        return s;
    }
    int solve(int[][] events , int i , int k , int[][] dp){
        if(i >= events.length || k <= 0)
        return 0;
        if(dp[i][k] != -1)
        return dp[i][k];
        int index = ceil(events , events[i][1]);
        int include = events[i][2]+solve(events , index , k-1 , dp);
        int exclude = solve(events , i+1 , k , dp);
        int ans = Math.max(include , exclude);
        dp[i][k] = ans;
        return dp[i][k];
    }
    /*int solve(int[][] events , int c , int p , int k , int[][] dp){
        if(c == events.length || k == 0)
        return 0;
        if(dp[p+1][k] != -1)
        return dp[p+1][k];
        int include = 0;
        if(p == -1 || (p != -1 && events[p][1] < events[c][0]))
        include = events[c][2]+solve(events , c+1 , c , k-1 , dp);
        int exclude = solve(events , c+1 , p , k , dp);
        int ans = Math.max(include , exclude);
        dp[p+1][k] = Math.max(include , exclude);
        return dp[p+1][k];
    }*/
    public int maxValue(int[][] events, int k) {
        int[][] dp = new int[events.length][k+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        //Arrays.sort(events , (x , y)->((x[0] != y[0])?Integer.compare(x[0] , y[0]):Integer.compare(x[1] , y[1])));
        Arrays.sort(events , (x , y)->Integer.compare(x[0] , y[0]));
        //return solve(events , 0 , -1 , k , dp);
        return solve(events , 0 , k , dp);
    }
}