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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                if(!map.containsKey(accounts.get(i).get(j)))
                map.put(accounts.get(i).get(j) , i);
                else
                ds.unionSetSize(i , map.get(accounts.get(i).get(j)));
            }
        }
        List<String>[] merge = new ArrayList[accounts.size()];
        for(int i = 0; i < accounts.size(); i++){
            merge[i] = new ArrayList<String>();
        }
        for(Map.Entry<String , Integer> m : map.entrySet()){
            String mail = m.getKey();
            int node = ds.findParent(m.getValue());
            merge[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            if(merge[i].size() == 0) continue;
            Collections.sort(merge[i]);
            List<String> inner = new ArrayList<>();
            inner.add(accounts.get(i).get(0));
            for(String s : merge[i]){
                inner.add(s);
            }
            ans.add(inner);
        }
        return ans;
    }
}