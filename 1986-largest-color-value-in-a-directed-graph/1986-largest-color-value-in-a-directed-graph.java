class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < colors.length(); i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[colors.length()];
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        int c = 0;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < colors.length(); i++){
            if(indegree[i] == 0)
                q.offer(i);
        }
        int[][] dp = new int[colors.length()][26];
        while(!q.isEmpty()){
            int node = q.poll();
            c++;
            dp[node][(int)(colors.charAt(node)-'a')]++;
            ans = Math.max(ans , dp[node][(int)(colors.charAt(node)-'a')]);
            for(Integer x : adj.get(node)){
                for(int i = 0; i < 26; i++){
                    dp[x][i] = Math.max(dp[node][i] , dp[x][i]);
                }
                indegree[x]--;
                if(indegree[x] == 0)
                    q.offer(x);
            }
        }
        if(c != colors.length())
            return -1;
        return ans;
    }
}