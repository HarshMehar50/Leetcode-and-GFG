class Solution {
    /*long solve(int[][] rides , int index , int p , long[][] dp){
        if(index >= rides.length)
        return 0;
        if(dp[index][p+1] != -1)
        return dp[index][p+1];
        long include = 0;
        if((p == -1)||(rides[index][0] >= rides[p][1] && p != -1))
        include = solve(rides , index+1 , index , dp)+(Math.abs(rides[index][1]-rides[index][0])+rides[index][2]);
        long exclude = solve(rides , index+1 , p , dp);
        long ans = Math.max(include , exclude);
        dp[index][p+1] = ans;
        return dp[index][p+1];
    }*/
    /*long solve(int[][] rides , int index , int p , long[][] dp){
        if(index >= rides.length)
        return 0;
        if(dp[index][p+1] != -1)
        return dp[index][p+1];
        long include = 0;
        if((p == -1)||(rides[index][0] >= rides[p][1] && p != -1))
        include = solve(rides , index+1 , index , dp)+(Math.abs(rides[index][1]-rides[index][0])+rides[index][2]);
        long exclude = solve(rides , index+1 , p , dp);
        long ans = Math.max(include , exclude);
        dp[index][p+1] = ans;
        return dp[index][p+1];
    }*/
    int ceil(int[] a , int t , int l){
        int s = l;
        int e = a.length;
        while(s < e){
            int m = s+(e-s)/2;
            if(a[m] >= t)
                e = m;
            else
                s = m+1;
        }
        return s;
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        /*long[][] dp = new long[rides.length][rides.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        Arrays.sort(rides , (x , y)->Integer.compare(x[0] , y[0]));
        return solve(rides , 0 , -1 , dp);*/
        /*long[][] dp = new long[rides.length][rides.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        Arrays.sort(rides , (x , y)->Integer.compare(x[0] , y[0]));
        return solve(rides , 0 , -1 , dp);*/
        Arrays.sort(rides , (x , y)->Integer.compare(x[0] , y[0]));
        long[] dp = new long[rides.length];
        long[] s = new long[rides.length];
        int[] start = new int[rides.length];
        for(int i = 0; i < rides.length; i++){
            start[i] = rides[i][0];
        }
        dp[dp.length-1] = rides[rides.length-1][1]-rides[rides.length-1][0]+rides[rides.length-1][2];
        s[s.length-1] = rides[rides.length-1][1]-rides[rides.length-1][0]+rides[rides.length-1][2];
        for(int i = dp.length-2; i >= 0; i--){
            int index = ceil(start , rides[i][1] , i+1);
            if(index >= rides.length)
                dp[i] = rides[i][1]-rides[i][0]+rides[i][2];
            else
                dp[i] = rides[i][1]-rides[i][0]+rides[i][2]+s[index];
            s[i] = Math.max(s[i+1] , dp[i]);
        }
        return s[0];
    }
}