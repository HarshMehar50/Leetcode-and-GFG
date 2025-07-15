class Solution {
    int solve(int[][] a , int c , int p){
        if(c == a.length){
            return 0;
        }
        /*if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }*/
        int include = 0;
        if(p == -1 || (a[c][1] >= a[p][1] && a[c][2] >= a[p][2] && a[c][3] >= a[p][3] && p != -1))
            include = a[c][3]+solve(a , c+1 , c);
        int exclude = solve(a , c+1 , p);
        int ans = Math.max(include , exclude);
        //dp[c][p+1] = ans;
        return ans;
    }
    public int maxHeight(int[][] cuboids) {
        for(int i = 0; i < cuboids.length; i++){
            Arrays.sort(cuboids[i]);
        }
        int[][] a = new int[cuboids.length][4];
        for(int i = 0; i < a.length; i++){
            a[i][0] = cuboids[i][0]*cuboids[i][1];
            a[i][1] = cuboids[i][0];
            a[i][2] = cuboids[i][1];
            a[i][3] = cuboids[i][2];
        }
        /*int[][] dp = new int[cuboids.length][cuboids.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }*/
        //Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        Arrays.sort(a, (x, y) -> (x[1] + x[2] + x[3]) - (y[1] + y[2] + y[3]));
        // Arrays.sort(a,(x,y)->x[0]==y[0]?y[1]-x[1]:x[0]-y[0]);
        return solve(a , 0 , -1);
    }
}