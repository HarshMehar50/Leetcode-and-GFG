class Solution {
    boolean[] seive(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime , true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i*i <= n; i++){
            if(prime[i]){
                for(int j = i*i; j <= n; j = j+i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = seive(right);
        List<Integer> l = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(prime[i])
            l.add(i);
        }
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l.size()-1; i++){
            if(l.get(i+1)-l.get(i) < min){
                min = l.get(i+1)-l.get(i);
                ans[0] = l.get(i);
                ans[1] = l.get(i+1);
            }
        }
        return ans;
    }
}