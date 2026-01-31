// User function Template for Java

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
    
    ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
        // code here
        Arrays.sort(edges , (x , y)->Integer.compare(x[2] , y[2]));
        DisjointSet ds = new DisjointSet(n);
        int[][] a = new int[q][2];
        for(int i = 0; i < q; i++){
            a[i][0] = queries[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        int j = 0;
        int[] ans = new int[q];
        int paths = 0;
        for(int i = 0; i < q; i++){
            while(j < edges.length && edges[j][2] <= a[i][0]){
                int s1 = ds.size[ds.findParent(edges[j][0])];
                int s2 = ds.size[ds.findParent(edges[j][1])];
                int p1 = s1*(s1-1)/2;
                int p2 = s2*(s2-1)/2;
                ds.unionSetSize(edges[j][0] , edges[j][1]);
                paths = paths-(p1+p2);
                int ns = ds.size[ds.findParent(edges[j][0])];
                paths += ns*(ns-1)/2;
                j++;
            }
            ans[a[i][1]] = paths;
        }
        ArrayList<Integer> fans = new ArrayList<>();
        for(int i = 0; i < q; i++){
            fans.add(ans[i]);
        }
        return fans;
    }
}