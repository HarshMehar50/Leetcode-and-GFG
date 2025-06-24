class Solution {
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
    int solve(int[] startTime , int[] endTime , int[] profit){
        int[] c = Arrays.copyOf(startTime , startTime.length);
        Arrays.sort(c);
        int[][] a = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            a[i][0] = startTime[i];
            a[i][1] = endTime[i];
            a[i][2] = profit[i];
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        int[] dp = new int[startTime.length];
        int[] sm = new int[startTime.length];
        dp[dp.length-1] = a[a.length-1][2];
        sm[sm.length-1] = a[a.length-1][2];
        int ans = 0;
        for(int i = dp.length-2; i >= 0; i--){
            int index = ceil(c , a[i][1] , i+1);
            if(index >= a.length){
                dp[i] = a[i][2];
                sm[i] = Math.max(a[i][2] , sm[i+1]);
            }else{
                dp[i] = sm[index]+a[i][2];
                sm[i] = Math.max(dp[i] , sm[i+1]);
            }
        }
        return sm[0];
    }
    int solve(int[][] a , int c , int p , int[][] dp){
        if(c == a.length)
        return 0;
        if(dp[c][p+1] != -1)
        return dp[c][p+1];
        int include = 0;
        if(p == -1 || (p != -1 && a[c][0] >= a[p][1]))
        include = a[c][2]+solve(a , c+1 , c , dp);
        int exclude = solve(a , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        /*int[][] a = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            a[i][0] = startTime[i];
            a[i][1] = endTime[i];
            a[i][2] = profit[i];
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        int[][] dp = new int[startTime.length][startTime.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(a , 0 , -1 , dp);*/
        return solve(startTime , endTime , profit);
    }
}