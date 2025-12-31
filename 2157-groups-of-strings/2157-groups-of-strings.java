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
    public int[] groupStrings(String[] words) {
        DisjointSet ds = new DisjointSet(words.length);
        int[] masks = new int[words.length];
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            int mask = 0;
            for(int j = 0; j < words[i].length(); j++){
                mask = mask|(1<<(words[i].charAt(j)-'a'));
            }
            masks[i] = mask;
            if(map.containsKey(mask))
            ds.unionSetSize(i , map.get(mask));
            else
            map.put(mask , i);
        }
        for(int i = 0; i < masks.length; i++){
            int mask = masks[i];
            for(int j = 0; j < 26; j++){
                if((mask&(1<<j)) == 0) continue;
                int nmask = mask^(1<<j);
                if(map.containsKey(nmask))
                ds.unionSetSize(i , map.get(nmask));
            }
            for(int j = 0; j < 26; j++){
                if((mask&(1<<j)) != 0) continue;
                int nmask = mask|(1<<j);
                if(map.containsKey(nmask))
                ds.unionSetSize(i , map.get(nmask));
            }
            for(int j = 0; j < 26; j++){
                if((mask&(1<<j)) == 0) continue;
                for(int k = 0; k < 26; k++){
                    if((mask&(1<<k)) != 0) continue;
                    int nmask = (mask^(1<<j))|(1<<k);
                    if(map.containsKey(nmask))
                    ds.unionSetSize(i , map.get(nmask));
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            set.add(ds.findParent(i));
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            max = Math.max(max , ds.size[i]);
        }
        return new int[]{set.size() , max};
    }
}