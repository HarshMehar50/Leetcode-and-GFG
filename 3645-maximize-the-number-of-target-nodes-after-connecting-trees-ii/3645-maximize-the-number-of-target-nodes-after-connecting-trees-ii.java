class Solution {
    /*int BFS(HashMap<Integer , List<Integer>> adj , int root , boolean even){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.offer(root);
        visited[root] = true;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int l = q.size();
            list.add(l);
            for(int i = 0; i < l; i++){
                int node = q.poll();
                for(Integer x : adj.get(node)){
                    if(!visited[x]){
                        q.offer(x);
                        visited[x] = true;
                    }
                } 
            }
        }
        int es = 0;
        int os = 0;
        for(int i = 0; i < list.size(); i++){
            if(i%2 == 0)
            es += list.get(i);
            else
            os += list.get(i);
        }
        if(even)
        return es;
        else
        return os;
    }*/
    List<List<Integer>> BFS(HashMap<Integer , List<Integer>> adj){
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                int node = q.poll();
                inner.add(node);
                for(Integer x : adj.get(node)){
                    if(!visited[x]){
                        q.offer(x);
                        visited[x] = true;
                    }
                }
            }
            list.add(inner);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(i%2 == 0)
            even.addAll(list.get(i));
            else
            odd.addAll(list.get(i));
        }
        ans.add(even);
        ans.add(odd);
        return ans;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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
        /*int[] d1 = new int[edges1.length+1];
        for(int i = 0; i <= edges1.length; i++){
            d1[i] = BFS(adj1 , i , true);
        }
        int max = 0;
        for(int i = 0; i <= edges2.length; i++){
            max = Math.max(max , BFS(adj2 , i , false));
        }
        for(int i = 0; i < d1.length; i++){
            d1[i] += max;
        }
        return d1;*/
        int[] ans = new int[edges1.length+1];
        List<List<Integer>> list1 = BFS(adj1);
        List<List<Integer>> list2 = BFS(adj2);
        int max = Math.max(list2.get(0).size() , list2.get(1).size());
        int[] value = new int[edges1.length+1];
        for(List<Integer> l : list1){
            for(Integer x : l){
                value[x] = l.size();
            }
        }
        for(int i = 0; i < ans.length; i++){
            ans[i] = value[i]+max;
        }
        return ans;
    }
}