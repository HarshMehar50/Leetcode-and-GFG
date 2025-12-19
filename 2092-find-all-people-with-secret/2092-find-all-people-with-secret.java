class Solution {
    /*class DisjointSet{
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
    }*/
    class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }

        void reset(int x) {
            parent[x] = x;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings , (x , y)->Integer.compare(x[2] , y[2]));
        /*TreeMap<Integer , List<int[]>> map = new TreeMap<>();
        for(int i = 0; i < meetings.length; i++){
            map.put(meetings[i][2] , new ArrayList<>());
        } 
        for(int i = 0; i < meetings.length; i++){
            map.get(meetings[i][2]).add(meetings[i]);
        }
        boolean[] know = new boolean[n];
        know[0] = true;
        know[firstPerson] = true;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);
        DisjointSet ds = new DisjointSet(n);
        ds.unionSetRank(0 , firstPerson);
        for(Integer x : map.keySet()){
            for(int[] a : map.get(x)){
                if(know[a[0]] || know[a[1]]){
                    ds.unionSetRank(a[0] , a[1]);
                    set.add(a[0]);
                    set.add(a[1]);
                    know[a[0]] = true;
                    know[a[1]] = true;
                }
            }
            for(int[] a : map.get(x)){
                if(know[a[0]] || know[a[1]]){
                    ds.unionSetRank(a[0] , a[1]);
                    set.add(a[0]);
                    set.add(a[1]);
                    know[a[0]] = true;
                    know[a[1]] = true;
                }
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        return ans;*/
        DisjointSet ds = new DisjointSet(n);
        ds.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<Integer> people = new ArrayList<>();
            while (i < meetings.length && meetings[i][2] == time) {
                ds.union(meetings[i][0], meetings[i][1]);
                people.add(meetings[i][0]);
                people.add(meetings[i][1]);
                i++;
            }
            for (int p : people) {
                if (ds.find(p) != ds.find(0)) {
                    ds.reset(p);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (ds.find(j) == ds.find(0)) {
                ans.add(j);
            }
        }
        return ans;
    }
}