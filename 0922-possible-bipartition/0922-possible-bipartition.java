class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < dislikes.length; i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] c = new int[n+1];
        Arrays.fill(c , -1);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(c[i] != -1) continue;
            q.offer(i);
            c[i] = 0;
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
        return true;
    }
}