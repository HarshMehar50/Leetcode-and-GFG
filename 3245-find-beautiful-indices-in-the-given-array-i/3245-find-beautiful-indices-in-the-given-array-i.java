class Solution {class Hashing {
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
    int ceil(List<int[]> l , int x){
        int s = 0;
        int e = l.size()-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m)[0] < x)
            s = m+1;
            else{
                ans = m;
                e = m-1;
            }
        }
        return ans;
    }
    int floor(List<int[]> l , int x){
        int s = 0;
        int e = l.size()-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m)[1] <= x){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        return ans;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        Hashing hs = new Hashing(s);
        Hashing ha = new Hashing(a);
        Hashing hb = new Hashing(b);
        List<Long> la = ha.substringHash(0 , a.length()-1);
        List<Long> lb = hb.substringHash(0 , b.length()-1);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i = 0; i+a.length()-1 < s.length(); i++){
            List<Long> l = hs.substringHash(i , i+a.length()-1);
            if(la.equals(l))
            l1.add(i);
        }
        for(int i = 0; i+b.length()-1 < s.length(); i++){
            List<Long> l = hs.substringHash(i , i+b.length()-1);
            if(lb.equals(l))
            l2.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>(l2);
        for(Integer x : l1){
            Integer c = set.ceiling(x-k);
            if(c != null && c <= x+k)
            ans.add(x);
        }
        return ans;
    }
}