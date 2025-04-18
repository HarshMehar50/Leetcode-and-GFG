class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n+1][n+1];
        int[] degree = new int[n+1];
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]][edges[i][1]] = true;
            graph[edges[i][1]][edges[i][0]] = true;
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(graph[i][j] || graph[j][i]){
                    for(int k = 1; k <= n; k++){
                        if((graph[j][k] || graph[k][j])&&(graph[i][k] || graph[k][i]))
                        ans = Math.min(ans , degree[i]+degree[j]+degree[k]-6);
                    }
                }
            }
        }
        return ans;
    }
}