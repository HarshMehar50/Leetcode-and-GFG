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
    boolean predicate(int row , int col , HashMap<Integer , Integer> map , int m){
        DisjointSet ds = new DisjointSet(row*col);
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                int cn = ((i-1)*col)+j;
                if(!map.containsKey(cn) || (map.containsKey(cn) && map.get(cn) > m)){
                    for(int k = 0; k < 4; k++){
                        int nr = i+dR[k];
                        int nc = j+dC[k];
                        if(nr <= row && nr >= 1 && nc <= col && nc >= 1){
                            int nn = (nr-1)*col+nc;
                            if(!map.containsKey(nn) || (map.containsKey(nn) && map.get(nn) > m))
                            ds.unionSetRank(cn , nn);
                        }
                    }
                }
            }
        }
        Set<Integer> set1 = new HashSet<>();
        for(int i = 1; i <= col; i++){
            if(!map.containsKey(i) || (map.containsKey(i) && map.get(i) > m))
            set1.add(ds.findParent(i));
        }
        for(int i = (row-1)*col+1; i <= row*col; i++){
            if(!map.containsKey(i) || (map.containsKey(i) && map.get(i) > m))
            if(set1.contains(ds.findParent(i)))
            return true;
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int s = 0;
        int e = cells.length-1;
        int ans = -1;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < cells.length; i++){
            map.put(((cells[i][0]-1)*col)+cells[i][1] , i);
        }
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(row , col , map , m)){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        if(ans == -1)
        return -1;
        return ans+1;
    }
}