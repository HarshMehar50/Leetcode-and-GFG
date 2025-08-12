class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for(int i = 0; i < relations.length; i++){
            adj.get(relations[i][0]).add(relations[i][1]);
            indegree[relations[i][1]]++;
        }
        int[] ct = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0)
            q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer x : adj.get(node)){
                indegree[x]--;
                if(indegree[x] == 0)
                q.offer(x);
                ct[x] = Math.max(ct[node]+time[node-1] , ct[x]);
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ct[i]+time[i-1] , ans);
        }
        return ans;
    }
}