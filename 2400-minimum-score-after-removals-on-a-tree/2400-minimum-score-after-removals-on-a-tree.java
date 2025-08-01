class Solution {
    /*boolean isAncestors(int u , int v , int[][] ancestors){
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < ancestors[0].length; i++){
            if(ancestors[v][i] != -1){
                l.add(ancestors[v][i]);
                v = ancestors[v][i];
            }
        }
        if(l.contains(u))
        return true;
        else
        return false;
    }
    void DFS(HashMap<Integer , List<Integer>> adj , int[] nums , int node , int parent , int[] subxor , int[][] ancestors){
        subxor[node] = nums[node];
        ancestors[node][0] = parent;
        for(int i = 1; i < ancestors[0].length; i++){
            if(ancestors[node][i-1] != -1)
            ancestors[node][i] = ancestors[ancestors[node][i-1]][i-1];
        }
        for(Integer x : adj.get(node)){
            if(x != parent){
                DFS(adj , nums , x , node , subxor , ancestors);
                subxor[node] = subxor[node]^subxor[x];
            }
        }
    }*/
    boolean isAncestors(int u , int v , List<Integer>[] descendents){
        int bs = Collections.binarySearch(descendents[u] , v);
        if(bs >= 0 && bs < descendents[u].size())
        return true;
        else
        return false;
    }
    void DFS(HashMap<Integer , List<Integer>> adj , int[] nums , int node , int parent , int[] subxor , List<Integer>[] descendents){
        subxor[node] = nums[node];
        descendents[node].add(node);
        for(Integer x : adj.get(node)){
            if(x != parent){
                DFS(adj , nums , x , node , subxor , descendents);
                subxor[node] = subxor[node]^subxor[x];
                descendents[node].addAll(descendents[x]);
            }
        }
    }
    public int minimumScore(int[] nums, int[][] edges) {
        /*HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] subxor = new int[nums.length];
        int log = (int)(Math.log(nums.length)/Math.log(2))+1;
        int[][] ancestors = new int[nums.length][log+1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(ancestors[i] , -1);
        }

        DFS(adj , nums , 0 , -1 , subxor , ancestors);
        int ans = Integer.MAX_VALUE;
        
        int txor = subxor[0];
        for(int i = 0; i < ancestors.length; i++){
            System.out.println(Arrays.toString(ancestors[i]));
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                if(isAncestors(i , j , ancestors)){
                    c1 = subxor[0]^subxor[i];
                    c2 = subxor[j]^subxor[i];
                    c3 = subxor[j];
                }else if(isAncestors(j , i , ancestors)){
                    c1 = subxor[0]^subxor[j];
                    c2 = subxor[i]^subxor[j];
                    c3 = subxor[i];
                }else{
                    c1 = subxor[0]^subxor[i]^subxor[j];
                    c2 = subxor[i];
                    c3 = subxor[j];
                }
                ans = Math.min(ans , Math.max(c1 , Math.max(c2 , c3))-Math.min(c1 , Math.min(c2 , c3)));
            }
        }
        return ans;*/
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer>[] descendents = new ArrayList[nums.length];
        int[] subxor = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            descendents[i] = new ArrayList<>();
        }
        DFS(adj , nums , 0 , -1 , subxor , descendents);
        for(int i = 0; i < nums.length; i++){
            Collections.sort(descendents[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                if(isAncestors(i , j , descendents)){
                    c1 = subxor[0]^subxor[i];
                    c2 = subxor[j]^subxor[i];
                    c3 = subxor[j];
                }else if(isAncestors(j , i , descendents)){
                    c1 = subxor[0]^subxor[j];
                    c2 = subxor[i]^subxor[j];
                    c3 = subxor[i];
                }else{
                    c1 = subxor[0]^subxor[i]^subxor[j];
                    c2 = subxor[i];
                    c3 = subxor[j];
                }
                ans = Math.min(ans , Math.max(c1 , Math.max(c2 , c3))-Math.min(c1 , Math.min(c2 , c3)));
            }
        }
        return ans;
    }
}