class Solution {
    /*List<Integer> BFS(HashMap<Integer , List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        List<Integer> sizes = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()+1];
        visited[1] = true;
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int j = 0; j < l; j++){
            int c = q.poll();
            inner.add(c);
            for(int i = 0; i < adj.get(c).size(); i++){
                if(!visited[adj.get(c).get(i)]){
                    q.offer(adj.get(c).get(i));
                    visited[adj.get(c).get(i)] = true;
                }
            }
            }
            sizes.add(inner.size());
        }
        return sizes;
    }*/
    void DFS(int s , int parent , HashMap<Integer , List<Integer>> adj , List<List<Integer>> ans , List<Integer> inner , int d){
        inner.add(s);
        if(s == d){
            List<Integer> c = new ArrayList<>(inner);
            ans.add(c);
            inner.remove(inner.size() - 1);
            return;
        }
        List<Integer> child = adj.get(s);
        if (child == null || child.isEmpty()) {
            inner.remove(inner.size() - 1);
            return;
        }
        for(int i = 0; i < child.size(); i++){
            if(child.get(i) != parent)
                DFS(child.get(i) , s , adj , ans , inner , d);
        }
        inner.remove(inner.size()-1);
    }
    List<List<Integer>> allPaths(HashMap<Integer , List<Integer>> adj , int s , int d){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        DFS(s , -1 , adj , ans , inner , d);
        return ans;
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(target == 1 && edges.length != 0){
            return 0;
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<List<Integer>> paths = allPaths(adj , 1 , target);
        List<List<Integer>> validPaths = new ArrayList<>();
        for (List<Integer> path : paths) {
            if (path.size() <= t + 1) {
                validPaths.add(path);
            }
        }
        if (validPaths.isEmpty()) {
            return 0;
        }
        /*List<Double> ans = new ArrayList<>();
        for(List<Integer> l : paths){
            double p = 1;
            for(int i = 0; i < l.size()-1; i++){
                p = p/adj.get(l.get(i)).size();
            }
            ans.add(p);
        }
        if(ans.isEmpty())
        return 0;
        else
        return ans.get(0);*/
        List<Integer> validPath = validPaths.get(0);
        double p = 1.0;
        for(int i = 0; i < validPath.size()-1; i++){
            int node = validPath.get(i);
            int nchild = adj.get(node).size();
            if(i > 0){
                nchild--;
            }
            p = p/nchild;
        }
        if(validPath.size()-1 < t && adj.get(target).size() > 1)
            return 0;
        return p;
    }
}