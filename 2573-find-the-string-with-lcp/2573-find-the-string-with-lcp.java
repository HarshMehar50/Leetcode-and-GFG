class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
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
    public String findTheString(int[][] lcp) {
        for(int i = 0; i < lcp.length; i++){
            for(int j = 0; j < lcp[0].length; j++){
                int l1 = lcp.length-i;
                int l2 = lcp[0].length-j;
                if(lcp[i][j] > Math.min(l1 , l2))
                return "";
            }
        }
        DisjointSet ds = new DisjointSet(lcp.length);
        for(int i = 0; i < lcp.length; i++){
            for(int j = i+1; j < lcp[0].length; j++){
                for(int k = 0; k < lcp[i][j]; k++){
                    ds.unionSetRank(i+k , j+k);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Integer , Character> map = new HashMap<>();
        char c = 'a';
        for(int i = 0; i < lcp.length; i++){
            int p = ds.findParent(i);
            if(map.containsKey(p)){
                sb.append(map.get(p));
            }else{
                map.put(p, c);
                sb.append(c);
                c++;
            }
        }
        String res = sb.toString();

    
    int[][] calc = new int[lcp.length][lcp[0].length];
    for(int i = lcp.length - 1; i >= 0; i--){
        for(int j = lcp[0].length - 1; j >= 0; j--){
            if(res.charAt(i) == res.charAt(j)){
                calc[i][j] = 1;
                if(i + 1 < lcp.length && j + 1 < lcp[0].length){
                    calc[i][j] += calc[i + 1][j + 1];
                }
            }
        }
    }

    for(int i = 0; i < lcp.length; i++){
        for(int j = 0; j < lcp[0].length; j++){
            if(calc[i][j] != lcp[i][j]){
                return "";
            }
        }
    }
    for(int i = 0; i < res.length(); i++){
        if(!(res.charAt(i) >= 'a' && res.charAt(i) <= 'z'))
        return "";
    }
    return res;
    }
}