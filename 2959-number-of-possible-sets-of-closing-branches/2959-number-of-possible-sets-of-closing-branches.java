class Solution {
    boolean check(int mask , int n , int maxDistance , int[][] a){
        int[][] d = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                d[i][j] = a[i][j];
            }
        }
        for(int k = 0; k < n; k++){
            if((mask&(1<<k)) == 0) continue;
            for(int i = 0; i < n; i++){
                if((mask&(1<<i)) == 0) continue;
                for(int j = 0; j < n; j++){
                    if((mask&(1<<j)) == 0) continue;
                    if(d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE)
                    d[i][j] = Math.min(d[i][j] , d[i][k]+d[k][j]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if((mask&(1<<i)) != 0){
                for(int j = i+1; j < n; j++){
                    if((mask&(1<<j)) != 0){
                        if(d[i][j] > maxDistance)
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int[][] a = new int[n][n];
        for(int[] b : a){
            Arrays.fill(b , Integer.MAX_VALUE);
        }
        for(int i = 0; i < n; i++){
            a[i][i] = 0;
        }
        for(int[] x : roads){
            a[x[0]][x[1]] = Math.min(a[x[0]][x[1]] , x[2]);
            a[x[1]][x[0]] = Math.min(a[x[1]][x[0]] , x[2]);
        }
        int ans = 0;
        for(int mask = 0; mask < (1<<n); mask++){
            if(check(mask , n , maxDistance , a))
            ans++;
        }
        return ans;
    }
}