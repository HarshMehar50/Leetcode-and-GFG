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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet ds = new DisjointSet(s.length());
        for(List<Integer> l : pairs){
            if(ds.findParent(l.get(0)) != ds.findParent(l.get(1)))
            ds.unionSetRank(l.get(0) , l.get(1));
        }
        HashMap<Integer , List<Integer>> mapi = new HashMap<>();
        HashMap<Integer , List<Integer>> mapc = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            mapi.put(ds.findParent(i) , new ArrayList<>());
            mapc.put(ds.findParent(i) , new ArrayList<>());
        }
        for(int i = 0; i < s.length(); i++){
            mapi.get(ds.findParent(i)).add(i);
            mapc.get(ds.findParent(i)).add((int)(s.charAt(i)-'a'));
        }
        for(Integer x : mapc.keySet()){
            Collections.sort(mapc.get(x));
        }
        StringBuilder sb = new StringBuilder(s);
        for(Integer x : mapi.keySet()){
            for(int i = 0; i < mapi.get(x).size(); i++){
                sb.setCharAt(mapi.get(x).get(i) , (char)(mapc.get(x).get(i)+'a'));
            }
        }
        return sb.toString();
    }
}