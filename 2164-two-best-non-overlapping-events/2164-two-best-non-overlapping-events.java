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
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events , (x , y)->Integer.compare(x[0] , y[0]));
        int[] s = new int[events.length];
        int[] start = new int[events.length];
        for(int i = 0; i < start.length; i++){
            start[i] = events[i][0];
        }
        s[s.length-1] = events[events.length-1][2];
        for(int i = s.length-2; i >= 0; i--){
            s[i] = Math.max(events[i][2] , s[i+1]);
        }
        int[] dp = new int[events.length];
        dp[dp.length-1] = events[events.length-1][2];
        int ans = dp[dp.length-1];
        for(int i = dp.length-2; i >= 0; i--){
            int index = ceil(start , events[i][1]+1 , i+1);
            if(index >= events.length)
            dp[i] = events[i][2];
            else
            dp[i] = events[i][2]+s[index];
            ans = Math.max(dp[i] , ans);
        }
        return ans;
    }
}