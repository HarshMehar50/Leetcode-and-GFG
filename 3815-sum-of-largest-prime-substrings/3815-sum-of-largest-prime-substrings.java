class Solution {
    boolean prime(long n){
        if(n <= 1)
        return false;
        if(n == 2 || n == 3 || n == 5)
        return true;
        if(n%2 == 0)
        return false;
        for(long i = 2; i*i <= n; i++){
            if(n%i == 0)
            return false;
        }
        return true;
    }
    public long sumOfLargestPrimes(String s) {
        Set<Long> set = new HashSet<>();
        for(int l = 1; l <= s.length(); l++){
            for(int i = 0; i+l-1 < s.length(); i++){
                long n = Long.parseLong(s.substring(i , i+l));
                if(prime(n))
                set.add(n);
            }
        }
        List<Long> l = new ArrayList<>();
        l.addAll(set);
        Collections.sort(l);
        long ans = 0;
        for(int i = l.size()-1; i >= Math.max(l.size()-3 , 0); i--){
            ans += l.get(i);
        }
        return ans;
    }
}