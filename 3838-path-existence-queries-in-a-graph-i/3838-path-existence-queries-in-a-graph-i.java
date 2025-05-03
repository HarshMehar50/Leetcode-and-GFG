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
    int floor(int[] arr , int x){
        int s = 0;
        int e = arr.length-1;
        int floor = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(arr[m] == x)
            return m;
            else if(arr[m] < x){
                floor = m;
                s = m+1;
            }else
            e = m-1;
        }
        return floor;
    }
    int ceil(int[] arr , int x){
        int s = 0;
        int e = arr.length-1;
        int ceil = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(arr[m] == x)
            return m;
            else if(arr[m] < x)
            s = m+1;
            else{
                ceil = m;
                e = m-1;
            }
        }
        return ceil;
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DisjointSet ds = new DisjointSet(n);
        int[][] range = new int[n][2];
        for(int i = 0; i < nums.length; i++){
            /*for(int j = 0; j <= maxDiff; j++){
                int n1 = Arrays.binarySearch(nums , nums[i]+j);
                int n2 = Arrays.binarySearch(nums , nums[i]-j);
                if(n1 >= 0 && n1 < n){
                    if(ds.findParent(i) != ds.findParent(n1))
                    ds.unionSetRank(i , n1);
                }
                if(n2 >= 0 && n2 < n){
                    if(ds.findParent(i) != ds.findParent(n2))
                    ds.unionSetRank(i , n2);
                }
            }*/
            int e = floor(nums , nums[i]+maxDiff);
            int s = ceil(nums , nums[i]-maxDiff);
            /*for(int j = s; j <= e; j++){
                if(j >= 0 && j < n && ds.findParent(j) != ds.findParent(i))
                ds.unionSetRank(i , j);
            }*/
            range[i][0] = Math.max(0 , s);
            range[i][1] = Math.min(e , n-1);
        }
        List<int[]> l = new ArrayList<>();
        l.add(range[0]);
        for(int i = 1; i < n; i++){
            if(range[i][0] <= l.get(l.size()-1)[1])
            l.get(l.size()-1)[1] = range[i][1];
            else
            l.add(range[i]);
        }
        int[] p = new int[n];
        for(int i = 0; i < l.size(); i++){
            for(int j = l.get(i)[0]; j <= l.get(i)[1]; j++){
                p[j] = l.get(i)[0];
            }
        }
        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            //if(ds.findParent(queries[i][0]) == ds.findParent(queries[i][1]))
            if(p[queries[i][0]] == p[queries[i][1]])
            ans[i] = true;
        }
        return ans;
    }
}