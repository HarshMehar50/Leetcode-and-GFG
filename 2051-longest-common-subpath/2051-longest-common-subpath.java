class Solution {class Hashing {
    static final long MOD1 = 1_000_000_007;
    static final long MOD2 = 1_000_000_009;
    static final long BASE = 100_007;
    List<long[]> hash1, hash2;
    List<long[]> power1, power2;
    int maxLength;
    public Hashing(List<int[]> paths) {
        this.maxLength = 0;
        for (int[] path : paths)
            maxLength = Math.max(maxLength, path.length);
        precomputePowers(maxLength);
        hash1 = new ArrayList<>();
        hash2 = new ArrayList<>();
        for (int[] path : paths) {
            hash1.add(buildHash(path, MOD1, BASE));
            hash2.add(buildHash(path, MOD2, BASE));
        }
    }
    private void precomputePowers(int len) {
        power1 = new ArrayList<>();
        power2 = new ArrayList<>();
        long[] p1 = new long[len + 1];
        long[] p2 = new long[len + 1];
        p1[0] = p2[0] = 1;
        for (int i = 1; i <= len; i++) {
            p1[i] = (p1[i - 1] * BASE) % MOD1;
            p2[i] = (p2[i - 1] * BASE) % MOD2;
        }
        power1.add(p1);
        power2.add(p2);
    }
    private long[] buildHash(int[] path, long mod, long base) {
        long[] hash = new long[path.length + 1];
        for (int i = 0; i < path.length; i++) {
            hash[i + 1] = (hash[i] * base + path[i]) % mod;
        }
        return hash;
    }
    public long[] subHash(int pathIdx, int l, int r) {
        long[] h1 = hash1.get(pathIdx);
        long[] h2 = hash2.get(pathIdx);
        long[] p1 = power1.get(0);
        long[] p2 = power2.get(0);
        long hashVal1 = (h1[r + 1] - h1[l] * p1[r - l + 1] % MOD1 + MOD1) % MOD1;
        long hashVal2 = (h2[r + 1] - h2[l] * p2[r - l + 1] % MOD2 + MOD2) % MOD2;
        return new long[]{hashVal1, hashVal2};
    }
    }
    Hashing h;
    boolean predicate(int m , List<int[]> l){
        /*Set<String> set = new HashSet<>();
        for(int i = 0; i < l.size(); i++){
            for(int j = 0; j+m-1 < l.get(i).length; j++){
                long[] sh = h.subHash(i , j , j+m-1);
                set.add(sh[0]+" "+sh[1]); 
            }
        }
        int t = 0;
        for(int i = 0; i < l.size(); i++){
            t += l.get(i).length-m+1;
        }
        t = t-(l.size()-1);
        if(set.size() <= t)
        return true;
        else
        return false;*/
        HashMap<String , Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < l.size(); i++){
            for(int j = 0; j+m-1 < l.get(i).length; j++){
                long[] sh = h.subHash(i , j , j+m-1);
                //map.put(sh[0]+" "+sh[1] , map.getOrDefault(sh[0]+" "+sh[1] , 0)+1);
                if(!map.containsKey(sh[0]+" "+sh[1]))
                map.put(sh[0]+" "+sh[1] , new HashSet<>());
                map.get(sh[0]+" "+sh[1]).add(i);
            }
        }
        for(String s : map.keySet()){
            if(map.get(s).size() == l.size())
            return true;
        }
        return false;
    }
    public int longestCommonSubpath(int n, int[][] paths) {
        List<int[]> l = new ArrayList<>();
        int e = Integer.MAX_VALUE;
        for(int i = 0; i < paths.length; i++){
            l.add(paths[i]);
            e = Math.min(e , paths[i].length);
        } 
        h = new Hashing(l);
        int s = 0;
        int ans = 0;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(m , l)){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        return ans;
    }
}