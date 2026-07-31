class Solution {
    public int candy(int[] ratings) {
        //Arrays.sort(ratings);
        /*int[] dp = new int[ratings.length];
        Arrays.fill(dp , 1);
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[dp.length];
        for(int i = 0; i < ratings.length; i++){
            min = Math.min(min , ratings[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < ratings.length; i++){
            if(ratings[i] == min){
            q.offer(i);
            visited[i] = true;
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            if(node-1 >= 0 && ratings[node] > ratings[node-1])
            dp[node] = Math.max(dp[node] , dp[node-1]+1);
            if(node+1 < ratings.length && ratings[node] > ratings[node+1])
            dp[node] = Math.max(dp[node] , dp[node+1]+1);
            if(node-1 >= 0 && !visited[node-1]){
            q.offer(node-1);
            visited[node-1] = true;
            }
            if(node+1 < dp.length && !visited[node+1]){
            q.offer(node+1);
            visited[node+1] = true;
            }
        }
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            ans += dp[i];
        }
        return ans;*/
        int[][] a = new int[ratings.length][2];
        for(int i = 0; i < a.length; i++){
            a[i][0] = ratings[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        int[] dp = new int[a.length];
        Arrays.fill(dp , 1);
        for(int i = 0; i < a.length; i++){
            if(a[i][1] > 0 && ratings[a[i][1]] > ratings[a[i][1]-1])
            dp[a[i][1]] = Math.max(dp[a[i][1]] , dp[a[i][1]-1]+1);
            if(a[i][1]+1 < a.length && ratings[a[i][1]] > ratings[a[i][1]+1])
            dp[a[i][1]] = Math.max(dp[a[i][1]] , dp[a[i][1]+1]+1);
        }
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            ans += dp[i];
        }
        return ans;
    }
}