class MapSum {
    public static class Hashing {
        String s;
        int n;
        int primesCount;
        List<Long> hashPrimes = Arrays.asList(1000000009L, 1000000007L);
        final long base = 31;
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
                if ((b & 1) == 1) 
                result = (result * a) % mod;
                a = (a * a) % mod;
                b >>= 1;
            }
            return result;
        }
    }
    HashMap<String , Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key , val);
    }
    
    public int sum(String prefix) {
        Hashing ph = new Hashing(prefix);
        List<Long> lp = ph.substringHash(0 , prefix.length()-1);
        int ans = 0;
        for(String s : map.keySet()){
            if(s.length() >= prefix.length()){
            Hashing h = new Hashing(s);
            List<Long> lh = h.substringHash(0 , prefix.length()-1);
            if(lp.equals(lh))
            ans += map.get(s);
            }
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */