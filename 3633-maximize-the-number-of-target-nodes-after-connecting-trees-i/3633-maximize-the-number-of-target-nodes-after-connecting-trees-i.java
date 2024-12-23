class Solution {
    int BFS(HashMap<Integer , List<Integer>> adj , int s , int d){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[s] = true;
        q.offer(s);
        int ans = 0;
        int level = 0;
        while(!q.isEmpty() && level <= d){
            int l = q.size();
            ans += l;
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
        return ans; 
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        HashMap<Integer , List<Integer>> adj1 = new HashMap<>();
        HashMap<Integer , List<Integer>> adj2 = new HashMap<>();
        for(int i = 0; i <= edges1.length; i++){
            adj1.put(i , new ArrayList<>());
        }
        for(int i = 0; i <= edges2.length; i++){
            adj2.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges1.length; i++){
            adj1.get(edges1[i][0]).add(edges1[i][1]);
            adj1.get(edges1[i][1]).add(edges1[i][0]);
        }
        for(int i = 0; i < edges2.length; i++){
            adj2.get(edges2[i][0]).add(edges2[i][1]);
            adj2.get(edges2[i][1]).add(edges2[i][0]);
        }
        int[] t1 = new int[edges1.length+1];
        int[] t2 = new int[edges2.length+1];
        for(int i = 0; i <= edges1.length; i++){
            t1[i] = BFS(adj1 , i , k);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= edges2.length; i++){
            t2[i] = BFS(adj2 , i , k-1);
            max = Math.max(max , t2[i]);
        }
        int[] ans = new int[edges1.length+1];
        for(int i = 0; i <= edges1.length; i++){
            ans[i] = t1[i]+max;
        }
        return ans;
    }
}