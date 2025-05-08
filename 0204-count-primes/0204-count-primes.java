class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime , true);
        for(int i = 2; i*i < n; i++){
            if(prime[i]){
                for(int j = i*i; j < n; j=j+i){
                    prime[j] = false;
                }
            }
        }
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(prime[i])
                ans++;
        }
        return ans;
    }
}