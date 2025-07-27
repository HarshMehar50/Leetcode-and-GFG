class Solution {
    class Hashing {
        String s;
        int n;
        int primesCount;
        List<Long> hashPrimes = Arrays.asList(1000000009L, 1000000007L);
        final long base = 27;
        List<long[]> hashValues;
        List<long[]> powersOfBase;
        List<long[]> inversePowersOfBase;

        public Hashing(String a) {
            s = a;
            n = s.length();
            primesCount = hashPrimes.size();

            hashValues = new ArrayList<>();
            powersOfBase = new ArrayList<>();
            inversePowersOfBase = new ArrayList<>();

            for (int i = 0; i < primesCount; i++) {
                long[] power = new long[n + 1];
                long[] invPower = new long[n + 1];
                long mod = hashPrimes.get(i);
                power[0] = 1;

                for (int j = 1; j <= n; j++) {
                    power[j] = (power[j - 1] * base) % mod;
                }

                invPower[n] = modInverse(power[n], mod);
                for (int j = n - 1; j >= 0; j--) {
                    invPower[j] = (invPower[j + 1] * base) % mod;
                }

                powersOfBase.add(power);
                inversePowersOfBase.add(invPower);
            }

            for (int i = 0; i < primesCount; i++) {
                long[] hash = new long[n];
                long mod = hashPrimes.get(i);
                long[] power = powersOfBase.get(i);

                for (int j = 0; j < n; j++) {
                    hash[j] = ((s.charAt(j) - 'a' + 1L) * power[j]) % mod;
                    if (j > 0) hash[j] = (hash[j] + hash[j - 1]) % mod;
                }

                hashValues.add(hash);
            }
        }

        public List<Long> substringHash(int l, int r) {
            List<Long> hash = new ArrayList<>();
            for (int i = 0; i < primesCount; i++) {
                long mod = hashPrimes.get(i);
                long[] hashVal = hashValues.get(i);
                long[] invPower = inversePowersOfBase.get(i);

                long val1 = hashVal[r];
                long val2 = l > 0 ? hashVal[l - 1] : 0;
                long subHash = (val1 - val2 + mod) % mod;
                subHash = (subHash * invPower[l]) % mod;
                hash.add(subHash);
            }
            return hash;
        }

        private long modInverse(long a, long mod) {
            return powMod(a, mod - 2, mod);
        }

        private long powMod(long a, long b, long mod) {
            long result = 1;
            a %= mod;
            while (b > 0) {
                if ((b & 1) == 1) result = (result * a) % mod;
                a = (a * a) % mod;
                b >>= 1;
            }
            return result;
        }
    }

    StringBuilder s1;
    
    void DFS(HashMap<Integer , TreeSet<Integer>> adj , boolean[] visited , int node , String s , int[] subTree , List<Integer> l){
        visited[node] = true;
        subTree[node] = 1;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                DFS(adj , visited , x , s , subTree , l);
                subTree[node] += subTree[x];
            }
        }
        l.add(node);
        s1.append(s.charAt(node));
    }
    public boolean[] findAnswer(int[] parent, String s) {
        HashMap<Integer , TreeSet<Integer>> adj = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            adj.put(i , new TreeSet<>());
        }
        for(int i = 0; i < parent.length; i++){
            if(parent[i] != -1)
            adj.get(parent[i]).add(i);
        }
        s1 = new StringBuilder();
        boolean[] visited = new boolean[parent.length];
        int[] subTree = new int[parent.length];
        List<Integer> l = new ArrayList<>();
        DFS(adj , visited , 0 , s , subTree , l);
        Collections.reverse(l);
        String s2 = s1.toString();
        String fs = s1.reverse().toString();
        boolean[] ans = new boolean[parent.length];
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < l.size(); i++){
            map.put(l.get(i) , i);
        }
        Hashing hs = new Hashing(fs);
        Hashing hr = new Hashing(s2);
        for(int i = 0; i < parent.length; i++){
            int si = map.get(i);
            int ei = si+subTree[i]-1;
            if(subTree[i] == 1)
            ans[i] = true;
            else if(subTree[i] == 2 || subTree[i] == 3){
                if(fs.charAt(si) == fs.charAt(ei))
                ans[i] = true;
                else
                ans[i] = false;
            }else{
                List<Long> l1 = hs.substringHash(si , ei);
                List<Long> l2 = hr.substringHash(s.length()-1-ei , s.length()-1-si);
                if(l1.equals(l2))
                ans[i] = true;
                else
                ans[i] = false;
            }
        }
        return ans;
    }
}