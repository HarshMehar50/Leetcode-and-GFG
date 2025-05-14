class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0 && n == 1){
            List<Integer> a = new ArrayList<>();
            a.add(0);
            return a;
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1)
                q.offer(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(n > 2){
            int l = q.size();
            n = n-l;
            for(int i = 0; i < l; i++){
                int node = q.poll();
                for(int j = 0; j < adj.get(node).size(); j++){
                    degree[adj.get(node).get(j)]--;
                    if(degree[adj.get(node).get(j)] == 1)
                        q.offer(adj.get(node).get(j));
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.peek());
            q.poll();
        }
        return ans;
    }
}