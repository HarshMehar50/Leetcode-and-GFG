class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            size = new int[n+1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        void unionSetRank(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp)
            return;
            if(rank[up] < rank[vp]){
                parent[up] = vp;
            }else if(rank[vp] < rank[up]){
                parent[vp] = up;
            }else{
                parent[up] = vp;
                rank[vp]++;
            }
        }
        void unionSetSize(int u , int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp)
            return;
            if(size[up] < size[vp]){
                parent[up] = vp;
                size[vp] = size[vp]+size[up];
            }else{
                parent[vp] = up;
                size[up] = size[up]+size[vp];
            }
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges , (x , y)->Integer.compare(y[0] , x[0]));
        DisjointSet dsA = new DisjointSet(n);
        DisjointSet dsB = new DisjointSet(n);
        int c = 0;
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == 3 && dsA.findParent(edges[i][1]) != dsA.findParent(edges[i][2])){
            dsA.unionSetRank(edges[i][1] , edges[i][2]);
            dsB.unionSetRank(edges[i][1] , edges[i][2]);
            c++;
            }
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == 2 && dsB.findParent(edges[i][1]) != dsB.findParent(edges[i][2])){
            dsB.unionSetRank(edges[i][1] , edges[i][2]);
            c++;
            }
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == 1 && dsA.findParent(edges[i][1]) != dsA.findParent(edges[i][2])){
            dsA.unionSetRank(edges[i][1] , edges[i][2]);
            c++;
            }
        }
        boolean alice = true;
        boolean bob = true;
        for(int i = 1; i <= n; i++){
            if(dsA.findParent(i) != dsA.findParent(1))
            alice = false;
            if(dsB.findParent(i) != dsB.findParent(1))
            bob = false;
        } 
        if(!alice || !bob)
        return -1;

        return edges.length-c;
    }
}