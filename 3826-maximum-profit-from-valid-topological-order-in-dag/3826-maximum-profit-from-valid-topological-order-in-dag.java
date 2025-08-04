class Solution {
    public int maxProfit(int n, int[][] edges, int[] score) {
        HashMap<Integer , List<Integer>> preadj = new HashMap<>();
        for(int i = 0; i < n; i++){
            preadj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < edges.length; i++){
            preadj.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][1]]++;
        }
        /*Queue<int[]> q = new LinkedList<>();
        int[][] dp = new int[n][(1<<n)];
         for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.offer(new int[]{i , (1<<i)});
                dp[i][(1<<i)] = score[i];
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int mask = q.peek()[1];
            q.poll();
            for(Integer x : adj.get(node)){
                indegree[x]--;
                if(indegree[x] == 0){
                    int nmask = mask|(1<<x);
                    q.offer(new int[]{x , nmask});
                    dp[x][nmask] = (Integer.bitCount(nmask)*score[x])+dp[node][mask];
                }
            }
        }
        for(int i = 0; i < n; i++){
            ans = Math.max(ans , dp[i][(1<<n)-1]);
        }
        return ans;*/
        int ans = 0;
        int[] dp = new int[(1<<n)];
        Arrays.fill(dp , -1);
        dp[0] = 0;
        for(int mask = 0; mask < (1<<n); mask++){
            if(dp[mask] != -1){
                for(int i = 0; i < n; i++){
                    if((mask&(1<<i)) == 0){
                        boolean t = true;
                        for(Integer x : preadj.get(i)){
                            if((mask&(1<<x)) == 0){
                                t = false;
                                break;
                            }
                        }
                        if(t){
                            dp[mask|(1<<i)] = Math.max(dp[mask|(1<<i)] , dp[mask]+(Integer.bitCount(mask|(1<<i))*score[i]));
                            ans = Math.max(ans , dp[mask|(1<<i)]);
                        }
                    }
                }
            }
        }
        return ans;
    }
}