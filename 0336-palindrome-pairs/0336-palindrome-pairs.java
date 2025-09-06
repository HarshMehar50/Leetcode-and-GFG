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
            if(l > r)
            return Arrays.asList(0L , 0L);
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
    boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        /*Hashing[] sh = new Hashing[words.length];
        Hashing[] rh = new Hashing[words.length];
        long[][] shv = new long[words.length][2];
        long[][] rhv = new long[words.length][2];
        for(int i = 0; i < words.length; i++){
            sh[i] = new Hashing(words[i]);
            rh[i] = new Hashing(new StringBuilder(words[i]).reverse().toString());
            List<Long> l1 = sh[i].substringHash(0 , words[i].length()-1);
            shv[i][0] = l1.get(0);
            shv[i][1] = l1.get(1);
            List<Long> l2 = rh[i].substringHash(0 , words[i].length()-1);
            rhv[i][0] = l2.get(0);
            rhv[i][1] = l2.get(1);
        }
        long[] mod = {1000000009L, 1000000007L};
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i == j) continue;
                long sv1 = (shv[i][0]+(sh[i].powersOfBase.get(0)[words[i].length()]*shv[j][0]))%mod[0];
                long sv2 = (shv[i][1]+(sh[i].powersOfBase.get(1)[words[i].length()]*shv[j][1]))%mod[1];
                long rv1 = (rhv[j][0]+(rh[j].powersOfBase.get(0)[words[j].length()]*rhv[i][0]))%mod[0];
                long rv2 = (rhv[j][1]+(rh[j].powersOfBase.get(1)[words[j].length()]*rhv[i][1]))%mod[1];
                if(sv1 == rv1 && sv2 == rv2){
                    List<Integer> inner = Arrays.asList(i , j);
                    ans.add(inner);
                }
            }
        }*/
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(new StringBuilder(words[i]).reverse().toString() , i);
        }
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String left = words[i].substring(0 , j);
                String right = words[i].substring(j);
                if(isPalindrome(left)){
                    Integer k = map.get(right);
                    if (k != null && k != i)
                    ans.add(Arrays.asList(k , i));
                }
                if (j != words[i].length() && isPalindrome(right)) {
                    Integer k = map.get(left);
                    if (k != null && k != i)
                    ans.add(Arrays.asList(i , k));
                }
            }
        }
        return ans;
    }
}