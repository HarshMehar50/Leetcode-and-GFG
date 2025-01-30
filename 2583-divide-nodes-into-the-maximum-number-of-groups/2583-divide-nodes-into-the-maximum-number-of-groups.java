class Solution {
    int BFS(int n , HashMap<Integer , List<Integer>> adj , int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        boolean[] visited = new boolean[n+1];
        visited[s] = true;
        int level = 0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                int node = q.poll();
                for(Integer x : adj.get(node)){
                    if(!visited[x]){
                        q.offer(x);
                        visited[x] = true;
                    }
                }
            }
            level++;
        }
        return level;
    }
    int maxComp(HashMap<Integer , List<Integer>> adj , int node , boolean[] visited , int[] levels){
        int max = levels[node];
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            max = Math.max(max , maxComp(adj , x , visited , levels));
        }
        return max;
    }
    boolean checkBipartite(int n , HashMap<Integer , List<Integer>> adj){
        int[] c = new int[n+1];
        Arrays.fill(c , -1);
        for(int i = 1; i <= n; i++){
            if(c[i] == -1){
                c[i] = 0;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(Integer x : adj.get(node)){
                        if(c[x] == -1){
                            c[x] = 1-c[node];
                            q.offer(x);
                        }else if(c[x] == c[node])
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int magnificentSets(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean bipartite = checkBipartite(n , adj);
        if(!bipartite)
        return -1;
        else{
            int[] levels = new int[n+1];
            for(int i = 1; i <= n; i++){
                levels[i] = BFS(n , adj , i);
            }
            int ans = 0;
            boolean[] visited = new boolean[n+1];
            for(int i = 1; i <= n; i++){
                if(!visited[i])
                ans += maxComp(adj , i , visited , levels);
            }
            return ans;
        }
    }
}